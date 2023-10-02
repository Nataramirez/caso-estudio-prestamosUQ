package co.edu.uniquindio.prestamo.model;
import co.edu.uniquindio.prestamo.model.Cliente;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrestamoUq {
    private String nombre;
    public static List<Cliente> listaClientes = new ArrayList<>();

    public static List<Empleado> listaEmpleados = new ArrayList<>();

    public static List<Prestamo> listaPrestamos = new ArrayList<>();

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

    public static List<Prestamo> getListaPrestamos() { return listaPrestamos; }

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
    public static boolean eliminarCliente(String cedula) {
        boolean clienteEliminado = false;
        int tamanioLista = getListaClientes().size();
        for(int i = 0; i < tamanioLista; i++){
            Cliente cliente = getListaClientes().get(i);
            if(cliente.getCedula().equalsIgnoreCase(cedula)){
                getListaClientes().remove(i);
                clienteEliminado = true;
                break;
            }
        }
        return clienteEliminado;
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
     * Método para actualizar los datos de un cliente, a partir de la cédula.
     * @param cedula
     * @return
     */
    public static Cliente actualizarCliente(String cedula) {
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
                nombre = JOptionPane.showInputDialog("Ingrese nombre del cliente");;
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
     * Método para actualizar cliente
     * @param cedula
     * @return
     */
    public static int ActualizarCliente2(String cedula){
        int tamanioLista = getListaClientes().size();
        String nombre;
        String apellido;
        Double edad;
        int cerrar = 1;
        Cliente cliente;
        boolean bandera = false;
        for (int i = 0; i < tamanioLista; i++) {
            cliente = getListaClientes().get(i);
            if (cliente.getCedula().equalsIgnoreCase(cedula)) {
                bandera = true;
                while(cerrar == 1){
                    nombre = JOptionPane.showInputDialog("Ingrese el nombre actualizado del cliente");
                    int cerrarAplicacionEnNombre = EntradaConsola.cerrarApliacionString(nombre);
                    if(cerrarAplicacionEnNombre == 0){
                        cerrar = cerrarAplicacionEnNombre;
                        return cerrar;
                    } else if (cerrarAplicacionEnNombre == 1 && nombre == null) {
                        nombre = JOptionPane.showInputDialog("Ingrese el nombre actualizado del cliente");
                        cerrarAplicacionEnNombre = EntradaConsola.cerrarApliacionString(nombre);
                    }
                    apellido = JOptionPane.showInputDialog("Ingrese el apellido actualizado del cliente");
                    int cerrarAplicacionEnApellido = EntradaConsola.cerrarApliacionString(apellido);
                    if(cerrarAplicacionEnApellido == 0){
                        cerrar = cerrarAplicacionEnApellido;
                        return cerrar;
                    } else if (cerrarAplicacionEnApellido == 1 && apellido == null) {
                        apellido = JOptionPane.showInputDialog("Ingrese el apellido actualizado del cliente");
                        cerrarAplicacionEnApellido = EntradaConsola.cerrarApliacionString(apellido);
                    }
                    edad = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la edad actualizada del cliente"));
                    int cerrarAplicacionEnEdad = EntradaConsola.cerrarApliacionDouble(edad);
                    if(cerrarAplicacionEnEdad == 0){
                        cerrar = cerrarAplicacionEnEdad;
                        return cerrar;
                    } else if (cerrarAplicacionEnEdad == 1 && edad == null) {
                        edad = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la edad actualizada del cliente"));
                        cerrarAplicacionEnEdad = EntradaConsola.cerrarApliacionDouble(edad);
                    }
                    cliente.setNombre(nombre);
                    cliente.setApellido(apellido);
                    cliente.setEdad(edad);
                    cerrar = 0;
                    JOptionPane.showMessageDialog(null,"El cliente ha sido actualizado con exito");
                }
            }
        }
        if(!bandera){
            JOptionPane.showMessageDialog(null,"El cliente NO fue econtrado");
        }
        return cerrar;
    }

    /**
     * Método para actualizar los datos de un empleado, a partir de la cédula.
     * @param cedula
     * @return
     */
    public static Empleado actualizarEmpleado(String cedula) {
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
     * método para actulizar empleado
     * @param cedula
     * @return
     */
    public static int actualizarEmpleado2(String cedula){
        int tamanioLista = getListaEmpleados().size();
        String nombre;
        String apellido;
        Double edad;
        int cerrar = 1;
        Empleado empleado;
        boolean bandera = false;
        for (int i = 0; i < tamanioLista; i++) {
            empleado = getListaEmpleados().get(i);
            if (empleado.getCedula().equalsIgnoreCase(cedula)) {
                bandera = true;
                while(cerrar == 1){
                    nombre = JOptionPane.showInputDialog("Ingrese el nombre actualizado del empleado");
                    int cerrarAplicacionEnNombre = EntradaConsola.cerrarApliacionString(nombre);
                    if(cerrarAplicacionEnNombre == 0){
                        cerrar = cerrarAplicacionEnNombre;
                        return cerrar;
                    } else if (cerrarAplicacionEnNombre == 1 && nombre == null) {
                        nombre = JOptionPane.showInputDialog("Ingrese el nombre actualizado del empleado");
                        cerrarAplicacionEnNombre = EntradaConsola.cerrarApliacionString(nombre);
                    }
                    apellido = JOptionPane.showInputDialog("Ingrese el apellido actualizado del empleado");
                    int cerrarAplicacionEnApellido = EntradaConsola.cerrarApliacionString(apellido);
                    if(cerrarAplicacionEnApellido == 0){
                        cerrar = cerrarAplicacionEnApellido;
                        return cerrar;
                    } else if (cerrarAplicacionEnApellido == 1 && apellido == null) {
                        apellido = JOptionPane.showInputDialog("Ingrese el apellido actualizado del empleado");
                        cerrarAplicacionEnApellido = EntradaConsola.cerrarApliacionString(apellido);
                    }
                    edad = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la edad actualizada del empleado"));
                    int cerrarAplicacionEnEdad = EntradaConsola.cerrarApliacionDouble(edad);
                    if(cerrarAplicacionEnEdad == 0){
                        cerrar = cerrarAplicacionEnEdad;
                        return cerrar;
                    } else if (cerrarAplicacionEnEdad == 1 && edad == null) {
                        edad = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la edad actualizada del empleado"));
                        cerrarAplicacionEnEdad = EntradaConsola.cerrarApliacionDouble(edad);
                    }
                    empleado.setNombre(nombre);
                    empleado.setApellido(apellido);
                    empleado.setEdad(edad);
                    cerrar = 0;
                    JOptionPane.showMessageDialog(null,"El empleado ha sido actualizado con exito");
                }
            }
        }
        if(!bandera){
            JOptionPane.showMessageDialog(null,"El empleado NO fue econtrado");
        }
        return cerrar;
    }

    /**
     * Método para actualizar los datos de un prestamo, a partir del número de préstamo.
     * @param numeroPrestamo
     * @return
     */
    public static Prestamo actualizarPrestamo(int numeroPrestamo) {
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
     * Método para actualizar prestamo
     * @param numeroPrestamo
     * @return
     */
    public static int actualizarPrestamo2(int numeroPrestamo){
        int tamanioLista = getListaPrestamos().size();
        String fechaPrestamo;
        String fechaEntrega;
        String descripcion;
        int cerrar = 1;
        Prestamo prestamo;
        boolean bandera = false;
        for (int i = 0; i < tamanioLista; i++) {
            prestamo = getListaPrestamos().get(i);
            if (prestamo.getNumeroPrestamo() == numeroPrestamo) {
                bandera = true;
                while(cerrar == 1){
                    fechaPrestamo = JOptionPane.showInputDialog("Ingrese el fechaPrestamo actualizado del prestamo");
                    int cerrarAplicacionFechaPrestamo = EntradaConsola.cerrarApliacionString(fechaPrestamo);
                    if(cerrarAplicacionFechaPrestamo == 0){
                        cerrar = cerrarAplicacionFechaPrestamo;
                        return cerrar;
                    } else if (cerrarAplicacionFechaPrestamo == 1 && fechaPrestamo == null) {
                        fechaPrestamo = JOptionPane.showInputDialog("Ingrese el fechaPrestamo actualizado del prestamo");
                        cerrarAplicacionFechaPrestamo = EntradaConsola.cerrarApliacionString(fechaPrestamo);
                    }
                    fechaEntrega = JOptionPane.showInputDialog("Ingrese el fechaEntrega actualizado del prestamo");
                    int cerrarAplicacionFechaEntrega = EntradaConsola.cerrarApliacionString(fechaEntrega);
                    if(cerrarAplicacionFechaEntrega == 0){
                        cerrar = cerrarAplicacionFechaEntrega;
                        return cerrar;
                    } else if (cerrarAplicacionFechaEntrega == 1 && fechaEntrega == null) {
                        fechaEntrega = JOptionPane.showInputDialog("Ingrese el fechaEntrega actualizado del prestamo");
                        cerrarAplicacionFechaEntrega = EntradaConsola.cerrarApliacionString(fechaEntrega);
                    }
                    descripcion = JOptionPane.showInputDialog(JOptionPane.showInputDialog("Ingrese la descripcion actualizada del prestamo"));
                    int cerrarAplicacionDescripcion = EntradaConsola.cerrarApliacionString(descripcion);
                    if(cerrarAplicacionDescripcion == 0){
                        cerrar = cerrarAplicacionDescripcion;
                        return cerrar;
                    } else if (cerrarAplicacionDescripcion == 1 && descripcion == null) {
                        descripcion = JOptionPane.showInputDialog(JOptionPane.showInputDialog("Ingrese la descripcion actualizada del prestamo"));
                        cerrarAplicacionDescripcion = EntradaConsola.cerrarApliacionString(descripcion);
                    }
                    prestamo.setFechaPrestamo(fechaPrestamo);
                    prestamo.setFechaEntrega(fechaEntrega);
                    prestamo.setDescripcion(descripcion);
                    cerrar = 0;
                    JOptionPane.showMessageDialog(null,"El prestamo ha sido actualizado con exito");
                }
            }
        }
        if(!bandera){
            JOptionPane.showMessageDialog(null,"El prestamo NO fue econtrado");
        }
        return cerrar;
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
    public static boolean eliminarEmpleado(String cedula) {
        int tamanioLista = getListaClientes().size();
        boolean empleadoExiste = false;
        for(int i = 0; i < tamanioLista; i++){
            Empleado empleado = getListaEmpleados().get(i);
            if(empleado.getCedula().equalsIgnoreCase(cedula)){
                getListaEmpleados().remove(i);
                empleadoExiste = true;
                break;
            }
        }
        return empleadoExiste;
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
    public static boolean crearPrestamo(int numeroPrestamo, String fechaPrestamo, String fechaEntrega, String descripcion)
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
    public static boolean eliminarPrestamo(int numeroPrestamo) {
        int tamanioLista = getListaPrestamos().size();
        boolean prestamoExiste = false;
        for(int i = 0; i < tamanioLista; i++){
            Prestamo prestamo = getListaPrestamos().get(i);
            if(prestamo.getNumeroPrestamo()==numeroPrestamo){
                getListaPrestamos().remove(i);
                prestamoExiste = true;
                break;
            }
        }
        return prestamoExiste;
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
