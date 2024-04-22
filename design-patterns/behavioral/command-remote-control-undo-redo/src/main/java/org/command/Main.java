package org.command;

import org.command.commands.TurnOnACCommand;
import org.command.invoker.MyRemoteControl;
import org.command.receiver.AirConditioner;

public class Main {
    public static void main(String[] args) {
        // create a received object - AC
        AirConditioner ac = new AirConditioner();

        // create invoker object - remote control
        MyRemoteControl remoteControl = new MyRemoteControl();

        // create the command & press button
        remoteControl.setCommand(new TurnOnACCommand(ac));
        remoteControl.pressButton();

        // undo
        remoteControl.undo();
    }
}