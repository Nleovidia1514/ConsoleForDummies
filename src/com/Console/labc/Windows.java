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
	
	public String cd(String camino,File path,String u) {
		try {
			if(u.equals(" ..")){
				camino=path.getParent();					}
			else if(u.equals(" .")) {
				camino=camino;
			}
			else {
				camino=moveDir(camino,u);
			}
		}catch(Exception e) {
			System.out.println("Directory doesn't exist");
		}
		return camino;
	}
	
	public void completo() throws IOException {
		Scanner sn;
		InputStream in;
		AudioStream audio;
		File hello;
		sn = new Scanner(System.in);
		in = new FileInputStream("sounds\\windows.wav");
		audio = new AudioStream(in);
        hello = new File("");
		AudioPlayer.player.start(audio);
		camino=hello.getAbsolutePath();
		while(keepRunning) {
			File path;
			path = new File(camino);
			System.out.print("\n"+path+'>');
			command = sn.next();
			
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
				copy(sn.next(), camino,sn.nextLine());
			}
			
			else if (command.equalsIgnoreCase("help")) {
				Scanner help;
				help = new Scanner(new File("WindowsHelp.txt"));
				while(help.hasNextLine()) {
					System.out.println(help.nextLine());
				}
			}
			
			else if (command.equalsIgnoreCase("exit")) {
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
		
			}
		}
	}
	
	

}
