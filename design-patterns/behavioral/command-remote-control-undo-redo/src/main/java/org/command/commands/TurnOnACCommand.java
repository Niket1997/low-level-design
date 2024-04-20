package org.command.commands;

import org.command.interfaces.ICommand;
import org.command.receiver.AirConditioner;

public class TurnOnACCommand implements ICommand {
    private final AirConditioner ac;

    public TurnOnACCommand(AirConditioner ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
        ac.turnOnAC();
    }

    @Override
    public void undo() {
        ac.turnOffAC();
    }
}
