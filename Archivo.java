import java.text.ParseException;
import java.util.*;

/**
 * La classe Archivo instancia un sistema de gestión documental
 * 
 * @author Juan Pedro Cerro Martínez 
 * @version 2.0
 */
public class Archivo
{
    // Propiedades se la clase principal
    private String nombre;
    private ArrayList<Coleccion> colecciones;
    
    /**
     * Constructor por defecto
     */
    public Archivo()
    {
        this.colecciones=new ArrayList<Coleccion>();
    }
    
    /**
     * Método constructor específico de la clase
     * 
     * @param pNombre Nombre del archivo
     */
    public Archivo(String pNombre) {
        this.nombre=pNombre;
        this.colecciones=new ArrayList<Coleccion>();
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
     * @param pNombre Nombre del archivo
     * @return 
     */
    public void setNombre(String pNombre) {
        this.nombre=pNombre;
    }

    /**
     * Método agregador de una Coleccion a un Archivo
     * @param pColeccion El objeto de una colección del archivo que queremos agregar
     * @return 
     */
    public void agregarColeccion(Coleccion pColeccion) {
        if (colecciones.contains(pColeccion)) {
            System.out.println("ERROR ARCHIVO: La colección '"+pColeccion.getNombre()+"'"+" ya está incluida en el archivo '"+this.nombre+"'\n");
        } else {
            this.colecciones.add(pColeccion);
        }
    }
    
    /**
     * Método accesor de la propiedad "colecciones"
     * @param 
     * @return El ArrayList con las colecciones del archivo
     */
    public ArrayList<Coleccion> getColecciones() {
        return this.colecciones;
    }
    
    /**
     * Método eliminador de una Coleccion a un Archivo
     * @param pColeccion El objeto de una colección del archivo que queremos eliminar
     * @return 
     */
    public void eliminarColeccion(Coleccion pColeccion) {
         if (colecciones.contains(pColeccion)) {
            this.colecciones.remove(pColeccion);
            } else {
                System.out.println("ERROR ARCHIVO: La colección '"+pColeccion.getNombre()+"'"+" NO está asignada al archivo '"+this.nombre+"' y no puede eliminarse\n");
        }
    }
      
    /**
     * Este método main pone en marcha el sistema de gestión documental
     * 
     */
    public static void main(String args[])  throws ParseException
    {
        // Inicio del juego de pruebas
        
        // Creación del Sistema de Gestión Documental
        Archivo archivo=new Archivo();
        archivo.setNombre("Archivo documental Carlemany");
        
        // En primer lugar damos de alta a todos los trabajadores de la organización
        Trabajador trabajador1= new Trabajador("Elisabeth López Mur",'M',"1105/1976",930000001,"elisabeth@carlemany.edu",null,(float)1700.00,"01/01/2022",false,"11223344556");
        trabajador1= new Trabajador("Elisabeth López Mur",'M',"11/05/1976",930000001,"elisabeth@carlemany.edu",null,(float)1700.00,"01/01/2022",false,"11223344556");
        Trabajador trabajador2= new Trabajador("Raúl Soria García",'H',"10/10/1983",930000002,"raul.soria@carlemany.edu",null,(float)1430.00,"10/04/2021",false,"11223344557");
        Trabajador trabajador3= new Trabajador("Mª Elena Pérez Alhoma",'M',"21/08/1990",930000003,"elena.perez@carlemany.edu",null,(float)2200.00,"23/09/2020",false,"11223344558");
        Trabajador trabajador4= new Trabajador("Manuel Einstein Ruíz",'H',"03/03/1967",930000004,"manuel.einstein@carlemany.edu",null,(float)1950.00,"16/03/2021",false,"11223344559");
        Trabajador trabajador5= new Trabajador("Ana Mª Ávila Megía",'M',"19/05/1986",930000005,"ana.avila@carlemany.edu",null,(float)1630.00,"10/11/2020",false,"11223344560");
        
        // A continuación, creamos los diferentes departamentos de la organización
        Departamento direccion=new Departamento("Dirección","Dirección general de la organización", null, null);
        Departamento administracion=new Departamento("Administración", "Departamento de soporte administrativo de la organización",null, null);
        Departamento comercial=new Departamento("Comercial", "Departamento encargado de las funciones comerciales de la organización",null, null);
        
        // Asignamos dependencias entre departamentos
        administracion.setDependencia(direccion);
        comercial.setDependencia(administracion);
        
        // Definimos los responsables de cada departamento
        direccion.setResponsable(trabajador1);
        administracion.setResponsable(trabajador3);
        comercial.setResponsable(trabajador5);
        
        // Asignamos los trabajadores a sus respectivos departamentos
        trabajador1.setDepartamento(direccion);
        trabajador2.setDepartamento(administracion);
        trabajador3.setDepartamento(administracion);
        trabajador4.setDepartamento(comercial);
        trabajador5.setDepartamento(comercial);
        
        // Identificamos diferentes autores para las publicaciones
        Autor autor1= new Autor("Manuel Hans Ruíz",'H',"01/05/1960",930000006,"manuel.hans@carlemany.edu",false);
        Autor autor2= new Autor("Eliana Swatch López",'M',"12/04/1970",930000007,"eliana.sw@carlemany.edu",true);
        Autor autor3= new Autor("Alberto Menéndez Mayo",'H',"22/12/1992",930000008,"albert.m@carlemany.edu",true);
        Autor autor4= new Autor("Rosa Mª Silva Po",'M',"07/10/1995",930000009,"rosa.po@carlemany.edu",false);
        
        // Creamos cuatro publicaciones en papel y les asignamos sus autores
        DocumentoPapel libro1=new DocumentoPapel("Paradigma de programación orientada a objetos", false, comercial, 95, true);
        DocumentoPapel libro2=new DocumentoPapel("Introducción al lenguaje de modelado UML", true, comercial, 110, false);
        DocumentoPapel libro3=new DocumentoPapel("¿Quién se ha llevado mi queso?", true, administracion, 106, false);
        DocumentoPapel libro4=new DocumentoPapel("La paradoja: un relato sobre la verdadera esencia del liderazgo", true, direccion, 192, false);
        libro1.agregarAutor(autor1);
        autor1.agregarPublicacion(libro1);
        libro1.agregarAutor(autor2);
        autor2.agregarPublicacion(libro1);
        libro2.agregarAutor(autor1);
        autor1.agregarPublicacion(libro2);
        libro2.agregarAutor(autor3);
        autor3.agregarPublicacion(libro2);
        libro3.agregarAutor(autor2);
        autor2.agregarPublicacion(libro3);
        libro4.agregarAutor(autor3);
        autor3.agregarPublicacion(libro4);
        libro4.agregarAutor(autor4);
        autor4.agregarPublicacion(libro4);
        libro4.agregarAutor(autor1);
        autor1.agregarPublicacion(libro4);
        
        // Creamos tres publicaciones digitales y les asignamos sus autores
        DocumentoElectronico fichero1=new DocumentoElectronico("Política de seguridad de los datos de la Intranet", false, direccion, 340, "C:\\Datos\\Soporte\\proteccion.pdf");
        DocumentoElectronico fichero2=new DocumentoElectronico("Catálogo de servicios y productos", false, comercial, 650, "C:\\Datos\\Trimestre1\\catalogo.pdf");
        DocumentoElectronico fichero3=new DocumentoElectronico("Protocolo de gestión de RR.HH.", false, administracion, 1024, "http://dominio.com/protocolo/rrhh.pdf");
        fichero1.agregarAutor(autor2);
        autor2.agregarPublicacion(fichero1);
        fichero1.agregarAutor(autor4);
        autor4.agregarPublicacion(fichero1);
        fichero2.agregarAutor(autor3);
        autor3.agregarPublicacion(fichero2);
        fichero3.agregarAutor(autor1);
        autor1.agregarPublicacion(fichero3);
        
        // Intentamos dar de baja algunas autorías
        libro1.eliminarAutor(autor2);
        autor2.eliminarPublicacion(libro1);
        libro1.eliminarAutor(autor2); // No existe esta asociación
        autor1.eliminarPublicacion(fichero1); // No existe esta asociación
        
        // Intentamos hacer dos asignaciones erróneas de autorías
        libro3.agregarAutor(autor2); // Ya está asignado previamente
        autor2.agregarPublicacion(libro3); // Ya está asignado previamente
        fichero3.agregarAutor(autor1); // Ya está asignado previamente
        autor1.agregarPublicacion(fichero3); // Ya está asignado previamente
        
        // Definimos dos colecciones
        Coleccion coleccionTecnica=new Coleccion("Colección de documentación técnica","Colección dedicada a las publicaciones científico-técnicas más destacadas");
        Coleccion coleccionEmpresarial=new Coleccion("Colección de documentación administrativa","Colección dedicada a las publicaciones vinculadas al entorno empresarial");
        
        // Establecemos las relaciones entre las publicaciones y sus respectivas colecciones
        coleccionTecnica.agregarPublicacion(libro1);
        coleccionTecnica.agregarPublicacion(libro3);
        coleccionTecnica.eliminarPublicacion(libro3);
        coleccionTecnica.agregarPublicacion(libro2);
        coleccionTecnica.agregarPublicacion(fichero1);
        
        coleccionEmpresarial.agregarPublicacion(libro3);
        coleccionEmpresarial.agregarPublicacion(libro4);
        coleccionEmpresarial.agregarPublicacion(fichero2);
        coleccionEmpresarial.agregarPublicacion(fichero3);
        
        // Intentamos hacer dos asignaciones erròneas de publicaciones a colecciones
        coleccionTecnica.eliminarPublicacion(libro3);
        coleccionEmpresarial.agregarPublicacion(libro3);
        
        // Registramos definitivamente las colecciones al archivo
        archivo.agregarColeccion(coleccionTecnica);
        archivo.agregarColeccion(coleccionEmpresarial);
        
        //Forzamos erróneamente una agregación y una eliminación de colecciones
        archivo.agregarColeccion(coleccionTecnica);
        Coleccion nuevaColeccion=new Coleccion("Nueva colección","");
        archivo.eliminarColeccion(nuevaColeccion);
        nuevaColeccion=null;
        System.gc();
                
                
        // Inicio del muestreo de resultados ----------------------------------------------------------------------------------
        System.out.println("ARCHIVO CONSULTADO: "+archivo.getNombre()+"\n");
        
        // Mostramos las dependencias de departamentos  
        System.out.println("Mostrando dependencias:\n-----------------------");
        System.out.println("El departamento "+administracion.getNombre()+" depende del departamento "+administracion.getDependencia().getNombre());
        System.out.println("El departamento "+comercial.getNombre()+" depende del departamento "+comercial.getDependencia().getNombre());
       
        // Mostramos la responsabilidad de un par de trabajadores    
        System.out.println("\nMostrando responsabilidades:\n----------------------------");
        System.out.println("¿El/La trabajador/a "+trabajador2.getNombreCompleto()+" es responsable del departamento "+trabajador2.getDepartamento().getNombre()+"? "+trabajador2.esResponsable()); // Debe dar false
        System.out.println("¿El/La trabajador/a "+trabajador3.getNombreCompleto()+" es responsable del departamento "+trabajador3.getDepartamento().getNombre()+"? "+trabajador3.esResponsable()); // Deba dar true
        
        // Mostramos los datos de un trabajador antes y después de realizar algunas modificaciones
        System.out.println("\nMostrando ficha de trabajador/a:\n--------------------------------");
        System.out.println("ANTES: El/La trabajador/a "+trabajador5.getNombreCompleto()+" nació el "+trabajador5.getFechaNacimiento()+" y gana "+trabajador5.getSalario()+" euros");
        trabajador5.setFechaNacimiento("3/1995");
        trabajador5.setFechaNacimiento("4/8/1990");
        trabajador5.setFechaAlta("2020-1");
        trabajador5.setSalario((float)(trabajador5.getSalario()*1.10));
        System.out.println("DESPUÉS: El/La trabajador/a "+trabajador5.getNombreCompleto()+" nació el "+trabajador5.getFechaNacimiento()+" y gana "+trabajador5.getSalario()+" euros");
        
        // Visualizamos las descripciones de dos publicaciones
        System.out.println("\nMostrando detalles de dos publicaciones:\n----------------------------------------");
        System.out.println(libro3.getDescripcion());
        System.out.println(fichero1.getDescripcion());
        
        // Mostramos los detalles de dos colecciones
        System.out.println("\nMostrando detalles de dos colecciones:\n--------------------------------------");
        System.out.println("La colección '"+coleccionTecnica.getNombre()+"' contiene un total de "+coleccionTecnica.getNumPublicaciones()+" publicaciones");
        System.out.println("La colección '"+coleccionEmpresarial.getNombre()+"' contiene un total de "+coleccionEmpresarial.getNumPublicaciones()+" publicaciones");
        
        // Visualizamos las dependencias y responsables de un departamento
        System.out.println("\nMostrando las dependencias y responsables de un departamento:\n-------------------------------------------------------------");
        System.out.println(comercial.listarDependenciasDepartamento());
        
        // Visualizamos el detalle de las publicaciones de una colección
        System.out.println("\nMostrando el detalle de las publicaciones de las colecciones:\n-------------------------------------------------------------");
        System.out.println(coleccionTecnica.listarDetallePublicaciones());
        System.out.println(coleccionEmpresarial.listarDetallePublicaciones());
        
        // Finalmente, visualizamos las publicaciones de los cuatro autores
        System.out.println("\nMostrando las publicaciones de los/las autores/as:\n--------------------------------------------------");
        System.out.println(autor1.listarPublicaciones());
        System.out.println(autor2.listarPublicaciones());
        System.out.println(autor3.listarPublicaciones());
        System.out.println(autor4.listarPublicaciones());
    }
    
}
