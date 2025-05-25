package co.edu.quindio.poo.bancouq.model;

import java.util.ArrayList;

public class Banco {
    ArrayList<CuentaBancaria> listacuentas;
    ArrayList<Usuario> listausuarios;
    private String nombre;
    private String codigo;

    public Banco(String nombre, String codigo) {

        this.nombre = nombre;
        this.codigo = codigo;
        this.listacuentas = new ArrayList<>();
        this.listausuarios = new ArrayList<>();

    }

    public ArrayList<CuentaBancaria> getListacuentas() {
        return listacuentas;
    }

    public void setListacuentas(ArrayList<CuentaBancaria> listacuentas) {
        this.listacuentas = listacuentas;
    }

    public ArrayList<Usuario> getListausuarios() {
        return listausuarios;
    }

    public void setListausuarios(ArrayList<Usuario> listausuarios) {
        this.listausuarios = listausuarios;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Banco{" +
                "listacuentas=" + listacuentas +
                ", listausuarios=" + listausuarios +
                ", nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                '}';
    }
    public Usuario buscarusuario(String identifiacion){
        if (listausuarios == null)
            return null;
        for(Usuario usuario : listausuarios){
            if(usuario.getIdentificacion().equals(identifiacion)){
                return usuario;
            }
        }
        return null;
    }
    public void registrarusuario (Usuario usuario) {
        listausuarios.add(usuario);
    }
    public void eliminarusuario(Usuario usuario) {
        listausuarios.remove(usuario);
    }
    public String modificarUsuario(String identificacion, String nuevoNombre, String nuevoApellido,
                                   String nuevoCorreo, String nuevoTelefono, String nuevoPin) {
        Usuario usuario = buscarusuario(identificacion);

        if (usuario == null) {
            return "Usuario no encontrado";
        }

        usuario.setNombres(nuevoNombre);
        usuario.setApellidos(nuevoApellido);
        usuario.setCorreo(nuevoCorreo);
        usuario.setTelefono(nuevoTelefono);
        usuario.setPin(nuevoPin);

        return "Usuario modificado exitosamente.";
    }
    public ArrayList<Usuario> listarusuarios() {
        return listausuarios;
    }


}
