package dev.anurag.javahandbook.io.streams;

public class ConfigsDemo {
	
	public static void main(String [] args){
		System.out.println(Configs.getConfig("org.java.app.db.username"));
	}
}
