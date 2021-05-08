import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author lizehui
 * @date 2021/4/8 16:11
 */
public class Leetcode347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[k];
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        map.forEach((key, v) -> queue.add(new int[]{key, v}));
        for (int i = 0; i <k ; i++) {
            res[i] = queue.poll()[0];
        }
        return res;
    }
}
