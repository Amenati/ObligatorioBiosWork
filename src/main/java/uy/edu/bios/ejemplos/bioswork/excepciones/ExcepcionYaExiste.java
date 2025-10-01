package uy.edu.bios.ejemplos.bioswork.excepciones;

public class ExcepcionYaExiste extends ExcepcionBiosWork{
    public ExcepcionYaExiste() {

    }

    public ExcepcionYaExiste(String mensaje) {
        super(mensaje);
    }

    public ExcepcionYaExiste(String mensaje, Exception excepcionInterna) {
        super(mensaje, excepcionInterna);
    }  
}
