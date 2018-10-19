package com.Console.labc;

import java.io.*;
import java.util.Scanner;


public class Main extends Functionalities{
	
	private static int i=0;
	static Functionalities fun = new Functionalities();
	static String camino ="C:/Users/User/Mis documentos/JAVA/test";
	Object p[];
	static Object[] poth = new Object[20];
	private static String command="";
	static boolean keepRunning=true;
	
	public static void main(String[] args){
		Scanner sn = new Scanner(System.in);
		System.out.print(camino+'>');
		while(keepRunning) {
			
			File path = new File(camino);
			command = sn.next();
			
			if(command.equals("echo")) {
				fun.echoPrint(sn.nextLine(),camino);
				System.out.println("");
				System.out.print(camino+'>');
			}
			
			if(command.equals("cd")) {
			    String u=sn.nextLine();
				try {
					if(u.equals(" ...")){
						i--;
						camino=fun.moveDr(camino, u, i);
					}
					else {
						i++;
						camino=fun.moveDir(i,camino,u);
					}
				}catch(Exception e) {
					System.out.println("Directory doesn't exist");
					i++;
				}
				System.out.print(camino+'>');
			}
			
			if(command.equals("mkdir")) {
				camino=fun.mkdir(camino,sn.nextLine(),i);
				i++;
				System.out.print(camino+'>');
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
}		
		
