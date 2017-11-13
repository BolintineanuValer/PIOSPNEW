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
public class AvgTest {
	private List<BigDecimal> firstterm = new ArrayList<BigDecimal>();
	private BigDecimal expectedresult;
	private BigDecimalsRepository bd2 = new BigDecimalsRepository();

	public AvgTest(List<BigDecimal> firstterm, BigDecimal expectedresult) {
		this.firstterm = firstterm;
		this.expectedresult = expectedresult;
	}

	@Parameters
	public static Collection<Object[]> testdata() {
		List<BigDecimal> a = Arrays.asList(new BigDecimal("1"), new BigDecimal("2"), new BigDecimal("3"),
				new BigDecimal("50"), new BigDecimal("100"));
		List<BigDecimal> b = Arrays.asList(new BigDecimal("-1"), new BigDecimal("5"), new BigDecimal("1"),
				new BigDecimal("0"), new BigDecimal("3"));
		List<BigDecimal> c = Arrays.asList(new BigDecimal("0"), new BigDecimal("0"), new BigDecimal("0"));
		List<BigDecimal> d = Arrays.asList(new BigDecimal("-5"), new BigDecimal("-10"), new BigDecimal("-23"),
				new BigDecimal("-11"));
		List<BigDecimal> e = Arrays.asList(new BigDecimal("6"), new BigDecimal("-1"), new BigDecimal("23"),
				new BigDecimal("13"), new BigDecimal("5"));
		List<BigDecimal> f = Arrays.asList(new BigDecimal("7"), new BigDecimal("13"), new BigDecimal("23"),
				new BigDecimal("4"), new BigDecimal("3"));
		Object data[][] = new Object[][] { { a, new BigDecimal("31.20") }, { b, new BigDecimal("1.60") },
				{ c, new BigDecimal("0.00") }, { d, new BigDecimal("-12.25") }, { e, new BigDecimal("9.20") },
				{ f, new BigDecimal("10.00") } };
		return Arrays.asList(data);
	}

	@Test
	public void testadd() {
		Assert.assertEquals(expectedresult, bd2.avg(firstterm));
		System.out.println("Tests passed --- avg()");
	}

}
