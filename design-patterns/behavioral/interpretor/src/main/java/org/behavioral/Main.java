package org.behavioral;

import org.behavioral.concretes.MultiplyNonTerminalExpression;
import org.behavioral.concretes.NumberTerminalExpression;
import org.behavioral.interfaces.IAbstractExpression;

public class Main {
    public static void main(String[] args) {
        // initialize context
        Context context = new Context();
        context.put("a", 2);
        context.put("b", 3);

        // a * b
        IAbstractExpression abstractExpression = new MultiplyNonTerminalExpression(
                new NumberTerminalExpression("a"),
                new NumberTerminalExpression("b")
        );
        System.out.println(abstractExpression.interpret(context));
    }
}