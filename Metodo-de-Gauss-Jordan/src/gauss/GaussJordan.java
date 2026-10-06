package gauss;

/**
 * Modulo de procesamiento: resuelve el sistema con el metodo de Gauss-Jordan.
 * Reutiliza la eliminacion gaussiana de la practica anterior y completa
 * la reduccion hasta obtener la matriz identidad.
 */
public class GaussJordan {

    /**
     * Resuelve el sistema de ecuaciones representado por la matriz aumentada.
     * La matriz se modifica directamente porque en Java los arreglos
     * se pasan por referencia.
     *
     * @param matriz matriz aumentada del sistema
     * @return arreglo con las soluciones de las variables
     */
    public static double[] resolver(double[][] matriz) {
        int n = matriz.length;

        // Reutiliza la practica anterior: deja ceros debajo de la diagonal.
        Gauss.eliminacionGaussiana(matriz);

        // Recorre las filas de la ultima a la primera.
        for (int i = n - 1; i >= 0; i--) {

            // Guarda el pivote antes de dividir, porque al dividir
            // la fila el valor de matriz[i][i] cambia a 1.
            double pivote = matriz[i][i];

            // Normaliza la fila para que el pivote valga 1.
            for (int k = i; k <= n; k++) {
                matriz[i][k] /= pivote;
            }

            // Hace ceros en la columna i en todas las filas de arriba.
            for (int j = 0; j < i; j++) {
                double factor = matriz[j][i];
                for (int k = i; k <= n; k++) {
                    matriz[j][k] -= factor * matriz[i][k];
                }
            }
        }

        // La matriz ya es la identidad: las soluciones estan en la ultima columna.
        double[] x = new double[n];
        for (int i = 0; i < n; i++) {
            x[i] = matriz[i][n];
        }
        return x;
    }
}