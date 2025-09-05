package utils;

import java.io.InputStream;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

public class SchemaValidator {
    /**
     * Validate a JSON string against a schema file located in resources/schemas.
     *
     * @param schemaFileName name of schema file (e.g., "companies-schema.json")
     * @param jsonResponse   JSON string to validate
     * @throws RuntimeException if validation fails
     */
    public static void validateJsonAgainstSchema(String schemaFileName, String jsonResponse) {
        try (InputStream schemaStream = SchemaValidator.class.getClassLoader()
                .getResourceAsStream("schemas/" + schemaFileName)) {

            if (schemaStream == null) {
                throw new IllegalArgumentException("Schema file not found: " + schemaFileName);
            }

            JSONObject rawSchema = new JSONObject(new JSONTokener(schemaStream));
            Schema schema = SchemaLoader.load(rawSchema);

            schema.validate(new JSONObject(jsonResponse)); // throws ValidationException if invalid

        } catch (Exception e) {
            throw new RuntimeException("Schema validation failed: " + e.getMessage(), e);
        }
    }
}
