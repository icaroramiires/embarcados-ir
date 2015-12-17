package br.edu.ifba.bsi.se.smartpark;

import javax.faces.bean.ManagedBean;

import br.edu.ifba.bsi.se.smartpark.bd.Usuario;
import br.edu.ifba.bsi.se.smartpark.bd.UsuarioDAO;
import br.edu.ifba.bsi.se.smartpark.conector.SingleConector;

@ManagedBean(name = "monitor")
public class MonitorEstacionamento {
	int id;
	int rfid;
	int statusVaga;
	int distancia;
	
	Usuario user = new Usuario();
	
	

	public void lerSensores() {

		Informacao info = SingleConector.getInformacao();
		
		id = info.getId();
		rfid = info.getRFID();
		statusVaga =info.getStatusVaga();
		distancia = info.getDistancia();
		
		
		if(info.getStatusVaga() == 0){
			System.out.println("Encoste o carro");
		}else{
		
			user = verificaUsuario(rfid);
		
			
			System.out.println(user.getId());
			System.out.println(user.getNome());
			System.out.println(user.getCarro());
			System.out.println(user.getIdade());
			System.out.println(user.getPlaca());
			System.out.println(user.getPne());
			System.out.println(user.getFoto());
		}
		
	}
	
	public Usuario verificaUsuario(int id){	

		return UsuarioDAO.getUsuario(id);
		
	}

	public int getId() {
		return id;
	}

	public int getRfid() {
		return rfid;
	}

	public String getStatusVaga() {
		String vaga = "";
		if(statusVaga == 0) {
			vaga = "Disponivel";
		}
		else{
			vaga = "Ocupado";
		}
		return vaga;
	}

	public int getDistancia() {
		return distancia;
	}
	
	public String getPlaca(){
		String placa = "";
		if(user.getPlaca()!=null){
			placa = user.getPlaca();
		}
		return placa;
	}
	
	
	public String getNome() {
		String nome = "";
		if(user.getNome()!=null){
			nome = user.getNome();
		}
		return nome;
	}
	
	public String getCarro() {
		String carro = "";
		if(user.getCarro()!=null){
			carro = user.getCarro();
		}
		return carro;
	}
	
	public String getIdade() {
		String idade = "";
		if(user.getIdade()!=null){
			idade = user.getIdade();
		}
		return idade;
	}
	public String getPne() {
		String pne = "icadeirante.png";
		if(user.getPne()!=null){
			pne = user.getPne();
		}
		return pne;
	}
	
	public String getFoto() {
		String foto = "adefault.png";
		if(user.getFoto()!=null){
			foto = user.getFoto();
		}
		return foto;
	}
}
