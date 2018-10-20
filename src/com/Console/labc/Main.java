package com.Console.labc;

import java.awt.Color;
import java.awt.Font;
import java.io.*;
import sun.audio.*;
import java.util.Scanner;
import java.util.stream.Stream;

import javax.sound.sampled.AudioInputStream;
import javax.swing.JFrame;
import javax.swing.JTextField;


public class Main {
	
	static Functionalities fun = new Functionalities();
	static String camino ="C:/Users/User/Mis documentos/JAVA/test";
	Object p[];
	static Object[] poth = new Object[20];
	private static String command="";
	static boolean keepRunning=true;
	
		
	public static void main(String[] args) throws IOException{
		Scanner sn = new Scanner(System.in);
		InputStream in = new FileInputStream("sounds/windows.wav");
		AudioStream audio = new AudioStream(in);
		AudioPlayer.player.start(audio);
		
        File hello = new File("");
		Windows win = new Windows();
		camino=hello.getAbsolutePath();
		while(keepRunning) {
			System.out.print("\n"+camino+'>');
			File path = new File(camino);
		
			command = sn.next();
			if(command.equalsIgnoreCase("echo")) {
				fun.echoPrint(sn.nextLine(),camino);
			}
			
			else if(command.equalsIgnoreCase("cd")) {
			    camino=win.cd(camino, path,sn.nextLine());
			}
			
			else if(command.equalsIgnoreCase("mkdir")) {
				camino=fun.mkdir(camino,sn.nextLine());	
			}
			
			else if(command.equalsIgnoreCase("dir")) {
				fun.showDir(path);
				
			}
			
			else if(command.equalsIgnoreCase("del")) {
				fun.delete(camino, sn.nextLine());
			}
			
			else if(command.equalsIgnoreCase("move")) {
				fun.move(sn.next(), camino, sn.next());
			}
			
			
			else if(command.equalsIgnoreCase("copy")) {
				fun.copy(sn.next(), camino, sn.next());
			}
			
			else if (command.equalsIgnoreCase("help")) {
				Scanner help = new Scanner(new File("WindowsHelp.txt"));
				while(help.hasNextLine()) {
					System.out.println(help.nextLine());
				}
			}
			
			else if (command.equalsIgnoreCase("exit")) {
				keepRunning=fun.exit();
			}
			
			else if (command.equalsIgnoreCase("Date")) {
				System.out.println("The current date is:   "+fun.sdf.format(System.currentTimeMillis()));
			}
			
			else if(command.equalsIgnoreCase("UNIX")) {
				Unix unix = new Unix();
				unix.unixConsole(path, camino);
			}
			
			else if(command.equalsIgnoreCase("zelda")) {
				audio.close();
				InputStream in2 = new FileInputStream("sounds/hey.wav");
				AudioStream audio2 = new AudioStream(in2);
				AudioPlayer.player.start(audio2);
			}
			
			else {
				System.out.println("'"+command+"' No se reconoce como comando interno o externo");
		
			}
		}
	}
		
}
		
	
				
			
			/*String content = "Perrosucio mamaguevo";
			OutputStream out = new FileOutputStream(path);
			out.write(content.getBytes());
			System.out.println(path.exists());
			out.close();
			out.
			BufferedReader read = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
			String firstline = read.readLine();
			System.out.println(firstline);*/
	

		
		
