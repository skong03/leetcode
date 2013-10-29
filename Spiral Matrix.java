public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<Integer> res=new ArrayList<Integer>();
        if(matrix.length==0)
            return res;
        int left=0,right=matrix[0].length-1;
        int up=0,down=matrix.length-1;
        while(true){
            for(int i=left;i<=right;i++)
                res.add(matrix[up][i]);
            if(++up>down)   break;
            
            for(int i=up;i<=down;i++)
                res.add(matrix[i][right]);
            if(--right<left)    break;
        
            for(int i=right;i>=left;i--)
                res.add(matrix[down][i]);
            if(--down<up)   break;
        
            for(int i=down;i>=up;i--)
                res.add(matrix[i][left]);
            if(++left>right)    break;
        }
        return res;
    }
}