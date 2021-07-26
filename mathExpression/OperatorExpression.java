package mathExpression;

import java.util.ArrayList;
import java.util.List;

public class OperatorExpression implements Expression {
    protected Expression left;
    protected Expression right;
    protected Operator operator;

    public OperatorExpression(Expression left, Operator operator, Expression right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    @Override
    public String toString() {
        return left + " " + operator + " " + right;
    }

    @Override
    public double calculate() {
        switch (operator.operator) {
            case "-":
                return left.calculate() - right.calculate();
            case "*":
                return left.calculate() * right.calculate();
            case "/":
                return left.calculate() / right.calculate();
            default:
                return left.calculate() + right.calculate();
        }
    }

    public static List<OperatorExpression> generateList(String exp[]) {
        List<OperatorExpression> operators = new ArrayList<>();
        for (int i = 0; i <= exp.length - 3; ) {
            operators.add(new OperatorExpression(new ValueExpression(Double.parseDouble(exp[i])),
                    new Operator(exp[++i]), new ValueExpression(Double.parseDouble(exp[++i]))));


        }


        return operators;
    }


    public Expression getLeft() {
        return left;
    }

    public void setLeft(Expression left) {
        this.left = left;
    }

    public Expression getRight() {
        return right;
    }

    public void setRight(Expression right) {
        this.right = right;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }
}
