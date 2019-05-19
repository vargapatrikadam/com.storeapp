package com.assignment.State;

public abstract class DeliveryState {
    public abstract void DeliveryStateChange(Delivery delivery);
    public abstract String GetStateMessage();
}
