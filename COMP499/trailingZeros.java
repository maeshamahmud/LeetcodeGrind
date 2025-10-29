import java.util.*;

public class trailingZeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long zeros = 0;

        for (long p = 5; p <= n; p *= 5) {
            zeros += n / p;
        }

        System.out.println(zeros);
    }
}
