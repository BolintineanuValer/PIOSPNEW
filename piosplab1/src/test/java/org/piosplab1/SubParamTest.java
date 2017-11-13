package org.piosplab1;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import org.junit.Assert;;


@RunWith(Parameterized.class)
public class SubParamTest {
		private double firstterm;
		private double secondterm;
		private double expectedresult;
		private Suboperation s1 = new Suboperation();
		
		public SubParamTest(double firstterm,double secondterm,double expectedresult) {
			this.firstterm=firstterm;
			this.secondterm=secondterm;
			this.expectedresult=expectedresult;
		}
		@Parameters
		public static Collection <Object[]> testdata(){
			Object data [][]=new Object[][] { {2,3,-1},{-10,-7,-3},{1,-3,4},{-31,31,-62},{10,10,0},{0,0,0} };
			return Arrays.asList(data);
		}
		
		@Test
		public void testsub() {
			Assert.assertEquals(expectedresult,s1.sub(firstterm, secondterm),0.0001);
			System.out.println("Tests passed --- sub()");
	}

}