package mathExpression;

import mathExpression.Expression;

public class ValueExpression implements Expression {
    private double value;

    public ValueExpression(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value + " ";
    }

    @Override
    public double calculate() {
        return value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
