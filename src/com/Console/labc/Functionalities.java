package com.Console.labc;

import java.io.*;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Scanner;


public class Functionalities {
	private char chars[];
	private String[] paths;
	private String[] path = new String[30];
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
	private Scanner sn = new Scanner(System.in);
	
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
	
	protected String moveDir(File a) {
		return a.getParent();
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
				System.out.format("%1$-25s %2$-10s %3$-5s %4$-10s\n",sdf.format(files.lastModified()),"<DIR>",files.length(),files.getName());
			}
			else {
				numberFiles+=1;
				System.out.format("%1$-25s %2$-10s %3$-5s %4$-10s\n",sdf.format(files.lastModified()),"<FILE>",files.length(),files.getName());
			}
			
			freeSpace-=files.length();
			TotalSpace+=files.length();
		}
		System.out.format("%1$-25s %2$-10s\n",numberFiles+" FILES",TotalSpace+" bytes");
		System.out.format("%1$-25s %2$-10s\n",numberDir+" DIRS",freeSpace+" bytes libres");
	}

	protected void echoTxt(String a,String h,int i,String c) throws IOException {
		char[] b = new char[a.length()];
		h=h+'/';	
		for(int z=i+2;z<a.length();z++) {
			b[z]=a.charAt(z);
			h=h+b[z];
		}
		File perro = new File(h);
		if(!perro.exists()) {
			OutputStream out = new FileOutputStream(perro);
			out.write(c.getBytes());
			out.close();
		}
		else{
			System.out.println("File already exists");
		}
	}
			
	protected void echoPrint(String a,String h) {
		char[] b = new char[a.length()];
		String c="";
		for (int i=0;i<a.length();i++) {
			try{
				b[i]=a.charAt(i+1);
				if(b[i]=='>') {
					echoTxt(a,h,i,c);
					break;
				}
				c=c+b[i];
			}catch(Exception e) {
				break;
			}
		}
		System.out.println(c);
	}
	
	protected void move(String a,String d,String k) {
		char[] b = new char[a.length()];
		char[] v = new char[k.length()];
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
	    if(c.renameTo(new File(k))) {
	    	c.delete();
	    }
	    else if(new File(k).exists()){
	    	System.out.println("File already exists in the destination folder");
	    	
	    }
	    else{
	    	System.out.println("The system couldn't find the specified file or route");
	    }
	}
	
	protected void delete(String d,String a) {
		char[] b = new char[a.length()];
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
		}
		else {
			if(c.isDirectory()) {
				System.out.println("¿Are you sure? Y/N");
				String p=sn.next();
				if(p.equalsIgnoreCase("y")) {
					File[] deletion = c.listFiles();
					for(File files : deletion) {
						files.delete();
					}
				c.delete();	
				}
				else if(p.equalsIgnoreCase("n")) {
				}
			}
			else {
				System.out.println("No se pudo encontrar  "+d);
			}
		}
	}
	
	protected void move() {
		
	}
	
	protected String mkdir(String h,String a) {
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
		return h;
	}
	
	protected void rmvdir() {
		
	}
}
