package org.piosplab1;

public class Sqrtoperation extends Operations{
	@Override
	public double sqrt(double a){
		if(a<0){
			throw new IllegalArgumentException("Can't take the square root of a negative number");
		}
		else
			return Math.sqrt(a);
	}

}
