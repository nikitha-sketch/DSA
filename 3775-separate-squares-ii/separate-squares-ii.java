import java.util.*;

class Solution {

    static class Event {
        double y;
        int type; // +1 start, -1 end
        double x1, x2;

        Event(double y, int type, double x1, double x2) {
            this.y = y;
            this.type = type;
            this.x1 = x1;
            this.x2 = x2;
        }
    }

    public double separateSquares(int[][] squares) {

        List<Event> events = new ArrayList<>();

        // Build events
        for (int[] s : squares) {
            double x1 = s[0];
            double y1 = s[1];
            double l  = s[2];
            double x2 = x1 + l;
            double y2 = y1 + l;

            events.add(new Event(y1, +1, x1, x2));
            events.add(new Event(y2, -1, x1, x2));
        }

        // Sort by Y
        events.sort(Comparator.comparingDouble(e -> e.y));

        List<double[]> active = new ArrayList<>();
        double totalArea = 0.0;

        // First pass: compute total union area
        for (int i = 0; i < events.size() - 1; i++) {
            Event e = events.get(i);

            if (e.type == 1) {
                active.add(new double[]{e.x1, e.x2});
            } else {
                remove(active, e.x1, e.x2);
            }

            double dy = events.get(i + 1).y - e.y;
            if (dy > 0) {
                double width = unionWidth(active);
                totalArea += width * dy;
            }
        }

        double target = totalArea / 2.0;

        // Second pass: find split Y
        active.clear();
        double areaSoFar = 0.0;

        for (int i = 0; i < events.size() - 1; i++) {
            Event e = events.get(i);

            if (e.type == 1) {
                active.add(new double[]{e.x1, e.x2});
            } else {
                remove(active, e.x1, e.x2);
            }

            double y1 = e.y;
            double y2 = events.get(i + 1).y;
            double dy = y2 - y1;

            if (dy > 0) {
                double width = unionWidth(active);
                double slabArea = width * dy;

                if (areaSoFar + slabArea >= target) {
                    double need = target - areaSoFar;
                    return y1 + need / width;
                }

                areaSoFar += slabArea;
            }
        }

        return 0.0;
    }

    private void remove(List<double[]> active, double x1, double x2) {
        for (int i = 0; i < active.size(); i++) {
            if (active.get(i)[0] == x1 && active.get(i)[1] == x2) {
                active.remove(i);
                return;
            }
        }
    }

    private double unionWidth(List<double[]> intervals) {
        if (intervals.isEmpty()) return 0.0;

        intervals.sort(Comparator.comparingDouble(a -> a[0]));

        double total = 0.0;
        double start = intervals.get(0)[0];
        double end   = intervals.get(0)[1];

        for (int i = 1; i < intervals.size(); i++) {
            double s = intervals.get(i)[0];
            double e = intervals.get(i)[1];

            if (s > end) {
                total += end - start;
                start = s;
                end = e;
            } else {
                end = Math.max(end, e);
            }
        }

        total += end - start;
        return total;
    }
}
