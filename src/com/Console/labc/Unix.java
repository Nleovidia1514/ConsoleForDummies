package com.Console.labc;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

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
			System.out.print("\n"+u+'>');
			File path = new File(camino);
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
				copy(sn.next(),camino,sn.nextLine());
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
			
			else if(command.equalsIgnoreCase("exit")) {
				exit();
				System.in.read();
				System.exit(1);
			}
			else if(command.equals("help")) {
				Scanner help = new Scanner(new File("UnixHelp.txt"));
				while(help.hasNextLine()) {
					System.out.println(help.nextLine());
				}
			}
			else {
				System.out.println("'"+command+"' No se reconoce como comando interno o externo");
			}
		}
		
	}

}
