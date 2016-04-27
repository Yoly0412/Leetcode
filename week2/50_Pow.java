public class Pow {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            double res = myPow(x, -(n + 1)) * x;
            return 1 / res;
        }
        double temp = myPow(x, n / 2);
        double res = temp * temp;
        
        if (n % 2 == 0) {
            return res;
        } else {
            return res * x;
        }
    }
}