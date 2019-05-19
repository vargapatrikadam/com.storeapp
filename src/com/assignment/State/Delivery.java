package com.assignment.State;

public class Delivery {
    private DeliveryState state;

    public Delivery(){
        this.state = new ProcessingState();
    }

    public void setState(DeliveryState state){
        this.state = state;
    }

    public DeliveryState getState(){
        return this.state;
    }

    public String getStateMessage(){
        return this.state.GetStateMessage();
    }

    public void stateChange(){
        state.DeliveryStateChange(this);
    }


}
