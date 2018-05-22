/**
 * Created by Ealing on 4/1/18.
 */
import java.util.*;

public class independentInterval {
    public Interval findtheOne(List<Interval> l1, List<Interval> l2) {
        sort(l1);
        sort(l2);

        return new Interval(0,0);
    }

    private void sort(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start == o2.start) {
                    return o1.end-o2.end;
                } else {
                    return o1.start-o2.start;
                }
            }
        });
    }

    class Interval {
        int start;
        int end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
