package org.piosplab4;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Person {

	private String name1;
	private String name2;
	private String name3;
	private long cnp;
	private String email;

	public Person() {
		this.name1 = "defaultname1";
		this.name2 = "defaultname2";
		this.name3 = "defaultname3";
		this.cnp = 0;
		this.email = "defaultemail";
	}

	public Person(String name1, String name2, String name3, long cnp, String email) {
		this.name1 = name1;
		this.name2 = name2;
		this.name3 = name3;
		this.cnp = cnp;
		this.email = email;

	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public void setName3(String name3) {
		this.name3 = name3;
	}

	public void setCnp(Long cnp) {
		this.cnp = cnp;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName1() {
		return this.name1;
	}

	public String getName2() {
		return this.name2;
	}

	public String getName3() {
		return this.name3;
	}

	public long getCnp() {
		return this.cnp;
	}

	public String getEmail() {
		return this.email;
	}

	@Override
	public String toString() {
		StringBuilder my_builder = new StringBuilder();
		my_builder.append(this.name1).append(" ").append(this.name2).append(" ").append(this.name3).append(" ")
				.append(this.cnp).append(" ").append(this.email).append(" ");
		return my_builder.toString();
	}

	public static List<Person> readfromfile() {
		List<Person> inpersons = new ArrayList<>();
		File file = new File("goodinput.txt");
		try {
			Scanner in = new Scanner(file);
			while (in.hasNext()) {
				String data = in.next();
				String[] values = data.split("%|~");
				for (int j = 0; j < values.length; j += 5) {
					long prcnp = Long.parseLong(values[j + 3]);
					int prcnplength = (int) (Math.log10(prcnp) + 1);
					if (prcnplength == 13 && Character.isUpperCase(values[j].charAt(0)) && Character.isUpperCase(values[j + 1].charAt(0)) && Character.isUpperCase(values[j + 2].charAt(0)) ) {
						inpersons.add(new Person(values[j], values[j + 1], values[j + 2], prcnp, values[j + 4]));
					}
				}
			}
			in.close();
		} catch (Exception e) {
			System.out.println("Error when trying to read from file");
		}
		return inpersons;
	}

	public static void writetofile(Person pa) {
		try(PrintWriter out = new PrintWriter(new FileWriter("goodoutput.txt", true))){
			out.print(pa.getName1() + "~" + pa.getName2() + "~" + pa.getName3() + "~" + pa.getCnp() + "~"
					+ pa.getEmail() + "%");
		} catch (Exception e) {
			System.out.println("Error when trying to write to file");
		}
	}

}
