package br.edu.ifba.embarcados.javamonitor.listeners;



import org.apache.log4j.Logger;
import br.edu.ifba.embarcados.javamonitor.asincexec.IListenerMonitor;


public class Log  implements IListenerMonitor{
	final Logger log = Logger.getLogger(Log.class);
	
	@Override
	public void notificarAtividade(int valor) {
		log.info("Atenção Atividade Sismica Detectada "+valor+" metros");
	}
}