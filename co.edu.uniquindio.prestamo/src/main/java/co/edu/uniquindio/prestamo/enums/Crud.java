package co.edu.uniquindio.prestamo.enums;


import java.util.ArrayList;

public enum Crud {
    CREATE("Crear ", 1),
    READ("Ver ", 2),
    UPDATE("Actualizar información de ", 3),
    DELETE("Eliminar ", 4);
    private String nombre;
    private int id;

    Crud(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public static String[] crud(String proceso){
        String[] tipoCrud = new String[4];
        if(proceso.equalsIgnoreCase(Proceso.CLIENTE.getNombre())){
            tipoCrud = new String[] {
                    Crud.CREATE.getNombre() + "cliente",
                    Crud.READ.getNombre() + "clientes",
                    Crud.UPDATE.getNombre() + "cliente",
                    Crud.DELETE.getNombre() + "cliente",
            };
        }else if(proceso.equalsIgnoreCase(Proceso.EMPLEADO.getNombre())) {
            tipoCrud = new String[] {
                    Crud.CREATE.getNombre() + "empleado",
                    Crud.READ.getNombre() + "empleados",
                    Crud.UPDATE.getNombre() + "empleado",
                    Crud.DELETE.getNombre() + "empleado",
            };
        } else if (proceso.equalsIgnoreCase(Proceso.PRESTAMO.getNombre())) {
            tipoCrud = new String[] {
                    Crud.CREATE.getNombre() + "prestamo",
                    Crud.READ.getNombre() + "prestamos",
                    Crud.UPDATE.getNombre() + "prestamo",
                    Crud.DELETE.getNombre() + "prestamo",
            };
        }
        return tipoCrud;
    }
}
