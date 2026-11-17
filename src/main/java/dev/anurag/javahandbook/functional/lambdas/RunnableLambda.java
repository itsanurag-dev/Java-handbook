package dev.anurag.javahandbook.functional.lambdas;

public class RunnableLambda {
	public static void main(String[] args) {
		Runnable r = () -> {
			try {
				Thread.sleep(1000);
				System.out.println("Awaking from sleep of 1000 ms");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		};
		new Thread(r).start();
	}
}
