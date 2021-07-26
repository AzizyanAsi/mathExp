package mathExpression;

import java.util.List;

public class ExpressionMain {
    public static void main(String[] args) {
        String expression = "5 + 7 - 8 + 10";
        double result;
        ValueExpression temp;
        List<OperatorExpression> a = OperatorExpression.generateList(expression.split(" "));
        System.out.println(a);
//        for (int i = 0; i < a.size(); i++) {
//            if (a.get(i).operator.getOperator().equals("*")) {
//                temp = new ValueExpression(a.get(i).calculate());
//                if (i != a.size() - 1) {
//                    a.get(i + 1).left = temp;
//                }
//                if (i != 0) {
//                    a.get(i - 1).right = temp;
//                }
//
//            }
//        }
        for (int i = 0; i < a.size() - 1; i++) {
            if (!a.get(i).operator.getOperator().equals("*") || !a.get(i).operator.getOperator().equals("/")) {
                a.get(i + 1).left = new ValueExpression(a.get(i).calculate());

            }
        }
        System.out.println(a.get(a.size() - 1).calculate());
    }

}
