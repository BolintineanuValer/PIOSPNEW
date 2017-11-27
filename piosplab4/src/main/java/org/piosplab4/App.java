package org.piosplab4;

public class App {
	public static void main(String[] args) throws InterruptedException {
		ProducerConsumer pc = new ProducerConsumer();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					pc.produce();
				} catch (InterruptedException e) {
					System.out.println("Error in Thread 1");
					e.printStackTrace();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					pc.consume();
				} catch (InterruptedException e) {
					System.out.println("Error in Thread 2");
					e.printStackTrace();
				}
			}
		});
		t1.start();
		t1.join();
		t2.start();
		t2.join();

		
		System.out.println("Threads finished ");
	}
}
