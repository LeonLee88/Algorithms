package problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by leon on 7/8/17.
 */
public class CourseSchedule3 {
    public int scheduleCourse(int[][] courses) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(b[0], a[0]);
            }
        });
        Arrays.sort(courses, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        });
        int max = 0;
        int timeUsed=0;
        int curDue=0;
        for(int[] course : courses) {
            if(course[0] <= course[1]) {
                if(timeUsed + course[0] <= course[1]) {
                    timeUsed = course[0] + timeUsed;
                    curDue = course[1];
                    queue.offer(course);
                    max++;
                } else {

                    int[] longestCourse = queue.peek();
                    if(longestCourse[0] >= course[0]) {
                        timeUsed = timeUsed - longestCourse[0] + course[0];
                        curDue = course[1];
                        queue.poll();
                        queue.offer(course);
                    }
                }
            }
        }
        return max;
    }
}
