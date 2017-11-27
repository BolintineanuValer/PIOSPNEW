package org.piosplab1;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import org.junit.Assert;;


@RunWith(Parameterized.class)
public class MaxParamTest {
		private double firstterm;
		private double secondterm;
		private double expectedresult;
		private Maxoperation ma1 = new Maxoperation();
		
		public MaxParamTest(double firstterm,double secondterm,double expectedresult) {
			this.firstterm=firstterm;
			this.secondterm=secondterm;
			this.expectedresult=expectedresult;
		}
		@Parameters
		public static Collection <Object[]> testdata(){
			Object data [][]=new Object[][] { {2,3,3},{-7,-10,-7},{-3,1,1},{31,-2,31},{-10,10,10},{0,0,0} };
			return Arrays.asList(data);
		}
		
		@Test
		public void testmax() {
			Assert.assertEquals(expectedresult,ma1.max(firstterm, secondterm),0.0001);
			System.out.println("Tests passed --- max()");
	}

}
