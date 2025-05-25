package co.edu.quindio.poo.bancouq.model;

public abstract class Usuario {
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
