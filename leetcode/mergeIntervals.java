//but it is not, so
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
        ArrayList<Interval> res = new ArrayList<Interval>();
        if(intervals == null || intervals.size() == 0)
            return res;
        
        Collections.sort(intervals, new Comparator<Interval>(){public int compare(Interval a, Interval b){return a.start>b.start?1:(a.start==b.start?0:-1);}});
        
        int i=0;
        while(i < intervals.size()){
            int start = intervals.get(i).start;
            Interval tmp = new Interval(intervals.get(i).start, intervals.get(i).end);
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
        ArrayList<Interval> res = new ArrayList<Interval>();
        if(intervals==null || intervals.size()==0) return res;
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.start>b.start?1:(a.start==b.start?0:-1);
            }
        });
        int i = 0;
        while(i < intervals.size()){
            Interval tmp = intervals.get(i);
            while(i+1<intervals.size() && tmp.end>=intervals.get(i+1).start){
                tmp.end = Math.max(tmp.end, intervals.get(i+1).end);
                i++;
            }
            res.add(tmp);
            i++;
        }
        return res;
    }
}









Collections.sort(intervals, new Comparater<Interval>{public int compare(Interval a, Interval b){return a.start>b.start?1:(a.start==b.start?0:-1)}});


















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
        int len = intervals.size();
        ArrayList<Interval> re = new ArrayList<Interval>();
        if(len==0) return re;
        Collections.sort(intervals, Int_compare);
        Interval travel = intervals.get(0);
        if(len==1){
            re.add(travel);
            return re;
        }

        for(int i=1; i<len; i++){
            Interval temp = intervals.get(i);
            if(temp.end<travel.start || temp.start > travel.end){
                re.add(travel);
                travel = temp;
            }
            else{
                travel.start = Math.min(travel.start, temp.start);
                travel.end = Math.max(travel.end, temp.end);

            }
        }
        
        re.add(travel);
        return re;
    }
    
    static final Comparator<Interval> Int_compare = new Comparator<Interval>(){
		public int compare(Interval i, Interval j){
			return new Integer(i.start).compareTo(new Integer(j.start));
		}
	};	
}