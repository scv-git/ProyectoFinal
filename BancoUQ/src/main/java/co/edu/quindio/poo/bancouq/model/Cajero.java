package co.edu.quindio.poo.bancouq.model;
import co.edu.quindio.poo.bancouq.model.Ahorro;

import java.util.ArrayList;

public class Cajero extends Usuario{
    private String codigocajero;
    private ArrayList<Transaccion> historialTransacciones;

    public Cajero(String nombres, String apellidos,String identifiacion, String correo, String pin, String telefono,String codigocajero) {
        super(nombres,apellidos,identifiacion,correo,pin,telefono);
        this.codigocajero = codigocajero;
        this.historialTransacciones = new ArrayList<>();

    }

    public String getCodigocajero() {
        return codigocajero;
    }

    public void setCodigocajero(String codigocajero) {
        this.codigocajero = codigocajero;
    }

    public ArrayList<Transaccion> getHistorialTransacciones() {
        return historialTransacciones;
    }

    public void setHistorialTransacciones(ArrayList<Transaccion> historialTransacciones) {
        this.historialTransacciones = historialTransacciones;
    }

    @Override
    public String toString() {
        return "Cajero{" +
                "codigocajero='" + codigocajero + '\'' +
                '}';
    }
    public String registrarCliente(Banco banco, String nombres, String apellidos, String correo,
                                   String pin, String telefono, String identificacion, String tipoCuenta) {


        if (banco.buscarusuario(identificacion) != null) {
            return "El cliente con identificación " + identificacion + " ya está registrado.";
        }


        Cliente nuevoCliente = new Cliente(nombres, apellidos, identificacion, correo, pin, telefono);


        CuentaBancaria nuevaCuenta = null;

        switch (tipoCuenta.trim().toLowerCase()) {
            case "ahorro":
                nuevaCuenta = new Ahorro(generarNumeroCuenta(banco), 0.0, 0.02);
                break;
            case "corriente":
                nuevaCuenta = new Corriente(generarNumeroCuenta(banco), 500.0, 0.0);
                break;
            case "empresarial":
                nuevaCuenta = new Empresarial(generarNumeroCuenta(banco), 0.0, 10000.0);
                break;
            default:
                return "Tipo de cuenta inválido.";
        }

        nuevoCliente.getCuentas().add(nuevaCuenta);

        banco.registrarusuario(nuevoCliente);

        return "Cliente y cuenta tipo '" + tipoCuenta + "' registrados exitosamente.";
    }

    public String realizarDeposito(String identificacion, double monto, Banco banco) {
        Usuario usuario = banco.buscarusuario(identificacion);
        if (usuario instanceof Cliente) {
            Cliente cliente = (Cliente) usuario;
            if (!cliente.getCuentas().isEmpty()) {
                CuentaBancaria cuenta = cliente.getCuentas().get(0);
                cuenta.depositar(monto);
                return "Depósito realizado con éxito.";
            }
        }
        return "El cliente no tiene cuentas o no se encuentra registrado.";
    }
    public String realizarRetiro(String identificacion, double monto, Banco banco) {
        Usuario usuario = banco.buscarusuario(identificacion);
        if (usuario instanceof Cliente) {
            Cliente cliente = (Cliente) usuario;
            if (!cliente.getCuentas().isEmpty()) {
                CuentaBancaria cuenta = cliente.getCuentas().get(0);
                if (cuenta.getSaldo() >= monto) {
                    cuenta.retirar(monto);
                    return "Retiro realizado con éxito.";
                } else {
                    return "Saldo insuficiente.";
                }
            }
        }
        return "El cliente no tiene cuentas o no se encuentra registrado.";
    }

    private String generarNumeroCuenta(Banco banco) {
        String numeroCuenta;
        boolean existe;
        int contadorCuentas = 0;

        do {
            numeroCuenta = "CTA" + String.format("%06d", contadorCuentas++);
            existe = false;

            for (Usuario usuario : banco.getListausuarios()) {
                if (usuario instanceof Cliente) {
                    Cliente cliente = (Cliente) usuario;
                    for (CuentaBancaria cuenta : cliente.getCuentas()) {
                        if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
                            existe = true;
                            break;
                        }
                    }
                }
                if (existe) break;
            }
        } while (existe);

        return numeroCuenta;
    }

    public double consultarSaldo(String identificacion, Banco banco) {
        Usuario usuario = banco.buscarusuario(identificacion);
        if (usuario instanceof Cliente) {
            Cliente cliente = (Cliente) usuario;
            if (!cliente.getCuentas().isEmpty()) {
                return cliente.getCuentas().get(0).getSaldo();
            }
        }
        return -1;
    }

    public String realizarTransferencia(String identificacionOrigen, String identificacionDestino, double monto, Banco banco) {
        Usuario usuarioOrigen = banco.buscarusuario(identificacionOrigen);
        Usuario usuarioDestino = banco.buscarusuario(identificacionDestino);

        if (usuarioOrigen instanceof Cliente && usuarioDestino instanceof Cliente) {
            Cliente clienteOrigen = (Cliente) usuarioOrigen;
            Cliente clienteDestino = (Cliente) usuarioDestino;


            if (!clienteOrigen.getCuentas().isEmpty() && !clienteDestino.getCuentas().isEmpty()) {
                CuentaBancaria cuentaOrigen = clienteOrigen.getCuentas().get(0);
                CuentaBancaria cuentaDestino = clienteDestino.getCuentas().get(0);

                if (cuentaOrigen.getSaldo() >= monto) {
                    cuentaOrigen.retirar(monto);
                    cuentaDestino.depositar(monto);
                    return "Transferencia realizada con éxito.";
                } else {
                    return "Saldo insuficiente en la cuenta de origen.";
                }
            }
        }
        return "Una de las cuentas no existe o los usuarios no fueron encontrados.";
    }

    public String generarReporteMovimientos(String identificacion, Banco banco) {
        Usuario usuario = banco.buscarusuario(identificacion);
        if (usuario instanceof Cliente) {
            Cliente cliente = (Cliente) usuario;
            StringBuilder reporte = new StringBuilder("Reporte de Movimientos de Cliente " + identificacion + ":\n");
            if (cliente.verHistorialTransacciones() != null && !cliente.verHistorialTransacciones().isEmpty()) {
                for (Transaccion transaccion : cliente.getHistorialTransacciones()){
                    reporte.append(transaccion.toString()).append("\n");
                }
            } else {
                reporte.append("No hay movimientos registrados.");
            }
            return reporte.toString();
        }
        return "Cliente no encontrado.";
    }

}
