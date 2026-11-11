# Regresión Lineal por Mínimos Cuadrados

Tarea 2, Unidad 5 — Métodos Numéricos (SCC-1017), ITSX.

Ajusta una recta `Y = β₀ + β₁X` a un conjunto de datos con el método de mínimos cuadrados y calcula el coeficiente de correlación de Pearson (`r`) y el coeficiente de determinación (`r²`).

> Este README es solo una guía rápida de ejecución. El análisis completo está en el reporte técnico en PDF.

## Requisitos

- Java JDK 17 o superior (probado con OpenJDK 26)
- Git, para clonar el repositorio
- IntelliJ IDEA (opcional)

## Estructura

```
src/Ajuste_de_Funciones/
├── RegresionLineal.java   Sumatorias, β₀, β₁, Pearson (r), r² y predicción
└── Main.java              Datos de prueba, ajuste y predicción para X = 8
```

## Clonar, compilar y ejecutar

1. Clonar el repositorio y entrar a la carpeta del proyecto:

   ```bash
   git clone https://github.com/Pabmx11/M-todos-N-mericos-ITSX.git
   cd M-todos-N-mericos-ITSX/Regresion-Lineal
   ```

2. Compilar:

   ```bash
   javac -d out $(find src -name "*.java")
   ```

3. Ejecutar:

   ```bash
   java -cp out Ajuste_de_Funciones.Main
   ```

En IntelliJ IDEA: abrir la carpeta `Regresion-Lineal` como proyecto y ejecutar `Main.java`.

## Datos de prueba y resultado esperado

| X | 1 | 2 | 3 | 4 | 5 | 6 | 7 |
|---|---|---|---|---|---|---|---|
| Y | 0.5 | 2.5 | 2.0 | 4.0 | 3.5 | 6.0 | 5.5 |

```
Modelo obtenido: Y = 0.0714 + 0.8393X
Coeficiente de Pearson (r): 0.9318
Coeficiente de Determinacion (r2): 0.8683
Para X = 8.0, el modelo estima Y = 6.7857
```

Para usar otros datos, cambia los arreglos `x` y `y` (y el valor `xNuevo`) en `Main.java`.
