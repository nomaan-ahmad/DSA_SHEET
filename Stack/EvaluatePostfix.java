
import java.util.Stack;

public class EvaluatePostfix {
    public static void main(String[] args) {
        String str = "25 7 + 9";
        System.out.println(solve(str));
    }

    private static int solve (String exp) {
        String[] tokens = exp.split(" ");
        Stack<Integer> stk = new Stack<>();

        String operator = "^*/+-";

        for (String t : tokens) {
            int len = t.length();
            if (operator.contains(t)) {
                if (len < 2) return Integer.MIN_VALUE;
                int b = stk.pop();
                int a = stk.pop();

                stk.push(evaluate(t, a, b));
            } else {
                if (len == 1) {
                    stk.push(Integer.parseInt(t));
                } else {
                    int num = 0;
                    for (int j = 0; j < len; j++)
                        num = num * 10 + (t.charAt(j) - '0');

                    stk.push(num);
                }
            }
        }

        return (stk.size()!=1) ? Integer.MIN_VALUE : stk.peek();
    }

    private static int evaluate (String operator, int a, int b) {
        return switch (operator) {
            case "+" -> a + b;
            case "*" -> a * b;
            case "-" -> a - b;
            case "^" -> (int)Math.pow(a,b);
            default -> a / b;
        };
    }
}
