public class Solution {
    public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        LinkedList<Integer> index=new LinkedList<Integer>();
        int[] width=new int[height.length];
        int max=0;
        for(int i=0;i<height.length;i++)
        {
            if(index.isEmpty()||height[i]>height[index.getLast()])
            {
                index.addLast(i);
                width[i]=1;
            }
            else if(height[i]<height[index.getLast()])
            {
                int w=1;
                while(!index.isEmpty()&&height[i]<height[index.getLast()])
                {
                	int in=index.removeLast();
                	int l=height[in];
                		//System.out.println("i: "+i+" in: "+in+" wid "+width[in]);
                	int wi=i-in+width[in]-1;
                	System.out.println("l:"+l+"  w:"+wi);
                    max=Math.max(max,l*wi);
                    w++;
                }
                index.addLast(i);
                width[i]=w;
            }
            
        }
        
//        for(int i:width)
//        {
//        	System.out.println(i);
//        }
        System.out.println(index);
        while(index.size()>1)
        {
            int i=height[index.removeLast()];
            int w=height.length-index.getLast()-1;
            System.out.println("i:"+i+"  w:"+w);
            max=Math.max(max,i*w);
        }
        
        max=Math.max(max,height[index.removeLast()]*height.length);
        
        return max;
    }
}


public class Solution {
public int largestRectangleArea(int[] height) {
    LinkedList<Integer> stack = new LinkedList<Integer>();
    int[] width = new int[height.length];
    int ret=0;
    int i=0;
    while (i<height.length) {
        if (stack.isEmpty() || height[i]>height[stack.getLast()]) {
            stack.addLast(i);
            //System.out.println(stack);
            width[i]=1;
        } else if (height[i]<height[stack.getLast()]) {
            int len=0;
            int ind = i;
            while (!stack.isEmpty() && height[i]<=height[stack.getLast()]) {
                ind = stack.removeLast();
                len = i-ind-1+width[ind];//this is the key
                ret = Math.max(ret, len*height[ind]);
            }
            stack.addLast(i);
            width[i]=i-ind+width[ind];// this is also key
        }
        i++;
    }
    
//    for(int k:width)
//    {System.out.print("  "+k);}
    
    //System.out.println(stack);
    
    int len = 0;
    while (!stack.isEmpty()) {
        int ind = stack.removeLast();
        System.out.println(i);
        len = i-ind-1+width[ind];
        ret = Math.max(ret,len*height[ind]);
    }
    return ret;
}
}


public class Solution {
    public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        LinkedList<Integer> stack=new LinkedList<Integer>();
        
        stack.addLast(-1);
        int max=0;
        for(int i=0;i<height.length;i++)
        {
            if(stack.size()==1||height[i]>height[stack.getLast()])
            {
                stack.addLast(i);
            }
            else if(height[i]<height[stack.getLast()])
            {
                while(stack.size()!=1&&height[i]<height[stack.getLast()])
                {
                    int index=stack.removeLast();
                    //System.out.println("height:"+height[index]+"  wid: "+(i-stack.getLast()-1));
                    max=Math.max(max,(i-stack.getLast()-1)*height[index]);
                }
                stack.addLast(i);
            }
        }
        
        while(stack.size()!=1)
        {
            int index=stack.removeLast();
            //System.out.println("height:"+height[index]+"  wid: "+(height.length-stack.getLast()-1));
            max=Math.max(max,(height.length-1-stack.getLast())*height[index]);
        }
        return max;
    }
}

