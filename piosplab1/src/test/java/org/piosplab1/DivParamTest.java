package org.piosplab1;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import junit.framework.Assert;


@RunWith(Parameterized.class)
public class DivParamTest {
		private double firstterm;
		private double secondterm;
		private double expectedresult;
		
		public DivParamTest(double firstterm,double secondterm,double expectedresult) {
			this.firstterm=firstterm;
			this.secondterm=secondterm;
			this.expectedresult=expectedresult;
		}
		@Parameters
		public static Collection <Object[]> validtestdata(){
			Object data [][]=new Object[][] { {2,3,2.0/3.0},{-14,-7,2},{1,-3,-1.0/3.0},{1,1,1},{-1,0,3},{0,0,0} };
			return Arrays.asList(data);
		}
		
		@Test
		public void testdiv() {
			try {
			Assert.assertEquals(expectedresult,Divoperation.div(firstterm, secondterm));
			System.out.println("Tests passed --- validdiv()");
			}
			catch(Exception ex) {
				Assert.assertEquals("Exception message must be correct","Can't divide by zero 0", ex.getMessage());
				System.out.println("Tests passed --- invaliddiv()");
			}
	}
}