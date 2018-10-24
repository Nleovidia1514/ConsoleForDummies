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
	static Windows win = new Windows();
	static Unix unix = new Unix();
	static Scanner sn = new Scanner(System.in);
	static boolean keepRunning=true;
	static int opc;
	String opc1;
	
	public static void main(String[] args) throws IOException{
		System.out.print("1.Windows\n2.Unix\n");
		while(keepRunning) {
			opc=sn.nextInt();
			switch(opc) {
			case 1:
				win.completo();
				break;
			case 2:
				unix.unixConsole();
				break;
			default:
				System.out.println("Pick a valid option");
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
	

		
		
