public class MetodoEuler {

    public static double evaluarFuncion(double x, double y) {
        // f(x, y) = x - y
        return x - y;
    }

    // Solucion analitica exacta de y' = x - y, y(0) = 1
    public static double solucionExacta(double x) {
        return x - 1 + 2 * Math.exp(-x);
    }

    public static void main(String[] args) {
        double x0 = 0.0;
        double y0 = 1.0;
        double h = 0.1; // Variar este valor en el reporte (ej. 0.1, 0.05, 0.01)
        double xFinal = 0.3;

        // Permite cambiar h desde la terminal: java -cp out MetodoEuler 0.05
        if (args.length > 0) {
            h = Double.parseDouble(args[0]);
        }

        // Criterio de paro (numero total de pasos N)
        int nPasos = (int) Math.round((xFinal - x0) / h);
        double x = x0;
        double y = y0;

        System.out.println("Metodo de Euler con h = " + h + " (N = " + nPasos + " pasos)");
        System.out.println("n\t x_n\t y_n (Euler)\t y_exacta\t Error abs");
        System.out.println("----------------------------------------------------------");
        System.out.printf("%d\t %.4f\t %.6f\t %.6f\t %.6f\n", 0, x, y, solucionExacta(x), Math.abs(solucionExacta(x) - y));

        for (int i = 0; i < nPasos; i++) {
            // Pendiente en el punto actual
            double pendiente = evaluarFuncion(x, y);

            // Actualizacion: y_{n+1} = y_n + h * f(x_n, y_n),  x_{n+1} = x_n + h
            y = y + h * pendiente;
            x = x + h;

            double yExacta = solucionExacta(x);
            System.out.printf("%d\t %.4f\t %.6f\t %.6f\t %.6f\n", i + 1, x, y, yExacta, Math.abs(yExacta - y));
        }
    }
}
