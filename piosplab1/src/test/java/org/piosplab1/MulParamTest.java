package org.piosplab1;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import junit.framework.Assert;


@RunWith(Parameterized.class)
public class MulParamTest {
		private double firstterm;
		private double secondterm;
		private double expectedresult;
		
		public MulParamTest(double firstterm,double secondterm,double expectedresult) {
			this.firstterm=firstterm;
			this.secondterm=secondterm;
			this.expectedresult=expectedresult;
		}
		@Parameters
		public static Collection <Object[]> testdata(){
			Object data [][]=new Object[][] { {2,3,6},{-10,-7,70},{1,-3,-3},{-2,31,-62},{0,1,0},{0,0,0} };
			return Arrays.asList(data);
		}
		
		@Test
		public void testmul() {
			Assert.assertEquals(expectedresult,Muloperation.mul(firstterm, secondterm));
			System.out.println("Tests passed --- mul()");
	}

}