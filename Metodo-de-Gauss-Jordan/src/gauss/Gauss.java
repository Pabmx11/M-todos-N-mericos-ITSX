package gauss;

public class Gauss {

    /**
     * Realiza la eliminacion gaussiana sobre una matriz aumentada.
     * El objetivo es transformar la matriz hasta obtener una forma triangular superior,
     * haciendo ceros debajo de la diagonal principal.
     *
     * @param matriz matriz aumentada que representa el sistema de ecuaciones
     */
    public static void eliminacionGaussiana(double[][] matriz){
        // Obtiene el numero de ecuaciones de la matriz.
        int n = matriz.length;

        // Recorre cada columna que se utilizara como pivote.
        for(int i = 0; i < n; i++){

            // Recorre las filas que se encuentran debajo de la fila pivote.
            for(int j = i + 1; j < n; j++){

                // Calcula el factor necesario para convertir en cero
                // el elemento que se encuentra debajo del pivote.
                double factor = matriz[j][i] / matriz [i][i];

                // Actualiza todos los elementos de la fila utilizando
                // la fila pivote multiplicada por el factor calculado.
                // Se incluye la ultima columna porque corresponde a los
                // terminos independientes de la matriz aumentada.
                for(int k = i; k <= n; k++){
                    matriz[j][k] -= factor * matriz[i][k];
                }
            }
        }
    }

    /**
     * Obtiene las soluciones del sistema mediante sustitucion regresiva.
     * Este proceso se realiza despues de convertir la matriz en triangular superior.
     *
     * @param matriz matriz aumentada en forma triangular superior
     * @return arreglo que contiene las soluciones de las variables
     */
    public static double[] sustitucionRegresiva(double[][] matriz){
        // Obtiene el numero de ecuaciones y crea el arreglo de soluciones.
        int n = matriz.length;
        double[] x = new double[n];

        // Comienza desde la ultima ecuacion y avanza hacia la primera.
        for(int i = n - 1; i >= 0; i--){
            // Acumula los terminos que ya tienen una solucion conocida.
            double suma = 0;

            // Calcula la suma de los productos de los coeficientes
            // por las soluciones obtenidas anteriormente.
            for(int j = i + 1; j < n; j++){
                suma += matriz[i][j] * x[j];
            }

            // Despeja la variable actual utilizando el termino independiente,
            // la suma calculada y el elemento de la diagonal principal.
            x[i] = (matriz[i][n] - suma) / matriz[i][i];
        }
        return x;
    }
}
