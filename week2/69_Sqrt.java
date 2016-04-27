public class Sqrt {
    public int mySqrt(int x) {
        long start = 1;
        long end = x;
        long mid;
        if (x == 0) {
            return 0;
        }
        while (start < end - 1) {
            mid = start + (end - start) / 2;
            long mm = mid * mid;
            if (mm == x) {
                return (int)mid;
            } else if (mm < x) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (end * end > x) {
            return (int)start;
        } else {
            return (int)end;
        }
    }
}