package excepciones;

public class DonkeyPoobExcepcion extends Exception{

    public static final String OPCION_EN_CONSTRUCCION = "Opcion en construccion";
    public static final String MENSAJE_SALVAR = "No fue posible guardar el archivo";
    public static final String MENSAJE_ABRIR = "No fue posible abrir el archivo";
    public static final String EXTENSION_INVALIDA_OBJETOS = "La extension del archivo debe ser .dat";
    public static final String EXTENSION_INVALIDA_TEXTO = "La extencion del archivo debe ser .txt";
    public static final String MENSAJE_EXPORTAR = "No fue posible exportar el archivo";
    public static final String MENSAJE_IMPORTAR = "No fue posible importar el archivo";

    public DonkeyPoobExcepcion (final String message) {
        super(message);
    }

    /*
    public TeatroColonExcepcion (String message, int linea){
        super("Linea " +linea+": "+message);
    }
    */
}
