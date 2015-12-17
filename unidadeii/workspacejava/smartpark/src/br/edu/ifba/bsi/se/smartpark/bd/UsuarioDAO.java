package br.edu.ifba.bsi.se.smartpark.bd;

import java.util.Map;
import java.util.TreeMap;

public class UsuarioDAO {

	private static Map<Integer, Usuario> usuarios = 
			new TreeMap<Integer, Usuario>();
	
	static{
		
		Usuario u1 = new Usuario();
		u1.setId(246);
		u1.setNome("Allexandre");
		u1.setCarro("Porsche Cayenne");
		u1.setPlaca("LTZ");
		u1.setIdade("22");
		u1.setPne("icnaocad.png");
		u1.setFoto("allexandre.png");
		
		Usuario u2 = new Usuario();
		u2.setId(49);
		u2.setNome("Jackie");
		u2.setCarro("Saveiro Preto");
		u2.setPlaca("123");
		u2.setIdade("60");
		u2.setPne("icadeirante.png");
		u2.setFoto("idoso.png");
		u2.setFoto("jackie.png");
		
		
		usuarios.put(u1.getId(), u1);
		usuarios.put(u2.getId(), u2);
		
	
		
	}
	
	public static Usuario getUsuario(int id){
		return usuarios.get(id);
	}
	
	

}
