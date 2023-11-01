public class Palindrome {
    public boolean isPalindrome(int x) {
        int reversed = 0;

        while(x != 0){
            int digit = x % 10;
            x /= 10;
            reversed = reversed * 10 + digit;
        }

        return reversed != x;

    }
}
