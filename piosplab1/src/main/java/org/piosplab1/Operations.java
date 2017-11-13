package org.piosplab1;

public class Operations {
	public  double add(double a, double b){
		System.out.println("Not Polymorphism");
		return a+b;
	}
	public double sub(double a, double b){
		System.out.println("Not Polymorphism");
		return a-b;
	}
	
	public double mul(double a,double b){
		System.out.println("Not Polymorphism");
		return a*b;
	}
	
	public double div(double a, double b){
		System.out.println("Not Polymorphism");
		if(b==0)
		{
			throw new IllegalArgumentException("Can't divide by zero 0");
		}
		else
			return a/b;
	}
	
	public double min(double a, double b){
		System.out.println("Not Polymorphism");
		if(a>=b){
			return b;
		}
		else
			return a;
	}
	
	public double max(double a, double b){
		System.out.println("Not Polymorphism");
		if(a>=b){
			return a;
		}
		else 
			return b; 
	}

	public double sqrt(double a){
		System.out.println("Not Polymorphism");
		if(a<0){
			throw new IllegalArgumentException("Can't take the square root of a negative number");
		}
		else
			return Math.sqrt(a);
	}

}
