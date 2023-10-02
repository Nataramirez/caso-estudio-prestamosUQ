package co.edu.uniquindio.prestamo.model;

import java.util.ArrayList;
import java.util.List;

public class PrestamoUq {
    private String nombre;
    public static List<Cliente> listaClientes = new ArrayList<>();

    public static List<Empleado> listaEmpleados = new ArrayList<>();

    List<Prestamo> listaPrestamos = new ArrayList<>();

    public PrestamoUq(String nombre) {
        this.nombre = nombre;
    }

    public PrestamoUq(){}


    // GET AND SET //
    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public static List<Cliente> getListaClientes() { return listaClientes; }

    public static List<Empleado> getListaEmpleados() { return listaEmpleados; }

    public void setListaClientes(List<Cliente> listaClientes) { this.listaClientes = listaClientes; }

    public void setListaEmpleados(List<Empleado> listaEmpleados) { this.listaEmpleados = listaEmpleados; }

    public List<Prestamo> getListaPrestamos() { return listaPrestamos; }

    public void setListaPrestamos(List<Prestamo> listaPrestamos) { this.listaPrestamos = listaPrestamos; }

    /**
     * Método para crear un cliente
     * @param nombre
     * @param apellido
     * @param cedula
     * @param edad
     * @return boolean
     */
    public static boolean crearCliente(String nombre, String apellido, String cedula, double edad){
        if (!buscarCliente(cedula)) {
            Cliente cliente = new Cliente(nombre, apellido, cedula, edad);
            getListaClientes().add(cliente);
            return true;
        }else {
            return false;}
    }

    /**
     * Método para obtener un listado de clientes
     * @return listaClientes
     */
    public static List<Cliente> obtenerClientes() {
        return getListaClientes();
    }

    /**
     * Método para eliminar un cliente de la lista
     * @param cedula
     */
    public static void eliminarCliente(String cedula) {
        int tamanioLista = getListaClientes().size();
        for(int i = 0; i < tamanioLista; i++){
            Cliente cliente = getListaClientes().get(i);
            if(cliente.getCedula().equalsIgnoreCase(cedula)){
                getListaClientes().remove(i);
                break;
            }
        }
    }

    /**
     * Método para determinar si un cliente existe en la base de datos.
     * @param cedula
     * @return boolean
     */
    public static boolean buscarCliente(String cedula) {
        int tamanioLista = getListaClientes().size();
        boolean clienteExiste = false;
        for(int i = 0; i < tamanioLista; i++){
            Cliente cliente = getListaClientes().get(i);
            if(cliente.getCedula().equalsIgnoreCase(cedula)){
                clienteExiste = true;
                System.out.println("El cliente con cédula " + cedula + " ya existe, no es posible crear de nuevo");
                break;
            }
        }
        return clienteExiste;
    }

    /**
     * Método para determinar si un empleado existe en la base de datos.
     * @param cedula
     * @return boolean
     */

    public boolean buscarEmpleado(String cedula) {
        int tamanioLista = getListaEmpleados().size();
        boolean empleadoExiste = false;
        for(int i = 0; i < tamanioLista; i++){
            Empleado empleado = getListaEmpleados().get(i);
            if(empleado.getCedula().equalsIgnoreCase(cedula)){
                empleadoExiste = true;
                System.out.println("El empleado con cédula " + cedula + " ya existe, no es posible crear de nuevo");
                break;
            }
        }
        return empleadoExiste;
    }

   
    @Override
    public String toString() {
        return "PrestamoUq{" +
                "nombre='" + nombre + '\'' +
                '}';
    }

    // LISTA EMPLEADOS //

    /**
     * Método para crear un empleado
     * @param nombre
     * @param apellido
     * @param cedula
     * @param edad
     * @return boolean
     */
    public static boolean crearEmpleado(String nombre, String apellido, String cedula, double edad){
        Empleado empleado = new Empleado(nombre, apellido, cedula, edad);
        getListaEmpleados().add(empleado);
        return true;
    }

    /**
     * Método para obtener un listado de empleados
     * @return listaEmpleados
     */
    public List<Empleado> obtenerEmpleados() {
        return getListaEmpleados();
    }

    /**
     * Método para eliminar un empleado de la lista
     * @param cedula
     */
    public static void eliminarEmpleado(String cedula) {
        int tamanioLista = getListaClientes().size();
        for(int i = 0; i < tamanioLista; i++){
            Empleado empleado = getListaEmpleados().get(i);
            if(empleado.getCedula().equalsIgnoreCase(cedula)){
                getListaEmpleados().remove(i);
                break;
            }
        }
    }

    // LISTA PRESTAMOS //

    /**
     * Método para crear un prestamo
     * @param numeroPrestamo
     * @param fechaPrestamo
     * @param fechaEntrega
     * @param descripcion
     * @return boolean
     */
    public boolean crearPrestamo(int numeroPrestamo, String fechaPrestamo, String fechaEntrega, String descripcion)
    {
        Prestamo prestamo = new Prestamo(numeroPrestamo, fechaPrestamo, fechaEntrega, descripcion);
        getListaPrestamos().add(prestamo);
        return true;
    }

    /**
     * Método para obtener un listado de prestamos
     * @return listaPrestamos
     */
    public List<Prestamo> obtenerPrestamos() {
        return getListaPrestamos();
    }

    /**
     * Método para eliminar un prestasmo de la lista
     * @param numeroPrestamo
     */
    public void eliminarPrestamo(int numeroPrestamo) {
        int tamanioLista = getListaPrestamos().size();
        for(int i = 0; i < tamanioLista; i++){
            Prestamo prestamo = getListaPrestamos().get(i);
            if(prestamo.getNumeroPrestamo()==numeroPrestamo){
                getListaPrestamos().remove(i);
                break;
            }
        }
    }

    /**
     * Método para determinar si un préstamo existe en la base de datos.
     * @param numeroPrestamo
     * @return boolean
     */

    public boolean buscarPrestamo(int numeroPrestamo) {
        int tamanioLista = getListaPrestamos().size();
        boolean prestamoExiste = false;
        for(int i = 0; i < tamanioLista; i++){
            Prestamo prestamo = getListaPrestamos().get(i);
            if(prestamo.getNumeroPrestamo()==numeroPrestamo){
                prestamoExiste = true;
                System.out.println("El préstamo número " + numeroPrestamo + " ya existe, no es posible crear de nuevo");
                break;
            }
        }
        return prestamoExiste;
    }
}
