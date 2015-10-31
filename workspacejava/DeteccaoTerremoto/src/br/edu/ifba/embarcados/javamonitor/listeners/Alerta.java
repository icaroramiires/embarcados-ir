package br.edu.ifba.embarcados.javamonitor.listeners;

import java.io.File;

import br.edu.ifba.bsi.embarcados.javamonitor.alerta.Audio;
import br.edu.ifba.embarcados.javamonitor.asincexec.IListenerMonitor;

public class Alerta implements IListenerMonitor{
	String path = System.getProperty("user.dir") + "/src/br/edu/ifba/bsi/embarcados/javamonitor/alerta/som.mp3";
	File mp3File = new File(path);
	Audio alerta  = new Audio(mp3File);
	@Override
	public void notificarAtividade() {
		alerta.play();
	}
}
