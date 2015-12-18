package br.edu.ifba.bsi.se.smartpark.conector;



import java.util.concurrent.Semaphore;

import br.edu.ifba.bsi.se.smartpark.IComunicacaoRF;
import br.edu.ifba.bsi.se.smartpark.Informacao;

public class SingleConector {
	
	private static final String PORTA = "/dev/ttyACM0";
	private static IComunicacaoRF comRF = null;
	private static Informacao info;
	private static Semaphore semaforo;
	
	public static void iniciarComunicacoRF(String libPath){
		info = new  Informacao();
		comRF = FabricaConectores.getConector(libPath);
		
		if (comRF.iniciar(PORTA)==0){
			System.out.println("Comunicaçao com sensores realizado com sucesso.");
			dispensarPrimeirasLeituras();
			semaforo = new Semaphore(1, true);
		}else
			System.out.println("Nao foi possivel se comunicar com o sensores.");
	}
	
	public static void dispensarPrimeirasLeituras(){
		for(int i=0; i<10; i++){
			comRF.ler();
			System.out.println("Dispensando leitura: [ID - RFID - STATUSVAGA - DISTANCIA]"+comRF.getId() +"/"+comRF.getRFID()+"/"+comRF.getStatusVaga()+"/"+comRF.getDistancia());
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Informacao getInformacao(){
		Informacao info_ = new Informacao();
		
		try {
			semaforo.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		info_.setId(info.getId());
		info_.setRFID(info.getRFID());
		info_.setStatusVaga(info.getStatusVaga());
		info_.setDistancia(info.getDistancia());
		semaforo.release();
		
		return info_;
	}
	
	public static int ler(){
		try {
			semaforo.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		int resultado = comRF.ler();
		
		if(resultado == 0){
			
			info.setId(comRF.getId());
			info.setRFID(comRF.getId());
			info.setStatusVaga(comRF.getStatusVaga());
			
			
			
			info.setId(comRF.getId());
			info.setRFID(comRF.getRFID());
			info.setStatusVaga(comRF.getStatusVaga());
			info.setDistancia(comRF.getDistancia());
		}
		
		semaforo.release();
		
		return resultado;
	}
	
	public static void  finalizar(){
		comRF.finalizar();
	}
}
