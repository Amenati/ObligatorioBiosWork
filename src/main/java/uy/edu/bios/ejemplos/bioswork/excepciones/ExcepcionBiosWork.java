package uy.edu.bios.ejemplos.bioswork.excepciones;

public class ExcepcionBiosWork extends Exception {
    public ExcepcionBiosWork() {
        
    }

    public ExcepcionBiosWork(String mensaje) {
        super(mensaje);
    }

    public ExcepcionBiosWork(String mensaje, Exception excepcionInterna) {
        super(mensaje, excepcionInterna);
    }
}
