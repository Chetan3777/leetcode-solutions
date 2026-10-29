class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Arrays.fill(answer, 0);

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; i++){
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int days = i - stack.peek();
                answer[stack.peek()] = days;
                stack.pop();
            }
            stack.push(i);
        }
        return answer;
    }
}