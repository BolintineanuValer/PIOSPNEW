package org.piosplab5_6_7;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class Channel implements Runnable {
	private DatagramSocket socket = null;
	private boolean running;
	private boolean firstrun;
	private String name;

	public Channel() {

	}

	public Channel(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public DatagramSocket getSocket() {
		return this.socket;
	}

	public void bind(int port) throws SocketException {
		socket = new DatagramSocket(port);
	}

	public void start() {
		Thread thread = new Thread(this);
		thread.start();
	}

	public void stop() {
		running = false;
		socket.close();
	}

	@Override
	public void run() {
		byte[] buffer = new byte[1024];
		DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

		running = true;
		firstrun = true;
		while (running) {
			try {
				socket.receive(packet);

				String msg = new String(buffer, 0, packet.getLength());
				if(msg.substring(msg.length()-4,msg.length()).equals("!bye")) {
					System.out.println("Connection closed --- !bye");
					firstrun=false;
					socket.close();
					break;
				}
				if(msg.substring(msg.length()-7,msg.length()).equals("!byebye")) {
					System.out.println("Connection closed --- !byebye");
					firstrun=false;
					socket.close();
					break;
				}
				
				if (firstrun == true) {
					if(msg.substring(msg.length()-4,msg.length()).equals("!ack")) {
						System.out.println(msg);
						firstrun = false;
					}
					else {
						System.out.println("Connection closed --- no !ack");
						socket.close();
						break;
					}
				}
				else {
					System.out.println(msg);
				}
			} catch (IOException e) {
				break;
			}
		}

	}

	public void sendTo(InetSocketAddress address, String msg) throws IOException {
		byte[] buffer = msg.getBytes();

		DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
		packet.setSocketAddress(address);

		socket.send(packet);
	}
}
