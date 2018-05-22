/**
 * Created by Ealing on 3/26/18.
 */
public class Pownx {
    public double myPow(double x, int n) {
        if (n < 0) {
            return (1/x)*myPow(1/x, -(n+1));
        } else if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        } else if (n == 2) {
            return x*x;
        } else if (n%2 == 0) {
            return myPow(myPow(x, n/2), 2);
        } else {
            return x*myPow(myPow(x, n/2), 2);
        }
    }
}
