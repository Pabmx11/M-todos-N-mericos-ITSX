package ecuaciones_lineales;

/**
 * Módulo 2 (Métodos Iterativos)
 * Contiene la lógica de cálculo de los métodos de Jacobi y Gauss-Seidel.
 */
public class MetodosIterativos {

    // Número de iteraciones que necesitó el último método ejecutado para converger
    private static int iteraciones = 0;

    public static int obtenerIteraciones() { return iteraciones; }

    /**
     * Resuelve un sistema de ecuaciones lineales Ax = b
     * mediante el método iterativo de Jacobi.
     *
     * @param A       Matriz de coeficientes (cuadrada)
     * @param b       Vector de términos independientes
     * @param x0      Vector de aproximación inicial
     * @param tol     Tolerancia o error máximo permitido
     * @param maxIter Número máximo de iteraciones
     * @return        Vector con la solución aproximada
     */
    public static double[] jacobi(double[][] A, double[] b, double[] x0, double tol, int maxIter) {
        int n = b.length;
        double[] x = x0.clone();            // Copia de la aproximación actual
        double[] xNuevo = new double[n];    // Vector auxiliar para almacenar la nueva aproximación
        iteraciones = 0;

        // Ciclo principal de iteraciones
        for (int k = 0; k < maxIter; k++) { // su función es repetir el cálculo una y otra vez
            // para ir afinando la respuesta, con un límite máximo
            iteraciones++;

            // Cálculo de cada variable para la nueva iteración
            for (int i = 0; i < n; i++) {   // cada fila
                double suma = 0.0;          // tenemos que resetear la suma de cada fila

                // Sumatoria de los términos A[i][j] * x[j] excluyendo la diagonal (i != j)
                for (int j = 0; j < n; j++) {   // cada columna
                    if (j != i) {               // tenemos que sumar todos excepto los de la diagonal
                        suma += A[i][j] * x[j];
                    }
                }

                // Fórmula de despeje de Jacobi: x_i = (b_i - suma) / A[i][i]
                xNuevo[i] = (b[i] - suma) / A[i][i];
            }

            // Evalúa si ya se alcanzó la precisión deseada (criterio de parada)
            if (calcularError(x, xNuevo) < tol) {
                return xNuevo; // Convergió con éxito
            }

            // Actualiza el vector para la siguiente iteración si es que todavía el error es muy grande
            x = xNuevo.clone();
        }

        // Retorna la última aproximación si se agotan las iteraciones sin converger del todo
        return xNuevo;
    }

    /**
     * Resuelve un sistema de ecuaciones lineales Ax = b
     * mediante el método iterativo de Gauss-Seidel.
     */
    public static double[] gaussSeidel(double[][] A, double[] b, double[] xInicial, double tol, int maxIter) {
        int n = xInicial.length;
        double[] x = xInicial.clone(); // Un solo vector que evoluciona al instante
        // clonamos el xInicial del main a x
        iteraciones = 0;

        // Ciclo principal de iteraciones (controla el límite de vueltas para evitar loops infinitos)
        for (int iter = 0; iter < maxIter; iter++) {
            iteraciones++;

            // Respaldamos el estado anterior para poder calcular el error al final de la vuelta
            double[] xAnt = x.clone();

            // Recorremos cada renglón o ecuación del sistema de arriba hacia abajo
            for (int i = 0; i < n; i++) {
                double suma = b[i]; // Arrancamos la suma con el término independiente b_i

                // Recorremos las columnas del sistema
                for (int j = 0; j < n; j++) {
                    // Omitimos la diagonal principal (j != i), ya que ese coeficiente no se resta aquí
                    if (j != i) {
                        suma -= A[i][j] * x[j]; // Usa los valores frescos en tiempo real
                    }
                }
                x[i] = suma / A[i][i]; // Actualización directa (despejamos y guardamos en el mismo vector)
            }

            // Usamos la función para calcular el error (compara el vector viejo con el recién calculado)
            if (calcularError(xAnt, x) < tol) {
                return x; // Si la tolerancia es menor a lo pedido, encontramos la solución y salimos
            }
        }

        return x; // Si se acaba el límite de iteraciones sin converger, regresa la aproximación actual
    }

    /**
     * Calcula el error máximo absoluto entre dos vectores (Norma Infinito).
     */
    public static double calcularError(double[] xAnt, double[] xNuevo) {
        double max = 0.0;
        for (int i = 0; i < xAnt.length; i++) {
            // Encuentra la máxima diferencia absoluta entre elementos correspondientes
            max = Math.max(max, Math.abs(xNuevo[i] - xAnt[i]));
        }
        return max;
    }
}
