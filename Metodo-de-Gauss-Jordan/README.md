# Método de Gauss-Jordan en Java

Programa que resuelve un sistema de ecuaciones lineales con el método de Gauss-Jordan, reutilizando el módulo de eliminación gaussiana de la práctica anterior.

Materia: SCC-1017 Métodos Numéricos, Unidad 3.  
Instituto Tecnológico Superior de Xalapa, Ingeniería en Sistemas Computacionales.

## Lenguaje de programación

Java (JDK 8 o superior).

## Estructura modular

```
src/gauss/
    Defmatrizz.java      Datos: define la matriz aumentada del sistema
    Gauss.java           Eliminación gaussiana (módulo reutilizado de la práctica anterior)
    GaussJordan.java     Procesamiento: completa la reducción hasta la matriz identidad
    Lanzador_gaus.java   Principal: une los módulos y muestra los resultados
```

Cada clase tiene una sola responsabilidad:

- `Defmatrizz` solo entrega los datos.
- `Gauss` hace ceros debajo de la diagonal principal y deja la matriz triangular superior.
- `GaussJordan` llama a `Gauss.eliminacionGaussiana` en lugar de repetir esos ciclos, y después:
  1. Normaliza cada pivote a 1, dividiendo toda su fila entre él.
  2. Hace ceros arriba de cada pivote (barrido superior).
  3. Lee las soluciones directamente de la última columna, sin sustitución regresiva.
- `Lanzador_gaus` obtiene la matriz, pide la solución a `GaussJordan` e imprime el resultado.

La matriz se pasa por referencia: los métodos modifican el mismo arreglo en memoria en lugar de trabajar con copias.

## Compilación y ejecución

### Desde la terminal

1. Clonar el repositorio y entrar a la carpeta del proyecto:

```bash
git clone https://github.com/Pabmx11/M-todos-N-mericos-ITSX.git
cd M-todos-N-mericos-ITSX/Metodo-de-Gauss-Jordan
```

2. Compilar:

```bash
javac -d out src/gauss/*.java
```

3. Ejecutar:

```bash
java -cp out gauss.Lanzador_gaus
```

### Desde IntelliJ IDEA

1. Abrir la carpeta `Metodo-de-Gauss-Jordan` con File > Open.
2. Verificar que haya un JDK configurado en File > Project Structure > SDK.
3. Abrir `src/gauss/Lanzador_gaus.java`.
4. Ejecutar el método `main` con la flecha verde que aparece junto a él.

## Ejemplo de prueba

Sistema de ecuaciones:

```
3.0 x1 - 0.1 x2 - 0.2 x3 =   7.85
0.1 x1 + 7.0 x2 - 0.3 x3 = -19.30
0.3 x1 - 0.2 x2 + 10.0 x3 =  71.40
```

Matriz aumentada de entrada:

```
3.0   -0.1   -0.2  |    7.85
0.1    7.0   -0.3  |  -19.30
0.3   -0.2   10.0  |   71.40
```

Al terminar Gauss-Jordan, la matriz queda como la identidad y la última columna contiene las soluciones:

```
1   0   0  |   3.0
0   1   0  |  -2.5
0   0   1  |   7.0
```

Salida en consola:

```
Soluciones del sistema:
x1 = 3.0000
x2 = -2.5000
x3 = 7.0000
```

Para resolver otro sistema basta con cambiar la matriz en `src/gauss/Defmatrizz.java`.
