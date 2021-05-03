package org.example.environment.mock;

import org.example.environment.structure.Observation;

public class MockResponse {
    public Observation getMockObservation(){
        return new Observation(12,1,false,null);
    }
}
