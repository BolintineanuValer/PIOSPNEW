package org.piosplab1;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import org.junit.Assert;;


@RunWith(Parameterized.class)
public class MinParamTest {
		private double firstterm;
		private double secondterm;
		private double expectedresult;
		private Minoperation mi1 = new Minoperation();
		
		public MinParamTest(double firstterm,double secondterm,double expectedresult) {
			this.firstterm=firstterm;
			this.secondterm=secondterm;
			this.expectedresult=expectedresult;
		}
		@Parameters
		public static Collection <Object[]> testdata(){
			Object data [][]=new Object[][] { {2,3,2},{-7,-10,-10},{-3,1,-3},{31,-2,-2},{-1,-2,-2},{0,0,0} };
			return Arrays.asList(data);
		}
		
		@Test
		public void testmin() {
			Assert.assertEquals(expectedresult,mi1.min(firstterm, secondterm),0.0001);
			System.out.println("Tests passed --- min()");
	}

}
