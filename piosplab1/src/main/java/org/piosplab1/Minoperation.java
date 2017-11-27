package org.piosplab1;

public class Minoperation extends Operations{
	@Override
	public double min(double a, double b){
		if(a>=b){
			return b;
		}
		else
			return a;
	}

}
