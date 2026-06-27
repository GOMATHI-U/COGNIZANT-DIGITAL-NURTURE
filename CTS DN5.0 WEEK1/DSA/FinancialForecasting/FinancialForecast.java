// Future value formula FV(n) = FV(n-1) * (r+1); 

public class FinancialForecast {

    public static double futureValue(double principal, double rate, int years) {
        if (years == 0) {
            return principal;
        }

        return futureValue(principal, rate, years - 1) * (rate + 1);
    }

    public static void main(String args[]) {
        double principal = 10000;
        double rate = 0.10;
        int years = 5;

        double result = futureValue(principal, rate, years);

        System.out.printf("Future Value : %.2f", result);
    }
}