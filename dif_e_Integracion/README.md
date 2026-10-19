# Integración Numérica: Trapecio Compuesto y Simpson 1/3 Compuesto

Tarea 1, Unidad 4 — Métodos Numéricos (SCC-1017), ITSX.

Calcula la integral

```
∫₀² x² dx        (valor exacto: 8/3 ≈ 2.666666…)
```

con tolerancia `ε = 0.0001`. Los dos métodos usan el mismo criterio de paro: empiezan
con `n = 2` y duplican los subintervalos (`n → 2n`) hasta que el error absoluto entre
dos aproximaciones sucesivas sea menor a la tolerancia.

## Estructura

```
src/dif_e_Integracion/
├── TrapecioCompuesto.java   f(x), cálculo de h y método del Trapecio Compuesto
├── SimpsonCompuesto.java    Método de Simpson 1/3 Compuesto (reutiliza f(x) y h)
├── MainTrap.java            Ejecuta el Trapecio Compuesto
└── MainSim.java             Ejecuta Simpson 1/3 Compuesto
```

## Compilación y ejecución

### Desde la terminal

1. Entrar a la carpeta del proyecto:

   ```bash
   cd dif_e_Integracion
   ```

2. Compilar todas las clases en la carpeta `out`:

   ```bash
   javac -d out $(find src -name "*.java")
   ```

3. Ejecutar cada método:

   ```bash
   java -cp out dif_e_Integracion.MainTrap
   java -cp out dif_e_Integracion.MainSim
   ```

### Desde IntelliJ IDEA

1. Abrir la carpeta `dif_e_Integracion` como proyecto.
2. Abrir `MainTrap.java` o `MainSim.java`.
3. Dar clic en el botón ▶ junto a `main` para ejecutarlo.

Para integrar otra función, se modifica el método `funcion(double x)` en
`TrapecioCompuesto.java`. Ambos métodos la usan.

## Ejemplo de salida

Trapecio Compuesto:

```
--- ITERACIONES (TRAPECIO COMPUESTO) ---
n = 2 | Integral = 3.0
n = 4 | Integral = 2.75 | Error = 0.25
n = 8 | Integral = 2.6875 | Error = 0.0625
n = 16 | Integral = 2.671875 | Error = 0.015625
n = 32 | Integral = 2.66796875 | Error = 0.00390625
n = 64 | Integral = 2.6669921875 | Error = 9.765625E-4
n = 128 | Integral = 2.666748046875 | Error = 2.44140625E-4
n = 256 | Integral = 2.66668701171875 | Error = 6.103515625E-5
Convergencia en 7 iteraciones con n = 256 subintervalos

Resultado final obtenido: 2.66668701171875
```

Simpson 1/3 Compuesto:

```
--- ITERACIONES (SIMPSON 1/3 COMPUESTO) ---
n = 2 | Integral = 2.6666666666666665
n = 4 | Integral = 2.6666666666666665 | Error = 0.0
Convergencia en 1 iteraciones con n = 4 subintervalos

Resultado final obtenido: 2.6666666666666665
```

## Comparación

| Método              | Iteraciones | n final | Resultado          | Error real vs. 8/3 |
|---------------------|-------------|---------|--------------------|--------------------|
| Trapecio Compuesto  | 7           | 256     | 2.66668701171875   | ≈ 2.03 × 10⁻⁵      |
| Simpson 1/3 Compuesto | 1         | 4       | 2.6666666666666665 | ≈ 0 (exacto)       |

Simpson necesitó 64 veces menos subintervalos. El Trapecio tiene un error proporcional a
h², por eso el error baja más o menos 4 veces cada vez que se duplica `n`
(0.25 → 0.0625 → 0.0156 → …). Simpson 1/3 tiene un error proporcional a h⁴ y es exacto
para polinomios de grado 3 o menor, por eso con `f(x) = x²` da el valor exacto desde `n = 2`.
