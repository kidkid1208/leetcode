import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 输入：[["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * 输出：["JFK", "MUC", "LHR", "SFO", "SJC"]
 *
 * @author lizehui
 * @date 2021/5/8 15:08
 */
public class Leetcode332 {
    private List<String> result = new ArrayList<>();

    private List<List<String>> tickets;

    private boolean[] used;

    public List<String> findItinerary(List<List<String>> tickets) {
        used = new boolean[tickets.size()];
        tickets.sort(Comparator.comparing(o -> o.get(1)));
        this.tickets = tickets;
        result.add("JFK");
        tracing("JFK");
        return result;
    }

    private void tracing(String from) {
        if (result.size() == tickets.size() + 1) {
            return;
        }
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).get(0).equals(from) && !used[i]) {
                List<String> ticket = tickets.get(i);
                String to = ticket.get(1);
                used[i] = true;
                result.add(to);
                tracing(to);
                if (result.size() == tickets.size() + 1) {
                    return;
                }
                used[i] = false;
                result.remove(result.size() - 1);
            }
        }
    }
}
