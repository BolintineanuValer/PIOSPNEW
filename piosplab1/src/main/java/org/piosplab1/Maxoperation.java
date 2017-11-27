package org.piosplab1;

public class Maxoperation extends Operations {
	@Override
	public double max(double a, double b){
		if(a>=b){
			return a;
		}
		else 
			return b; 
	}

}
