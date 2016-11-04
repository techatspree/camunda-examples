package de.akquinet.camunda;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.logging.Logger;

/**
 * This is an empty service implementation illustrating how to use a plain Java
 * class as a BPMN 2.0 Service Task delegate.
 */
public class FancyServiceDelegate implements JavaDelegate {

    private final Logger LOGGER = Logger.getLogger( FancyServiceDelegate.class.getName());

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        LOGGER.info("\n\n  ... Fancy Service call \n\n");

    }

}
