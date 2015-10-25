package br.edu.ifba.embarcados.javamonitor.conector;

import com.sun.jna.Library;

public interface IConexao extends Library{
	public int iniciar(String porta);
	int ler();
	int getAtividade();
	int getAltura();
	int finalizar();
}
