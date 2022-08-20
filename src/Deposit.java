import java.util.Scanner;

public class Deposit {
    public static void main(String[] args) {
        new Deposit().calculateInvestment();
    }

    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        return roundValue(amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod), 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return roundValue(amount + amount * yearRate * depositPeriod, 2);
    }

    double roundValue(double value, int exponent) {
        final double SCALE = Math.pow(10, exponent);

        return Math.round(value * SCALE) / SCALE;
    }

    void calculateInvestment() {
        final Scanner SCANNER = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        final int AMOUNT = SCANNER.nextInt();

        System.out.println("Введите срок вклада в годах:");
        final int PERIOD = SCANNER.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        final int ACTION = SCANNER.nextInt();

        double investment = 0;

        if (ACTION == 1) {
            investment = calculateSimplePercent(AMOUNT, 0.06, PERIOD);
        } else if (ACTION == 2) {
            investment = calculateComplexPercent(AMOUNT, 0.06, PERIOD);
        }

        System.out.println("Результат вклада: " + AMOUNT + " за " + PERIOD + " лет превратятся в " + investment);

        SCANNER.close();
    }


}
