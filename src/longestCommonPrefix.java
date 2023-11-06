public class longestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }

        String prefix = strs[0];

        for(int i = 1; i<strs.length; i++){
            while(strs[i].indexOf(prefix) != 0){ //significa que o prefixo não corresponde ao início da string strs[i]
                prefix = prefix.substring(0,prefix.length() - 1);
                if(prefix.isEmpty()){
                    return "";
                }
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] example = {"flower","flow","flight"};
        String haha = longestCommonPrefix(example);
        System.out.println(haha); // Output: "fl"
    }

    }

