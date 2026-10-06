# Método de Gauss en Java

Programa que resuelve un sistema de ecuaciones lineales mediante eliminación gaussiana y sustitución regresiva.

Materia: SCC-1017 Métodos Numéricos, Unidad 3.  
Instituto Tecnológico Superior de Xalapa, Ingeniería en Sistemas Computacionales.

## Lenguaje de programación

Java (JDK 8 o superior).

## Estructura

```
src/gauss/
    Defmatrizz.java      Datos: define la matriz aumentada del sistema
    Gauss.java           Lógica: eliminación gaussiana y sustitución regresiva
    Lanzador_gaus.java   Principal: une los módulos y muestra los resultados
```

El programa trabaja en dos pasos:

1. Eliminación gaussiana: hace ceros debajo de la diagonal principal hasta obtener una matriz triangular superior.
2. Sustitución regresiva: despeja la última variable y avanza hacia arriba usando los valores ya conocidos.

## Compilación y ejecución

### Desde la terminal

1. Clonar el repositorio y entrar a la carpeta del proyecto:

```bash
git clone https://github.com/Pabmx11/M-todos-N-mericos-ITSX.git
cd M-todos-N-mericos-ITSX/Metodo-de-Gauss
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

1. Abrir la carpeta `Metodo-de-Gauss` con File > Open.
2. Verificar que haya un JDK configurado en File > Project Structure > SDK.
3. Abrir `src/gauss/Lanzador_gaus.java`.
4. Ejecutar el método `main`.

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

Salida en consola:

```
Soluciones del sistema:
x1 = 3.0000
x2 = -2.5000
x3 = 7.0000
```

Para resolver otro sistema basta con cambiar la matriz en `src/gauss/Defmatrizz.java`.
