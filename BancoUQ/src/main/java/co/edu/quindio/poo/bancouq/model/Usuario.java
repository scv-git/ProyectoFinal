package co.edu.quindio.poo.bancouq.model;

public abstract class Usuario {

    private String nombres;
    private String apellidos;
    private String identificacion;
    private String correo;
    private String pin;
    private String telefono;

    public Usuario(String nombres, String apellidos, String correo, String pin, String telefono,String identificacion) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.pin = pin;
        this.telefono = telefono;
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", correo='" + correo + '\'' +
                ", pin='" + pin + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }


}
