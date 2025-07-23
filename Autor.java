/**
 * Clase Autor - Esta clase heredada de Persona contiene la especialización
 * de propiedades y métodos propios de un actor modelado del sistema
 * 
 * @author Juan Pedro Cerro Martínez
 * @version 02/03/2022
 */

import java.util.*;
import java.text.ParseException;

public class Autor extends Persona
{
    // Propiedades de la clase
    private boolean esFamoso;
    private ArrayList<Publicacion> publicaciones;
    
    /**
     * Método constructor sobrecargado de la clase
     * 
     * @param pNombreCompleto Nombre de la persona
     * @param pSexo El sexo de la persona {"H" - Hombre | "M" - Mujer}
     * @param pFechaNacimiento Fecha de nacimiento de la persona en formato "dd/mm/aaaa"
     * @param pTelefono Teléfono de contacto de la persona
     * @param pCorreoElectronico Correo electrónico de contacto de la persona
     */
    public Autor(String pNombreCompleto, char pSexo, String pFechaNacimiento, int pTelefono, String pCorreoElectronico) throws ParseException  {
        super(pNombreCompleto, pSexo, pFechaNacimiento, pTelefono, pCorreoElectronico);
    }
    
    
    /**
     * Método constructor específico de la clase
     * 
     * @param pNombreCompleto Nombre del trabajador
     * @param pSexo El sexo del trabajador {"H" - Hombre | "M" - Mujer}
     * @param pFechaNacimiento Fecha de nacimiento del trabajador en formato "dd/mm/aaaa"
     * @param pTelefono Teléfono de contacto del trabajador
     * @param pCorreoElectronico Correo electrónico de contacto del trabajador
     * @param pEsFamoso Fama del autor/a
     */
    public Autor(String pNombreCompleto, char pSexo, String pFechaNacimiento, int pTelefono, String pCorreoElectronico, boolean pEsFamoso) throws ParseException  {
        super(pNombreCompleto, pSexo, pFechaNacimiento, pTelefono, pCorreoElectronico);
        this.esFamoso=pEsFamoso;
        this.publicaciones= new ArrayList<Publicacion>();
    }
    
    /**
     * Método accesor de la propiedad "esFamoso"
     * 
     * @param 
     * @return El boolean con el contenido de la propiedad
     */
    public boolean esFamoso() {
        return this.esFamoso;
    }

    /**
     * Método instanciador de la propiedad "esFamoso"
     * 
     * @param pEsFamoso El valor lógico indicando si el autor es famoso o no
     * @return 
     */
    public void setFamoso(boolean pFamoso) {
        this.esFamoso=pFamoso;
    }
    
    /**
     * Método accesor de la propiedad "publicaciones"
     * @param 
     * @return El ArrayList con las autorías del autor/a
     */
    public ArrayList<Publicacion> getPublicaciones() {
        return this.publicaciones;
    }
    
    /**
     * Método agregador de una Publicacion a un Autor
     * @param pPublicacion El objeto de una publicación del autor/a que queremos agregar
     * @return 
     */
    public void agregarPublicacion(Publicacion pPublicacion) {
        if (publicaciones.contains(pPublicacion)) {
            System.out.println("ERROR AUTOR: La publicación '"+pPublicacion.getTitulo()+"'"+" ya está asignada al autor/a "+this.nombreCompleto+"\n");
        } else {
            this.publicaciones.add(pPublicacion);
        }
    }
    
    /**
     * Método eliminador de una Publicacion a un Autor
     * @param Autoria El objeto de una publicación del autor/a que queremos eliminar
     * @return 
     */
    public void eliminarPublicacion(Publicacion pPublicacion) {
        if (publicaciones.contains(pPublicacion)) {
            this.publicaciones.remove(pPublicacion);
        } else {
            System.out.println("ERROR AUTOR: La publicación '"+pPublicacion.getTitulo()+"'"+" NO está asignada al autor/a "+this.nombreCompleto+" y no puede eliminarse\n");
        }
    }
    
    /**
     * Método que retorna una cadena con el listado de publicaciones del autor.
     * El listado incluye los títulos de las publicaciones y, dependiendo del soporte
     * de la publicación, el número de páginas o el peso en Kb
     * 
     * @param 
     * @return La cadena con los detalles de las publicaciones de un/a autor/a
     */
    public String listarPublicaciones() {
        String respuesta=new String();
        respuesta="Listado de publicaciones del autor/a '"+this.getNombreCompleto()+"'";
        for (Publicacion pub:this.getPublicaciones()) {
            respuesta+="\n\t'"+pub.getTitulo()+"'";
            if (pub instanceof DocumentoPapel) {
                DocumentoPapel doc=new DocumentoPapel("",false,null);
                doc=(DocumentoPapel)pub;
                respuesta+=" de "+doc.getNumPaginas()+" páginas";
            } else {
                DocumentoElectronico file=new DocumentoElectronico("",false,null);
                file=(DocumentoElectronico)pub;
                respuesta+=" de "+file.getPesoKb()+" kilobytes";
            }
        }
        return respuesta;
    }
}
