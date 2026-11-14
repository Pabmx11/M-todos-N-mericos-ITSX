public class MetodoRungeKutta {

    public static double evaluarFuncion(double x, double y) {
        // f(x, y) = x + y
        return x + y;
    }

    // Solucion analitica exacta de y' = x + y, y(0) = 1
    public static double solucionExacta(double x) {
        return 2 * Math.exp(x) - x - 1;
    }

    public static void main(String[] args) {
        double x0 = 0.0;
        double y0 = 1.0;
        double h = 0.1;
        double xFinal = 0.3;

        // Permite cambiar h desde la terminal: java -cp out MetodoRungeKutta 0.05
        if (args.length > 0) {
            h = Double.parseDouble(args[0]);
        }

        int nPasos = (int) Math.round((xFinal - x0) / h);
        double x = x0;
        double y = y0;

        System.out.println("Metodo de Runge-Kutta 4 con h = " + h + " (N = " + nPasos + " pasos)");
        System.out.println("n\t x_n\t y_n (RK4)\t y_exacta\t Error abs");
        System.out.println("----------------------------------------------------------");
        System.out.printf("%d\t %.4f\t %.6f\t %.6f\t %.2e\n", 0, x, y, solucionExacta(x), Math.abs(solucionExacta(x) - y));

        for (int i = 0; i < nPasos; i++) {
            // Las 4 pendientes
            double k1 = evaluarFuncion(x, y);
            double k2 = evaluarFuncion(x + h / 2, y + h * k1 / 2);
            double k3 = evaluarFuncion(x + h / 2, y + h * k2 / 2);
            double k4 = evaluarFuncion(x + h, y + h * k3);

            // Actualizacion ponderada de y y avance de x en h
            y = y + (h / 6) * (k1 + 2 * k2 + 2 * k3 + k4);
            x = x + h;

            double yExacta = solucionExacta(x);
            System.out.printf("%d\t %.4f\t %.6f\t %.6f\t %.2e\n", i + 1, x, y, yExacta, Math.abs(yExacta - y));
        }
    }
}
