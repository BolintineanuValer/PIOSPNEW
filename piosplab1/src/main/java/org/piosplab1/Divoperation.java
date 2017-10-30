package org.piosplab1;

public class Divoperation {
	public static double div(double a, double b){
		if(b==0)
		{
			throw new IllegalArgumentException("Can't divide by zero 0");
		}
		else
			return a/b;
	}

}
