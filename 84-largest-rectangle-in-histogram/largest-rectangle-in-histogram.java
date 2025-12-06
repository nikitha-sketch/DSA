class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer>st=new Stack<>();
        st.push(-1);
        int maxArea=0;

        for(int i=0;i<heights.length;i++){
    // If current bar is smaller than top of stack → pop and calculate area
            while(st.peek()!=-1 && heights[i]<=heights[st.peek()]){
                int height=heights[st.pop()];//height of rectangle
                int width=i-st.peek()-1;   //width
                maxArea=Math.max(maxArea,height*width);
            }
            st.push(i);
        }
        //remaining bars
        while(st.peek()!=-1){
            int height=heights[st.pop()];
            int width=heights.length-st.peek()-1;
            maxArea=Math.max(maxArea,height*width);
        }
        return maxArea;
    }
}