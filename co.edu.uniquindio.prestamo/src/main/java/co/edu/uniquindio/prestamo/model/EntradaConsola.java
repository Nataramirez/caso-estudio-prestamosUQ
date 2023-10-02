package co.edu.uniquindio.prestamo.model;

import co.edu.uniquindio.prestamo.enums.Crud;
import co.edu.uniquindio.prestamo.enums.Proceso;

import javax.swing.*;
import java.util.List;

public class EntradaConsola {
    public static String tipoProceso(){
        String proceso = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione el proceso que desea gestionar",
                "PROCESO", JOptionPane.DEFAULT_OPTION,
                null,
                Proceso.proceso(),
                null);
        return proceso;
    }

    public static String tipoCrud(String proceso){
        String resp = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione una acción a ejecutar",
                "CRUD", JOptionPane.DEFAULT_OPTION,
                null,
                Crud.crud(proceso),
                null);
        return resp;
    }

    public static int crear(String proceso){
        int cerrar = 1;
        if(proceso.equals(Proceso.CLIENTE.getNombre())){
            while(cerrar == 1){
                String nombre = JOptionPane.showInputDialog("Ingrese nombre del cliente");
                int cerrarAplicacionEnNombre = cerrarApliacionString(nombre);
                if(cerrarAplicacionEnNombre == 0){
                    cerrar = cerrarAplicacionEnNombre;
                    return cerrar;
                } else if (cerrarAplicacionEnNombre == 1 && nombre == null) {
                    nombre = JOptionPane.showInputDialog("Ingrese nombre del cliente");
                    cerrarAplicacionEnNombre = cerrarApliacionString(nombre);
                }
                String apellido = JOptionPane.showInputDialog("Ingrese apellido del cliente");
                int cerrarAplicacionEnApellido = cerrarApliacionString(apellido);
                if(cerrarAplicacionEnApellido == 0){
                    cerrar = cerrarAplicacionEnApellido;
                    return cerrar;
                } else if (cerrarAplicacionEnApellido == 1 && apellido == null) {
                    apellido = JOptionPane.showInputDialog("Ingrese apellido del cliente");
                    cerrarAplicacionEnApellido = cerrarApliacionString(apellido);
                }
                String cedula = JOptionPane.showInputDialog("Ingrese cedula del cliente");
                int cerrarAplicacionEnCedula = cerrarApliacionString(cedula);
                if(cerrarAplicacionEnCedula == 0){
                    cerrar = cerrarAplicacionEnCedula;
                    return cerrar;
                } else if (cerrarAplicacionEnCedula == 1 && cedula == null) {
                    cedula = JOptionPane.showInputDialog("Ingrese cedula del cliente");
                    cerrarAplicacionEnCedula = cerrarApliacionString(cedula);
                }
                Double edad = Double.parseDouble(JOptionPane.showInputDialog("Ingrese edad del cliente"));
                int cerrarAplicacionEnEdad = cerrarApliacionDouble(edad);
                if(cerrarAplicacionEnEdad == 0){
                    cerrar = cerrarAplicacionEnEdad;
                    return cerrar;
                } else if (cerrarAplicacionEnEdad == 1 && edad == null) {
                    edad = Double.parseDouble(JOptionPane.showInputDialog("Ingrese edad del cliente"));
                    cerrarAplicacionEnEdad = cerrarApliacionDouble(edad);
                }
                PrestamoUq.crearCliente(nombre,apellido, cedula, edad);
                cerrar = cerrarAplicacion();
                return cerrar;
            }

        }
        if (proceso.equals(Proceso.EMPLEADO.getNombre())){
            while(cerrar == 1){
                String nombre = JOptionPane.showInputDialog("Ingrese nombre del empleado");
                int cerrarAplicacionEnNombre = cerrarApliacionString(nombre);
                if(cerrarAplicacionEnNombre == 0){
                    cerrar = cerrarAplicacionEnNombre;
                    return cerrar;
                } else if (cerrarAplicacionEnNombre == 1 && nombre == null) {
                    nombre = JOptionPane.showInputDialog("Ingrese nombre del empleado");
                    cerrarAplicacionEnNombre = cerrarApliacionString(nombre);
                }
                String apellido = JOptionPane.showInputDialog("Ingrese apellido del empleado");
                int cerrarAplicacionEnApellido = cerrarApliacionString(apellido);
                if(cerrarAplicacionEnApellido == 0){
                    cerrar = cerrarAplicacionEnApellido;
                    return cerrar;
                } else if (cerrarAplicacionEnApellido == 1 && apellido == null) {
                    apellido = JOptionPane.showInputDialog("Ingrese apellido del empleado");
                    cerrarAplicacionEnApellido = cerrarApliacionString(apellido);
                }
                String cedula = JOptionPane.showInputDialog("Ingrese cedula del empleado");
                int cerrarAplicacionEnCedula = cerrarApliacionString(cedula);
                if(cerrarAplicacionEnCedula == 0){
                    cerrar = cerrarAplicacionEnCedula;
                    return cerrar;
                } else if (cerrarAplicacionEnCedula == 1 && cedula == null) {
                    cedula = JOptionPane.showInputDialog("Ingrese cedula del empleado");
                    cerrarAplicacionEnCedula = cerrarApliacionString(cedula);
                }
                Double edad = Double.parseDouble(JOptionPane.showInputDialog("Ingrese edad del empleado"));
                int cerrarAplicacionEnEdad = cerrarApliacionDouble(edad);
                if(cerrarAplicacionEnEdad == 0){
                    cerrar = cerrarAplicacionEnEdad;
                    return cerrar;
                } else if (cerrarAplicacionEnEdad == 1 && edad == null) {
                    edad = Double.parseDouble(JOptionPane.showInputDialog("Ingrese edad del empleado"));
                    cerrarAplicacionEnEdad = cerrarApliacionDouble(edad);
                }
                PrestamoUq.crearEmpleado(nombre,apellido, cedula, edad);
                cerrar = cerrarAplicacion();
                return cerrar;
            }
        }
        return cerrar;
    }

    public static int leer(String proceso){
        int cerrar = 1;
        if(proceso.equals(Proceso.CLIENTE.getNombre())){
            List<Cliente> listaClientes =  PrestamoUq.getListaClientes();
            for(int i = 0; i < listaClientes.size(); i++){
                JOptionPane.showMessageDialog(null,listaClientes.get(i).toString());
            }
            cerrar = cerrarAplicacion();
        }
        if(proceso.equals(Proceso.EMPLEADO.getNombre())){
            List<Empleado> listaEmpleados =  PrestamoUq.getListaEmpleados();
            for(int i = 0; i < listaEmpleados.size(); i++){
                JOptionPane.showMessageDialog(null,listaEmpleados.get(i).toString());
            }
            cerrar = cerrarAplicacion();
        }
        return cerrar;
    }

    public static int eliminar(String proceso){
        int cerrar = 1;
        if(proceso.equals(Proceso.CLIENTE.getNombre())){
            String cedula = JOptionPane.showInputDialog("Ingrese cedula del cliente que desea eliminar");
            if (cedula != null){
                boolean clienteEliminado = PrestamoUq.eliminarCliente(cedula);
                if (clienteEliminado){
                    JOptionPane.showMessageDialog(null,"El cliente ha sido eliminado");
                }else {
                    JOptionPane.showMessageDialog(null,"El cliente NO ha ha sido encontrado");
                }

            }
        }
        if(proceso.equals(Proceso.EMPLEADO.getNombre())){
            String cedula = JOptionPane.showInputDialog("Ingrese cedula del empleado que desea eliminar");
            if(cedula != null){
                boolean empleadoEliminado = PrestamoUq.eliminarEmpleado(cedula);
                if(empleadoEliminado){
                    JOptionPane.showMessageDialog(null,"El empleado ha sido eliminado");
                }else {
                    JOptionPane.showMessageDialog(null,"El empleado NO ha ha sido encontrado");
                }

            }
        }
        return cerrar;
    }

    public static int cerrarApliacionString(String accion){
        int cerrar = 1;
        if(accion instanceof String){
            return cerrar;
        }else {
            int respuestaCerrar = JOptionPane.showConfirmDialog(null,
                    "¿Desea cerrar la aplicación?",
                    "Alerta!",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.ERROR_MESSAGE);
            cerrar = respuestaCerrar;
            return cerrar;
        }
    }

    public static int cerrarApliacionDouble(Double dato){
        int cerrar = 1;
        if(dato instanceof Double){
            return cerrar;
        }else {
            int respuestaCerrar = JOptionPane.showConfirmDialog(null,
                    "¿Desea cerrar la aplicación?",
                    "Alerta!",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.ERROR_MESSAGE);
            cerrar = respuestaCerrar;
            return cerrar;
        }
    }

    public static int cerrarAplicacion(){
        int respuestaCerrar = JOptionPane.showConfirmDialog(null,
                    "¿Desea cerrar la aplicación?",
                    "Alerta!",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.ERROR_MESSAGE);
        System.out.println(respuestaCerrar + " respuesta para cerrar");
        return respuestaCerrar;
    }

}
