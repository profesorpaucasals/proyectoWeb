/**
 * Clase Coleccion - Esta clase contiene las propiedades y 
 * métodos propios de una colección de publicaciones del sistema de archivo.
 * 
 * @author Juan Pedro Cerro Martínez
 * @version 08/03/2022
 */

import java.util.*;

public class Coleccion {
    // Propiedades de la clase
    private String nombre;
    private String descripcion;
    private int numPublicaciones;
    private ArrayList<Publicacion> publicaciones;

    /**
     * Método constructor específico de la clase
     * 
     * @param pNombre Nombre que identifica la colección
     * @param pDescripcion Descripción de la colección
     * @param pPublicaciones Lista de publicaciones de la colección
     */
    public Coleccion(String pNombre, String pDescripcion) {
        this.nombre=new String(pNombre);
        this.descripcion=pDescripcion;
        this.numPublicaciones=0;
        this.publicaciones=new ArrayList<Publicacion>();
    }
    
    /**
     * Método accesor de la propiedad "nombre"
     * 
     * @param 
     * @return El String con el contenido de la propiedad
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Método instanciador de la propiedad "nombre"
     * 
     * @param pNombre Nombre que identifica la colección
     * @return 
     */
    public void setNombre(String pNombre) {
        this.nombre=pNombre;
    }
    
    /**
     * Método accesor de la propiedad "descripcion"
     * 
     * @param 
     * @return El String con el contenido de la propiedad
     */
    public String getDescripcion() {
        return this.descripcion;
    }

    /**
     * Método instanciador de la propiedad "nombre"
     * 
     * @param pDescripcion Descripción de la colección
     * @return 
     */
    public void setDescripcion(String pDescripcion) {
        this.descripcion=pDescripcion;
    }
    
    /**
     * Método accesor de la propiedad "publicaciones"
     * @param 
     * @return El ArrayList con las publicaciones de la colección
     */
    public ArrayList<Publicacion> getPublicaciones() {
        return this.publicaciones;
    }
    
    /**
     * Método accesor de la propiedad "numPublicaciones"
     * 
     * @param 
     * @return El int con el contenido de la propiedad
     */
    public int getNumPublicaciones() {
        return this.numPublicaciones;
    }
    
    /**
     * Método agregador de una Publicacion a una Coleccion
     * @param pPublicacion El objeto de una publicación de la coleccón que queremos agregar
     * @return 
     */
    public void agregarPublicacion(Publicacion pPublicacion) {
        if (publicaciones.contains(pPublicacion)) {
            System.out.println("ERROR COLECCION: La publicación '"+pPublicacion.getTitulo()+"'"+" ya está asignada a la colección '"+this.nombre+"'\n");
        } else {
            this.publicaciones.add(pPublicacion);
            this.numPublicaciones++;
        }
    }
    
    /**
     * Método eliminador de una Publicacion a una Coleccion
     * @param pPublicacion El objeto de una publicación de la coleccón que queremos eliminar
     * @return 
     */
    public void eliminarPublicacion(Publicacion pPublicacion) {
         if (publicaciones.contains(pPublicacion)) {
            this.publicaciones.remove(pPublicacion);
            this.numPublicaciones--;
            } else {
                System.out.println("ERROR COLECCION: La publicación '"+pPublicacion.getTitulo()+"'"+" NO está asignada a la colección '"+this.nombre+"' y no puede eliminarse\n");
        }
    }    

    /**
     * Método que retorna una cadena con el listado de publicaciones de la coleccion.
     * El listado incluye el título, el tipo de publicación, el autor y, también,
     * el trabajador responsable del departamento que la custodia
     * 
     * @param 
     * @return La cadena con los detalles del departamento y sus dependientes
     */
    public String listarDetallePublicaciones() {
        String respuesta=new String();
        respuesta="Detalle de la colección '"+this.getNombre()+"' con un total de "+this.getNumPublicaciones()+" publicaciones";
        for (Publicacion pub:this.getPublicaciones()) {
            respuesta+="\n\tDetalle de la publicación: '"+pub.getTitulo()+"' en formato ";
            if (pub instanceof DocumentoPapel) {
                respuesta+="papel";
            } else {
                respuesta+="digital";
            }
            respuesta+="\n\t\tAutorías ->";
            for (Autor aut:pub.getAutorias()) {
                respuesta+=" '"+aut.getNombreCompleto()+"'";
            }
            respuesta+="\n\t\tResponsable custodia -> "+pub.getDepartamento().getResponsable().getNombreCompleto();
        }
        return respuesta;
    }
}
