class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int n = heights.length;
        int[] heights2 = new int[n + 1];
        for(int i = 0; i < n; ++i) {
            heights2[i] = heights[i];
        }
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < heights2.length; ++i) {
            while(!stack.isEmpty() && heights2[i] < heights2[stack.peek()]) {
                int h = heights2[stack.pop()];
                int w = stack.isEmpty()? i: i - stack.peek() - 1;
                maxArea = Math.max(maxArea, h * w);
            }
            stack.add(i);
        }
        return maxArea;
    }
}
