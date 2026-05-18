/***********************************************************************
 * Module:  Registro.java
 * Author:  Lopez, Macay y Paillacho
 * Purpose: Defines the Class Registro
 ***********************************************************************/

import java.time.LocalTime;

/**
 * Clase Registro.
 * Permite registrar hora de entrada,
 * hora de salida y calcular horas trabajadas.
 * 
 * @author Lopez, Macay y Paillacho
 * @version 1.0
 * @since 2026
 */
public class Registro {

   private String hora_llegada;
   private String hora_salida;
   private int id;
   private Fecha fecha;

   /**
    * Constructor de la clase Registro.
    * 
    * @param hora_llegada hora de llegada
    * @param hora_salida hora de salida
    * @param id identificador
    * @param fecha fecha del registro
    */
   public Registro(String hora_llegada, String hora_salida, int id, Fecha fecha) {

      this.hora_llegada = hora_llegada;
      this.hora_salida = hora_salida;
      this.id = id;
      this.fecha = fecha;
   }

   /**
    * Registra la hora de llegada.
    */
   public void hora_llegada() {

      this.hora_llegada =
              LocalTime.now().toString().substring(0,5);
   }

   /**
    * Registra la hora de salida.
    */
   public void hora_salida() {

      this.hora_salida =
              LocalTime.now().toString().substring(0,5);
   }

   /**
    * Obtiene la hora de llegada.
    * 
    * @return hora de llegada
    */
   
   public String gethora_llegada() {
      return hora_llegada;
   }

   /**
    * Modifica la hora de llegada.
    * 
    * @param h nueva hora
    */

   public void sethora_llegada(String h) {
      hora_llegada = h;
   }

   /**
    * Obtiene la hora de salida.
    * 
    * @return hora de salida
    */

   public String gethora_salida() {
      return hora_salida;
   }

   /**
    * Modifica la hora de salida.
    * 
    * @param h nueva hora
    */

   public void sethora_salida(String h) {
      hora_salida = h;
   }

   /**
    * Obtiene el id del registro.
    * 
    * @return id
    */

   public int getid() {
      return id;
   }

   /**
    * Modifica el id.
    * 
    * @param id nuevo id
    */

   public void setid(int id) {
      this.id = id;
   }

   /**
    * Obtiene la fecha.
    * 
    * @return fecha
    */

   public Fecha getfecha() {
      return fecha;
   }

   /**
    * Modifica la fecha.
    * 
    * @param f nueva fecha
    */

   public void setfecha(Fecha f) {
      fecha = f;
   }

   /**
    * Calcula minutos trabajados.
    * 
    * @return minutos trabajados
    */

   public int calcularMinutosTrabajados() {

      if (hora_llegada == null
              || hora_salida == null) {

         return 0;
      }

      String[] llegada = hora_llegada.split(":");
      String[] salida = hora_salida.split(":");

      int h1 = Integer.parseInt(llegada[0]);
      int m1 = Integer.parseInt(llegada[1]);

      int h2 = Integer.parseInt(salida[0]);
      int m2 = Integer.parseInt(salida[1]);

      int totalLlegada = h1 * 60 + m1;
      int totalSalida = h2 * 60 + m2;

      return totalSalida - totalLlegada;
   }

   /**
    * Calcula horas trabajadas.
    * 
    * @return horas trabajadas
    */


   public double calcularHorasTrabajadas() {

      return calcularMinutosTrabajados() / 60.0;
   }

   /**
    * Muestra resumen del registro.
    */
   public void mostrarResumen() {

      System.out.println("ID: " + id);

      System.out.println("Fecha: " + fecha.mostrarInfo());

      System.out.println("Hora llegada: " + hora_llegada);

      System.out.println("Hora salida: " + hora_salida);

      System.out.println("Minutos trabajados: " + calcularMinutosTrabajados());

      System.out.println("Horas trabajadas: " + calcularHorasTrabajadas());
   }
}