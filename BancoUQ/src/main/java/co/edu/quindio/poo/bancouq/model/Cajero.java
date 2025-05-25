package co.edu.quindio.poo.bancouq.model;

public class Cajero extends Usuario{
    private String codigocajero;

    public Cajero(String nombres, String apellidos,String identifiacion, String correo, String pin, String telefono,String codigocajero) {
        super(nombres,apellidos,identifiacion,correo,pin,telefono);
        this.codigocajero = codigocajero;

    }

    public String getCodigocajero() {
        return codigocajero;
    }

    public void setCodigocajero(String codigocajero) {
        this.codigocajero = codigocajero;
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

        switch (tipoCuenta.toLowerCase()) {
            case "ahorro":
                nuevaCuenta = new Ahorro();
                break;
            case "corriente":
                nuevaCuenta = new Corriente();
                break;
            case "empresarial":
                nuevaCuenta = new Empresarial();
                break;
            default:
                return "Tipo de cuenta inválido.";
        }

        nuevoCliente.getCuentas().add(nuevaCuenta);

        banco.registrarusuario(nuevoCliente);

        return "✅ Cliente y cuenta tipo '" + tipoCuenta + "' registrados exitosamente.";
    }

    public String realizarDeposito(String identificacion, double monto, Banco banco) {
        Usuario usuario = banco.buscarusuario(identificacion);
        if (usuario instanceof Cliente) {
            Cliente cliente = (Cliente) usuario;
            if (!cliente.getCuentas().isEmpty()) {
                CuentaBancaria cuenta = cliente.getCuentas().get(0); // Suponemos que usa la primera cuenta
                cuenta.depositar(monto);  // Método de la clase CuentaBancaria
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
                if (cuenta.consultarSaldo() >= monto) {
                    cuenta.retirar(monto); // Método de la clase CuentaBancaria
                    return "✅ Retiro realizado con éxito.";
                } else {
                    return "Saldo insuficiente.";
                }
            }
        }
        return "El cliente no tiene cuentas o no se encuentra registrado.";
    }

    public double consultarSaldo(String identificacion, Banco banco) {
        Usuario usuario = banco.buscarusuario(identificacion);
        if (usuario instanceof Cliente) {
            Cliente cliente = (Cliente) usuario;
            if (!cliente.getCuentas().isEmpty()) {
                return cliente.getCuentas().get(0).consultarSaldo(); // Consulta la primera cuenta
            }
        }
        return -1; // Retorna -1 si no se encontró o no tiene cuenta
    }

    public String realizarTransferencia(String identificacionOrigen, String identificacionDestino, double monto, Banco banco) {
        Usuario usuarioOrigen = banco.buscarusuario(identificacionOrigen);
        Usuario usuarioDestino = banco.buscarusuario(identificacionDestino);

        if (usuarioOrigen instanceof Cliente && usuarioDestino instanceof Cliente) {
            Cliente clienteOrigen = (Cliente) usuarioOrigen;
            Cliente clienteDestino = (Cliente) usuarioDestino;

            // Verificar que ambos clientes tengan cuentas
            if (!clienteOrigen.getCuentas().isEmpty() && !clienteDestino.getCuentas().isEmpty()) {
                CuentaBancaria cuentaOrigen = clienteOrigen.getCuentas().get(0); // Cuenta de origen
                CuentaBancaria cuentaDestino = clienteDestino.getCuentas().get(0); // Cuenta de destino

                if (cuentaOrigen.consultarSaldo() >= monto) {
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
            if (cliente.getHistorialTransacciones() != null && !cliente.getHistorialTransacciones().isEmpty()) {
                for (Transaccion transaccion : cliente.getHistorialTransacciones()) {
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
