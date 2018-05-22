/**
 * Created by Ealing on 3/31/18.
 */
public class isSameWithBackspace {
    public static boolean isSame(char[] ch1, char[] ch2) {
        int count1 = 0;
        int count2 = 0;

        int index1 = ch1.length-1;
        int index2 = ch2.length-1;

        while (index1 >= 0 && index2 >= 0) {
            while (index1 >= 0 && ch1[index1] == '\b') {
                count1++;
                index1--;
            }

            while (index2 >= 0 && ch2[index2] == '\b') {
                count2++;
                index2--;
            }

            while (index1 >= 0 && count1 > 0) {
                if (ch1[index1] != '\b') {
                    count1--;
                } else {
                    count1++;
                }
                index1--;
            }

            while (index2 >= 0 && count2 > 0) {
                if (ch2[index2] != '\b') {
                    count2--;
                } else {
                    count2++;
                }
                index2--;
            }

            if (index1 < 0 && index2 < 0) {
                return true;
            }

            if (index1 < 0 || index2 < 0) {
                return false;
            }

            if (ch1[index1] != ch2[index2]) {
                return false;
            } else {
                index1--;
                index2--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        char[] ch1 = {'a', 'b', '\b', 'd', 'c'};
//        char[] ch2 = {'a', 'd', 'c'};

//        char[] ch1 = {'a','\b','b','\b','\b','d','c'};
//        char[] ch2 = {'d','c'};

        char[] ch1 = {'\b', 'a','d'};
        char[] ch2 = {'a','d'};

        if (isSame(ch1, ch2)) {
            System.out.print("true");
        } else {
            System.out.print("false");
        }
    }
}
