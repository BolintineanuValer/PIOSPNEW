package org.piosplab1;

import java.util.Scanner;

public class Calculator implements ICalculator {

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

	public static double userinput() {
		System.out.println("Input your number: ");
		@SuppressWarnings("resource")
		Scanner scn = new Scanner(System.in);
		try {
			double opt = scn.nextDouble();
			return opt;
		} catch (Exception ex) {
			throw new IllegalArgumentException("Not a number");
		}
	}

	@Override
	public void calculatoroption() {
		double term;
		double result;
		int choice = 0;
		Operations op;
		double term1 = userinput();
		do {
			calculatormeniu();
			choice = userchoice();
			switch (choice) {
			case 1:
				term = userinput();
				//Addoperation a1 = new Addoperation();
				op = new Addoperation();
				//result = a1.add(term1, term);
				result = op.add(term1,term);
				System.out.println(term1 + " + " + term + " = " + result);
				term1 = result;
				break;
			case 2:
				term = userinput();
				//Suboperation s1 = new Suboperation();
				op = new Suboperation();
				//result = s1.sub(term1, term);
				result = op.sub(term1, term);
				System.out.println(term1 + " - " + term + " = " + result);
				term1 = result;
				break;
			case 3:
				term = userinput();
				//Muloperation m1 = new Muloperation();
				op = new Muloperation();
				//result = m1.mul(term1, term);
				result = op.mul(term1, term);
				System.out.println(term1 + " * " + term + " = " + result);
				term1 = result;
				break;
			case 4:
				term = userinput();
				//Divoperation d1 = new Divoperation();
				op = new Divoperation();
				//result = d1.div(term1, term);
				result = op.div(term1, term);
				System.out.println(term1 + " / " + term + " = " + result);
				term1 = result;
				break;
			case 5:
				term = userinput();
				//Minoperation mi1 = new Minoperation();
				op = new Minoperation();
				//result = mi1.min(term1, term);
				result = op.min(term1, term);
				System.out.println("min(" + term1 + "," + term + ")" + " = " + result);
				term1 = result;
				break;
			case 6:
				term = userinput();
				//Maxoperation ma1 = new Maxoperation();
				op = new Maxoperation();
				//result = ma1.max(term1, term);
				result = op.max(term1, term);
				System.out.println("max(" + term1 + "," + term + ")" + " = " + result);
				term1 = result;
				break;
			case 7:
				//Sqrtoperation sq1 = new Sqrtoperation();
				op = new Sqrtoperation();
				//result = sq1.sqrt(term1);
				result = op.sqrt(term1);
				System.out.println("Sqrt(" + term1 + ")" + " = " + result);
				term1 = result;
				break;
			case 0:
				System.out.println("Exited");
				break;
			case 8:
				System.out.println("Deleted");
				term1 = userinput();
				break;

			default:
				choice = userchoice();
			}
		} while (choice != 0);
	}

	public static void calculatormeniu() {
		System.out.println("1.Add numbers");
		System.out.println("2.Substract numbers");
		System.out.println("3.Multiply numbers");
		System.out.println("4.Divide numbers");
		System.out.println("5.Min of two numbers");
		System.out.println("6.Max of two numbers");
		System.out.println("7.Square root of a number");
		System.out.println("8.Delete last result");
		System.out.println("0.Exit");
		/*
		 * Teste cu parametri junit test fiecare methoda in clasa separata
		 */
	}

}