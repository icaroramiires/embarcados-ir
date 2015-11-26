package br.edu.ifba.embarcados.javamonitor;


import br.edu.ifba.embarcados.javamonitor.asincexec.AsincExec;
import br.edu.ifba.embarcados.javamonitor.listeners.Alerta;
import br.edu.ifba.embarcados.javamonitor.listeners.Log;



public class Executor {
	
	//static Logger log  = Logger.getLogger(Executor.class);
	
	public static void main(String[] args) throws InterruptedException {
		
		Log logListener = new Log();
		Alerta alertaListener = new Alerta();
		
		AsincExec asinc = new AsincExec("/dev/ttyUSB0");
		asinc.addListener(logListener);
		asinc.addListener(alertaListener);
		
		Thread t = new Thread(asinc);
		t.start();
		
		for(int i = 0; i < 10; i++){
			Thread.sleep(1000);
		}
		
		asinc.setContinuar(false);
		t.join();
	}
}
