package co.edu.quindio.poo.bancouq.model;

public class Administrador extends Usuario {
    private String codigoAdmin;

    public Administrador(String nombres, String apellidos, String identificacion,
                         String correo, String pin, String telefono, String codigoAdmin) {
        super(nombres, apellidos, identificacion, correo, pin, telefono);
        this.codigoAdmin = codigoAdmin;
    }

    public String getCodigoAdmin() {
        return codigoAdmin;
    }

    public void setCodigoAdmin(String codigoAdmin) {
        this.codigoAdmin = codigoAdmin;
    }
    public boolean autenticarAdmin(String codigoIngresado) {
        return this.codigoAdmin.equals(codigoIngresado);
    }

    public String agregarEmpleado(Banco banco, Usuario empleado) {
        if (banco.buscarusuario(empleado.getIdentificacion()) != null) {
            return " Ya existe un usuario con esa identificación.";
        }
        banco.registrarusuario(empleado);
        return " Empleado agregado exitosamente.";
    }


    public String modificarEmpleado(Banco banco, String identificacion, String nuevoNombre, String nuevoApellido,
                                    String nuevoCorreo, String nuevoTelefono, String nuevoPin) {
        return banco.modificarUsuario(identificacion, nuevoNombre, nuevoApellido, nuevoCorreo, nuevoTelefono, nuevoPin);
    }


    public String eliminarEmpleado(Banco banco, String identificacion) {
        Usuario empleado = banco.buscarusuario(identificacion);
        if (empleado == null) {
            return " Empleado no encontrado.";
        }
        banco.eliminarusuario(empleado);
        return " Empleado eliminado correctamente.";
    }
    public String generarReporteGeneral(Banco banco) {
        StringBuilder reporte = new StringBuilder("Reporte General del Banco UQ:\n");
        for (Usuario usuario : banco.listarusuarios()) {
            reporte.append(usuario.toString()).append("\n");

            if (usuario instanceof Cliente) {
                Cliente cliente = (Cliente) usuario;
                for (CuentaBancaria cuenta : cliente.getCuentas()) {
                    reporte.append("    Cuenta: ").append(cuenta.toString()).append("\n");
                }
            }
        }
        return reporte.toString();
    }
    public String monitorearTransacciones(Banco banco) {
        StringBuilder reporte = new StringBuilder("Historial de Transacciones:\n");
        for (Usuario usuario : banco.listarusuarios()) {
            if (usuario instanceof Cliente) {
                Cliente cliente = (Cliente) usuario;
                reporte.append("Cliente: ").append(cliente.getNombres()).append(" ").append(cliente.getApellidos()).append("\n");
                for (Transaccion transaccion : cliente.getHistorialTransacciones()) {
                    reporte.append("    ").append(transaccion.toString()).append("\n");
                }
            }
        }
        return reporte.toString();
    }
}