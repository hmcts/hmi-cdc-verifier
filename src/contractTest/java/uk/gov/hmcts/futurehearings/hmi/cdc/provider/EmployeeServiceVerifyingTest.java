package uk.gov.hmcts.futurehearings.hmi.cdc.provider;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit5.HttpTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SpringExtension.class)
public class EmployeeServiceVerifyingTest {

    @BeforeEach
    void setupTestTarget(PactVerificationContext context) {
        //context.setTarget(new HttpTestTarget("localhost", 4550, "/"));
    }

    @BeforeClass
    void enablePublishingPact() {
        System.setProperty("pact.verifier.publishResults", "true");
    }

    @TestTemplate
    @ExtendWith(PactVerificationInvocationContextProvider.class)
    void pactVerificationTestTemplate(PactVerificationContext context) {
        context.verifyInteraction();
    }

    @State("An employee exists")
    public void employeeExist() {
        System.out.println("Verification for the Employee Exists PACT Test");
    }

    @State("An employee should be updated")
    public void updateEmployee() {
        System.out.println("Verification for the Employee Exists PACT Test");
    }
}
