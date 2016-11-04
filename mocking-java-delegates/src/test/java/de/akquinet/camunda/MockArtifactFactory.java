package de.akquinet.camunda;

import org.camunda.bpm.engine.impl.DefaultArtifactFactory;
import org.camunda.bpm.engine.test.mock.Mocks;

public class MockArtifactFactory extends DefaultArtifactFactory {

    @Override
    public <T> T getArtifact(Class<T> clazz) {
        T mockedDelegate = (T) Mocks.get(clazz.getCanonicalName());
        if (mockedDelegate == null) {
            return super.getArtifact(clazz);
        }
        return mockedDelegate;
    }
}
