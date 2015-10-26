package br.edu.ifba.bsi.embarcados.javamonitor.alerta;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Audio {
	
	private File audio;
	
	private Player player;
	
	
	public Audio(File audio){
		this.audio = audio;
	}
	
	
	public void play(){
		
		try {
			FileInputStream fis = new FileInputStream(audio);
			BufferedInputStream  bis = new BufferedInputStream( fis);
			this.player = new Player(bis);
			System.out.println("Tocando ");
			this.player.play();
			System.out.println("Terminando");
			
			
			
		} catch (Exception e) {
			System.out.println("problema ao tocar " + audio);
			e.printStackTrace();
		}
		
	}

}