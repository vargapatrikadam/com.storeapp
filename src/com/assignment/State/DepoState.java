package com.assignment.State;

public class DepoState extends DeliveryState{
    @Override
    public void DeliveryStateChange(Delivery delivery) {
        delivery.setState(new CourierState());
    }

    @Override
    public String GetStateMessage() {
        return "Delivery is in the depo, and ready for delivering";
    }
}
