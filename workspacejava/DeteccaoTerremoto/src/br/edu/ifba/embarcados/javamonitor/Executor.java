package br.edu.ifba.embarcados.javamonitor;

import br.edu.ifba.embarcados.javamonitor.conector.Conector;
import br.edu.ifba.embarcados.javamonitor.conector.IConexao;

public class Executor {

	public static void main(String[] args) throws InterruptedException {

		IConexao conector = Conector.getConector();

		if (conector.iniciar("/dev/ttyUSB0") == 0) {

			while (true) {
				conector.ler();

				System.out.println("Atividade " + conector.getAtividade());
				System.out.println("Altitude " + conector.getAltura());

				Thread.sleep(100);
			}
		}
	}

}
