package FirstWeek;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainBase {
	public static void main(String[] args) throws ClassNotFoundException, IOException{
	/*	Scanner sc = new Scanner(System.in);
		String l=sc.next();
		String p=sc.next();
		sc.close();
		*/
		Base b = new Base();
		//b.auth(l,p);
		/*
		b.userToFile("D:"+File.separator+"work"+File.separator+"Cources"
		+File.separator+"homerwork_01"+File.separator+"User.txt");
		*/
		/*
		b.userFromFile("D:"+File.separator+"work"+File.separator+"Cources"
		+File.separator+"homerwork_01"+File.separator+"User.txt");
		*/
		/*
		b.usersSerializeToFile("D:"+File.separator+"work"+File.separator+"Cources"
		+File.separator+"homerwork_01"+File.separator+"UserFileSerialize.txt");
		*/
		b.usersDeSerializeFromFileArray("D:"+File.separator+"work"+File.separator+"Cources"
		+File.separator+"homerwork_01"+File.separator+"UserFileSerialize.txt");
		
	}

	
	

}
