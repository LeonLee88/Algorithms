package problems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * given a list of flight schedule indicating plane departure and arrival time,
 * calculate the most number of airplane on the sky at any given time?
 *
 * given [[1,8],[2,3],[5,8],[4,9]]
 */
public class MostPlane {
//    public int mostPlane (Schedule[] schedules) {
//        Arrays.sort(schedules, new Comparator<Schedule>() {
//            @Override
//            public int compare(Schedule o1, Schedule o2) {
//                if(o1.start == o2.start) {
//                    return Integer.compare(o1.end, o2.end);
//                }
//                return Integer.compare(o1.start, o2.start);
//            }
//        });
//
//
//    }
}

class Schedule {
    int start;
    int end;
}
