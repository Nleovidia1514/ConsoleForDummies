package com.Console.labc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Unix extends Functionalities{
	String u="";
	static File start = new File("");
	private static String camino = start.getAbsolutePath();
	private static  String command="";
	
	public void unixConsole() throws IOException {
		boolean keepRunning=true;
		Windows win = new Windows();
		while(keepRunning) {
			u="";
			for(int i=0;i<camino.length();i++) {
				char b[];
				b = new char[camino.length()];
				if(camino.charAt(i)=='\\') {
					b[i]='/';
				}
				else {
					b[i]=camino.charAt(i);
				}
				
				u=u+b[i];
			}
			File path = new File(camino);
			u=u.toUpperCase().replaceAll("C:/users".toUpperCase(), "~");
			System.out.print("\n"+u+" $");
			command=sn.next();
			if (command.equalsIgnoreCase("ls")) {
				showDir(path);
		    }
			
			else if (command.equalsIgnoreCase("cd")) {
				camino=win.cd(camino, path,sn.nextLine());
			}
			
			else if(command.equalsIgnoreCase("echo")) {
				echoPrint(sn.nextLine(),camino);	
			}
			else if (command.equalsIgnoreCase("cp")) {
				copy(sn.nextLine(),camino);
			}
			else if (command.equalsIgnoreCase("rm")){
				delete(camino,sn.nextLine());
			}
			else if (command.equalsIgnoreCase("mv")){
				move(sn.next(),camino,sn.next());
			}
			else if (command.equalsIgnoreCase("mkdir")){
				mkdir(camino,sn.nextLine());
			}
			else if(command.equalsIgnoreCase("pwd")) {
				System.out.println(camino);
			}
			
			else if(command.equalsIgnoreCase("rmdir")) {
				rmdir(sn.nextLine(),camino);
			}
			
			else if(command.equalsIgnoreCase("Date")) {
				System.out.println("The current date is:   "+sdf.format(System.currentTimeMillis()));
			}
			
			else if(command.equalsIgnoreCase("q")) {
				keepRunning=exit();
			}
			else if (command.equalsIgnoreCase("exit")) {
				Main perro= new Main();
				perro.main(null);
			}
			
			else if(command.equalsIgnoreCase("zelda")) {
				InputStream in2;
				AudioStream audio2;
				in2 = new FileInputStream("sounds/hey.wav");
				audio2 = new AudioStream(in2);
				AudioPlayer.player.start(audio2);
			}
			
			else if(command.equalsIgnoreCase("help")) {
				Scanner help = new Scanner(new File("UnixHelp.txt"));
				while(help.hasNextLine()) {
					System.out.println(help.nextLine());
				}
			}
			else {
				System.out.println("'"+command+"' No se reconoce como comando interno o externo");
				String o = sn.nextLine();
			}
		}
		
	}

}
