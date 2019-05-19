package com.assignment.State;

public class ProcessedState extends DeliveryState {
    @Override
    public void DeliveryStateChange(Delivery delivery) {
        delivery.setState(new DepoState());
    }

    @Override
    public String GetStateMessage() {
        return "Delivery is under processing";
    }
}
