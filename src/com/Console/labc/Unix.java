package com.Console.labc;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Unix extends Functionalities{
	
	public void unixConsole(File a,String camino) throws IOException {
		boolean keepRunning=true;
		Windows win = new Windows();
		while(keepRunning) {
			System.out.print(camino+'>');
			File path = new File(camino);
			String command=sn.next();
			if (command.equalsIgnoreCase("ls")) {
				showDir(a);
		}
			
			else if (command.equalsIgnoreCase("cd")) {
				camino=win.cd(camino, path,sn.nextLine());
			}
			
			else if(command.equalsIgnoreCase("echo")) {
				echoPrint(sn.nextLine(),camino);	
			}
			else if (command.equalsIgnoreCase("cp")) {
				copy(sn.next(),camino,sn.next());
			}
			else if (command.equalsIgnoreCase("rm")){
				delete(camino,sn.nextLine());
			}
			else if (command.equalsIgnoreCase("mv")){
				move(sn.next(),camino,sn.next());
			}
			else if (command.equalsIgnoreCase("mkdir")){
				camino=mkdir(camino,sn.nextLine());
			}
			else if(command.equalsIgnoreCase("pwd")) {
				System.out.println(camino);
			}
			else if(command.equalsIgnoreCase("Date")) {
				System.out.println("The current date is:   "+sdf.format(System.currentTimeMillis()));
			}
			else if(command.equalsIgnoreCase("Windows")) {
				Main main = new Main();
				main.main(null);
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
