package yang.java.test;

/**
 * Created by Dev_yang on 2017/4/27.
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(say());
        float y= (float) 3.3;
    }

    private static boolean say() {

        try {
            return false;
        } finally {
            return true;
        }
    }
}
