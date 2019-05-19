package com.assignment.State;

public class CourierState extends DeliveryState{
    @Override
    public void DeliveryStateChange(Delivery delivery) {
        delivery.setState(new CompletedState());
    }

    @Override
    public String GetStateMessage() {
        return "Delivery is in the hands of the courier";
    }
}
