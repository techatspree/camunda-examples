package de.akquinet.camunda;

import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.engine.test.ProcessEngineRule;
import org.camunda.bpm.engine.test.mock.Mocks;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.camunda.bpm.engine.test.assertions.ProcessEngineTests.init;
import static org.camunda.bpm.engine.test.assertions.ProcessEngineTests.runtimeService;

/**
 * Test case starting an in-memory database-backed Process Engine.
 */
public class MockingTest {

    @Rule
    public ProcessEngineRule rule = new ProcessEngineRule();

    private static final String PROCESS_DEFINITION_KEY = "mocking";

    @Before
    public void setup() {
        init(rule.getProcessEngine());
        Mocks.reset();
    }

    @Test
    @Deployment(resources = "process.bpmn")
    public void testRunningProcessWithoutMock() throws Exception {
        runtimeService().startProcessInstanceByKey(PROCESS_DEFINITION_KEY);
    }

    @Test
    @Deployment(resources = "process.bpmn")
    public void testRunningProcessWithMock() throws Exception {
        Mocks.register("de.akquinet.camunda.FancyServiceDelegate", new MockedFancyService());
        runtimeService().startProcessInstanceByKey(PROCESS_DEFINITION_KEY);
    }
}
