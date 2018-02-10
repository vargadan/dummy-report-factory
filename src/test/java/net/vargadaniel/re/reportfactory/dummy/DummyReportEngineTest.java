package net.vargadaniel.re.reportfactory.dummy;

import java.util.HashMap;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import net.vargadaniel.re.reportfactory.dummy.model.DummyReport;
import net.vargadaniel.re.reportfactory.dummy.model.DummyReportOrder;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = DummyReportFactoryApp.class)
@WebAppConfiguration
public class DummyReportEngineTest {
	
	@Autowired
	DummyReportEngine engine;
	
	@Test
	public void testNormalOrder() throws Exception {
		DummyReportOrder order = new DummyReportOrder();
		
		order.setId(UUID.randomUUID().toString());
		order.setProperties(new DummyReportOrder.Properties());
		order.getProperties().setCif("1");
		order.getProperties().setFrom("2017-01-01");
		order.getProperties().setTo("2017-01-31");
		
		DummyReport report = engine.processOrder(order);
		
		Assert.assertNotNull(report);
		Assert.assertEquals("1", report.getCif());
		Assert.assertNotNull(report.getDailyStats());
		Assert.assertEquals(31, report.getDailyStats().size());
		
		String xml = engine.convertReportToXml(report);
		Assert.assertNotNull(xml);
	}

}