package uy.edu.bios.ejemplos.bioswork.excepciones;

public class ExcepcionNoExiste extends ExcepcionBiosWork {

    public ExcepcionNoExiste() {

    }

    public ExcepcionNoExiste(String mensaje) {
        super(mensaje);
    }

    public ExcepcionNoExiste(String mensaje, Exception excepcionInterna) {
        super(mensaje, excepcionInterna);
    }
}
