public class NumerosRomanos {

    public static String intToRoman(int num) {
        if (num <= 0 || num >= 4000) {
            throw new IllegalArgumentException("Number must be between 1 and 3999 (both included)");
        }

        // Define Roman numeral symbols and their corresponding values
        String[] romanNumerals = {
                "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
        };
        int[] values = {
                1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
        };

        StringBuilder romanNumeral = new StringBuilder();
        int i = 0;
        while (num > 0) {
            while (num >= values[i]) {
                romanNumeral.append(romanNumerals[i]);
                num -= values[i];
            }
            i++;
        }

        return romanNumeral.toString();
    }


    public static void main(String[] args) {

    }
}
