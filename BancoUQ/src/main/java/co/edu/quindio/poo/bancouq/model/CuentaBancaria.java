package co.edu.quindio.poo.bancouq.model;

import java.util.ArrayList;

public abstract class CuentaBancaria {

    protected String numeroCuenta;
    protected double saldo;
    protected ArrayList<Cliente> listaClientes;
    protected ArrayList<CuentaBancaria> listaCuentas;

    public CuentaBancaria(String numeroCuenta, double saldo) {

        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.listaClientes = new ArrayList<>();
        this.listaCuentas = new ArrayList<>();

    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public ArrayList<CuentaBancaria> getListaCuentas() {
        return listaCuentas;
    }

    public void setListaCuentas(ArrayList<CuentaBancaria> listaCuentas) {
        this.listaCuentas = listaCuentas;
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "numeroCuenta='" + numeroCuenta + '\'' +
                ", saldo=" + saldo +
                ", listaClientes=" + listaClientes +
                '}';
    }

    public void agregarCliente(Cliente IdCliente) {
        for (Cliente cliente : listaClientes) {
            if(cliente.getPin().equals(IdCliente.getPin())) {
                System.out.println("El cliente se encuentra registrado");
                return;
            }
        }

        listaClientes.add(IdCliente);
        System.out.println("El cliente se encuentra agregado");
    }


    public ArrayList<Cliente> obtenerCuentasDeCliente(Cliente clienteBuscado) {
        ArrayList<Cliente> cuentasDelCliente = new ArrayList<>();

        for (Cliente cliente : listaClientes) {
            if (cliente.getPin().equals(clienteBuscado.getPin())) {
                cuentasDelCliente.add(cliente);
            }
        }

        return cuentasDelCliente;
    }



    public String obtenerCliente(Cliente buscado) {
        for (Cliente cliente : listaClientes) {
            if(cliente.getPin().equals(buscado.getPin())) {
                return cliente.getNombres();
            }
        }
        return null;
    }


    public double depositar(double valorIngresado) {
        if (valorIngresado > 0) {
            saldo += valorIngresado;
            System.out.println("Depósito exitoso. Nuevo saldo: " + saldo);

        } else {
            System.out.println("El valor ingresado debe ser mayor a 0");
        }

        return saldo;

    }



    public double retirar(double valorRetirado) {

        saldo -= valorRetirado;
        System.out.println("Retiro exitoso");
        return saldo;


    }


    public String verSaldo() {

        return "El saldo actual en su cuenta es de: " + saldo;


    }

    public String encontrarCuentaCliente() {

        for (CuentaBancaria cuentaBancaria : listaCuentas) {

            if (cuentaBancaria.getNumeroCuenta().equals(numeroCuenta)) {

                System.out.println("El cliente se encuentra");
                return cuentaBancaria.getNumeroCuenta();


            }


        }

        return "El cliente no se encuentra ";

    }


}
