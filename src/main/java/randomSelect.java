import java.util.Random;

/**
 * Created by Ealing on 4/29/18.
 */
public class randomSelect {
    final Random random = new Random();
    public Point selectRect(Rect rect) {
        return new Point(rect.x1+random.nextInt(rect.x2-rect.x1+1), rect.y1-random.nextInt(rect.y1-rect.y2+1));
    }

    public Point selectMulti(Rect[] rects) {
        int select = -1;
        int sum = 0;
        for (int i = 0; i < rects.length; i++) {
            int area = (rects[i].x2-rects[i].x1)*(rects[i].y1-rects[i].y2);
            if (random.nextInt(sum+area) >= area) {
                select = i;
            }
            sum += area;
        }

        return selectRect(rects[select]);
    }

    class Rect {
        int x1;
        int y1;
        int x2;
        int y2;
    }

    class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
