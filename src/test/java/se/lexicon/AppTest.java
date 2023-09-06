package se.lexicon;


public class AppTest {

    public static void main(String[] args) {
        String name1 = "Anna";      // Palindrome
        String name2 = "John";      // Not a palindrome
        String name3 = "radar";     // Palindrome

        System.out.println(name1 + " is a palindrome: " + isPalindrome(name1));
        System.out.println(name2 + " is a palindrome: " + isPalindrome(name2));
        System.out.println(name3 + " is a palindrome: " + isPalindrome(name3));
    }

    private static boolean isPalindrome(String str) {
        String cleanStr = str.replaceAll("\\s+", "").toLowerCase();
        int length = cleanStr.length();
        for (int i = 0; i < length / 2; i++) {
            if (cleanStr.charAt(i) != cleanStr.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

}
