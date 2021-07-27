package mathExpression;

import java.util.List;

public class ExpressionMain {
    public static void main(String[] args) {
        String expression = "5 * 1 + 7 * 8 - 8 / 4";
        double result = 0.0;
        ValueExpression temp = null;
        List<OperatorExpression> a = OperatorExpression.generateList(expression.split(" "));
        String operator;
        ValueExpression tempExpression;
        for (int i = 0; i < a.size(); i++) {
            operator = a.get(i).operator.getOperator();
            if (operator.equals("*") || operator.equals("/")) {
                if(temp == null)
                    temp = new ValueExpression(a.get(i).calculate());
                else
                    temp.setValue(a.get(i).calculate());
                if (i < a.size() - 1) {
                    a.get(i + 1).left = temp;
                }
                if (i != 0){
                    a.get(i - 1).right = temp;
                }
            }else{
                temp = null;
            }
        }

        temp = null;
        for (int i = 0; i < a.size(); i++) {
            if (!a.get(i).operator.getOperator().equals("*") && !a.get(i).operator.getOperator().equals("/")) {
                if (temp !=null){
                    a.get(i).left = temp;
                }
                temp = new ValueExpression(a.get(i).calculate());
            }
        }
        System.out.println(temp.getValue());
    }

}
