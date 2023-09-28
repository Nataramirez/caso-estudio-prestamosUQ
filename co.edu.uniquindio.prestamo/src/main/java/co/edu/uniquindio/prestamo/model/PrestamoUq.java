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
        Cliente cliente = new Cliente(nombre, apellido, cedula, edad);
        getListaClientes().add(cliente);
        return true;
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

    @Override
    public String toString() {
        return "PrestamoUq{" +
                "nombre='" + nombre + '\'' +
                '}';
    }

}
