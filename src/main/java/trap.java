/**
 * Created by Ealing on 4/10/18.
 */
public class trap {
    public static int trapWater(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int res = 0;
        int left = 0;
        int right = height.length-1;

        while (left < right && height[left] <= height[left+1]) {
            left++;
        }

        while (left < right && height[right] <= height[right-1]) {
            right--;
        }

        while (left < right) {
            int valL = height[left];
            int valR = height[right];

            if (valL < valR) {
                while (left < right && valL >= height[++left]) {
                    res += valL-height[left];
                }
            } else {
                while (left < right && valR >= height[--right]) {
                    res += valR-height[right];
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] test = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.print(trapWater(test));
    }
}
