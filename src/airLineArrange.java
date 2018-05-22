/**
 * Created by Ealing on 4/3/18.
 */
import java.util.*;

public class airLineArrange {
    public boolean canArrange(List<Flight> flightList, List<String> place) {
        Collections.sort(flightList, (o1, o2)->((int)(o1.departTime-o2.departTime)));
        Map<String, PriorityQueue<Long>> map = new HashMap<>();

        for (String p: place) {
            if (!map.containsKey(p)) {
                map.put(p, new PriorityQueue<>());
            }
            map.get(p).offer(0L);
        }

        for (Flight flight: flightList) {
            if (!map.containsKey(flight.departPlace)
                    || map.get(flight.departPlace).size() == 0
                    || flight.departTime < map.get(flight.departPlace).peek()) {
                return false;
            }

            if (!map.containsKey(flight.arrPlace)) {
                map.put(flight.arrPlace, new PriorityQueue<>());
            }
            map.get(flight.arrPlace).offer(flight.arrTime);
        }

        return true;
    }

    class Flight {
        String departPlace;
        String arrPlace;
        Long departTime;
        Long arrTime;
        public Flight(String dp, String ap, Long dt, Long at) {
            departPlace = dp;
            arrPlace = ap;
            departTime = dt;
            arrTime = at;
        }
    }
}
