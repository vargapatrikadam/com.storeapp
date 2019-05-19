package com.assignment.State;

public class ProcessingState extends DeliveryState {

    @Override
    public void DeliveryStateChange(Delivery delivery) {
        delivery.setState(new ProcessedState());
    }

    @Override
    public String GetStateMessage() {
        return "Delivery is under processing";
    }
}
