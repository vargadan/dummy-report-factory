package net.vargadaniel.re.reportfactory.dummy;

import java.io.IOException;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;

@SpringBootApplication
public class DummyReportFactoryApp {

	public static void main(String... args) {
		String k8sNamespace = System.getenv("KUBERNETES_NAMESPACE");
		if (k8sNamespace != null) {
			String profile = k8sNamespace.substring(k8sNamespace.lastIndexOf("-") + 1);
			System.setProperty("spring.profiles.active", profile);
		}
		SpringApplication.run(DummyReportFactoryApp.class, args);
	}
	
	@Bean
	public Jackson2ObjectMapperBuilder objectMapperBuilder() {
	    Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
	    SimpleModule module = new SimpleModule("org.json");
        module.addSerializer(JSONObject.class, new JsonSerializer<JSONObject>() {
            @Override
            public void serialize(JSONObject value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
            jgen.writeRawValue(value.toString());
            }
        });
        module.addDeserializer(JSONObject.class, new JsonDeserializer<JSONObject>() {
        		@Override
            public JSONObject deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
                Map<String, Object> bean = jp.readValueAs(new TypeReference<Map<String, Object>>() {});
                return new JSONObject(bean);
            }
        });
        builder.modules(module);
	    return builder;
	}

}
