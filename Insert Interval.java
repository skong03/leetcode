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
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        intervals.add(newInterval);
        return merge(intervals);
    }
    
    public ArrayList<Interval> merge(ArrayList<Interval> intervals){
        Comparator<Interval> com=new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start-i2.start;
            }
        };
	Collections.sort(intervals,com);
        ArrayList<Interval> res=new ArrayList<Interval>();
        int i=0;
        while(i<intervals.size()){
            Interval temp=intervals.get(i);
            int start=temp.start;
            int end=temp.end;
            int j=i+1;
            while(j<intervals.size()&&intervals.get(j).start<=end){
                end=Math.max(end, intervals.get(j).end);
                j++;
            }
            res.add(new Interval(start,end));
            i=j;
        }
        return res;
    }
}