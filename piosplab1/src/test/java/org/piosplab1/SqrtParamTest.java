package org.piosplab1;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import junit.framework.Assert;


@RunWith(Parameterized.class)
public class SqrtParamTest {
		private double firstterm;
		private double expectedresult;
		
		public SqrtParamTest(double firstterm,double expectedresult) {
			this.firstterm=firstterm;
			this.expectedresult=expectedresult;
		}
		@Parameters
		public static Collection <Object[]> testdata(){
			Object data [][]=new Object[][] { {2,Math.sqrt(2)},{100,10},{1,1},{0,0},{-9,Math.sqrt(-9)},{-31,Math.sqrt(-31)} };
			return Arrays.asList(data);
		}
		
		@Test
		public void testsqrt() {
			try {
			Assert.assertEquals(expectedresult,Sqrtoperation.sqrt(firstterm));
			System.out.println("Tests passed --- validsqrt()");
			}
			catch(Exception sqrt) {
				Assert.assertEquals("Exception message must be correct","Can't take the square root of a negative number", sqrt.getMessage());
				System.out.println("Tests passed --- invalidsqrt()");
			}
		}
}
