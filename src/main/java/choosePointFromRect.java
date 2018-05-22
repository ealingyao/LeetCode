/**
 * Created by Ealing on 4/1/18.
 */
import com.sun.org.apache.regexp.internal.RE;

import java.util.*;

public class choosePointFromRect {
    public Node randomChoose(List<Rect> list) {
        List<Integer> areaList = calArea(list);
        int total = areaList.get(areaList.size()-1);

        int ran = (int)(Math.random()*total+1); //[1,total]
        int count = 0;
        int index = 0;
        for (int i = 0; i < areaList.size(); i++) {
            if (count + areaList.get(i) >= total) {
                index = i;
                break;
            }
            count += areaList.get(i);
        }

        Rect theOne = list.get(index);
        int row1 = theOne.r1.y;
        int row2 = theOne.r2.y;
        int col1 = theOne.l1.x;
        int col2 = theOne.r1.x;

        int posX = (int)(Math.random()*(col2-col1+1)+col1);
        int posY = (int)(Math.random()*(row2-row1+1)+row1);

        return new Node(posX, posY);
    }

    private List<Integer> calArea(List<Rect> list) {
        List<Integer> res = new ArrayList<>();
        int total = 0;
        for (Rect rect: list) {
            int area = (rect.r1.x-rect.l2.x)*(rect.r1.y-rect.l2.y);
            res.add(area);
            total += area;
        }

        res.add(total);
        return res;
    }

    class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    class Rect {
        Node l1;
        Node l2;
        Node r1;
        Node r2;
        public Rect (Node l1, Node l2, Node r1, Node r2) {
            this.l1 = l1;
            this.l2 = l2;
            this.r1 = r1;
            this.r2 = r2;
        }
    }
}
