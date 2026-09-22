class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();
        int opsLength = operations.length;
        int sum = 0;

        for (int i = 0; i < opsLength; i++) {
            String op = operations[i];

            if (op.equals("+")) {
                // + : Pop last 2, add them, push back addends and answer
                int addendPop = stack.pop();
                int addendPeek = stack.peek();
                stack.push(addendPop);
                stack.push(addendPop + addendPeek);
            } else if (op.equals("D")) {
                // D : peek last number, double it, push answer
                stack.push(stack.peek() * 2);
            } else if (op.equals("C")) {
                // C : pop the last number
                stack.pop();
            } else {
                stack.push(Integer.parseInt(op));
            }
        }

        // Add up the stack
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}