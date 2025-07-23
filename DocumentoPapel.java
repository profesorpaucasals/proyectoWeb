/**
 * Clase DocumentoPapel - Esta clase contiene la especialización
 * de propiedades y métodos propios de una publicación del sistema de archivo.
 * 
 * @author Juan Pedro Cerro Martínez
 * @version 03/03/2022
 */

import java.util.*;

public class DocumentoPapel extends Publicacion {
    // Propiedades de la clase
    private int numPaginas;
    private boolean color;

    /**
     * Método constructor sobrecargado de la clase
     * 
     * @param pTitulo Título que identifica la publicación
     * @param pBestseller Si es o no una publicación bestseller
     * @param pDepartamento Departamento responsable de la custodia de la publicación
     */
    public DocumentoPapel(String pTitulo, boolean pBestseller, Departamento pDepartamento)  {
        super(pTitulo, pBestseller, pDepartamento);
    }
    
    /**
     * Método constructor específico de la clase
     * 
     * @param pTitulo Título que identifica la publicación
     * @param pBestseller Si es o no una publicación bestseller
     * @param pDepartamento Departamento responsable de la custodia de la publicación
     * @param pNumPaginas Número de páginas de la publicación en papel
     * @param pColor Si la publicación en papel es a color o no
     */
    public DocumentoPapel(String pTitulo, boolean pBestseller, Departamento pDepartamento, int pNumPaginas, boolean pColor) {
        super(pTitulo, pBestseller, pDepartamento);
        this.numPaginas=pNumPaginas;
        this.color=pColor;
    }
    
    /**
     * Método accesor de la propiedad "numPaginas"
     * 
     * @param 
     * @return El int con el contenido de la propiedad
     */
    public int getNumPaginas() {
        return this.numPaginas;
    }

    /**
     * Método instanciador de la propiedad "numPaginas"
     * 
     * @param pNumPaginas Número de páginas de la publicación en papel
     * @return 
     */
    public void setNumPaginas(int pNumPaginas) {
        this.numPaginas=pNumPaginas;
    }

    /**
     * Método accesor de la propiedad "color"
     * 
     * @param 
     * @return El boolean con el contenido de la propiedad
     */
    public boolean esColor() {
        return this.color;
    }

    /**
     * Método instanciador de la propiedad "color"
     * 
     * @param pColor Si la publicación en papel es a color o no
     * @return 
     */
    public void setColor(boolean pColor) {
        this.color=pColor;
    }
    

    /**
     * Método sobrecargado que retorna un String con la descripción
     * de la publicación en papel.
     * 
     * @param 
     * @return El String con la descripción
     */
    public String getDescripcion() {
        String descripcion=new String();
        descripcion="Publicación ";
        if (this.esBestseller()) {
            descripcion+="bestseller ";
        }
        
        if (this.esColor()) {
            descripcion+="a color ";
        } else {
            descripcion+="en B/N ";
        }
        descripcion+="titulada '"+this.getTitulo()+"' custodiada por el Dpto. "+this.getDepartamento().getNombre();
        return descripcion;
    }   
    
}
