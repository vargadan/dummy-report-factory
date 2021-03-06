package net.vargadaniel.re.reportfactory.dummy;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface ReportEngine {
	
	final String PRODUCTS = "products";
	final String ORDERS = "orders";
	final String STATUS_UPDATES = "statusUpdates";
	final String REPORT_FILES = "reportFiles";
	
	@Input(ORDERS)
	SubscribableChannel orders();
	
	@Output(PRODUCTS)
	MessageChannel products();
	
	@Output(STATUS_UPDATES)
	MessageChannel statusUpdates();

	@Output(REPORT_FILES)
	MessageChannel reportFiles();
}
