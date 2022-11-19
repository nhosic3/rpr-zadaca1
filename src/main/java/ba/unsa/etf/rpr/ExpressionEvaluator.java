package ba.unsa.etf.rpr;

import java.util.Stack;

/**
 * ExpressionEvaluator class for calculating expressions with Dijkstra's Algorithm
 * @author Nedim Hosic
 */

public class ExpressionEvaluator {
    public static Double evaluate(String str){

        /**
         * If string is empty or doesn't end with ')'
         * then expression is not valid
         */

        if (str.isEmpty() || str.charAt(str.length() - 1) != ')')
            throw new RuntimeException();
        int leftParCounter = 0, rightParCounter = 0, operatorCounter = 0;
        for (int i = 0; i < str.length(); ++i){
            if (str.charAt(i) == '('){
                if(str.charAt(i+1) != ' ')
                    throw new RuntimeException();
                leftParCounter++;
            }
            if (str.charAt(i) == ')'){
                if(str.charAt(i-1) != ' ')
                    throw new RuntimeException();
                rightParCounter++;
            }
            if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' || str.charAt(i) == '/'){
                operatorCounter++;
                if(str.charAt(i+1) != ' ' || str.charAt(i-1) != ' ')
                    throw new RuntimeException();
                boolean isDigitBefore = Character.isDigit(str.charAt(i-2));
                boolean isDigitAfter = Character.isDigit(str.charAt(i+2));
                if(str.charAt(i+2) != '(' && isDigitAfter == false && (str.charAt(i+2) != 's' && str.charAt(i+3) != 'q' && str.charAt(i+4) != 'r' && str.charAt(i+5) != 't'))
                    throw new RuntimeException();
            }
            if (str.charAt(i) == 's' && str.charAt(i+1) == 'q' && str.charAt(i+2) == 'r' && str.charAt(i+3) == 't'){
                operatorCounter++;
                if(str.charAt(i+4) != ' ' || str.charAt(i+5) != '(')
                    throw new RuntimeException();
                if(!Character.isDigit(str.charAt(i+7)))
                    throw new RuntimeException();
            }
        }
        /**
         * If number of right and left parenthesis are not equal
         * then expression is not valid
         */
        if (leftParCounter != rightParCounter || operatorCounter > leftParCounter)
            throw new RuntimeException();


        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();
        for(String s : str.split(" ")){
            if(s.equals("("));
            else if(s.equals("+")) ops.push(s);
            else if(s.equals("-")) ops.push(s);
            else if(s.equals("*")) ops.push(s);
            else if(s.equals("/")) ops.push(s);
            else if(s.equals("sqrt")) ops.push(s);
            else if(s.equals(")")){
                String op = ops.pop();
                Double v = vals.pop();
                if(op.equals("+")) v = vals.pop() + v;
                else if(op.equals("-")) v = vals.pop() - v;
                else if(op.equals("*")) v = vals.pop() * v;
                else if(op.equals("/")) v = vals.pop() / v;
                else if(op.equals("sqrt")) v = Math.sqrt(v);
                vals.push(v);
            }
            else{
                try{
                    vals.push(Double.parseDouble(s));
                }
                catch(Exception e){
                    throw new RuntimeException();
                }
            }
        }
        return vals.pop();
    }
}
