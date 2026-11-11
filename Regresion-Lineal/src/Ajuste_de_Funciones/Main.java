package Ajuste_de_Funciones;

public class Main {
    public static void main(String[] args) {
        // Conjunto de datos de prueba (Chapra y Canale, ejemplo de regresion lineal)
        double[] x = {1, 2, 3, 4, 5, 6, 7};
        double[] y = {0.5, 2.5, 2.0, 4.0, 3.5, 6.0, 5.5};

        // 1. Ajuste por minimos cuadrados, Pearson y r2
        double[] resultado = RegresionLineal.calcularMinimosCuadrados(x, y);
        double beta0 = resultado[0];
        double beta1 = resultado[1];

        // 2. Prediccion con el modelo obtenido
        double xNuevo = 8.0;
        double yEstimado = RegresionLineal.predecir(beta0, beta1, xNuevo);

        System.out.println("\n--- PREDICCION ---");
        System.out.printf("Para X = %.1f, el modelo estima Y = %.4f%n", xNuevo, yEstimado);
    }
}
