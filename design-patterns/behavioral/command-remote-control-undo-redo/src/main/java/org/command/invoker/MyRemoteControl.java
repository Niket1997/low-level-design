package org.command.invoker;

import org.command.interfaces.ICommand;

import java.util.Stack;

public class MyRemoteControl {
    Stack<ICommand> acCommandHistory;
    ICommand command;

    public MyRemoteControl() {
        acCommandHistory = new Stack<>();
    }

    public void setCommand(ICommand command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
        acCommandHistory.push(command);
    }

    public void undo() {
        if (!acCommandHistory.isEmpty()) {
            ICommand lastExecutedCommand = acCommandHistory.pop();
            lastExecutedCommand.undo();
        }
    }
}
