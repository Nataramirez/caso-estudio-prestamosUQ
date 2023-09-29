package co.edu.uniquindio.prestamo.model;

import java.util.ArrayList;
import java.util.List;

public class PrestamoUq {
    private String nombre;
    List<Cliente> listaClientes = new ArrayList<>();

    public PrestamoUq(String nombre) {
        this.nombre = nombre;
    }

    public PrestamoUq(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
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

}
