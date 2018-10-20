package com.Console.labc;

import java.io.File;
import java.io.IOException;

public class Unix extends Functionalities{
	
	public void unixConsole(File a,String camino) throws IOException {
		boolean keepRunning=true;
		while(keepRunning) {
			System.out.print(camino+'>');
			File path = new File(camino);
			String command=sn.next();
			if (command.equalsIgnoreCase("ls")) {
				showDir(a);
		}
			
			if (command.equalsIgnoreCase("cd")) {
				String u=sn.nextLine();
				try {
					if(u.equals(" ..")){
						camino=path.getParent();					}
					else {
						camino=moveDir(camino,u);
					}
				}catch(Exception e) {
					System.out.println("Directory doesn't exist");
				}
			}
		}
		
	}

}
