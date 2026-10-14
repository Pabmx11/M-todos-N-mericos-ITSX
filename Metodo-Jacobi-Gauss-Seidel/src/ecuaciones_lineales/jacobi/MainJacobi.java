package ecuaciones_lineales.jacobi;

import ecuaciones_lineales.Defmatrix;
import ecuaciones_lineales.MetodosIterativos;

public class MainJacobi {

    public static void main(String[] args) {
        // Cargamos la matriz, los vectores y la tolerancia desde la clase externa
        double[][] A = Defmatrix.obtenerMatrizA();
        double[] b = Defmatrix.obtenerVectorB();
        double[] x0 = Defmatrix.obtenerVectorX0();
        double tol = Defmatrix.obtenerTolerancia();

        // Límite de iteraciones
        int maxIter = 100;

        // Llamada al método de Jacobi
        double[] solucion = MetodosIterativos.jacobi(A, b, x0, tol, maxIter);

        // Imprimir el resultado final
        System.out.println("Método de Jacobi");
        System.out.print("Solución aproximada: [ ");
        for (double val : solucion) {
            System.out.printf("%.5f ", val);
        }
        System.out.println("]");
        System.out.println("Iteraciones: " + MetodosIterativos.obtenerIteraciones());
    }
}
