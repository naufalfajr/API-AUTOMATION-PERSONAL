# API Automation Personal Project

This project provides automated tests for the [fakerapi.it](https://fakerapi.it/) Companies API using Java, JUnit 5, and JSON Schema validation.

## Prerequisites

- Java 11 or higher
- Maven (recommended)
- Internet connection (for API calls and dependency downloads)

## Project Structure

```
src/
  main/
    java/
      base/
      clients/
      models/
  test/
    java/
      tests/
      utils/
    resources/
      schemas/
        ApiV1CompaniesGETSchema.json
```

## How to Run

1. **Clone the repository:**
   ```sh
   git clone https://github.com/naufalfajr/API-AUTOMATION-PERSONAL.git
   cd API-AUTOMATION-PERSONAL
   ```

2. **Install dependencies:**
   - If using Maven:
     ```sh
     mvn clean install
     ```

3. **Run the tests:**
   - With Maven:
     ```sh
     mvn test
     ```

## Customization

- To change the number of companies fetched, edit the test parameters in `ApiV1CompaniesGETTest.java`.
- To validate against a different schema, update or add the schema file in `src/test/resources/schemas/`.

##