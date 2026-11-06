# Interpolación: Lagrange vs. Diferencias Divididas de Newton

Tarea 1, Unidad 5 — Métodos Numéricos (SCC-1017), ITSX.

Calcula el polinomio interpolador que pasa por los nodos

```
(0, 1), (1, 3), (3, 2), (4, 5)
```

y lo evalúa en `x = 2` con dos métodos: Diferencias Divididas de Newton y Polinomios de Lagrange.

> Este README es solo una guía rápida de ejecución. El análisis completo está en el reporte técnico en PDF.

## Requisitos

- Java JDK 17 o superior (probado con OpenJDK 26)
- IntelliJ IDEA (opcional)

## Estructura

```
src/interpolacion/
├── InterpolacionNewton.java     Tabla de diferencias divididas y evaluación del polinomio de Newton
│                                (código del repositorio oficial de la asignatura)
├── InterpolacionLagrange.java   Validación de datos y evaluación del polinomio de Lagrange
└── Main.java                    Define los nodos, ejecuta ambos métodos y compara resultados
```

## Compilación y ejecución

### Desde la terminal

Desde la carpeta del proyecto (`Interpolacion-Lagrange-Newton`):

```bash
javac -d out $(find src -name "*.java")
java -cp out interpolacion.Main
```

### Desde IntelliJ IDEA

Abrir la carpeta `Interpolacion-Lagrange-Newton` como proyecto y ejecutar `Main.java`.

## Resultado esperado

```
P(2.00) = 2.3333333333   (Newton)
P(2.00) = 2.3333333333   (Lagrange)
Diferencia |Newton - Lagrange| = 0.000e+00
```

El valor exacto es 7/3. Para usar otros nodos o punto de evaluación, cambia los arreglos `x`, `y` y la variable `xEval` en `Main.java`.
