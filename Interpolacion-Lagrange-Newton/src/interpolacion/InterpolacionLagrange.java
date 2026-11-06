package interpolacion;

public class InterpolacionLagrange {

    private static void validarDatos(double[] x, double[] y) {
        if (x == null || y == null || x.length == 0 || y.length == 0) {
            throw new IllegalArgumentException("Los arreglos no pueden ser nulos ni estar vacios.");
        }
        if (x.length != y.length) {
            throw new IllegalArgumentException("Los arreglos x y y deben tener el mismo tamano.");
        }
        for (int i = 0; i < x.length; i++) {
            for (int j = i + 1; j < x.length; j++) {
                if (x[i] == x[j]) {
                    throw new IllegalArgumentException("Nodos de x repetidos: " + x[i]);
                }
            }
        }
    }

    /**
     * Evalúa el polinomio interpolador de Lagrange en un punto xEval dado.
     *
     * P(x) = Σ y_i · L_i(x),   con   L_i(x) = Π (x - x_j) / (x_i - x_j),  j ≠ i
     *
     * @param x     Arreglo con los nodos de x
     * @param y     Arreglo con los valores de y (f(x))
     * @param xEval El punto x donde queremos interpolar
     * @return El valor interpolado y = P(xEval)
     */
    public static double interpolacionLagrange(double[] x, double[] y, double xEval) {
        validarDatos(x, y);
        double resultado = 0.0;
        int n = x.length;

        for (int i = 0; i < n; i++) {
            double termino = y[i];

            for (int j = 0; j < n; j++) {
                if (i != j) {
                    // Productoria L_i(x): multiplica cada factor (xEval - x_j) / (x_i - x_j)
                    termino *= (xEval - x[j]) / (x[i] - x[j]);
                }
            }
            resultado += termino;
        }
        return resultado;
    }
}
