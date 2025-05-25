package co.edu.quindio.poo.bancouq.model;

import java.util.ArrayList;

public class Cliente extends Usuario{
    private String idUsuario;
    private ArrayList<CuentaBancaria> cuentas;

    public Cliente(String nombres, String apellidos,String identifiacion, String correo, String pin, String telefono) {
        super(nombres,apellidos,identifiacion,correo,pin,telefono);
        this.idUsuario = idUsuario;
        this.cuentas = new ArrayList<>();
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public ArrayList<CuentaBancaria> getCuentas() {
        return cuentas;
    }

    public void setCuentas(ArrayList<CuentaBancaria> cuentas) {
        this.cuentas = cuentas;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idUsuario='" + idUsuario + '\'' +
                ", cuentas=" + cuentas +
                '}';
    }
    public double consultarSaldo() {
        double total = 0;
        for (CuentaBancaria cuenta : cuentas) {
            total += cuenta.consultarSaldo();
        }
        return total;
    }

    public String verHistorialTransacciones() {
        if (historialTransacciones.isEmpty()) {
            return "No hay transacciones registradas.";
        }
        StringBuilder historial = new StringBuilder("📜 Historial de Transacciones:\n");
        for (Transaccion transaccion : historialTransacciones) {
            historial.append(transaccion.toString()).append("\n");
        }
        return historial.toString();
    }
    public String realizarTransferencia(String numeroCuentaOrigen, String numeroCuentaDestino, double monto, Banco banco) {
        CuentaBancaria cuentaOrigen = null;
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.getNumeroCuenta().equals(numeroCuentaOrigen)) {
                cuentaOrigen = cuenta;
                break;
            }
        }

        if (cuentaOrigen == null) {
            return "❌ Cuenta origen no encontrada.";
        }

        // Buscar cuenta destino en todos los clientes del banco
        CuentaBancaria cuentaDestino = banco.buscarCuentaPorNumero(numeroCuentaDestino);
        if (cuentaDestino == null) {
            return "❌ Cuenta destino no encontrada.";
        }

        if (cuentaOrigen.getSaldo() < monto) {
            return "❌ Saldo insuficiente.";
        }

        cuentaOrigen.retirar(monto);
        cuentaDestino.depositar(monto);

        Transferencia transferencia = new Transferencia(cuentaOrigen, cuentaDestino, monto);
        this.agregarTransaccion(transferencia);
        return "✅ Transferencia realizada con éxito.";
    }

}
