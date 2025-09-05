package tests;

import clients.ApiV1CompaniesGET;
import models.ResponseApiV1CompaniesGET;
import com.google.gson.Gson;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

public class ApiV1CompaniesGETTest {

    private final ApiV1CompaniesGET client = new ApiV1CompaniesGET();
    private final Gson gson = new Gson();

    @Test
    void testCompaniesIdNotNull() throws Exception {
        String json = client.callApiV1CompaniesGET();
        ResponseApiV1CompaniesGET response = gson.fromJson(json, ResponseApiV1CompaniesGET.class);

        assertEquals(200, response.code, "Expected HTTP code 200 in body");
        assertEquals(20, response.total, "Expected total = 20");

        // Loop verify ID
        response.data.forEach(company ->
                assertNotNull(company.id, "Company ID should not be null"));
    }

    @Test
    void testCompaniesJsonSchema() throws Exception {
        String json = client.callApiV1CompaniesGET();

        try (InputStream schemaStream = getClass().getClassLoader()
                .getResourceAsStream("schemas/companies-schema.json")) {

            JSONObject rawSchema = new JSONObject(new JSONTokener(schemaStream));
            Schema schema = SchemaLoader.load(rawSchema);

            schema.validate(new JSONObject(json)); // throws exception if invalid
        }
    }
}
