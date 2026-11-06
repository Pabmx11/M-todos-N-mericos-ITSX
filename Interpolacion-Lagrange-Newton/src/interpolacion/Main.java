package interpolacion;

public class Main {
    public static void main(String[] args) {
        // Nodos propios: (0, 1), (1, 3), (3, 2), (4, 5)
        double[] x = {0.0, 1.0, 3.0, 4.0};
        double[] y = {1.0, 3.0, 2.0, 5.0};

        // Punto intermedio a interpolar
        double xEval = 2.0;

        System.out.println("===== DIFERENCIAS DIVIDIDAS DE NEWTON =====");

        // 1. Calcular tabla de diferencias divididas
        double[][] tablaDiferencias = InterpolacionNewton.calcularDiferenciasDivididas(x, y);

        // 2. Imprimir la tabla
        InterpolacionNewton.imprimirTabla(x, tablaDiferencias);

        // 3. Mostrar los coeficientes (Diagonal superior)
        System.out.println("\n--- COEFICIENTES DEL POLINOMIO (a_k) ---");
        for (int k = 0; k < x.length; k++) {
            System.out.printf("a_%d = %.4f\n", k, tablaDiferencias[0][k]);
        }

        // 4. Evaluar con Newton
        double yNewton = InterpolacionNewton.evaluarPolinomio(x, tablaDiferencias, xEval);
        System.out.println("\n--- RESULTADO NEWTON ---");
        System.out.printf("P(%.2f) = %.10f\n", xEval, yNewton);

        System.out.println("\n===== POLINOMIOS DE LAGRANGE =====");

        // 5. Evaluar con Lagrange
        double yLagrange = InterpolacionLagrange.interpolacionLagrange(x, y, xEval);
        System.out.println("\n--- RESULTADO LAGRANGE ---");
        System.out.printf("P(%.2f) = %.10f\n", xEval, yLagrange);

        // 6. Comparación de ambos métodos
        System.out.println("\n===== COMPARACIÓN =====");
        System.out.printf("Diferencia |Newton - Lagrange| = %.3e\n", Math.abs(yNewton - yLagrange));
    }
}
