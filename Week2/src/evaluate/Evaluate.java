package evaluate;

import generics.GenericStack;

/**
 * This uses Dijkstra two stack algorithm to evaluate an expression. This code evaluates only
 * expression that contain add and multiply operators
 */

public class Evaluate {
    public static void main(String[] args){
        GenericStack<Character> opStack = new GenericStack<Character>();
        GenericStack<Integer> valStack = new GenericStack<Integer>();

        String expression = "(1 + ((2 + 3) * (4 * 5) ))";

        for(char c : expression.toCharArray()){
            if(c == '(' || c == ' ') continue;
            if(c == ')'){
                char op = opStack.pop();
                int value = 0;
                if(op == '+'){
                    value = valStack.pop() + valStack.pop();
                }else if (op == '*'){
                    value = valStack.pop() * valStack.pop();
                }
                valStack.push(value);
            }else if(c < '9' && c > '0'){
                valStack.push(c - '0');
            }else {
                opStack.push(c);
            }

        }
        System.out.println(valStack.pop());
    }
}
