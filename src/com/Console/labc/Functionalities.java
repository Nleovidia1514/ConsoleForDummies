package com.Console.labc;

import java.io.*;


public class Functionalities {
	char chars[];
	String[] paths;
	String[] path = new String[30];
	
	public String moveDir(int o,String d,String a) {
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
		path[o]=d;
		if(idk.isDirectory()) {
			return d;
		}
		else {
			System.out.println("Directory doesn't exist");
			return c;
		}
	
	}
	
	public String moveDr(String d,String a,int o) {
		if(o==0) {
			d="C:/Users/User/Mis documentos/JAVA/test";
		}
		else {
			d=path[o];
		}
		return d;
	}
	
	public void showDir() {
		
	}
	
	public void echoTxt(String a,String h,int i,String c) throws IOException {
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
			
			
		
	
	public void echoPrint(String a,String h) {
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
	
	public void copy() {
		
	}
	
	public void delete() {
		
	}
	
	public void move() {
		
	}
	
	public String mkdir(String h,String a,int o) {
		path[o]=h;
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
	
	public void rmvdir() {
		
	}
}
