public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
    	ArrayList<Integer> res=new ArrayList<Integer>();
        if(rowIndex==0){
            res.add(1);
            return res;
        }
        
            int[] pre=new int[rowIndex+1];
            int[] next=new int[rowIndex+1];
            
            pre[0]=1;
            for(int i=1;i<=rowIndex;i++){
                
                next[0]=1;
                for(int j=1;j<i;j++){
                    next[j]=pre[j-1]+pre[j];
                }
                next[i]=1;
                pre=next.clone();
            }
            for(int i:pre){
            	res.add(i);
            }
            return res;
        }
}

public ArrayList<Integer> getRow(int rowIndex) {
    ArrayList<Integer> resultList = new ArrayList<Integer>();
    if (rowIndex == 0) {
        resultList.add(1);
        return resultList;
    }
    // Initial
    resultList.add(1);
    resultList.add(1);

    for (int i = 2; i <= rowIndex; i++) {
        resultList.add(1, resultList.get(0) + resultList.get(1));       
        for (int j = 2; j < resultList.size() - 1; j++) {
            resultList.set(j, resultList.get(j) + resultList.get(j + 1));
        }
    }

    return resultList;
}