package br.edu.ifba.bsi.se.smartpark;

import javax.faces.bean.ManagedBean;

import br.edu.ifba.bsi.se.smartpark.conector.SingleConector;
@ManagedBean(name="monitor")
public class MonitorEstacionamento {
	
	

public void lerSensores(){
		
Informacao info = SingleConector.getInformacao();
		
int id = info.getId();
int rfid = info.getRFID();
int status = info.getStatusVaga();
int distancia = info.getDistancia();
		
			
			System.out.println("Id"+ id);
			System.out.println("rfid"+ rfid);
			System.out.println("status"+ status);
			System.out.println("distancia"+ distancia);
	
		
		
	}

}
