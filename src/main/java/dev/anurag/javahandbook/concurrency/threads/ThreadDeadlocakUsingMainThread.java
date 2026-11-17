package dev.anurag.javahandbook.concurrency.threads;

public class ThreadDeadlocakUsingMainThread {

	public static void main(String[] args) {
		System.out.println("Going into the DEADLOCK...3..2..1");
		try {
			Thread.currentThread().join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
