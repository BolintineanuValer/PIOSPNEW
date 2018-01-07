package org.piosplab5_6_7;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Chat {

	public static void main(String[] args) throws IOException {

		Scanner scanner = new Scanner(System.in);
		List<String> names = new ArrayList<>();
		List<Integer> sourcePorts = new ArrayList<>();
		List<Integer> destinationPorts = new ArrayList<>();
		List<String> destinationIPs = new ArrayList<>();
		List<Channel> channelslist = new ArrayList<>();
		int msgnr=0;

		System.out.print("Name: ");
		String name = scanner.nextLine();
		names.add(name);

		/*
		 * System.out.print("Source Port : "); int sourcePort =
		 * Integer.parseInt(scanner.nextLine()); sourcePorts.add(sourcePort);
		 */
		sourcePorts.add(100);

		/*
		 * System.out.print("Destination IP : "); String destinationIP =
		 * scanner.nextLine(); is //192.168.0.31<-destinationIP
		 * destinationIPs.add(destinationIP);
		 */
		destinationIPs.add("192.168.0.31");

		/*
		 * System.out.print("Destination Port : "); int destinationPort =
		 * Integer.parseInt(scanner.nextLine()); destinationPorts.add(destinationPort);
		 */
		destinationPorts.add(100);

		Channel channel = new Channel();
		/// channel.bind(sourcePort);
		/// channel.start();*/ // Start Receive

		/// System.out.println("Started.");

		InetSocketAddress address = new InetSocketAddress(/* destinationIP */"192.168.0.31", /* destinationPort */1);

		String actualmessage;

		while (true) {
			String msg = scanner.nextLine();
			msgnr++;

			if (msg.length() > 7) {

				for (int i = 0; i < names.size(); i++) {
					if (names.get(i).equals(msg.substring(7, msg.length()))) {
						System.out.println("In chat with " + msg.substring(7, msg.length()));

						for (int j = 0; j < channelslist.size(); j++) {
							if (msg.substring(7, msg.length()).equals(channelslist.get(j).getName())) {
								System.out.println(channelslist.get(j).getName() + "<- Channel close socket");
								// channelslist.get(j).sendTo(address, sendexisting);
								channelslist.get(j).getSocket().close();
							}
						}

						// name = msg;

						System.out.print("Source Port : ");
						int sourcePort = sourcePorts.get(i);
						System.out.println(sourcePort + "<- sourcePort");

						/*
						 * System.out.print("Destination IP : "); destinationIP = destinationIPs.get(i);
						 */

						System.out.print("Destination Port : ");
						int destinationPort = destinationPorts.get(i);
						System.out.println(destinationPort + "<- destinationPort");

						channel = new Channel(msg.substring(7, msg.length()));
						channel.bind(sourcePort);
						channel.start(); // Start Receive

						System.out.println("Started.");

						address = new InetSocketAddress(/* destinationIP */"192.168.0.31", destinationPort);
						
						msgnr=1;

					}
				}

				if ("!hello".equals(msg.substring(0, 6))) {
					if (!names.contains(msg.substring(7, msg.length()))) {
						/*
						 * System.out.print("Name : "); String name1 = scanner.nextLine();
						 * names.add(name1);
						 */

						String name1 = msg.substring(7, msg.length());
						names.add(name1);

						System.out.print("Source Port : ");
						int sourcePort1 = Integer.parseInt(scanner.nextLine());
						sourcePorts.add(sourcePort1);

						/*
						 * System.out.print("Destination IP : "); String destinationIP1 =
						 * scanner.nextLine(); is //192.168.0.31<-destinationIP1
						 * destinationIPs.add(destinationIP1);
						 */

						System.out.print("Destination Port : ");
						int destinationPort1 = Integer.parseInt(scanner.nextLine());
						destinationPorts.add(destinationPort1);

						channel = new Channel(name1);
						channelslist.add(channel);
						channel.bind(sourcePort1);
						channel.start(); // Start Receive

						System.out.println("Started.");

						address = new InetSocketAddress(/* destinationIP1 */"192.168.0.31", destinationPort1);
						
						msgnr=1;
					}
				}
				//System.out.println(names);
			}
			System.out.println("Chat: "+names);
			actualmessage = msg;

			msg = name + " >> " + msg;

			if (actualmessage.length() > 7) {
				if (!"!hello".equals(actualmessage.substring(0, 6))) {
					channel.sendTo(address, msg);
					System.out.println(msg);
				}
			} else {
				if(!actualmessage.equals("!byebye")) {
				channel.sendTo(address, msg);
				System.out.println(msg);
				}
			}

			if (actualmessage.equals("!bye")) {
				System.out.println("Connection closed --- !bye");
				channel.sendTo(address, msg);
				channel.getSocket().close();
			}
			
			if (actualmessage.equals("!byebye")) {
				System.out.println("Connection closed --- !byebye");
				channel.sendTo(address, msg);
				break;
			}
			
			if(!actualmessage.equals("!ack") && msgnr==2) {
				System.out.println("Connection closed --- no !ack");
				channel.sendTo(address, msg);
				channel.getSocket().close();
				
			}
		}

		scanner.close();
		channel.stop();

		System.out.println("Closed.");
	}

}
