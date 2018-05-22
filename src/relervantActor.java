import java.util.*;

/**
 * Created by Ealing on 4/9/18.
 */
public class relervantActor {
    public List<String> findRelervant(List<Movie> list, String actor) {
        List<String> res = new ArrayList<>();
        Map<String, Actor> map = new HashMap<>();

        for (Movie m: list) {
            List<String> aList = m.actorList;
            for (String s: aList) {
                if (!map.containsKey(s)) {
                    map.put(s, new Actor(s));
                }
                map.get(s).movieList.add(m);
            }
        }

        List<Movie> theMovie = map.get(actor).movieList;
        Set<String> visited = new HashSet<>();
        Queue<Actor> queue = new LinkedList<>();

        queue.add(map.get(actor));

        while (!queue.isEmpty()) {
            Actor theActor = queue.remove();
            for (Movie m: theMovie) {
                for (String a: m.actorList) {
                    if (visited.add(a)) {
                        res.add(a);
                        queue.add(map.get(a));
                    }
                }
            }
        }

        return res;
    }

    class Actor {
        String _name;
        List<Movie> movieList = new ArrayList<>();
        public Actor(String name) {
            _name = name;
        }
    }

    class Movie {
        String _movieName;
        List<String> actorList = new ArrayList<>();
        public Movie(String movieName) {
            _movieName = movieName;
        }
    }
}
