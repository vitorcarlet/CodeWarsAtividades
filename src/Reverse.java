public class Reverse {

//
//    public static String reverseWords(String input){
//        if (input == null || input.isEmpty()) {
//            return input;
//        }
//
//        StringBuilderAtividade reversedString = new StringBuilderAtividade();
//        StringBuilderAtividade wordBuilder = new StringBuilderAtividade();
//
//        for (int i = 0; i < input.length(); i++) {
//            char c = input.charAt(i);
//
//            if (Character.isLetterOrDigit(c)) {
//                wordBuilder.append(c);
//            } else {
//                if (wordBuilder.length() > 0) {
//                    reversedString.append(wordBuilder.reverse());
//                    wordBuilder.setLength(0);
//                }
//                reversedString.append(c);
//            }
//        }
//
//        if (wordBuilder.length() > 0) {
//            reversedString.append(wordBuilder.reverse());
//        }
//
//        return reversedString.toString();
//    }
//
//    public static void main(String[] args) {
//
//
//        String input = "Hello Banana Milk";
//        String reversed = reverseWords(input);
//        System.out.println(reversed);
//         reversed =  Reverse.reverseWords("The quick brown fox jumps over the lazy dog.");
//        System.out.println(reversed);
//         reversed =  Reverse.reverseWords("apple");
//        System.out.println(reversed);
//         reversed = Reverse.reverseWords("a b c d");
//        System.out.println(reversed);
//         reversed =  Reverse.reverseWords("double  spaced  words");
//        System.out.println(reversed);
//
//    }
}


