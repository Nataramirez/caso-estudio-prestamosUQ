package co.edu.uniquindio.prestamo.model;

import java.util.ArrayList;
import java.util.List;

public class PrestamoUq {
    private String nombre;
    List<Cliente> listaClientes = new ArrayList<>();

    List<Empleado> listaEmpleados = new ArrayList<>();

    public PrestamoUq(String nombre) {
        this.nombre = nombre;
    }

    public PrestamoUq(){}

    // GET AND SET //
    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public List<Cliente> getListaClientes() { return listaClientes; }

    public List<Empleado> getListaEmpleados() { return listaEmpleados; }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

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
     * Método para determinar si un cliente existe en la base de datos
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


}
