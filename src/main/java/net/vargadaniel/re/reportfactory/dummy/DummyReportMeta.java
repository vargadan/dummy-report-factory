package net.vargadaniel.re.reportfactory.dummy;

import org.json.JSONObject;

public class DummyReportMeta {
	
	public final static String NAME = "dummyReport";
	
	private final JSONObject propertiesSchema;
		
	public DummyReportMeta(JSONObject propertiesSchema) {
		this.propertiesSchema = propertiesSchema;

	}

	public String getName() {
		return NAME;
	}

	public JSONObject getPropertiesSchema() {
		return propertiesSchema;
	}

}
