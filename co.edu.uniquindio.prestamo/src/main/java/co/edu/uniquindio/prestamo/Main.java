package co.edu.uniquindio.prestamo;

import co.edu.uniquindio.prestamo.enums.Crud;
import co.edu.uniquindio.prestamo.model.Cliente;
import co.edu.uniquindio.prestamo.model.EntradaConsola;
import co.edu.uniquindio.prestamo.model.PrestamoUq;
import co.edu.uniquindio.prestamo.model.Empleado;

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
        System.out.println("--------> Lista de clientes <-------");
        mostrarInformacionClientes(prestamoUq);
        eliminarCliente(prestamoUq, "1095");
        System.out.println("--------> Lista de clientes después de eliminar cliente <-------");
        mostrarInformacionClientes(prestamoUq);
        System.out.println("--------> Lista de empleados <-------");
        mostrarInformacionEmpleados(prestamoUq);
        eliminarEmpleado(prestamoUq, "1095");
        System.out.println("--------> Lista de empleados después de eliminar empleado <-------");
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

    public static void crearCiente(String nombre,
                                    String apellido,
                                    String cedula,
                                    double edad,
                                    PrestamoUq prestamoUq) {
        prestamoUq.crearCliente(nombre, apellido, cedula, edad);
    }

    private static void crearEmpleado(String nombre,
                                    String apellido,
                                    String cedula,
                                    double edad,
                                    PrestamoUq prestamoUq) {
        prestamoUq.crearEmpleado(nombre, apellido, cedula, edad);
    }

    private static void mostrarInformacionClientes(PrestamoUq prestamoUq) {
        List<Cliente> listaCliente = prestamoUq.obtenerClientes();
        int tamanioLista = listaCliente.size();
        for(int i = 0; i < tamanioLista; i++){
            Cliente cliente = listaCliente.get(i);
            System.out.println(cliente.toString());
        }
    }

    private static void mostrarInformacionEmpleados(PrestamoUq prestamoUq) {
        List<Empleado> listaEmpleado = prestamoUq.obtenerEmpleados();
        int tamanioLista = listaEmpleado.size();
        for(int i = 0; i < tamanioLista; i++){
            Empleado empleado = listaEmpleado.get(i);
            System.out.println(empleado.toString());
        }
    }

    private static void eliminarCliente(PrestamoUq prestamoUq, String cedula) {
        prestamoUq.eliminarCliente(cedula);
    }

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

    private static PrestamoUq inicializarDatosPrueba() {
        PrestamoUq prestamoUq = new PrestamoUq();
        prestamoUq.setNombre("Prestamo rapido");
        return prestamoUq;
    }


}