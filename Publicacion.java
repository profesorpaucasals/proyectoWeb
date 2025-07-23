/**
 * Abstract class Publicacion - Esta clase abstracta contiene la generalidad
 * de propiedades y métodos propios de una publicación del sistema de archivo.
 * 
 * @author Juan Pedro Cerro Martínez
 * @version 03/03/2022
 */

import java.util.*;

public abstract class Publicacion {
    // Propiedades de la clase
    protected String titulo;
    protected boolean bestseller;
    protected Departamento departamento;
    private ArrayList<Autor> autorias;

    /**
     * Método constructor específico de la clase
     * 
     * @param pTitulo Título que identifica la publicación
     * @param pBestseller Si es o no una publicación bestseller
     * @param pDepartamento Departamento responsable de la custodia de la publicación
     */
    public Publicacion(String pTitulo, boolean pBestseller, Departamento pDepartamento) {
        this.titulo=new String(pTitulo);
        this.bestseller=pBestseller;
        this.departamento=pDepartamento;
        this.autorias=new ArrayList<Autor>();
    }
    
    /**
     * Método accesor de la propiedad "titulo"
     * 
     * @param 
     * @return El String con el contenido de la propiedad
     */
    protected String getTitulo() {
        return this.titulo;
    }

    /**
     * Método instanciador de la propiedad "titulo"
     * 
     * @param pTitulo Título que identifica la publicación
     * @return 
     */
    protected void setTitulo(String pTitulo) {
        this.titulo=pTitulo;
    }

    /**
     * Método accesor de la propiedad "bestseller"
     * 
     * @param 
     * @return El boolean con el contenido de la propiedad
     */
    protected boolean esBestseller() {
        return this.bestseller;
    }

    /**
     * Método instanciador de la propiedad "bestseller"
     * 
     * @param pBestseller Si es o no una publicación bestseller
     * @return 
     */
    protected void setBestseller(boolean pBestseller) {
        this.bestseller=pBestseller;
    }

    /**
     * Método accesor de la propiedad "departamento"
     * 
     * @param 
     * @return El Departamento con el contenido de la propiedad
     */
    protected Departamento getDepartamento() {
        return this.departamento;
    }

    /**
     * Método instanciador de la propiedad "departamento"
     * 
     * @param pDepartamento Departamento responsable de la custodia de la publicación
     * @return 
     */
    protected void setDepartamento(Departamento pDepartamento) {
        this.departamento=pDepartamento;
    }

    /**
     * Método accesor de la propiedad "autorias"
     * @param 
     * @return El ArrayList con los autores de la publicación
     */
    public ArrayList<Autor> getAutorias() {
        return this.autorias;
    }
    
    /**
     * Método agregador de un/a Autor/a a una Publicacion
     * @param pAutor El objeto de un/a autor/a de la publicación que queremos agregar
     * @return 
     */
    public void agregarAutor(Autor pAutor) {
        if (autorias.contains(pAutor)) {
            System.out.println("ERROR PUBLICACION: El autor/a "+pAutor.getNombreCompleto()+" ya está asignado a la publicación '"+this.titulo+"'\n");
        } else {
            this.autorias.add(pAutor);
        }
    }
    
    /**
     * Método eliminador de una Autoria a una Publicacion
     * @param pAutor El objeto de un/a autor/a de la publicación que queremos eliminar
     * @return 
     */
    public void eliminarAutor(Autor pAutor) {
        if (autorias.contains(pAutor)) {
            this.autorias.remove(pAutor);
        } else {
            System.out.println("ERROR PUBLICACION: El autor/a "+pAutor.getNombreCompleto()+" NO está asignado a la publicación '"+this.titulo+"' y no puede eliminarse\n");
        }
    }    

    /**
     * Método no implementado que retorna un String con la descripción de la publicación.
     * Esta descripción dependerá el tipo de publicación de que se trate en función
     * de las subclases.
     * 
     * @param 
     * @return El String con la descripción
     */
    protected String getDescripcion() {
        return null;
    }   
    
}
