# Sistema de Registro Docente

## Descripción

Sistema desarrollado en Java utilizando Programación Orientada a Objetos (POO).

El sistema permite:

- Registrar entrada de docentes
- Registrar salida mediante cédula
- Registrar fecha y hora automática
- Calcular horas trabajadas
- Guardar registros en TXT

---

# Clases del Proyecto

## Main.java

Clase principal del sistema.

Funciones:
- registrar entrada,
- registrar salida,
- mostrar registros,
- guardar datos.

---

## Docente.java

Clase que representa al docente.

Atributos:
- nombre,
- apellido,
- cédula,
- facultad,
- carrera.

---

## Registro.java

Clase encargada del registro de asistencia.

Funciones:
- hora de llegada,
- hora de salida,
- cálculo de horas trabajadas.

---

## Fecha.java

Clase utilizada para almacenar:
- día,
- mes,
- año.

---

# Funcionamiento

## Registrar Entrada

El usuario ingresa:

- nombre,
- apellido,
- cédula,
- facultad,
- carrera.

El sistema genera automáticamente:
- fecha,
- hora,
- código fecha-hora.

Ejemplo:

```text
20260517235940
```

---

## Registrar Salida

El usuario ingresa la cédula.

El sistema:
- busca el registro,
- registra la hora de salida,
- calcula horas trabajadas.

---

# Archivo TXT

El sistema genera:

```text
registros.txt
```

donde se almacenan:
- datos del docente,
- fecha,
- entrada,
- salida,
- horas trabajadas.

---

# Librerías Utilizadas

```java
java.util.Scanner
java.util.ArrayList
java.time.LocalDate
java.time.LocalDateTime
java.time.format.DateTimeFormatter
java.io.FileWriter
java.io.PrintWriter
```

---

# Autores

- Lopez
- Macay
- Paillacho

---

# Versión

Versión 1.0 - 2026
