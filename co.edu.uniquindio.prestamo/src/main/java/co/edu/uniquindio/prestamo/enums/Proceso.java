package co.edu.uniquindio.prestamo.enums;

public enum Proceso {
    CLIENTE("Clientes"),
    EMPLEADO("Empleados");
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    Proceso(String nombre) {
        this.nombre = nombre;
    }

    public static String[] proceso(){
        String[] proceso = {
                Proceso.CLIENTE.getNombre(),
                Proceso.EMPLEADO.getNombre(),
        };
        return proceso;
    }

}
