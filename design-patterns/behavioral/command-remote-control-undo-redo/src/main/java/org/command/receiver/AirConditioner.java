package org.command.receiver;

public class AirConditioner {
    private boolean isOn;
    private int temprature;

    public AirConditioner() {
        this.isOn = false;
        this.temprature = 0;
    }

    public void turnOnAC() {
        isOn = true;
        System.out.println("AC is on");
    }

    public void turnOffAC() {
        isOn = false;
        System.out.println("AC is off");
    }

    public void setTemprature(int newTemprature) {
        this.temprature = newTemprature;
        System.out.println("Temprature is changed to " + newTemprature);
    }
}
