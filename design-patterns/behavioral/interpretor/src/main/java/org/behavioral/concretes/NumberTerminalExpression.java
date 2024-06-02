package org.behavioral.concretes;

import org.behavioral.Context;
import org.behavioral.interfaces.IAbstractExpression;

public class NumberTerminalExpression implements IAbstractExpression {
    String stringValue;

    public NumberTerminalExpression(String stringValue) {
        this.stringValue = stringValue;
    }

    @Override
    public int interpret(Context context) {
        return context.get(stringValue);
    }
}
