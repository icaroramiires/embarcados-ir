package br.edu.ifba.embarcados.javamonitor.asincexec;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;

import br.edu.ifba.embarcados.javamonitor.conector.Conector;
import br.edu.ifba.embarcados.javamonitor.conector.IConexao;

public class AsincExec implements Runnable {
	private String porta;
	private boolean continuar;
	private List<IListenerMonitor> listeners;

	public AsincExec(String porta) {
		this.porta = porta;
		this.listeners = new ArrayList<IListenerMonitor>();
	}

	public void addListener(IListenerMonitor listener) {
		listeners.add(listener);
	}

	public void setContinuar(boolean continuar) {
		this.continuar = continuar;
	}
	@Override
	public void run() {
		BasicConfigurator.configure();
		PropertyConfigurator.configure("conf/log4j.properties");
		
		IConexao conector = Conector.getConector();
		
		if (conector.iniciar(porta) == 0) {

			continuar = true;

			while (continuar) {

				conector.ler();
				
				if (conector.getAtividade() == 1) {
					notificaAtividade();
				}
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			}
			conector.finalizar();
		} else {
			System.out.println("Não foi possivel comunicar via serial");
		}

	}

	private void notificaAtividade() {
		for (IListenerMonitor listener : listeners) {
			listener.notificarAtividade();
		}
	}
}