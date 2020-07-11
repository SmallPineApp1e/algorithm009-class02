import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Zeng
 * @date 2020/7/11 8:28
 */
public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{};
        }
        // 将每个区间升序排序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        List<int[]> res = new ArrayList<>();
        int[] newInterval = intervals[0];
        res.add(intervals[0]);
        for (int[] interval : intervals) {
            if (interval[0] > newInterval[1]) {
                res.add(interval);
                newInterval = interval;
            } else {
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }
        return res.toArray(new int[][]{});
    }

    public static void main(String[] args) {

    }

}
