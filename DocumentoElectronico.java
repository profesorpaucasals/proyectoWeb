/**
 * Clase DocumentoElectronico - Esta clase contiene la especialización
 * de propiedades y métodos propios de una publicación del sistema de archivo.
 * 
 * @author Juan Pedro Cerro Martínez
 * @version 03/03/2022
 */

import java.util.*;

public class DocumentoElectronico extends Publicacion {
    // Propiedades de la clase
    private long pesoKb;
    private String uri;

    /**
     * Método constructor sobrecargado de la clase
     * 
     * @param pTitulo Título que identifica la publicación
     * @param pBestseller Si es o no una publicación bestseller
     * @param pDepartamento Departamento responsable de la custodia de la publicación
     */
    public DocumentoElectronico(String pTitulo, boolean pBestseller, Departamento pDepartamento)  {
        super(pTitulo, pBestseller, pDepartamento);
    }
    
    /**
     * Método constructor específico de la clase
     * 
     * @param pTitulo Título que identifica la publicación
     * @param pBestseller Si es o no una publicación bestseller
     * @param pDepartamento Departamento responsable de la custodia de la publicación
     * @param pPesoKb Número de Kb que ocupa el fichero en disco
     * @param pUri Dirección electrónica para acceder al fichero
     */
    public DocumentoElectronico(String pTitulo, boolean pBestseller, Departamento pDepartamento, long pPesoKb, String pUri) {
        super(pTitulo, pBestseller, pDepartamento);
        this.pesoKb=pPesoKb;
        this.uri=pUri;
    }
    
    /**
     * Método accesor de la propiedad "pesoKb"
     * 
     * @param 
     * @return El long con el contenido de la propiedad
     */
    public long getPesoKb() {
        return this.pesoKb;
    }

    /**
     * Método instanciador de la propiedad "pesoKb"
     * 
     * @param pPesoKb Número de Kb que ocupa el fichero en disco
     * @return 
     */
    public void setPesoKb(long pPesoKb) {
        this.pesoKb=pPesoKb;
    }

    /**
     * Método accesor de la propiedad "uri"
     * 
     * @param 
     * @return El String con el contenido de la propiedad
     */
    public String getUri() {
        return this.uri;
    }

    /**
     * Método instanciador de la propiedad "uri"
     * 
     * @param pUri Dirección electrónica para acceder al fichero
     * @return 
     */
    public void setUri(String pUri) {
        this.uri=pUri;
    }
    

    /**
     * Método sobrecargado que retorna un String con la descripción
     * de la publicación electrónica.
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
        descripcion+="de "+this.getPesoKb()+" Kb de espacio en disco titulada '"+this.getTitulo()+"' custodiada por el Dpto. "+this.getDepartamento().getNombre();
        return descripcion;
    }   
    
}
