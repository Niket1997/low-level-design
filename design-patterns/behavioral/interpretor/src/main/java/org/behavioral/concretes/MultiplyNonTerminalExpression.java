package org.behavioral.concretes;

import org.behavioral.interfaces.IAbstractExpression;
import org.behavioral.Context;


public class MultiplyNonTerminalExpression implements IAbstractExpression {
    IAbstractExpression leftExpression;
    IAbstractExpression rightExpression;

    public MultiplyNonTerminalExpression(IAbstractExpression leftExpression, IAbstractExpression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int interpret(Context context) {
        return leftExpression.interpret(context) * rightExpression.interpret(context);
    }
}
