package ecuaciones_lineales;

/**
 * Módulo 1 (Definición del Sistema)
 *
 *   5x +  y +  z = 7
 *    x + 4y +  z = 6
 *    x + 2y + 5z = 8
 */
public class Defmatrix {

    public static double[][] obtenerMatrizA() {
        return new double[][] {
                {5.0, 1.0, 1.0},
                {1.0, 4.0, 1.0},
                {1.0, 2.0, 5.0}
        };
    }

    public static double[] obtenerVectorB() { return new double[] {7.0, 6.0, 8.0}; }

    public static double[] obtenerVectorX0() { return new double[] {0.0, 0.0, 0.0}; }

    // Tolerancia de error establecida (ε = 0.0001)
    public static double obtenerTolerancia() { return 0.0001; }
}
