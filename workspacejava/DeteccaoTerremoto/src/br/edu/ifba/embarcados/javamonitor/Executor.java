package br.edu.ifba.embarcados.javamonitor;

import java.io.File;
import java.io.ObjectInputStream.GetField;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import br.edu.ifba.bsi.embarcados.javamonitor.alerta.Audio;
import br.edu.ifba.embarcados.javamonitor.conector.Conector;
import br.edu.ifba.embarcados.javamonitor.conector.IConexao;

public class Executor {

	static Logger log = Logger.getLogger(Executor.class);
	
	
	public static void main(String[] args) throws InterruptedException {
		// definindo um arquivo sonoro para alertar ocorrencias 
		String path = System.getProperty("user.dir")+"/src/br/edu/ifba/bsi/embarcados/javamonitor/alerta/som.mp3";
		File mp3File = new File(path);
		Audio alerta  = new Audio(mp3File);
		
		// setando as  configurações do arquivo de log
		BasicConfigurator.configure();
		PropertyConfigurator.configure("conf/log4j.properties");
		
		IConexao conector = Conector.getConector();
		
		if (conector.iniciar("/dev/ttyUSB0") == 0) {

			while (true) {
				conector.ler();

				//System.out.println("Atividade " + conector.getAtividade());
				// System.out.println("Altitude " + conector.getAltura());
				log.info("Atividade " + conector.getAtividade() + " - " + "Altura " + conector.getAltura());
				
				if(conector.getAtividade() == 1){
					log.warn("Atividade Sismica detectada");
				alerta.play();
				}
				Thread.sleep(100);
			}
		}
		else
			log.error("nao foi possivel comunicar via serial");
	}

}
