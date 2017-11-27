package org.piosplab3;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BigDecimalsRepository {

	private List<BigDecimal> listofdecimals = new ArrayList<BigDecimal>();

	public BigDecimalsRepository() {
		this.listofdecimals = new ArrayList<BigDecimal>();
	}

	public boolean addbigdecimalnumber(BigDecimal bg) {
		return listofdecimals.add(bg);
	}

	public static int userchoice() {
		System.out.println("Input your choice: ");
		@SuppressWarnings("resource")
		Scanner scn = new Scanner(System.in);
		try {
			int opt = scn.nextInt();
			return opt;
		} catch (Exception ex) {
			throw new IllegalArgumentException("Not a choice");
		}
	}

	public static BigDecimal userinput() {
		System.out.println("Input your number: ");
		@SuppressWarnings("resource")
		Scanner scn = new Scanner(System.in);
		try {
			BigDecimal opt = scn.nextBigDecimal();
			return opt;
		} catch (Exception ex) {
			throw new IllegalArgumentException("Not a number");
		}
	}

	public BigDecimal sum(List<BigDecimal> listofdecimals) {
		return listofdecimals.stream().reduce(BigDecimal::add).get();
	}

	public BigDecimal avg(List<BigDecimal> listofdecimals) {
		return sum(listofdecimals).divide(new BigDecimal(listofdecimals.size()), 2, RoundingMode.HALF_UP);
	}

	public List<BigDecimal> top10percentbiggestnr(List<BigDecimal> listofdecimals) {
		return listofdecimals.stream().sorted(Comparator.reverseOrder()).limit(Math.round(0.1 * listofdecimals.size()))
				.collect(Collectors.toList());
		// .forEach(System.out::println);
	}

	public void serialize(List<BigDecimal> listofdecimals) throws FileNotFoundException, IOException {
		File storageFile = new File("C:\\Users\\altex\\\\Desktop\\maven-samples-master\\piosplab3\\ceva.txt");
		try {
			storageFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(storageFile))) {
			out.writeLong(listofdecimals.size());
			listofdecimals.stream().forEach(value -> {
				try {
					out.writeUnshared(value);
					out.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		}
	}

	public void serializelambdasum(List<BigDecimal> listofdecimals) throws FileNotFoundException, IOException {
		File storageFile = new File("C:\\Users\\altex\\\\Desktop\\maven-samples-master\\piosplab3\\ceva.txt");
		try {
			storageFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try (ObjectOutput oo = new ObjectOutputStream(new FileOutputStream(storageFile))) {
			Runnable r = (Runnable & Serializable) () -> listofdecimals.stream().reduce(BigDecimal::add).get();
			oo.writeObject(r);
		}
	}

	public void serializelambdatop10percentbiggestnr(List<BigDecimal> listofdecimals)
			throws FileNotFoundException, IOException {
		File storageFile = new File("C:\\Users\\altex\\\\Desktop\\maven-samples-master\\piosplab3\\ceva.txt");
		try {
			storageFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try (ObjectOutput oo = new ObjectOutputStream(new FileOutputStream(storageFile))) {
			Runnable r = (Runnable & Serializable) () -> listofdecimals.stream().sorted(Comparator.reverseOrder())
					.limit(Math.round(0.1 * listofdecimals.size())).collect(Collectors.toList());
			oo.writeObject(r);
		}
	}

	public void serializelambdaavg(List<BigDecimal> listofdecimals) throws FileNotFoundException, IOException {
		File storageFile = new File("C:\\Users\\altex\\\\Desktop\\maven-samples-master\\piosplab3\\ceva.txt");
		try {
			storageFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try (ObjectOutput oo = new ObjectOutputStream(new FileOutputStream(storageFile))) {
			Runnable r = (Runnable & Serializable) () -> listofdecimals.stream().reduce(BigDecimal::add).get()
					.divide(new BigDecimal(listofdecimals.size()), 2, RoundingMode.HALF_UP);
			oo.writeObject(r);
		}
	}

	public void deserializelambdas() throws FileNotFoundException, IOException, ClassNotFoundException {
		File storageFile = new File("C:\\Users\\altex\\\\Desktop\\maven-samples-master\\piosplab3\\ceva.txt");
		try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(storageFile)))) {
			// BigDecimal value;
			Runnable r = (Runnable) in.readObject();
			System.out.println(r);
			/*
			 * long recoveredSize = in.readLong(); while (recoveredSize-- > 0) {
			 * listofdecimals.add((BigDecimal) in.readUnshared()); //
			 * System.out.println((BigDecimal)in.readUnshared()); } return listofdecimals;
			 */
		}
	}

	public List<BigDecimal> deserialize(List<BigDecimal> listofdecimals)
			throws FileNotFoundException, IOException, ClassNotFoundException {
		File storageFile = new File("C:\\Users\\altex\\\\Desktop\\maven-samples-master\\piosplab3\\ceva.txt");
		try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(storageFile)))) {
			// BigDecimal value;
			long recoveredSize = in.readLong();
			while (recoveredSize-- > 0) {
				listofdecimals.add((BigDecimal) in.readUnshared());
				// System.out.println((BigDecimal)in.readUnshared());
			}
			return listofdecimals;
		}
	}

	public synchronized List<BigDecimal> produce() {
		List<BigDecimal> listofdecimals = new ArrayList<BigDecimal>();
		for (int i = 0; i < 10000000; i++) {
			listofdecimals.add(new BigDecimal(i));
		}
		return listofdecimals;
	}

	public synchronized List<BigDecimal> producedeserialized(List<BigDecimal> listofdecimals)
			throws FileNotFoundException, ClassNotFoundException, IOException {
		BigDecimalsRepository bg = new BigDecimalsRepository();
		listofdecimals = bg.deserialize(listofdecimals);
		return listofdecimals;
	}

	public synchronized void consume(List<BigDecimal> listofdecimals) throws FileNotFoundException, IOException {
		/*
		 * BigDecimalsRepository bg = new BigDecimalsRepository();
		 * bg.serialize(listofdecimals);
		 */
		for (int i = 0; i < listofdecimals.size(); i += 1000) {
			System.out.println("BigDecimal removed from the list (consumed): " + listofdecimals.remove(i));
		}
	}

	public void options() throws FileNotFoundException, IOException, ClassNotFoundException, InterruptedException {
		int choice = 0;
		BigDecimalsRepository bg = new BigDecimalsRepository();
		do {
			meniu();
			choice = userchoice();
			switch (choice) {
			case 1:
				int nr = 1;
				while (nr != 0) {
					BigDecimal term = userinput();
					bg.addbigdecimalnumber(term);
					System.out.println("Want to keep adding? ");
					System.out.println("1.Yes ");
					System.out.println("0.No ");
					nr = userchoice();
					/*
					 * for (int i = 0; i < 100000; i++) { bg.addbigdecimalnumber(new BigDecimal(i));
					 * }
					 */
				}
				break;
			case 2:
				System.out.println("The sum of the BigDecimals in the list is: ");
				System.out.println(bg.sum(bg.listofdecimals));
				break;
			case 3:
				System.out.println("The avg of the BigDecimals in the list is: ");
				System.out.println(bg.avg(bg.listofdecimals));
				break;
			case 4:
				System.out.println("The top 10% biggest nr in the List of BigDecimals are: ");
				System.out.println(bg.top10percentbiggestnr(bg.listofdecimals));
				break;
			case 5:
				bg.serialize(bg.listofdecimals);
				System.out.println("Serialized");
				break;
			case 6:
				bg.listofdecimals.clear();// can comment and it will add not override
				bg.listofdecimals = bg.deserialize(bg.listofdecimals);
				System.out.println("Deserialized");
				break;
			case 7:
				bg.serializelambdasum(bg.listofdecimals);
				System.out.println("Lambda sum serialized");
				break;
			case 8:
				bg.serializelambdaavg(bg.listofdecimals);
				System.out.println("Lambda avg serialized");
				break;
			case 9:
				bg.serializelambdatop10percentbiggestnr(bg.listofdecimals);
				System.out.println("Lambda top10ps serialized");
				break;
			case 10:
				bg.deserializelambdas();
				System.out.println("Lambda deserialized");
				break;
			case 11:
				Thread t1 = new Thread(new Runnable() {
					@Override
					public void run() {
						bg.listofdecimals.clear();// can comment and it will add not override
						try {
							bg.listofdecimals = bg.producedeserialized(bg.listofdecimals);
						} catch (FileNotFoundException e) {
							System.out.println("FileNotFoundException "+e);
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							System.out.println("ClassNotFoundException "+e);
							e.printStackTrace();
						} catch (IOException e) {
							System.out.println("IOException "+e);
							e.printStackTrace();
						}
						System.out.println("10M BigDecimals deserialized and Added to the list");
					}
				});
				Thread t2 = new Thread(new Runnable() {
					@Override
					public void run() {
						try {
							bg.consume(bg.listofdecimals);
						} catch (FileNotFoundException e) {
							System.out.println("FileNotFoundException "+e);
							e.printStackTrace();
						} catch (IOException e) {
							System.out.println("IOException "+e);
							e.printStackTrace();
						}
						System.out.println("10M BigDecimals consumed");
					}
				});
				t1.start();
				t1.join();
				t2.start();
				t2.join();
				System.out.println("Threads finished");
				break;
			case 0:
				System.out.println("Exited");
				break;
			default:
				choice = userchoice();
			}
		} while (choice != 0);
	}

	public static void meniu() {
		System.out.println("1.Add to the List of BigDecimals");
		System.out.println("2.Sum of the BigDecimals from the List");
		System.out.println("3.Average of the BigDecimals from the List");
		System.out.println("4.Top 10% biggest nr in the List of BigDecimals");
		System.out.println("5.Serialize the elements from the List");
		System.out.println("6.Deserialize elements for the List");
		System.out.println("7.Lambda sum serialize");
		System.out.println("8.Lambda avg serialize");
		System.out.println("9.Lambda top10ps serialize");
		System.out.println("10.Lambdas deserialize");
		System.out.println("11.10M BigDecimals added to the list of BigDecimals(deserialized) and then consumed");
		System.out.println("0.Exit");
	}
}
