class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    
        Map<Integer, Integer> nextGreater = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();

        for(int num : nums2){
            while(!stack.isEmpty() && num > stack.peek()){
                nextGreater.put(stack.peek(), num);
                stack.pop();
            }
            stack.push(num);
        }
        
        int[] answer = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
           answer[i] = nextGreater.getOrDefault(nums1[i], -1);
        }
        return answer;
    }
}

