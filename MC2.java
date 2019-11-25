import java.util.Random;

public class MC2 {
    double allRands[] = new double[110000];

    public static double getRan(int n) {

        double x = 1000;
        double u = 0;
        double a = 24693;
        double c = 3517;
        double K = Math.pow(2, 17);
        for (int i = 0; i < n; i++) {
            x = (a * x + c) % K;
            u = x / K;
        }
        return u;
    }

    public static double getX(int n) {
        return Math.sqrt(-6498 * Math.log(1 - getRan(n)));
    }

    public static double get110Avg(int n) {
        Random r = new Random();

        double megaAvg = 0;
        System.out.println("Values for n = " + n);
        for (int i = 0; i < 110; i++) {
            double avg = 0;
            for (int j = 0; j < n; j++) {
                avg += getX(r.nextInt(n));
            }
            avg = avg / n;
            System.out.print(avg + ", ");
            megaAvg += avg;

        }
        System.out.println();
        System.out.println();
        System.out.println();

        megaAvg = megaAvg / 110;

        return megaAvg;
    }

    public void genAll() {
        for (int i = 0; i < allRands.length; i++) {
            allRands[i] = getRan(i);
        }
    }

    public double getAvg(double a[]) {
        double sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum / a.length;
    }

    public static void main(String[] args) {
        System.out.println("U51: " + getRan(51));
        System.out.println("U52: " + getRan(52));
        System.out.println("U53: " + getRan(53));

        System.out.println("AVG for n = 10: " + get110Avg(10));
        System.out.println("AVG for n = 30: " + get110Avg(30));
        System.out.println("AVG for n = 50: " + get110Avg(50));
        System.out.println("AVG for n = 100: " + get110Avg(100));
        System.out.println("AVG for n = 150: " + get110Avg(150));
        System.out.println("AVG for n = 250: " + get110Avg(250));
        System.out.println("AVG for n = 500: " + get110Avg(500));
        System.out.println("AVG for n = 1000: " + get110Avg(1000));

    }
}