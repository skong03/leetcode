public class Solution {
    public int[][] generateMatrix(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[][] matrix=new int[n][n];
        int start=0;
        int end=n-1;
        int num=1;
        
        while(start<end)
        {
            for(int j=start;j<end;j++)
            {
                matrix[start][j]=num;
                num++;
            }
            for(int i=start;i<end;i++)
            {
                matrix[i][end]=num;
                num++;
            }
            for(int j=end;j>start;j--)
            {
                matrix[end][j]=num;
                num++;
            }
            for(int i=end;i>start;i--)
            {
                matrix[i][start]=num;
                num++;
            }
            start++;
            end--;
        }
        
        if(start==end)//if n%2==1, very important, easy to forget
            matrix[start][end]=num;
        return matrix;
    }
}



public class Solution {
    public int[][] generateMatrix(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int count=1;
        int[][] table=new int[n][n];

        for(int i=0;i<n/2;i++){
            for(int j=i;j<n-i-1;j++){
                table[i][j]=count;
                count++;
            }
            for(int j=i;j<n-i-1;j++){
                table[j][n-i-1]=count;
                count++;
            }
            for(int j=i;j<n-i-1;j++){
                table[n-i-1][n-j-1]=count;
                count++;
            }
            for(int j=i;j<n-i-1;j++){
                table[n-j-1][i]=count;
                count++;
            }
        }
        if(n%2==1)
        	table[n/2][n/2]=count;
        return table;
    }
}