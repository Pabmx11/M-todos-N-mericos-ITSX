package gauss;

/**
 * Modulo de datos: define la matriz aumentada del sistema de ecuaciones.
 * Cada fila es una ecuacion; las primeras columnas son los coeficientes
 * de x1, x2 y x3, y la ultima columna es el termino independiente.
 *
 *   3.0 x1 - 0.1 x2 - 0.2 x3 =   7.85
 *   0.1 x1 + 7.0 x2 - 0.3 x3 = -19.30
 *   0.3 x1 - 0.2 x2 + 10.0 x3 =  71.40
 */
public class Defmatrizz {

    /**
     * Devuelve una matriz nueva cada vez que se llama, para que la
     * eliminacion gaussiana no modifique los datos originales.
     *
     * @return matriz aumentada de 3 x 4
     */
    public static double[][] defmatriz(){
        return new double[][]{
                {3.0, -0.1, -0.2, 7.85},
                { 0.1, 7.0, -0.3, -19.3},
                { 0.3, -0.2, 10.0, 71.4}
        };
    }
}
