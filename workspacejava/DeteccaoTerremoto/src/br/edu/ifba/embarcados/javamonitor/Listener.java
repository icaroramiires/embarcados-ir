package br.edu.ifba.embarcados.javamonitor;

import br.edu.ifba.embarcados.javamonitor.asincexec.IListenerMonitor;

public class Listener implements IListenerMonitor{
	@Override
	public void notificarAtividade() {
		// TODO Auto-generated method stub
		System.out.println("Terremoto");
		
	}

}