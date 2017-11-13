package org.piosplab1;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import org.junit.Assert;


@RunWith(Parameterized.class)
public class AddParamTest {
		private double firstterm;
		private double secondterm;
		private double expectedresult;
		private Addoperation a1 = new Addoperation();		
		public AddParamTest(double firstterm,double secondterm,double expectedresult) {
			this.firstterm=firstterm;
			this.secondterm=secondterm;
			this.expectedresult=expectedresult;
		}
		@Parameters
		public static Collection <Object[]> testdata(){
			Object data [][]=new Object[][] { {2,3,5},{-7,-10,-17},{-3,1,-2},{31,-2,29},{-10,10,0},{0,0,0} };
			return Arrays.asList(data);
		}
		
		@Test
		public void testadd() {
			Assert.assertEquals(expectedresult,a1.add(firstterm, secondterm),0.0001);
			System.out.println("Tests passed --- add()");
	}

}
