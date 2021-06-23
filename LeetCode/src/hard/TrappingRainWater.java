package hard;

import java.util.Stack;

public class TrappingRainWater {

    public int trap(int[] height) {

        if(height.length<=1)
            return 0;

        int l = 0;
        int r = height.length-1;

        int leftMax = height[l++];
        int rightMax = height[r--];

        int water = 0;

        while(l<=r){

            if(height[l]>=leftMax)
                leftMax= height[l];

            if(height[r]>=rightMax)
                rightMax=height[r];

            if(leftMax<rightMax){
                water+=(leftMax-height[l]);
                l++;
            }else{
                water+=rightMax-height[r];
                r--;
            }


        }

        return water;
    }

    public int trapStack(int[] height) {

        if(height.length<=1)
            return 0;

        Stack<Integer> stack = new Stack<>();
        int max = height[0];
        stack.push(max);

        int water = 0;

        for(int i=1;i<height.length;i++){

            int h = height[i];

            if(h<max){
                stack.push(h);
            }else{

                while(!stack.isEmpty()){
                    int curr = stack.pop();
                    water+= (max-curr);
                }

                stack.push(h);
                max = h;
            }
        }

        if(!stack.isEmpty()){
            max = stack.pop();
        }

        while(!stack.isEmpty()){
            int h = stack.pop();
            if(h<max){
                water+=(max-h);
            }else{
                max = h;
            }
        }

        return water;


    }



    public int trapStackClean(int[] height) {

        if(height.length<=1)
            return 0;

        Stack<Integer> stack = new Stack<>();
        int curr = 0;
        int water = 0;

        while(curr<height.length){

            while(!stack.isEmpty() && height[curr]>height[stack.peek()] ){

                int top = stack.pop();
                if(stack.isEmpty())
                    break;

                int l = curr - stack.peek() -1;
                int h = Math.min(height[curr], height[stack.peek()]) - height[top];
                water+= l*h;
            }
            stack.push(curr++);

        }

        return water;


    }

}
