package com.assignment.State;

public class CompletedState extends DeliveryState {
    @Override
    public void DeliveryStateChange(Delivery delivery) {
        delivery.setState(new CompletedState());
    }

    @Override
    public String GetStateMessage() {
        return "Delivery is completed!";
    }
}
