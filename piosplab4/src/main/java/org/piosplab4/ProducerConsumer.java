package org.piosplab4;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumer {
	private static BlockingQueue<Person> queuelistperson = new LinkedBlockingQueue<Person>();

	public synchronized BlockingQueue<Person> produce() throws InterruptedException {
		Person ab = new Person();
		List<Person> listperson = ab.readfromfile();
		System.out.println("Before producing" + queuelistperson);
		for (int i = 0; i < listperson.size(); i++) {
			queuelistperson.put(listperson.get(i));
			System.out.println("Person " + listperson.get(i) + " has been added to the queue");
		}
		System.out.println("After producing" + queuelistperson);
		System.out.println("DEAD1");
		return queuelistperson;
	}

	public synchronized void consume() throws InterruptedException {
		Person a = new Person();
		Person b = new Person();
		System.out.println("Before consuming " + queuelistperson);
		for (int j = 0; j < queuelistperson.size(); j++) {
			b = queuelistperson.take();
			System.out.println("Person " + b + " has been consumed from the queue");
			a.writetofile(b);
			j--;
		}
		System.out.println("After consuming" + queuelistperson);
		System.out.println("DEAD2");
	}

	/*
	 * public static void main(String[] args) throws ExecutionException,
	 * InterruptedException {
	 * 
	 * ProducerConsumer pc = new ProducerConsumer(); Thread t1 = new Thread(new
	 * Runnable() {
	 * 
	 * @Override public void run() { try { pc.produce(); } catch
	 * (InterruptedException e) { System.out.println("Error in Thread 1");
	 * e.printStackTrace(); } } }); Thread t2 = new Thread(new Runnable() {
	 * 
	 * @Override public void run() { try { pc.consume(); } catch
	 * (InterruptedException e) { System.out.println("Error in Thread 2");
	 * e.printStackTrace(); } } }); t1.start(); t2.start(); t1.join(); t2.join();
	 * 
	 * System.out.println("Threads finished "); }
	 */
}
