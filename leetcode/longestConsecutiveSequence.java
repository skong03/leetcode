//Õý½â
public class Solution {
    public int longestConsecutive(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num==null || num.length==0) return 0;
        int cnt = 0, res = 0;
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i=0; i<num.length; i++)
            hs.add(num[i]);
        for(int i=0; i<num.length; i++){
            int tmp = num[i];
            cnt = 0;
            while(hs.contains(tmp)){
                hs.remove(tmp);
                cnt++;
                res = Math.max(cnt, res);
                tmp++;
            }
            tmp = num[i]-1;
            while(hs.contains(tmp)){
                hs.remove(tmp);
                cnt++;
                res = Math.max(cnt, res);
                tmp--;
            }
        }
        return res;
    }
}




public class Solution {
    public int longestConsecutive(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num==null || num.length==0) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i=0; i<num.length; i++)
            pq.add(num[i]);
        int pre = pq.peek()-1, cnt = 0, res = 0;
        while(!pq.isEmpty()){
            int cur = pq.poll();
            if(pre == cur) continue;
            cnt = ((cur-pre)==1)?cnt+1:1;
            res = Math.max(res, cnt);
            pre = cur;
        }
        return res;
    }
}




public class Solution {
    public int longestConsecutive(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num.length <= 1)
            return num.length;
        
        Arrays.sort(num);
        
        int max = 1;
        int res = 1;
        for(int i=0; i<num.length; i++){
            if(i > 0){
                if(num[i] == num[i-1] + 1)
                    max++;
                else if(num[i] == num[i-1])
                    continue;
                else
                    max = 1;
            }
            res = Math.max(max, res);
        }
        
        return res;
    }
}