package org.piosplab3;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SumTest {
		private List<BigDecimal> firstterm = new ArrayList<BigDecimal>();
		private BigDecimal expectedresult;
		private BigDecimalsRepository bd1 = new BigDecimalsRepository();		
		public SumTest(List<BigDecimal> firstterm,BigDecimal expectedresult) {
			this.firstterm=firstterm;
			this.expectedresult=expectedresult;
		}
		@Parameters
		public static Collection <Object[]> testdata(){
			List<BigDecimal> a = Arrays.asList(new BigDecimal("1"),new BigDecimal("2"),new BigDecimal("3"),new BigDecimal("50"),new BigDecimal("100"));
			List<BigDecimal> b = Arrays.asList(new BigDecimal("-1"),new BigDecimal("5"),new BigDecimal("1"),new BigDecimal("0"),new BigDecimal("3"));
			List<BigDecimal> c = Arrays.asList(new BigDecimal("0"),new BigDecimal("0"),new BigDecimal("0"));
			List<BigDecimal> d = Arrays.asList(new BigDecimal("-5"),new BigDecimal("-10"),new BigDecimal("-23"),new BigDecimal("-11"));
			List<BigDecimal> e = Arrays.asList(new BigDecimal("6"),new BigDecimal("-1"),new BigDecimal("23"),new BigDecimal("13"),new BigDecimal("5"));
			List<BigDecimal> f = Arrays.asList(new BigDecimal("7"),new BigDecimal("13"),new BigDecimal("23"),new BigDecimal("14"),new BigDecimal("11"));
			Object data [][]=new Object[][] { {a,new BigDecimal("156")},{b,new BigDecimal("8")},{c,new BigDecimal("0")},{d,new BigDecimal("-49")},{e,new BigDecimal("46")},{f,new BigDecimal("68")} };
			return Arrays.asList(data);
		}
		
		@Test
		public void testadd() {
			Assert.assertEquals(expectedresult,bd1.sum(firstterm));
			System.out.println("Tests passed --- sum()");
	}

}
