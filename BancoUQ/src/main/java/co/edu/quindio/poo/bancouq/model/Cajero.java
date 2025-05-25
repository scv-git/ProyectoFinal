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
    public String registrarusuario() {

    }
}
