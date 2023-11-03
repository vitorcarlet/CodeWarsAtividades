public class Palindrome {
    public static boolean isPalindrome(int x) {
        int reversed = 0;
        int userInput = x;

        while(x != 0){
            if(x < 0){
                return false;
            }
            int digit = x % 10;
            x /= 10;
            reversed = reversed * 10 + digit;
        }
        System.out.println(reversed+" "+userInput);
        return reversed == userInput;

    }

    public static void main(String[] args) {
    boolean result = isPalindrome(121);
        System.out.println(result);

    }
}
