package br.edu.ifba.bsi.se.smartpark;
import com.sun.jna.Library;

public interface IComunicacaoRF extends Library{

	public int iniciar(String porta);
	public int ler();
	public int getId();
	public int getRFID();
	public int getStatusVaga();
	public int getDistancia();
	public int finalizar();
	
}