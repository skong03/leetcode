/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    class Com implements Comparator<Interval>{
        public int compare(Interval o1, Interval o2) {
            return o1.start - o2.start;
        }
    }
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // Start typing your Java solution below
        // DO NOT write main() function
         ArrayList<Interval> rs =new ArrayList<Interval>();
       Collections.sort(intervals, new Com());
       int i =0;
        while( i< intervals.size())
        {
            //System.out.print(i);
            Interval current= intervals.get(i);
            
            int end =current.end;
            int j=i+1;
            while( j<intervals.size()&&intervals.get(j).start<=end)
            {
                end=Math.max(end, intervals.get(j).end);
                j++;
            }
            current.end=end;
            i=j;
            //System.out.print("("+current.start+" "+current.end+")");
            rs.add(current);
        }
        return rs;
    }
}

public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<Interval> res=new ArrayList<Interval>();
        if(intervals.isEmpty())
            return res;
        Comparator<Interval> com=new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start-i2.start;
            }
        };
        Collections.sort(intervals,com);
        
        int start=intervals.get(0).start;
        int end=intervals.get(0).end;
        
        for(int i=1;i<intervals.size();i++){
            Interval temp=intervals.get(i);
            if(temp.start<=end){
                end=Math.max(end,temp.end);
            }else{
                Interval tempi=new Interval(start,end);
                res.add(tempi);
                start=temp.start;
                end=temp.end;
            }
        }
        Interval tempi=new Interval(start,end);
        res.add(tempi);
        return res;
    }
}



/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Comparator<Interval> com= new Comparator<Interval>(){
            @Override
            public int compare(Interval o1, Interval o2){
                if(o1.start>o2.start)
                    return 1;
                else if(o1.start<o2.start)
                    return -1;
                else return 0;
            }
        };
        
        Collections.sort(intervals, com);
        ArrayList<Interval> res=new ArrayList<Interval>();
        
        for(int i=0;i< intervals.size();i++)
        {
            int start=intervals.get(i).start;
            int end=intervals.get(i).end;
            
            int j=i+1;
            while(j< intervals.size()&& intervals.get(j).start<=end )
            {
                end=Math.max(end, intervals.get(j).end);
                j++;
            }
            
            i=j-1;
            res.add(new Interval(start,end));
        }
        
        return res;
    }
}