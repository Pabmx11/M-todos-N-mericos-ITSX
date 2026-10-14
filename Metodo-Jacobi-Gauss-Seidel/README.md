# Métodos Iterativos: Jacobi y Gauss-Seidel

Práctica de Programación Modular en Java — Métodos Numéricos, ITSX.

Resuelve el sistema:

```
5x +  y +  z = 7
 x + 4y +  z = 6
 x + 2y + 5z = 8
```

con aproximación inicial `X(0) = [0, 0, 0]` y tolerancia `ε = 0.0001`.

## Estructura

```
src/ecuaciones_lineales/
├── Defmatrix.java                   Módulo 1: matriz A, vector b, X(0) y tolerancia
├── MetodosIterativos.java           Módulo 2: métodos de Jacobi y Gauss-Seidel
├── jacobi/MainJacobi.java           Módulo 3: ejecuta Jacobi
└── gauss_seidel/MainGaussSeidel.java  Módulo 3: ejecuta Gauss-Seidel
```

## Compilación y ejecución

Desde la carpeta raíz del proyecto:

```bash
javac -d out $(find src -name "*.java")
java -cp out ecuaciones_lineales.jacobi.MainJacobi
java -cp out ecuaciones_lineales.gauss_seidel.MainGaussSeidel
```

También se puede abrir en IntelliJ IDEA y ejecutar cada clase `Main` directamente.

## Resultados

| Método       | Iteraciones | Solución aproximada |
|--------------|-------------|---------------------|
| Jacobi       | 16          | [0.99999, 0.99998, 0.99998] |
| Gauss-Seidel | 6           | [0.99999, 1.00000, 1.00000] |
