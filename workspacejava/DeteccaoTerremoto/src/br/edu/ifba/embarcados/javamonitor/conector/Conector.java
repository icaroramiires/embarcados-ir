package br.edu.ifba.embarcados.javamonitor.conector;

import com.sun.jna.Native;
import com.sun.jna.Platform;

public class Conector {
	public static IConexao getConector(){
		IConexao conector = null;

		if (Platform.isWindows()) {

			conector = (IConexao) Native.loadLibrary("comunicacao.dll",
					IConexao.class);
		} else if (Platform.isLinux()) {
			
			conector = (IConexao) Native.loadLibrary("comunicacao.so",
					IConexao.class);
		}
		
		return conector;
	}
}
