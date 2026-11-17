package dev.anurag.javahandbook.concurrency.coordination;

import java.util.ArrayList;

public class SleepWaitNotifyThreadDemo {

	public static void main(String[] args) {
		ArrayList name = new ArrayList();
		Thread th1 = new Thread(new SleepWaitNotifyThread(name));
		th1.start();
	}

}
