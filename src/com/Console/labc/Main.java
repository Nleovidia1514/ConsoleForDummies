package com.Console.labc;

import java.io.*;
import java.util.Scanner;
import java.util.stream.Stream;


public class Main {
	
	static Functionalities fun = new Functionalities();
	static String camino ="C:/Users/User/Mis documentos/JAVA/test";
	Object p[];
	static Object[] poth = new Object[20];
	private static String command="";
	static boolean keepRunning=true;
	
	public static void main(String[] args) throws IOException{
		Scanner sn = new Scanner(System.in);
		File hello = new File("");
		camino=hello.getAbsolutePath();
		while(keepRunning) {
			System.out.print(camino+'>');
			File path = new File(camino);
		
			command = sn.next();
			if(command.equalsIgnoreCase("echo")) {
				fun.echoPrint(sn.nextLine(),camino);
				System.out.println("");
				
			}
			
			if(command.equalsIgnoreCase("cd")) {
			    String u=sn.nextLine();
				try {
					if(u.equals(" ..")){
						camino=path.getParent();					}
					else {
						camino=fun.moveDir(camino,u);
					}
				}catch(Exception e) {
					System.out.println("Directory doesn't exist");
				}
			
			}
			
			if(command.equalsIgnoreCase("mkdir")) {
				camino=fun.mkdir(camino,sn.nextLine());	
			}
			
			if(command.equalsIgnoreCase("dir")) {
				fun.showDir(path);
				
			}
			
			if(command.equalsIgnoreCase("del")) {
				fun.delete(camino, sn.nextLine());
			}
			
			if(command.equalsIgnoreCase("move")) {
				fun.move(sn.next(), camino, sn.next());
			}
			
			
			if(command.equalsIgnoreCase("copy")) {
				fun.copy(sn.next(), camino, sn.next());
			}
			
			if (command.equalsIgnoreCase("help")) {
				Reader read = new FileReader("C:/Users/USer/Mis documentos/Java/Poo/Console/help.txt");
				System.out.println(read);
				}
			
			
			if (command.equalsIgnoreCase("exit")) {
				keepRunning=false;
			}
			
			if (command.equalsIgnoreCase("Date")) {
				System.out.println("The current date is:   "+fun.sdf.format(System.currentTimeMillis()));
			}
			
			if(command.equalsIgnoreCase("UNIX")) {
				Unix unix = new Unix();
				unix.unixConsole(path, camino);
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
	
}
		
		
