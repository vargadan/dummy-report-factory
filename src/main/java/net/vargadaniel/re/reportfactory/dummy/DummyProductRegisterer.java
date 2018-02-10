package net.vargadaniel.re.reportfactory.dummy;

import java.io.IOException;
import java.io.InputStream;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@EnableBinding(ReportEngine.class)
public class DummyProductRegisterer {

	static final Logger logger = LoggerFactory.getLogger(DummyProductRegisterer.class);

	@RequestMapping("/register")
	@InboundChannelAdapter(channel = ReportEngine.PRODUCTS, poller = @Poller(maxMessagesPerPoll = "1", fixedRate = "10000"))
	public DummyReportMeta registerProduct() throws IOException {
//		StringWriter sw = new StringWriter();
		JSONObject jsonSchema = null;
		try (InputStream inputStream = getClass().getResourceAsStream("/DummyReportSchema.json")) {
			jsonSchema = new JSONObject(new JSONTokener(inputStream));
//			schema = SchemaLoader.load(rawSchema);
//			JSONPrinter jsonPrinter = new JSONPrinter(sw);
//			schema.describeTo(jsonPrinter);
		}
		return new DummyReportMeta(jsonSchema);
	}
}