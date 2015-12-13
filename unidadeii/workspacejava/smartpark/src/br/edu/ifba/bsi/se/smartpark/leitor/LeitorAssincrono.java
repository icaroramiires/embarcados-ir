package br.edu.ifba.bsi.se.smartpark.leitor;

import br.edu.ifba.bsi.se.smartpark.conector.SingleConector;

public class LeitorAssincrono implements Runnable{

	private boolean continuar;
	
	
	public LeitorAssincrono() {
	}
	
	@Override
	public void run() {
		continuar = true;
		
		while(continuar){
			SingleConector.ler();
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void parar(){
		continuar = false;
	}
	
}
