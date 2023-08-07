import java.util.Arrays;
import java.util.Stack;

class stockSpanHelper {
    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] stockSpans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[i] >= prices[stack.peek()]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                stockSpans[i] = i - stack.peek();
            } else {
                stockSpans[i] = i + 1;
            }
            stack.push(i);
        }

        return stockSpans;
    }
}

public class stockSpanProblem {
    public static void main(String[] args) {
        int[] stockPrices = { 200, 300, 400, 500, 600 };
        int[] stockSpans = stockSpanHelper.calculateSpan(stockPrices);
        System.out.println("Stock Spans: " + Arrays.toString(stockSpans));
    }
}