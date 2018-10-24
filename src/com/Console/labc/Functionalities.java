package com.Console.labc;

import java.awt.Color;
import java.awt.Font;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTextField;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;;



public class Functionalities {
	protected SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
	protected Scanner sn = new Scanner(System.in);
	
	protected String moveDir(String d,String a) {
		char[] b = new char[a.length()];
		String c=d;	
		for (int i=0;i<a.length();i++) {
			if(i==0) {
				d=d+'/';
			}
			else {
				b[i]=a.charAt(i);
				d=d+b[i];
			}
		}
		File idk = new File(d);
		if(idk.isDirectory()) {
			return idk.getAbsolutePath();
		}
		else {
			System.out.println("Directory doesn't exist");
			return c;
		}
	
	}
	
	protected void showDir(File a) throws IOException {
		File[] content = a.listFiles();
		int numberDir=0;
		int numberFiles=0;
		long freeSpace=a.getUsableSpace();
		long TotalSpace=0;
	
		for(File files : content ) {
			if(files.isDirectory()) {
				numberDir+=1;
				System.out.format("%1$-25s %2$-10s %3$-10s %4$-10s\n",sdf.format(files.lastModified()),"<DIR>",files.length(),files.getName());
			}
			else {
				numberFiles+=1;
				System.out.format("%1$-25s %2$-10s %3$-10s %4$-10s\n",sdf.format(files.lastModified()),"<FILE>",files.length(),files.getName());
			}
			
			freeSpace-=files.length();
			TotalSpace+=files.length();
		}
		System.out.format("%1$-25s %2$-10s\n",numberFiles+" FILES",TotalSpace+" bytes");
		System.out.format("%1$-25s %2$-10s\n",numberDir+" DIRS",freeSpace+" bytes libres");
	}

	protected void echoTxt(String a,String h) throws IOException {
		char[] b = new char[a.length()]; String[] split;
		split = a.split(">");
		a=split[1];
		if(h.equalsIgnoreCase("C:\\Windows")) {
			System.out.println("Access denied");
		}
		else {
			h=h+'/';	
			for(int i=0;i<a.length();i++) {
				b[i]=a.charAt(i);
				h=h+b[i];
			}
			File perro = new File(h);
			if(!perro.exists()) {
				OutputStream out = new FileOutputStream(perro);
				out.write(split[0].getBytes());
				out.close();
			}
			else{
				System.out.println("File already exists");
			}
		}
		
	}
			
	protected void echoPrint(String a,String h) {
		char[] b = new char[a.length()];
		String c="";
		if(a.contains(">") && a.endsWith(".txt")) {
			try {
				echoTxt(a,h);
			} catch (IOException e) {}
		}
		else {
			for (int i=0;i<a.length();i++) {
				try{
					b[i]=a.charAt(i+1);
					c=c+b[i];
				}catch(Exception e) {
					break;
				}
			}
			System.out.println(c);
		}	
	}
	
	protected void move(String a,String d,String k) {
		
		String o = "";
		if(d.equalsIgnoreCase("C:\\Windows")) {
			System.out.println("Access denied");
		}
		else {
			if(k.charAt(1)=='C') {
				o=k.trim()+'/'+a;
			}
			else {
				char[] b = new char[k.length()];
				for (int i=0;i<k.length();i++) {
					if(i==0) {
						o=d+'/';
					}
					else {
						b[i]=k.charAt(i);
						o=o+b[i];
					}
				}
			}
			char[] b = new char[a.length()];
			for (int i=0;i<a.length();i++) {
				if(i==0) {
					b[i]=a.charAt(i);
					d=d+'/'+b[i];
				}
				else {
					b[i]=a.charAt(i);
					d=d+b[i];
				}
			}
		
			File c = new File(d);
			File g = new File(o+"\\"+a);
			System.out.println(g);
			if(g.exists()){
		    	System.out.println("File already exists in the destination folder");	
		    }
			else if(c.renameTo(g)) {
		    	if(c.delete()) {}
		    	System.out.format("%1$-20s\n","Se han movido 1 archivo(s)");
		    }
		    else{
		    	System.out.println("The system couldn't find the specified file or route");
		    }
		}
	}
		
	
	protected void delete(String d,String a) {
		char[] b = new char[a.length()];
		if(d.equalsIgnoreCase("C:\\Windows")) {
			System.out.println("Access denied");
		}
		else {
			for (int i=0;i<a.length();i++) {
				if(i==0) {
					d=d+'/';
				}
				else {
					b[i]=a.charAt(i);
					d=d+b[i];
				}
			}
			File c = new File(d);
			if(c.delete()) {
				System.out.format("%1$-20s\n","Se han eliminado 1 archivo(s)");
			}
			else {
				if(c.isDirectory()) {
					System.out.println(c.getName()+" is not empty");
				}
				else {
					System.out.println("No se pudo encontrar  "+d+"\n");
				}
			}
		}
	}
		
	
	protected void copy(String a,String d,String k) throws IOException {
		char[] b;char[] v;
		String j=d;
		File destination;
	    b = new char[a.length()];
		v = new char[k.length()];
		if (k.equalsIgnoreCase(" .")) {
			destination = new File(d+"\\"+a);
		}
		else {
			for (int z=0;z<k.length();z++) {
				if(z==0) {
					v[z]=k.charAt(z);
					j=j+'/';
				}
				else {
					v[z]=k.charAt(z);
					j=j+v[z];
				}
			}
			destination = new File(j+"\\"+a);
		}
		for (int i=0;i<a.length();i++) {
			if(i==0) {
				b[i]=a.charAt(i);
				d=d+'/'+b[i];
			}
			else {
				b[i]=a.charAt(i);
				d=d+b[i];
			}
		}
		
		File source = new File(d);
		if (!source.exists()) {
			System.out.println("Couldn't find the specified file	");
		}
		else if(source.toString().equalsIgnoreCase(destination.toString())) {
			System.out.println("Can't copy over itself");
		}
		else {
			Files.copy(source.toPath(),destination.toPath(),StandardCopyOption.REPLACE_EXISTING);
			System.out.format("%1$-20s\n","Se han copiado 1 archivo(s)");
		}
		
	}
	
	protected void mkdir(String h,String a) {
		for(int i=0;i<a.length();i++) {
			if(i==0) {
				h=h+'/';
			}
			else {
				h=h+a.charAt(i);
			}
		}
		File dir = new File(h);
		boolean exists = dir.mkdir();
		if (!exists) {
			System.out.println("Directory already exists");
		}
	}
	
	protected boolean exit() {
		InputStream in3;
		boolean keepRunning;
		try {
			in3 = new FileInputStream("sounds/are-you-sure-about-that.wav");
			AudioStream audio3 = new AudioStream(in3);
			AudioPlayer.player.start(audio3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Y/N");
		String exit = sn.next();
		if(exit.equalsIgnoreCase("Y")){
			JFrame f = new JFrame("Gracias por el 20");
			JTextField tf = new JTextField("Gracias por el 20 profesor");
			f.setSize(340, 300);
			tf.setBounds(0,0,300,300);
			tf.setBackground(Color.BLACK);
			tf.setForeground(Color.white);
			tf.setFont(new Font("perro loco",Font.ITALIC,24));
			f.add(tf);
			f.setVisible(true);
			f.setAlwaysOnTop(true);
			keepRunning=false;
			return keepRunning;
		}
		else {
			keepRunning=true;
			return keepRunning;
		}
	}
	
	protected void rmdir(String a,String d) {
		char[] b = new char[a.length()];
		if(d.equalsIgnoreCase("C:\\Windows")) {
			System.out.println("Access denied");
		}
		else {
			for (int i=0;i<a.length();i++) {
				if(i==0) {
					d=d+'/';
				}
				else {
					b[i]=a.charAt(i);
					d=d+b[i];
				}
			}
			File c = new File(d);
			if(!c.isDirectory()) {
				System.out.println(a+" is not a directory");
			}
			else {
				System.out.println("Are you sure? Y/N");
				InputStream in3;
				try {
					in3 = new FileInputStream("sounds/are-you-sure-about-that.wav");
					AudioStream audio3 = new AudioStream(in3);
					AudioPlayer.player.start(audio3);
				} catch (Exception e) {}
				String sure=sn.next();
				if(sure.equalsIgnoreCase("y")) {
					if(remove(c)) {
						System.out.println("Deleted: "+c.getName());
					}
					else {
						System.out.println(c.getName()+" could not be deleted");
					}
				}
			}
		}
	}
	
	private boolean remove(File files) {
		if(files.isDirectory()){
			File[] content = files.listFiles();
			for(File delete : content) {
				remove(delete);
				System.out.println("deleted: "+delete.getName());
			}
		}
		return files.delete();
	}
	
}	
