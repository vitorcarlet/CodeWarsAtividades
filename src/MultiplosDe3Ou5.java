public class MultiplosDe3Ou5{
    public static int calculateMultiplesSum(int number) {
        if (number < 0) {
            return 0;
        }

        int sum = 0;
        for (int i = 0; i < number; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int number = 10;
        int multiplesSum = calculateMultiplesSum(number);
        System.out.println("The sum of multiples of 3 or 5 below " + number + " is: " + multiplesSum);
    }
}
