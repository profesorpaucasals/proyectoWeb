/**
 * Clase Departamento - Esta clase contiene las propiedades
 * y métodos de uno de los departamentos de la organización
 * 
 * @author Juan Pedro Cerro Martínez
 * @version 22/02/2022
 */

import java.util.*;

public class Departamento
{
    // Propiedades de la clase
    private String nombre;
    private String descripcion;
    private Departamento dependencia;
    private Trabajador responsable;

    /**
     * Método constructor específico de la clase
     * 
     * @param pNombre Nombre del departamento
     * @param pDescripcion La descripción del departamento
     * @param pDependencia Departamento del cual depende el actual
     * @param pResponsable El trabajador responsable del departamento
     */
    public Departamento(String pNombre, String pDescripcion, Departamento pDependencia, Trabajador pResponsable) {
        this.nombre=pNombre;
        this.descripcion=pDescripcion;
        this.dependencia=pDependencia;
        this.responsable=pResponsable;
    }
    
    /**
     * Método accesor de la propiedad "nombre"
     * 
     * @param 
     * @return El nombre con el contenido de la propiedad
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Método instanciador de la propiedad "nombre"
     * 
     * @param pNombre Nombre del departamento
     * @return 
     */
    public void setNombre(String pNombre) {
        this.nombre=pNombre;
    }

    /**
     * Método accesor de la propiedad "descripcion"
     * 
     * @param 
     * @return El string con el contenido de la propiedad
     */
    public String getDescripcion() {
        return this.descripcion;
    }
    
    /**
     * Método instanciador de la propiedad "descripcion"
     * 
     * @param pDescripcion Descripción del departamento
     * @return 
     */
    public void setDescripcion(String pDescripcion) {
        this.nombre=pDescripcion;
    }
    
    /**
     * Método accesor de la propiedad "dependencia"
     * 
     * @param 
     * @return El departamento del cual depende el actual
     */
    public Departamento getDependencia() {
        return this.dependencia;
    }
    
    /**
     * Método instanciador de la propiedad "dependencia"
     * 
     * @param pDependencia El departamento del cual depende el actual
     * @return 
     */
    public void setDependencia(Departamento pDependencia) {
        this.dependencia=pDependencia;
    }

    /**
     * Método accesor de la propiedad "responsable"
     * 
     * @param 
     * @return El trabajador responable del departamento
     */
    public Trabajador getResponsable() {
        return this.responsable;
    }
    
    /**
     * Método instanciador de la propiedad "responsable"
     * 
     * @param pResponsable El trabajador resposnable del departamento
     * @return 
     */
    public void setResponsable(Trabajador pResponsable) {
        pResponsable.setResponsabilidad(true);
        this.responsable=pResponsable;
        
    }

    /**
     * Método que retorna una cadena con el nombre del departamento,
     * su responsable y, de forma recursiva, el departamento dependiente
     * 
     * @param 
     * @return La cadena con los detalles del departamento y sus dependientes
     */
    public String listarDependenciasDepartamento() {
        String respuesta=new String();
        respuesta="Departamento: "+this.getNombre()+" | Responsable: "+this.getResponsable().getNombreCompleto();
        if (this.getDependencia()!=null) {
            respuesta+="\n\tDEPENDE DE -> "+this.getDependencia().listarDependenciasDepartamento();
        }
        return respuesta;
    }

}
