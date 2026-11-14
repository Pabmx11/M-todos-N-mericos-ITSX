# Resolución Numérica de EDOs: Euler y Runge-Kutta 4

Actividad Unidad 6 — Métodos Numéricos (SCC-1017), ITSX.

Resuelve dos problemas de valor inicial en el intervalo `[0, 0.3]` y compara cada paso contra la solución analítica exacta:

| Clase | EDO | Condición inicial | Solución exacta |
|---|---|---|---|
| `MetodoEuler` | `y' = x − y` | `y(0) = 1` | `y = x − 1 + 2e^(−x)` |
| `MetodoRungeKutta` | `y' = x + y` | `y(0) = 1` | `y = 2e^x − x − 1` |

> Este README es solo una guía rápida de ejecución. El análisis completo está en el reporte técnico en PDF.

## Requisitos

- Java JDK 17 o superior (probado con OpenJDK 26)
- Git, para clonar el repositorio
- IntelliJ IDEA (opcional)

## Estructura

```
src/
├── MetodoEuler.java        f(x, y) = x − y, solución exacta y método de Euler
└── MetodoRungeKutta.java   f(x, y) = x + y, solución exacta y método RK4
```

Cada clase imprime una tabla con `n`, `x_n`, `y_n`, `y_exacta` y el error absoluto `|y_exacta(x_n) − y_n|`.
El criterio de paro es el número total de pasos `N = round((xFinal − x0) / h)`.

## Clonar, compilar y ejecutar

1. Clonar el repositorio y entrar a la carpeta del proyecto:

   ```bash
   git clone https://github.com/Pabmx11/M-todos-N-mericos-ITSX.git
   cd M-todos-N-mericos-ITSX/EDO-Euler-RK4
   ```

2. Compilar:

   ```bash
   javac -d out src/*.java
   ```

3. Ejecutar con el tamaño de paso por defecto (`h = 0.1`):

   ```bash
   java -cp out MetodoEuler
   java -cp out MetodoRungeKutta
   ```

4. Ejecutar con otro tamaño de paso, pasándolo como argumento:

   ```bash
   java -cp out MetodoEuler 0.05
   java -cp out MetodoEuler 0.01
   ```

En IntelliJ IDEA: abrir la carpeta `EDO-Euler-RK4` como proyecto y ejecutar cada clase. Para cambiar `h`, edita la variable `h` en `main` o agrégalo en **Run → Edit Configurations → Program arguments**.

## Resultado esperado en x = 0.3

| Método | h | N | y_n | y_exacta | Error absoluto |
|---|---|---|---|---|---|
| Euler | 0.1 | 3 | 0.758000 | 0.781636 | 0.023636 |
| Euler | 0.05 | 6 | 0.770184 | 0.781636 | 0.011453 |
| Euler | 0.01 | 30 | 0.779401 | 0.781636 | 0.002236 |
| RK4 | 0.1 | 3 | 1.399717 | 1.399718 | 6.21e-07 |
