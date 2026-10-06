package gauss;

import java.util.Locale;

/**
 * Clase principal: obtiene los datos, aplica el Metodo de Gauss-Jordan
 * y muestra las soluciones en consola.
 */
public class Lanzador_gaus {
    public static void main(String[] args) {
        // Lee la matriz aumentada desde el modulo de datos.
        double [][] matriz = Defmatrizz.defmatriz();

        // Resuelve el sistema con Gauss-Jordan: la matriz se reduce a la
        // identidad y las soluciones se leen directo de la ultima columna.
        double[] soluciones = GaussJordan.resolver(matriz);

        // Muestra cada solucion con 4 decimales para evitar
        // errores de redondeo visibles (por ejemplo 7.000000000000002).
        // Locale.US asegura que se use punto decimal en cualquier equipo.
        System.out.println("Soluciones del sistema:");
        for (int i = 0; i < soluciones.length; i++) {
            System.out.printf(Locale.US, "x%d = %.4f%n", i + 1, soluciones[i]);
        }
    }
}
