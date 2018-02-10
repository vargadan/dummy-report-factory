package net.vargadaniel.re.reportfactory.dummy.model;

import java.time.LocalDate;

public class DummyReportOrder {
	
	public static class Properties {
		
		String cif;
		
		String from;
		
		String to;

		public String getCif() {
			return cif;
		}

		public void setCif(String cif) {
			this.cif = cif;
		}

		public String getFrom() {
			return from;
		}

		public void setFrom(String from) {
			this.from = from;
		}

		public String getTo() {
			return to;
		}

		public void setTo(String to) {
			this.to = to;
		}
		
	}
	
	private String id;
	
	private Properties properties;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public String getCif() {
		return properties.cif;
	}

	public LocalDate getFromDate() {
		return LocalDate.parse(properties.from);
	}
	
	public LocalDate getToDate() {
		return LocalDate.parse(properties.to);
	}
	
	

}