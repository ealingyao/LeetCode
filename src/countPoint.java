/**
 * Created by Ealing on 4/1/18.
 */
import java.math.*;
public class countPoint {
    public static int countPoints(int r) {
        if (r < 1) {
            return 1;
        }

        int res = 1+4*r; //points on line
        for (int i = 1; i < r; i++) {
            res += (int) Math.sqrt(r*r-i*i);
        }

        return res;
    }
}
