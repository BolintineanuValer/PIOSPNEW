package org.piosplab1;

public class Divoperation extends Operations {
	@Override
	public double div(double a, double b){
		if(b==0)
		{
			throw new IllegalArgumentException("Can't divide by zero 0");
		}
		else
			return a/b;
	}

}
