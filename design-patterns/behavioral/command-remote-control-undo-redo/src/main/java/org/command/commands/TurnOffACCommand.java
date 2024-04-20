package org.command.commands;

import org.command.interfaces.ICommand;
import org.command.receiver.AirConditioner;

public class TurnOffACCommand implements ICommand {
    private final AirConditioner ac;

    public TurnOffACCommand(AirConditioner ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
        ac.turnOffAC();
    }

    @Override
    public void undo() {
        ac.turnOnAC();
    }
}
