/***********************************************************************
 * Module:  Fecha.java
 * Author:  Lopez, Macay y Paillacho
 * Purpose: Defines the Class Fecha
 ***********************************************************************/

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Clase Fecha.
 * Permite almacenar una fecha y administrar
 * registros asociados.
 * 
 * @author Lopez, Macay y Paillacho
 * @version 1.0
 * @since 2026
 */
public class Fecha {

   private int dia;
   private int mes;
   private int anio;

   private Collection<Registro> registro;

   /**
    * Constructor de la clase Fecha.
    * 
    * @param dia día
    * @param mes mes
    * @param anio año
    */
   public Fecha(int dia, int mes, int anio) {

      this.dia = dia;
      this.mes = mes;
      this.anio = anio;

      this.registro = new HashSet<>();
   }

   /**
    * Obtiene el día.
    * 
    * @return día
    */
   public int getdia() {
      return dia;
   }

   /**
    * Modifica el día.
    * 
    * @param newDia nuevo día
    */
   public void setdia(int newDia) {
      dia = newDia;
   }

   /**
    * Obtiene el mes.
    * 
    * @return mes
    */
   public int getmes() {
      return mes;
   }

   /**
    * Modifica el mes.
    * 
    * @param newMes nuevo mes
    */
   public void setmes(int newMes) {
      mes = newMes;
   }

   /**
    * Obtiene el anio.
    * 
    * @return anio
    */
   public int getanio() {
      return anio;
   }

   /**
    * Modifica el anio.
    * 
    * @param newAnio nuevo anio
    */
   public void setanio(int newAnio) {
      anio = newAnio;
   }

   /**
    * Muestra la fecha completa.
    * 
    * @return fecha en formato dia/mes/anio
    */
   public String mostrarInfo() {
      return dia + "/" + mes + "/" + anio;
   }

   /**
    * Obtiene la coleccion de registros.
    * 
    * @return coleccion de registros
    */
   public Collection<Registro> getRegistro() {
      return registro;
   }

   /**
    * Obtiene un iterador de registros.
    * 
    * @return iterador
    */
   public Iterator<Registro> getIteratorRegistro() {
      return registro.iterator();
   }

   /**
    * Modifica la coleccion de registros.
    * 
    * @param newRegistro nueva coleccion
    */
   public void setRegistro(Collection<Registro> newRegistro) {

      registro.clear();
      registro.addAll(newRegistro);
   }

   /**
    * Agrega un registro.
    * 
    * @param newRegistro nuevo registro
    */
   public void addRegistro(Registro newRegistro) {

      if (newRegistro != null) {
         registro.add(newRegistro);
      }
   }

   /**
    * Elimina un registro.
    * 
    * @param oldRegistro registro a eliminar
    */
   public void removeRegistro(Registro oldRegistro) {
      registro.remove(oldRegistro);
   }

   /**
    * Elimina todos los registros.
    */
   public void removeAllRegistro() {
      registro.clear();
   }
}