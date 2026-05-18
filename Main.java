/***********************************************************************
 * Module: Main.java
 * Author: Lopez, Macay y Paillacho
 ***********************************************************************/

import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Clase principal del sistema.
 * 
 * @author Lopez, Macay y Paillacho
 * @version 1.0
 * @since 2026
 */
public class Main {

   static Scanner sc =
           new Scanner(System.in);

   // LISTA DE DOCENTES
   static ArrayList<Docente> docentes =
           new ArrayList<>();

   // LISTA DE REGISTROS
   static ArrayList<Registro> registros =
           new ArrayList<>();

   /**
    * Méeodo principal.
    * 
    * @param args argumentos
    * @throws IOException error archivo
    */
   public static void main(String[] args)
           throws IOException {

      int opcion;

      do {

         System.out.println("\n===== SISTEMA DOCENTE =====");
         System.out.println("1. Registrar entrada");
         System.out.println("2. Registrar salida");
         System.out.println("3. Mostrar registros");
         System.out.println("4. Salir");
         System.out.print("Seleccione opción: ");

         opcion = sc.nextInt();

         sc.nextLine();

         switch(opcion) {

            case 1:

               registrarEntrada();
               break;

            case 2:

               registrarSalida();
               break;

            case 3:

               mostrarRegistros();
               break;

            case 4:

               System.out.println("Saliendo...");
               break;

            default:

               System.out.println("Opcion incorrecta");
         }

      } while(opcion != 4);

      sc.close();
   }

   /**
    * Registra entrada del docente.
    * 
    * @throws IOException error archivo
    */
   public static void registrarEntrada() throws IOException {

      System.out.print( "Ingrese nombre: ");

      String nombre = sc.nextLine();

      System.out.print( "Ingrese apellido: ");

      String apellido = sc.nextLine();

      System.out.print("Ingrese cedula: ");

      int cedula = sc.nextInt();

      sc.nextLine();

      System.out.print( "Ingrese facultad: ");

      String facultad = sc.nextLine();

      System.out.print("Ingrese carrera: ");

      String carrera = sc.nextLine();

      // CREAR DOCENTE
      Docente d = new Docente(nombre, apellido, cedula, facultad, carrera);

      docentes.add(d);

      // FECHA AUTOMATICA
      LocalDate hoy = LocalDate.now();

      Fecha f = new Fecha( hoy.getDayOfMonth(), hoy.getMonthValue(), hoy.getYear());

      // FECHA Y HORA COMPLETA
      LocalDateTime ahora = LocalDateTime.now();

      DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

      String fechaHora = ahora.format(formato);

      // CREAR REGISTRO
      Registro r1 = new Registro( "", "", cedula, f);

      // HORA ENTRADA
      r1.hora_llegada();

      // AGREGAR REGISTRO
      registros.add(r1);
      d.addRegistro(r1);
      f.addRegistro(r1);

      // MOSTRAR DATOS
      System.out.println( "\nEntrada registrada correctamente");

      System.out.println("Codigo: " + fechaHora);

      System.out.println("Hora entrada: " + r1.gethora_llegada());

      // GUARDAR EN TXT
      guardarEntrada(nombre, apellido, cedula, facultad, carrera, r1, fechaHora);
   }

   /**
    * Registra salida usando cedula.
    * 
    * @throws IOException error archivo
    */
   public static void registrarSalida() throws IOException {

      System.out.print( "Ingrese cedula: ");

      int cedula = sc.nextInt();

      sc.nextLine();

      boolean encontrado = false;

      for(Registro r : registros) {

         if(r.getid() == cedula) {

            r.hora_salida();

            System.out.println("\nSalida registrada correctamente");

            System.out.println( "Hora salida: " + r.gethora_salida());

            System.out.println( "Horas trabajadas: " + r.calcularHorasTrabajadas());

            guardarSalida(cedula,r);

            encontrado = true;

            break;
         }
      }

      if(!encontrado) {

         System.out.println("No existe registro para esa cédula");
      }
   }

   /**
    * Muestra todos los registros.
    */
   public static void mostrarRegistros() {

      System.out.println("\n===== REGISTROS =====");

      for(Registro r : registros) {

         r.mostrarResumen();

         System.out.println();
      }
   }

   /**
    * Guarda entrada en TXT.
    * 
    * @param nombre nombre
    * @param apellido apellido
    * @param cedula codula
    * @param facultad facultad
    * @param carrera carrera
    * @param r registro
    * @param fechaHora codigo fecha-hora
    * @throws IOException error archivo
    */
   public static void guardarEntrada(
           String nombre,
           String apellido,
           int cedula,
           String facultad,
           String carrera,
           Registro r,
           String fechaHora)
           throws IOException {

      FileWriter fw = new FileWriter("registros.txt",true);

      PrintWriter pw = new PrintWriter(fw);

      pw.println( "DOCENTE");

      pw.println( "Código: " + fechaHora);

      pw.println("Nombre: " + nombre + " " + apellido);

      pw.println( "Cédula: " + cedula);

      pw.println( "Facultad: " + facultad);

      pw.println( "Carrera: " + carrera);

      pw.println( "Fecha: " + r.getfecha().mostrarInfo());

      pw.println( "Hora entrada: " + r.gethora_llegada());

      pw.close();
   }

   /**
    * Guarda salida en TXT.
    * 
    * @param cedula cédula
    * @param r registro
    * @throws IOException error archivo
    */
   public static void guardarSalida( int cedula, Registro r) throws IOException {

      FileWriter fw =
              new FileWriter(
                      "registros.txt",
                      true
              );

      PrintWriter pw = new PrintWriter(fw);

      pw.println( "Hora salida: " + r.gethora_salida());

      pw.println( "Horas trabajadas: " + r.calcularHorasTrabajadas());

      pw.println("========================");

      pw.close();
   }
}