package de.akquinet.camunda;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.logging.Logger;

public class MockedFancyService implements JavaDelegate {

    private final Logger LOGGER = Logger.getLogger( MockedFancyService.class.getName());

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        LOGGER.info("\n\n  ... MOCKED Fancy Service call \n\n");

    }

}
