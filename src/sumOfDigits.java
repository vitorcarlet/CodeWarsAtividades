public class sumOfDigits {


    public static int sumDigits(int number){
         return sumDigits(number, 0);
    }
    public static int sumDigits(int number, int accumulatedSum) {
        int exp = 1;

        while (exp <= number) {
            accumulatedSum += (number / exp) % 10;
            exp = exp * 10;
        }

        if (accumulatedSum > 9) {
            return sumDigits(accumulatedSum, 0); // Chamada recursiva com a soma atual e soma acumulada zerada
        }

        return accumulatedSum;
    }

    public static void main(String[] args) {
        int num = 942;
        int teste = sumDigits(num);
        System.out.println("Sum of digits: " + teste);

    }
}
