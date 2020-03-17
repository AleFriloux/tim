import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;


public class ValidateJson {
	
	public static void main( String[] args ) throws IOException, ProcessingException
	{
		final JsonNode fstabSchema = JsonLoader.fromPath("ietf.json");
		final JsonNode good = JsonLoader.fromPath("test.json");
		final JsonNode bad = JsonLoader.fromPath("partie1.json");
		final JsonSchemaFactory factory = JsonSchemaFactory.byDefault();

		final JsonSchema schema = factory.getJsonSchema(fstabSchema);

		ProcessingReport report;

		report = schema.validate(good); //SUCCESS
		System.out.print(report);

		report = schema.validate(bad); //FAILURE
	}

}
