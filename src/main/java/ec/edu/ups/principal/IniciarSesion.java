package ec.edu.ups.principal;

import java.util.ArrayList;

import ec.edu.ups.clases.Usuario;

public class IniciarSesion {
	public boolean buscarUsuario (String nombreUsuario, String contrasena, ArrayList <Usuario> listaUsuarios) {
		Usuario usuario = new Usuario();
		
		/*
		 * Busca en la lista de usuarios la existencia del ingresado por su nombre de usuario y su contraseña
		*/
		for(int i=0; i<listaUsuarios.size(); i++){
			usuario=listaUsuarios.get(i);
			if(nombreUsuario.equals(usuario.getUsuario()) && contrasena.equals(usuario.getContrasena())) {
				return true;
			}
		}
		return false;
	}
}
