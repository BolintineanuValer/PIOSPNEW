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
public class Top10psTest {
	private List<BigDecimal> firstterm = new ArrayList<BigDecimal>();
	private List<BigDecimal> expectedresult = new ArrayList<BigDecimal>();
	private BigDecimalsRepository bd = new BigDecimalsRepository();

	public Top10psTest(List<BigDecimal> firstterm, List<BigDecimal> expectedresult) {
		this.firstterm = firstterm;
		this.expectedresult = expectedresult;
	}

	@Parameters
	public static Collection<Object[]> testdata() {
		List<BigDecimal> a = Arrays.asList(new BigDecimal("1"), new BigDecimal("2"), new BigDecimal("3"),
				new BigDecimal("50"), new BigDecimal("100"));
		List<BigDecimal> aa = Arrays.asList(new BigDecimal("100"));
		List<BigDecimal> b = Arrays.asList(new BigDecimal("-1"), new BigDecimal("5"), new BigDecimal("1"),
				new BigDecimal("0"), new BigDecimal("3"));
		List<BigDecimal> bb = Arrays.asList(new BigDecimal("5"));
		List<BigDecimal> c = Arrays.asList(new BigDecimal("0"), new BigDecimal("0"), new BigDecimal("0"));
		List<BigDecimal> cc = Arrays.asList();
		List<BigDecimal> d = Arrays.asList(new BigDecimal("-5"), new BigDecimal("-10"), new BigDecimal("-23"),
				new BigDecimal("-11"));
		List<BigDecimal> dd = Arrays.asList();
		List<BigDecimal> e = Arrays.asList(new BigDecimal("6"), new BigDecimal("-1"), new BigDecimal("23"),
				new BigDecimal("13"), new BigDecimal("5"));
		List<BigDecimal> ee = Arrays.asList(new BigDecimal("23"));
		List<BigDecimal> f = Arrays.asList(new BigDecimal("7"), new BigDecimal("13"), new BigDecimal("68"),
				new BigDecimal("14"), new BigDecimal("11"), new BigDecimal("6"), new BigDecimal("-1"),
				new BigDecimal("23"), new BigDecimal("13"), new BigDecimal("5"), new BigDecimal("0"),
				new BigDecimal("0"), new BigDecimal("0"), new BigDecimal("14"), new BigDecimal("11"),
				new BigDecimal("6"), new BigDecimal("-1"), new BigDecimal("23"));
		List<BigDecimal> ff = Arrays.asList(new BigDecimal("68"), new BigDecimal("23"));
		Object data[][] = new Object[][] { { a, aa }, { b, bb }, { c, cc }, { d, dd }, { e, ee }, { f, ff } };
		return Arrays.asList(data);
	}

	@Test
	public void testadd() {
		Assert.assertEquals(expectedresult, bd.top10percentbiggestnr(firstterm));
		System.out.println("Tests passed --- top10percentbiggestnr()");
	}

}
