package co.edu.uniquindio.prestamo.model;
import co.edu.uniquindio.prestamo.model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrestamoUq {
    private String nombre;
    List<Cliente> listaClientes = new ArrayList<>();

    List<Empleado> listaEmpleados = new ArrayList<>();

    List<Prestamo> listaPrestamos = new ArrayList<>();

    public PrestamoUq(String nombre) {
        this.nombre = nombre;
    }

    public PrestamoUq(){}


    // GET AND SET //
    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public List<Cliente> getListaClientes() { return listaClientes; }

    public List<Empleado> getListaEmpleados() { return listaEmpleados; }

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
    public boolean crearCliente(String nombre, String apellido, String cedula, double edad){
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
    public List<Cliente> obtenerClientes() {
        return getListaClientes();
    }

    /**
     * Método para eliminar un cliente de la lista
     * @param cedula
     */
    public void eliminarCliente(String cedula) {
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
    public boolean buscarCliente(String cedula) {
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
     * Método para actualizar los datos de un cliente, a partir de la cédula.
     * @param cedula
     * @return
     */
    public Cliente actualizarCliente(String cedula) {
        int tamanioLista = getListaClientes().size();
        String nombre;
        String apellido;
        double edad;
        Cliente clienteActualizado = null;
        for (int i = 0; i < tamanioLista; i++) {
            Cliente cliente = getListaClientes().get(i);
            if (cliente.getCedula().equalsIgnoreCase(cedula)) {
                Scanner teclado = new Scanner(System.in);
                System.out.print("Introduzca el nombre actualizado del cliente: ");
                nombre = teclado.nextLine();
                cliente.setNombre(nombre);
                System.out.print("Introduzca el apellido actualizado del cliente: ");
                apellido = teclado.nextLine();
                cliente.setApellido(apellido);
                System.out.print("Introduzca la edad actualizada del cliente: ");
                edad = teclado.nextDouble();
                cliente.setEdad(edad);
                clienteActualizado = new Cliente(nombre, apellido, cedula, edad);
                break;
            } else
                System.out.println("El cliente no se puede actualizar porque no existe.");
        }
        return clienteActualizado;
    }

    /**
     * Método para actualizar los datos de un empleado, a partir de la cédula.
     * @param cedula
     * @return
     */
    public Empleado actualizarEmpleado(String cedula) {
        int tamanioLista = getListaEmpleados().size();
        String nombre;
        String apellido;
        double edad;
        Empleado empleadoActualizado = null;
        for (int i = 0; i < tamanioLista; i++) {
            Empleado empleado = getListaEmpleados().get(i);
            if (empleado.getCedula().equalsIgnoreCase(cedula)) {
                Scanner teclado = new Scanner(System.in);
                System.out.print("Introduzca el nombre actualizado del empleado: ");
                nombre = teclado.nextLine();
                empleado.setNombre(nombre);
                System.out.print("Introduzca el apellido actualizado del empleado: ");
                apellido = teclado.nextLine();
                empleado.setApellido(apellido);
                System.out.print("Introduzca la edad actualizada del empleado: ");
                edad = teclado.nextDouble();
                empleado.setEdad(edad);
                empleadoActualizado = new Empleado(nombre, apellido, cedula, edad);
                break;
            } else
                System.out.println("El cliente no se puede actualizar porque no existe.");
        }
        return empleadoActualizado;
    }

    /**
     * Método para actualizar los datos de un prestamo, a partir del número de préstamo.
     * @param numeroPrestamo
     * @return
     */
    public Prestamo actualizarPrestamo(int numeroPrestamo) {
        int tamanioLista = getListaPrestamos().size();
        String fechaPrestamo;
        String fechaEntrega;
        String descripcion;
        Prestamo prestamoActualizado = null;
        for (int i = 0; i < tamanioLista; i++) {
            Prestamo prestamo = getListaPrestamos().get(i);
            if (prestamo.getNumeroPrestamo()==numeroPrestamo) {
                Scanner teclado = new Scanner(System.in);
                System.out.print("Introduzca la fecha actualizada del préstamo: ");
                fechaPrestamo = teclado.nextLine();
                prestamo.setFechaPrestamo(fechaPrestamo);
                System.out.print("Introduzca la fecha actualizada de la entrega del préstamo: ");
                fechaEntrega = teclado.nextLine();
                prestamo.setFechaPrestamo(fechaPrestamo);
                System.out.print("Introduzca la nueva descripción del préstamo: ");
                descripcion = teclado.nextLine();
                prestamo.setDescripcion(descripcion);
                prestamoActualizado = new Prestamo(numeroPrestamo, fechaPrestamo, fechaEntrega, descripcion);
                break;
            } else
                System.out.println("El préstamo no se puede actualizar porque no existe.");
        }
        return prestamoActualizado;
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
    public boolean crearEmpleado(String nombre, String apellido, String cedula, double edad){
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
    public void eliminarEmpleado(String cedula) {
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
