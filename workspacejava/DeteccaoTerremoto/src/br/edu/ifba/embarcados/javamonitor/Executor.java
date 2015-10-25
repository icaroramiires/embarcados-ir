package br.edu.ifba.embarcados.javamonitor;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import br.edu.ifba.embarcados.javamonitor.conector.Conector;
import br.edu.ifba.embarcados.javamonitor.conector.IConexao;

public class Executor {

	static Logger log = Logger.getLogger(Executor.class);
	
	public static void main(String[] args) throws InterruptedException {

		BasicConfigurator.configure();
		
		IConexao conector = Conector.getConector();
		
		if (conector.iniciar("/dev/ttyUSB0") == 0) {

			while (true) {
				conector.ler();

				//System.out.println("Atividade " + conector.getAtividade());
				// System.out.println("Altitude " + conector.getAltura());
				log.info("Atividade " + conector.getAtividade() + " - " + "Altura " + conector.getAltura());
				
				if(conector.getAtividade() == 1){
					log.warn("Terremoto!");
				}
				Thread.sleep(100);
			}
		}
	}

}
