package tests;

import clients.ApiV1CompaniesGET;
import models.ResponseApiV1CompaniesGET;
import utils.SchemaValidator;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

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

        response.data.forEach(company -> {
            assertNotNull(company.id, "Company ID should not be null");
            if (company.addresses != null) {
                company.addresses.forEach(address -> assertNotNull(address.id, "Address ID should not be null"));
            }
            if (company.contact != null) {
                assertNotNull(company.contact.id, "Contact ID should not be null");
            }
        });
    }

    @Test
    void testCompaniesJsonSchema() throws Exception {
        String json = client.callApiV1CompaniesGET();
        SchemaValidator.validateJsonAgainstSchema("ApiV1CompaniesGETSchema.json", json);
    }
}
