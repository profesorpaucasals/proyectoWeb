import java.text.ParseException;

/**
 * La clase Archivo instancia un Sistema de Gestión Documental
 * 
 * @author Juan Pedro Cerro Martínez
 * @version 01/01/2024
 */
public class Archivo
{
    // Propiedades de la clase principal
    private String nombre;
    
    /**
     * Constructor por defecto
     */
    public Archivo()
    {
    }
    
    /**
     * Método constructor específico de la clase
     * 
     * @param pNombre Nombre del archivo
     */
    public Archivo(String pNombre) {
        this.nombre=pNombre;
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
     * Test de caja negra del Sistema de Gestión Documental
     * 
     */
    public static void main(String args[])  throws ParseException
    {
        // Inicio del banco de pruebas
        
        // Creación del Sistema de Gestión Documental
        Archivo archivo=new Archivo();
        archivo.setNombre("Archivo documental Carlemany");
        
        // En primer lugar damos de alta a todos los trabajadores de la organización
        Trabajador trabajador1= new Trabajador("Elisabeth López Mur",'M',"1105/1976",930000001,"elisabeth@carlemany.edu",null,(float)1700.00,"01/01/2022",false,"11223344556");
        trabajador1= new Trabajador("Elisabeth López Mur",'M',"11/05/1976",930000001,"elisabeth@carlemany.edu",null,(float)1700.00,"01/01/2022",false,"11223344556");
        Trabajador trabajador2= new Trabajador("Raúl Soria García",'H',"10/10/1983",930000002,"raul@carlemany.edu",null,(float)1430.00,"10/04/2021",false,"11223344557");
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
        comercial.setResponsable(trabajador2);
        comercial.setResponsable(trabajador5);
        
        // Asignamos los trabajadores a sus respectivos departamentos
        trabajador1.setDepartamento(direccion);
        trabajador2.setDepartamento(administracion);
        trabajador3.setDepartamento(administracion);
        trabajador4.setDepartamento(comercial);
        trabajador5.setDepartamento(comercial);   
        
        // Inicio del muestreo de resultados ----------------------------------------------------------------------------------
        System.out.println("ARCHIVO CONSULTADO: "+archivo.getNombre()+"\n");
        
        // Mostramos las dependencias de departamentos  
        System.out.println("Mostrando dependencias:\n-----------------------");
        System.out.println("El departamento "+administracion.getNombre()+" depende del departamento "+administracion.getDependencia().getNombre());
        System.out.println("El departamento "+comercial.getNombre()+" depende del departamento "+comercial.getDependencia().getNombre());
       
        // Mostramos la responsabilidad de un par de trabajadores    
        System.out.println("\nMostrando responsabilidades:\n----------------------------");
        System.out.println("¿El/La trabajador/a "+trabajador2.getNombreCompleto()+" es responsable del departamento "+trabajador2.getDepartamento().getNombre()+"? "+trabajador2.esResponsable()); // Debe dar false
        System.out.println("¿El/La trabajador/a "+trabajador3.getNombreCompleto()+" es responsable del departamento "+trabajador3.getDepartamento().getNombre()+"? "+trabajador3.esResponsable()); // Debe dar true
        
        // Mostramos los datos de un trabajador antes y después de realizar algunas modificaciones
        System.out.println("\nMostrando ficha de trabajador/a:\n-------------------------------");
        System.out.println("ANTES: El/La trabajador/a "+trabajador5.getNombreCompleto()+" nació el "+trabajador5.getFechaNacimiento()+" y gana "+trabajador5.getSalario()+" euros");
        trabajador5.setFechaNacimiento("3/1995");
        trabajador5.setFechaNacimiento("4/8/1990");
        trabajador5.setFechaAlta("2020-1");
        trabajador5.setSalario((float)(trabajador5.getSalario()*1.10));
        System.out.println("DESPUÉS: El/La trabajador/a "+trabajador5.getNombreCompleto()+" nació el "+trabajador5.getFechaNacimiento()+" y gana "+trabajador5.getSalario()+" euros");
    }
    
}
