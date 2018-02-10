package net.vargadaniel.re.reportfactory.dummy;

import org.junit.Assert;
import org.junit.Test;

public class DummyProductRegistererTest {
	
	@Test
	public void test() throws Exception {
		DummyProductRegisterer registerer = new DummyProductRegisterer();
		DummyReportMeta meta = registerer.registerProduct();
		Assert.assertNotNull(meta);
		Assert.assertNotNull(meta.getPropertiesSchema());
	}

}
