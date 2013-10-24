//找到合适位置，插入，然后merge
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
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Interval> res = new ArrayList<Interval>();
        if(intervals==null || intervals.size() == 0){
            intervals.add(newInterval);
            return intervals;
        }
        if(newInterval == null)
            return intervals;
        
        for(int i=0; i<intervals.size(); i++){
            if(newInterval.start < intervals.get(i).start){
                intervals.add(i, newInterval);
                break;
            }
            else if(i == intervals.size()-1){
                intervals.add(newInterval);
                break;
            }
        }
        
        int i=0;
        while(i < intervals.size()){
            Interval tmp = intervals.get(i);
            while(i+1<intervals.size() && tmp.end>=intervals.get(i+1).start){
                tmp.end = Math.max(tmp.end, intervals.get(i+1).end);
                i++;
            }
            //if(tmp.start == start)
            res.add(tmp);
            i++;
        }
        
        return res;
    }
}


//懒人方法，仅仅在merge的基础上加了一位
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
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Interval> res = new ArrayList<Interval>();
        intervals.add(newInterval);
        if(intervals == null || intervals.size() == 0)
            return intervals;
        Collections.sort(intervals, new Comparator<Interval>(){public int compare(Interval a, Interval b){return a.start>b.start?1:(a.start==b.start?0:-1);}});
        int i = 0;
        while(i < intervals.size()){
            int start = intervals.get(i).start;
            Interval tmp = intervals.get(i);
            while(i+1 < intervals.size() && tmp.end >= intervals.get(i+1).start){
                tmp.end = Math.max(tmp.end, intervals.get(i+1).end);
                i++;
            }
            if(tmp.start == start)
                res.add(tmp);
            i++;
        }
        return res;
    }
}