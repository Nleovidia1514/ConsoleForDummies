package com.Console.labc;

import java.io.File;

public class Windows extends Functionalities {
	
	public String cd(String camino,File path,String u) {
		try {
			if(u.equals(" ..")){
				camino=path.getParent();					}
			else {
				camino=moveDir(camino,u);
			}
		}catch(Exception e) {
			System.out.println("Directory doesn't exist");
		}
		return camino;
	}

}
