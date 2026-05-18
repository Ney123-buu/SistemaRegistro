/***********************************************************************
 * Module:  Docente.java
 * Author:  Lopez, Macay y Paillacho
 * Purpose: Defines the Class Docente
 ***********************************************************************/

import java.util.Collection;
import java.util.HashSet;

/**
 * Clase Docente.
 * Permite almacenar la informacion de un docente
 * y administrar sus registros de asistencia.
 * 
 * @author Lopez, Macay y Paillacho
 * @version 1.0
 * @since 2026
 */
public class Docente {

   private String nombre;
   private String apellido;
   private int cedula;
   private String facultad;
   private String carrera;

   private Collection<Registro> registro;

   /**
    * Constructor de la clase Docente.
    * 
    * @param nombre nombre del docente
    * @param apellido apellido del docente
    * @param cedula cedula del docente
    * @param facultad facultad del docente
    * @param carrera carrera del docente
    */
   public Docente(String nombre,
                  String apellido,
                  int cedula,
                  String facultad,
                  String carrera) {

      this.nombre = nombre;
      this.apellido = apellido;
      this.cedula = cedula;
      this.facultad = facultad;
      this.carrera = carrera;

      this.registro = new HashSet<>();
   }

   /**
    * Agrega un registro al docente.
    * 
    * @param r registro a agregar
    */
   public void addRegistro(Registro r) {

      if (r != null) {
         registro.add(r);
      }
   }

   /**
    * Calcula el total de horas trabajadas.
    * 
    * @return total de horas trabajadas
    */
   public double totalHorasTrabajadas() {

      double total = 0;

      for (Registro r : registro) {
         total += r.calcularHorasTrabajadas();
      }

      return total;
   }

   /**
    * Obtiene los registros del docente.
    * 
    * @return coleccion de registros
    */
   public Collection<Registro> getRegistro() {
      return registro;
   }
}