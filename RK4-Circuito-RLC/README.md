# Sistemas de EDOs y RK4 Vectorial: Circuito RLC

Actividad Tema 6.3 — Métodos Numéricos (SCC-1017), ITSX.

**Integrantes:**

- Pablo Ali Hinojosa de la Hidalga ([@Pabmx11](https://github.com/Pabmx11))
- Jorge Angel Saldaña Morales ([@angelsaldanha](https://github.com/angelsaldanha))
- Rey Arturo Acosta Varela ([@Papitaseca](https://github.com/Papitaseca))

Simula la respuesta libre de un circuito RLC serie con `L = 1 H`, `R = 0.4 Ω` y `C = 1 F`:

```
q'' + 0.4 q' + q = 0,     q(0) = 1.0 C,   q'(0) = 0.0 A
```

La EDO de segundo orden se convierte en un sistema de primer orden con las variables de estado
`y1 = q` (carga) y `y2 = q'` (corriente):

```
y1' = y2
y2' = −0.4 y2 − y1          Y(0) = [1.0, 0.0]
```

y se resuelve con Runge-Kutta de 4to orden en forma vectorial. Cada paso se compara contra la solución exacta de la carga:

```
q(t) = e^(−0.2t) · ( cos(ωd t) + (0.2/ωd) sin(ωd t) ),   ωd = √0.96 ≈ 0.979796
```

> Este README es solo una guía rápida de ejecución. El análisis completo está en el reporte técnico en PDF.

## Requisitos

- Java JDK 17 o superior (probado con OpenJDK 26)
- Git, para clonar el repositorio
- IntelliJ IDEA (opcional)

## Estructura

```
src/
└── RK4CircuitoRLC.java   Sistema F(t, Y), suma vectorial, solución exacta y RK4 vectorial
```

## Clonar, compilar y ejecutar

1. Clonar el repositorio y entrar a la carpeta del proyecto:

   ```bash
   git clone https://github.com/Pabmx11/M-todos-N-mericos-ITSX.git
   cd M-todos-N-mericos-ITSX/RK4-Circuito-RLC
   ```

2. Compilar:

   ```bash
   javac -d out src/*.java
   ```

3. Ejecutar con el tamaño de paso por defecto (`h = 0.2`):

   ```bash
   java -cp out RK4CircuitoRLC
   ```

4. Ejecutar con otro tamaño de paso, pasándolo como argumento:

   ```bash
   java -cp out RK4CircuitoRLC 0.1
   java -cp out RK4CircuitoRLC 0.05
   ```

En IntelliJ IDEA: abrir la carpeta `RK4-Circuito-RLC` como proyecto, ejecutar `RK4CircuitoRLC.java`, y para cambiar `h` usar **Run with Parameters…**

## Salida

El programa calcula `nPuntos = 25` puntos después de `t = 0` e imprime `n`, `t_n`, la carga `y1`, la corriente `y2`,
la carga exacta y el error absoluto `|q_exacta(t_n) − y1(t_n)|`. Primeras y últimas líneas con `h = 0.2`:

```
n    t_n    y1 (Carga)   y2 (Corr)    q_exacta     Error abs
0    0.00   1.000000     0.000000     1.000000     0.00e+00
1    0.20   0.980589    -0.190929     0.980587     2.01e-06
2    0.40   0.925102    -0.359864     0.925097     4.46e-06
...
25   5.00  -0.005562     0.368970    -0.005544     1.75e-05
```

Como el número de puntos es fijo, un `h` más chico cubre menos tiempo:

| h | Tiempo final | Error en el último punto |
|---|---|---|
| 0.2 | t = 5.00 | 1.75e-05 |
| 0.1 | t = 2.50 | 4.15e-08 |
| 0.05 | t = 1.25 | 4.77e-08 |
