package com.Console.labc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Windows extends Functionalities {
	private static String camino;
	private static  String command="";
	private static boolean keepRunning=true;
	private Scanner sn;
	private Scanner sn1;
	private InputStream in;
	private AudioStream audio;
	private File hello;
	private String ask;
	
	public String cd(String camino,File path,String u) {
		Scanner sn1 = new Scanner(u);
		if(sn1.hasNext()) {
			try {
				if(u.trim().equals("..")){
					camino=path.getParent();					}
				else if(u.trim().equals(".")) {
					camino=camino;
				}
				else if(u.trim().startsWith("c:\\") || u.trim().startsWith("C:\\")) {
					camino=u.trim();
				}
				else {
					camino=moveDir(camino,u);
				}
			}catch(Exception e) {
				System.out.println("Directory doesn't exist");
			}
		}
		else {
			System.out.println(path.getAbsolutePath());
		}
		return camino;
	}
	
	public void completo() throws IOException {
		
		sn = new Scanner(System.in);
		in = new FileInputStream("sounds\\windows.wav");
		audio = new AudioStream(in);
        hello = new File("");
		AudioPlayer.player.start(audio);
		camino=hello.getAbsolutePath();
		while(keepRunning) {
			File path;
			path = new File(camino);
			System.out.print("\n"+path.toString().toUpperCase()+'>');
			command=sn.next();
			if(command.equalsIgnoreCase("echo")) {
				echoPrint(sn.nextLine(),camino);
			}
			
			else if(command.equalsIgnoreCase("cd")) {
			    camino=cd(camino, path,sn.nextLine());
			}
			
			else if(command.equalsIgnoreCase("mkdir")) {
				mkdir(camino,sn.nextLine());	
			}
			
			else if(command.equalsIgnoreCase("dir")) {
				showDir(path);
				
			}
			
			else if(command.equalsIgnoreCase("del")) {
				delete(camino, sn.nextLine());
			}
			
			else if(command.equalsIgnoreCase("move")) {
				move(sn.next(), camino, sn.nextLine());
			}
			
			
			else if(command.equalsIgnoreCase("copy")) {
				copy(sn.nextLine(), camino);
			}
			
			else if (command.equalsIgnoreCase("help")) {
				Scanner help;
				help = new Scanner(new File("WindowsHelp.txt"));
				while(help.hasNextLine()) {
					System.out.println(help.nextLine());
				}
			}
			
			else if (command.equalsIgnoreCase("exit")) {
				Main perro= new Main();
				perro.main(null);
			}
			else if(command.equalsIgnoreCase("q")) {
				keepRunning=exit();
			}
			else if (command.equalsIgnoreCase("Date")) {
				System.out.println("The current date is:   "+sdf.format(System.currentTimeMillis()));
			}
			
			else if(command.equalsIgnoreCase("zelda")) {
				audio.close();
				InputStream in2;
				AudioStream audio2;
				in2 = new FileInputStream("sounds/hey.wav");
				audio2 = new AudioStream(in2);
				AudioPlayer.player.start(audio2);
			}
			
			else if(command.equalsIgnoreCase("rmdir")) {
				rmdir(sn.nextLine(),camino);
			}
			
			else {
				System.out.println("'"+command+"' No se reconoce como comando interno o externo");
				String o=sn.nextLine();
			}
		}
	}
	
	

}
