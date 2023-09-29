package co.edu.uniquindio.prestamo;

import co.edu.uniquindio.prestamo.model.Cliente;
import co.edu.uniquindio.prestamo.model.PrestamoUq;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PrestamoUq prestamoUq = inicializarDatosPrueba();
        crearCiente("juan", "sanchez", "1094", 35, prestamoUq);
        crearCiente("andres", "miranda", "1095", 28, prestamoUq);
        crearCiente("sara", "morales", "1096", 31, prestamoUq);
        crearCiente("luis", "castro", "1097", 26, prestamoUq);
        crearCiente("sara", "morales", "1096", 31, prestamoUq);
        crearCiente("luis", "castro", "1097", 26, prestamoUq);
        mostrarInformacionClientes(prestamoUq);
        eliminarCliente(prestamoUq, "1095");
        System.out.println("--------> Lista de clientes después de eliminar cliente <-------");
        mostrarInformacionClientes(prestamoUq);
    }

    private static void crearCiente(String nombre,
                                    String apellido,
                                    String cedula,
                                    double edad,
                                    PrestamoUq prestamoUq) {
        prestamoUq.crearCliente(nombre, apellido, cedula, edad);
    }

    private static void mostrarInformacionClientes(PrestamoUq prestamoUq) {
        List<Cliente> listaCliente = prestamoUq.obtenerClientes();
        int tamanioLista = listaCliente.size();
        for(int i = 0; i < tamanioLista; i++){
            Cliente cliente = listaCliente.get(i);
            System.out.println(cliente.toString());
        }
    }

    private static void eliminarCliente(PrestamoUq prestamoUq, String cedula) {
        prestamoUq.eliminarCliente(cedula);
    }

    private static PrestamoUq inicializarDatosPrueba() {
        PrestamoUq prestamoUq = new PrestamoUq();
        prestamoUq.setNombre("Prestamo rapido");
        return prestamoUq;
    }


}