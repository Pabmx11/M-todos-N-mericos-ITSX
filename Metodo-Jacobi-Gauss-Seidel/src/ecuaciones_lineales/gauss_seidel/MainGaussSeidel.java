package ecuaciones_lineales.gauss_seidel;

// Importamos el sistema y los métodos desde el paquete común de ecuaciones_lineales
import ecuaciones_lineales.Defmatrix;
import ecuaciones_lineales.MetodosIterativos;

public class MainGaussSeidel {

    public static void main(String[] args) {
        // Reciclamos A, b, X(0) y la tolerancia directamente desde Defmatrix
        double[][] A = Defmatrix.obtenerMatrizA();
        double[] b = Defmatrix.obtenerVectorB();
        double[] xInicial = Defmatrix.obtenerVectorX0();
        double tol = Defmatrix.obtenerTolerancia();

        // Número máximo de iteraciones
        int maxIter = 100;

        // Llamada al método de Gauss-Seidel
        double[] resultado = MetodosIterativos.gaussSeidel(A, b, xInicial, tol, maxIter);

        // Imprimir los resultados por consola
        System.out.println("Método de Gauss-Seidel");
        System.out.print("Solución aproximada: [ ");
        for (double val : resultado) {
            System.out.printf("%.5f ", val);
        }
        System.out.println("]");
        System.out.println("Iteraciones: " + MetodosIterativos.obtenerIteraciones());
    }
}
