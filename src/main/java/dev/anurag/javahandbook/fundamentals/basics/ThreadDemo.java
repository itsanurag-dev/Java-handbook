package dev.anurag.javahandbook.fundamentals.basics;

public class ThreadDemo extends Thread{
	
	@Override
	public void run() {		
		System.out.println("Thread process from ThreadDeom'");
		super.run();
	}

}
