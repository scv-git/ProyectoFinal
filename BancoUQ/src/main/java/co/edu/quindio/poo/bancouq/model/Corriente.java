package co.edu.quindio.poo.bancouq.model;

public class Corriente extends CuentaBancaria{

    private double limiteSobregiro;

    public Corriente(String numeroCuenta, double limiteSobregiro, double saldo) {

        super(numeroCuenta, saldo);
        this.limiteSobregiro = limiteSobregiro;


    }

    public double getLimiteSobregiro() {
        return limiteSobregiro;
    }

    public void setLimiteSobregiro(double limiteSobregiro) {
        this.limiteSobregiro = limiteSobregiro;
    }

    @Override
    public String toString() {
        return "Corriente{" +
                "limiteSobregiro=" + limiteSobregiro +
                '}';
    }

    @Override
    public double depositar(double valorIngresado) {
        return super.depositar(valorIngresado);
    }

    public double retirar(double monto) {
        if (monto <= 0) {
            System.out.println(" El monto debe ser mayor a cero.");
            return saldo - monto;
        }

        if (saldo >= monto) {
            saldo -= monto;
            System.out.println("Retiro exitoso. Saldo restante: $" + saldo);
            return saldo;
        } else if ((saldo + limiteSobregiro) >= monto) {
            double sobregiroUsado = monto - saldo;
            saldo -= monto;
            System.out.println("Se usó sobregiro por $" + sobregiroUsado + ". Nuevo saldo: $" + saldo);
            return saldo;
        } else {
            System.out.println("Retiro denegado. Excede el límite de sobregiro.");
            return saldo;
        }
    }

    @Override
    public String verSaldo() {
        return super.verSaldo();
    }
}