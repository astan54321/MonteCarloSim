import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Test {

    public static double getRan(int n) {

        double x = 1000;
        double u = 0;
        double a = 24693;
        double c = 3967;
        double K = Math.pow(2, 15);
        for (int i = 0; i < n; i++) {
            x = (a * x + c) % K;
            u = x / K;
        }
        return u;
    }

    public static double getX(double u) {
        return -12 * Math.log(1 - u);
    }

    public static double getTime(int r) {
        if (r >= 0 && r <= 1) {
            return 10;
        } else if (r >= 2 && r <= 4) {
            return 32;
        } else {
            return 0;
        }
    }

    public static double getMean(ArrayList<Double> trials) {
        double sum = 0;
        for (Double trial : trials) {
            sum += trial;
        }
        return sum / trials.size();
    }

    public static void main(String[] args) {
        ArrayList<Double> trials = new ArrayList<>();
        Random r = new Random();
        int n = 1000;
        for (int i = 0; i < n; i++) {
            // int calls = 0;
            // double time = getTime(r.nextInt(10));
            // if (time == 0) {
            // double inverse = getX(getRan(i));
            // time += inverse < 25 ? 6 + inverse : 32;
            // }
            // if ()
            int calls = 0;
            double time = 0;
            boolean answered = false;
            do {
                double currtime = getTime(r.nextInt(10));
                if (currtime == 0){
                    double inverse = getX(getRan(i));
                    answered = inverse < 25;
                    time += inverse < 25 ? 6 + inverse : 32;
                } else {
                    answered = false;
                } 
                time += currtime;
                calls++;                
            } while (calls < 4 && !answered);
            trials.add(time);
        }
        Collections.sort(trials);

        // MEAN
        System.out.println("MEAN = " + getMean(trials));

        // MEDIANS
        int size = trials.size();
        // Q1 MEDIAN
        double q1median = (trials.get(size / 4) + trials.get(size / 4 - 1)) / 2;
        System.out.println("Q1 = " + q1median);

        // MEDIAN
        double median = (trials.get(size / 2) + trials.get(size / 2 - 1)) / 2;
        System.out.println("MEDIAN = " + median);

        // Q3 MEDIAN
        double q3median = (trials.get(3 * size / 4) + trials.get(3 * size / 4 - 1)) / 2;
        System.out.println("Q3 = " + q3median);

        System.out.println("MAX = " + Collections.max(trials));

        int sum = 0;
        double w1, w2, w3, w4, w5, w6, w7;
        w1 = w2 = w3 = w4 = w5 = w6 = w7 = 0;
        for (int i = 0; i < trials.size(); i++) {
            sum += trials.get(i);
            if (trials.get(i) <= 15)
                w1++;
            if (trials.get(i) <= 20)
                w2++;
            if (trials.get(i) <= 30)
                w3++;
            if (trials.get(i) > 40)
                w4++;
            if (trials.get(i) > 50)
                w5++;
            if (trials.get(i) > 75)
                w6++;
            if (trials.get(i) > 100)
                w7++;
            // System.out.println("P[W <= 15] = " + sum / );
        }
        System.out.println("P[W <= 15] = " + w1 / 1000);
        System.out.println("P[W <= 20] = " + w2 / 1000);
        System.out.println("P[W <= 30] = " + w3 / 1000);
        System.out.println("P[W > 40] = " + w4 / 1000);
        System.out.println("P[W > 50] = " + w5 / 1000);
        System.out.println("P[W > 75] = " + w6 / 1000);
        System.out.println("P[W > 100] = " + w7 / 1000);

        // System.out.println(trials);
    }
}