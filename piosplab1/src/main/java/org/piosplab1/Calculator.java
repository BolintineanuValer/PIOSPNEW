package org.piosplab1;

import java.util.Scanner;

public class Calculator {
	public static int userchoice(){
		System.out.println("Input your choice: ");
		Scanner scn = new Scanner(System.in);
		try{
			int opt = scn.nextInt();
			return opt;}
		catch(Exception ex){
			throw new IllegalArgumentException("Not a choice");
		}
	}
	public static double userinput(){
		System.out.println("Input your number: ");
		Scanner scn = new Scanner(System.in);
		try{
			double opt = scn.nextDouble();
			return opt;
		}
		catch(Exception ex){
			throw new IllegalArgumentException("Not a number");
		}
	}
	public void calculatoroption(){
		double term;
		double result;
		int choice=0;
		double term1=userinput();
		do
		{
		calculatormeniu();
		choice = userchoice();
		switch (choice){
			case 1:
				term=userinput();
				result=Addoperation.add(term1,term);
				System.out.println(term1+" + "+term+" = "+result);
				term1=result;
				break;
			case 2:
				term=userinput();
				result=Suboperation.sub(term1,term);
				System.out.println(term1+" - "+term+" = "+result);
				term1=result;
				break;
			case 3:
				term=userinput();
				result=Muloperation.mul(term1,term);
				System.out.println(term1+" * "+term+" = "+result);
				term1=result;
				break;
			case 4:
				term=userinput();
				result=Divoperation.div(term1,term);
				System.out.println(term1+" / "+term+" = "+result);
				term1=result;
				break;
			case 5:
				term=userinput();
				result=Minoperation.min(term1,term);
				System.out.println("min("+term1+","+term+")"+" = "+result);
				term1=result;
				break;
			case 6:
				term=userinput();
				result=Maxoperation.max(term1,term);
				System.out.println("max("+term1+","+term+")"+" = "+result);
				term1=result;
				break;
			case 7:
				result=Sqrtoperation.sqrt(term1);
				System.out.println("Sqrt("+term1+")"+" = "+result);
				term1=result;
				break;
			case 0:
				System.out.println("Exited");
				break;
			case 8:
				System.out.println("Deleted");
				term1=userinput();
				break;
				
			default:
				choice = userchoice();
		}
		}
		while(choice !=0);
	}
	public static void calculatormeniu(){	
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
		 * Teste cu parametri junit test 
		 * fiecare methoda in clasa separata
		 */
	}


}