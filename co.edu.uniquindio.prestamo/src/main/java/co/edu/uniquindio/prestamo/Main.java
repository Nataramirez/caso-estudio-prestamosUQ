package co.edu.uniquindio.prestamo;

import co.edu.uniquindio.prestamo.enums.Crud;
import co.edu.uniquindio.prestamo.model.Cliente;
import co.edu.uniquindio.prestamo.model.EntradaConsola;
import co.edu.uniquindio.prestamo.model.PrestamoUq;
import co.edu.uniquindio.prestamo.model.Empleado;
import co.edu.uniquindio.prestamo.model.Prestamo;

import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        PrestamoUq prestamoUq = inicializarDatosPrueba();
        crearCiente("juan", "sanchez", "1094", 35, prestamoUq);
        crearCiente("andres", "miranda", "1095", 28, prestamoUq);
        crearCiente("sara", "morales", "1096", 31, prestamoUq);
        crearCiente("luis", "castro", "1097", 26, prestamoUq);
        crearCiente("sara", "morales", "1096", 31, prestamoUq);
        crearCiente("luis", "castro", "1097", 26, prestamoUq);

        // CREAR EMPLEADOS
        crearEmpleado("Nicolás", "Upegui", "1098", 42, prestamoUq);
        crearEmpleado("Jerónimo", "Osorio", "1099", 26, prestamoUq);
        crearEmpleado("Augusto", "Álvarez", "1001", 54, prestamoUq);
        crearEmpleado("Camilo", "Marulanda", "1002", 18, prestamoUq);

        // CREAR PRESTAMOS
        crearPrestamo(10,
                "Marzo 20 de 2023",
                "Abril 14 de 2023",
                "Prestamo de palas", prestamoUq);
        crearPrestamo(11,
                "Marzo 25 de 2023",
                "Abril 30 de 2023",
                "Prestamo de baldes", prestamoUq);
        crearPrestamo(12,
                "Enero 03 de 2023",
                "Mayo 15 de 2023",
                "Prestamo de martillo", prestamoUq);
        crearPrestamo(13,
                "Junio 06 de 2023",
                "Agosto 29 de 2023",
                "Prestamo de destornilladores", prestamoUq);
        crearPrestamo(14,
                "Febrero 19 de 2023",
                "Febero 27 de 2023",
                "Prestamo de andamios", prestamoUq);
        crearPrestamo(15,
                "Agosto 26 de 2023",
                "Septiembre 28 de 2023",
                "Prestamo de mezcladora", prestamoUq);

        System.out.println("\n--------> Lista de clientes <-------\n");
        mostrarInformacionClientes(prestamoUq);
        eliminarCliente(prestamoUq, "1095");
        System.out.println("\n--------> Lista de clientes después de eliminar cliente <-------\n");
        mostrarInformacionClientes(prestamoUq);

        System.out.println("\n--------> Lista de empleados <-------\n");
        mostrarInformacionEmpleados(prestamoUq);
        eliminarEmpleado(prestamoUq, "1095");
        System.out.println("\n--------> Lista de empleados después de eliminar empleado <-------\n");
        mostrarInformacionEmpleados(prestamoUq);
        int ejecutarAplicacion = 1;
        while (ejecutarAplicacion == 1){
            String tipoProceso = EntradaConsola.tipoProceso();
            ejecutarAplicacion = EntradaConsola.cerrarApliacionString(tipoProceso);
            if(tipoProceso != null){
                String tipoCrud = EntradaConsola.tipoCrud(tipoProceso);
                ejecutarAplicacion = EntradaConsola.cerrarApliacionString(tipoCrud);
                if(tipoCrud != null){
                    ejecutarAplicacion = ejecutarCrud(tipoProceso, tipoCrud);
                }
            }
        }
    }

    /**
     * Método de para crear cliente
     * @param nombre
     * @param apellido
     * @param cedula
     * @param edad
     * @param prestamoUq
     */
    private static void crearCiente(String nombre,
                                    String apellido,
                                    String cedula,
                                    double edad,
                                    PrestamoUq prestamoUq) {
        prestamoUq.crearCliente(nombre, apellido, cedula, edad);
    }

    /**
     * Método para crear empleado
     * @param nombre
     * @param apellido
     * @param cedula
     * @param edad
     * @param prestamoUq
     */
    private static void crearEmpleado(String nombre,
                                    String apellido,
                                    String cedula,
                                    double edad,
                                    PrestamoUq prestamoUq) {
        prestamoUq.crearEmpleado(nombre, apellido, cedula, edad);
    }

    /**
     * Método para crear Prestamo
     * @param numeroPrestamo
     * @param fechaPrestamo
     * @param fechaEntrega
     * @param descripcion
     * @param prestamoUq
     */
    private static void crearPrestamo(int numeroPrestamo,
                                      String fechaPrestamo,
                                      String fechaEntrega,
                                      String descripcion,
                                      PrestamoUq prestamoUq) {
        prestamoUq.crearPrestamo(numeroPrestamo, fechaPrestamo, fechaEntrega, descripcion);
    }

    /**
     * Método para mostrar la información de clientes.
     * @param prestamoUq
     */
    private static void mostrarInformacionClientes(PrestamoUq prestamoUq) {
        List<Cliente> listaCliente = prestamoUq.obtenerClientes();
        int tamanioLista = listaCliente.size();
        for(int i = 0; i < tamanioLista; i++){
            Cliente cliente = listaCliente.get(i);
            System.out.println(cliente.toString());
        }
    }

    /**
     * Método para mostrar información de empleados
     * @param prestamoUq
     */
    private static void mostrarInformacionEmpleados(PrestamoUq prestamoUq) {
        List<Empleado> listaEmpleado = prestamoUq.obtenerEmpleados();
        int tamanioLista = listaEmpleado.size();
        for(int i = 0; i < tamanioLista; i++){
            Empleado empleado = listaEmpleado.get(i);
            System.out.println(empleado.toString());
        }
    }

    /**
     * Método para mostrar información de prestamos
     * @param prestamoUq
     */
    private static void mostrarInformacionPrestamos(PrestamoUq prestamoUq) {
        List<Prestamo> listaPrestamo = prestamoUq.obtenerPrestamos();
        int tamanioLista = listaPrestamo.size();
        for(int i = 0; i < tamanioLista; i++){
            Prestamo prestamo = listaPrestamo.get(i);
            System.out.println(prestamo.toString());
        }
    }

    /**
     * Método para emiliar un cliente
     * @param prestamoUq
     * @param cedula
     */
    private static void eliminarCliente(PrestamoUq prestamoUq, String cedula) {
        prestamoUq.eliminarCliente(cedula);
    }

    /**
     * Método para eliminar un empleado.
     * @param prestamoUq
     * @param cedula
     */
    private static void eliminarEmpleado(PrestamoUq prestamoUq, String cedula) {
        prestamoUq.eliminarEmpleado(cedula);
    }


    private static int ejecutarCrud(String proceso, String crud){
        int cerrarAplicacion = 1;
        if(crud.contains(Crud.CREATE.getNombre())){
            cerrarAplicacion = EntradaConsola.crear(proceso);
        }
        if(crud.contains(Crud.READ.getNombre())){
            cerrarAplicacion = EntradaConsola.leer(proceso);
        }
        if(crud.contains(Crud.DELETE.getNombre())){
            cerrarAplicacion = EntradaConsola.eliminar(proceso);
        }
        /*

        if(crud.contains(Crud.UPDATE.getNombre())){}
        */
        return cerrarAplicacion;
    }

    /**
     * Método para eliminar un prestamo.
     * @param prestamoUq
     * @param numeroPrestamo
     */
    private static void eliminarPrestamo(PrestamoUq prestamoUq, int numeroPrestamo) {
        prestamoUq.eliminarPrestamo(numeroPrestamo);
    }

    /**
     * Método para inicializar datos prueba.
     * @return
     */
    private static PrestamoUq inicializarDatosPrueba() {
        PrestamoUq prestamoUq = new PrestamoUq();
        prestamoUq.setNombre("Prestamo rapido");
        return prestamoUq;
    }


}