package co.edu.quindio.poo.bancouq.model;

public class Empresarial extends CuentaBancaria {

    private double montoMaximoMensual;

    public Empresarial(String numeroCuenta, double saldo, double montoMaximoMensual) {

        super(numeroCuenta, saldo);
        this.montoMaximoMensual = montoMaximoMensual;

    }

    public double getMontoMaximoMensual() {
        return montoMaximoMensual;
    }

    public void setMontoMaximoMensual(double montoMaximoMensual) {
        this.montoMaximoMensual = montoMaximoMensual;
    }

    @Override
    public String toString() {
        return "Empresarial{" +
                "montoMaximoMensual=" + montoMaximoMensual +
                '}';
    }

    @Override
    public double depositar(double valorIngresado) {
        return super.depositar(valorIngresado);
    }

    public double retirar(double monto){

        if(monto <= 0){

            System.out.println("El monto no puede ser menor a cero");
            return saldo;

        }

        if(monto <= saldo && monto <= montoMaximoMensual){

            montoMaximoMensual -= monto;
            saldo -= monto;
            System.out.println("Dinero retirado con exito");
            return saldo;

        }

        return saldo;

    }

    @Override
    public String verSaldo() {
        return super.verSaldo();
    }
}
