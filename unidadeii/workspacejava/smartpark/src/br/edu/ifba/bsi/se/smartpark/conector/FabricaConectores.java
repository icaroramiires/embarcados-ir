package br.edu.ifba.bsi.se.smartpark.conector;


import com.sun.jna.Native;
import com.sun.jna.Platform;

import br.edu.ifba.bsi.se.smartpark.IComunicacaoRF;

public class FabricaConectores {
	
	public static IComunicacaoRF getConector(String libPath){
		IComunicacaoRF comRF = null;
		
		if(Platform.isWindows())
			comRF = (IComunicacaoRF) Native.loadLibrary(libPath+"/smartpark.dll", IComunicacaoRF.class);
		else if(Platform.isLinux())
			comRF = (IComunicacaoRF) Native.loadLibrary(libPath+"/smartpark.so", IComunicacaoRF.class);
		return comRF;
	}
	
}