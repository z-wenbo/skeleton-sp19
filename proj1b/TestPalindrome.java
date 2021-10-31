import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator offbyone = new OffByOne();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testisPalindrome(){
        String t1 = "";
        assertTrue(palindrome.isPalindrome(t1));
        String t2 = "a";
        assertTrue(palindrome.isPalindrome(t2));
        String t3 = "acccs";
        assertFalse(palindrome.isPalindrome(t3));
        String t4 = "asdfdsa";
        assertTrue(palindrome.isPalindrome(t4));
    }

    //test isPalindrome with comparator as parameter
    @Test
    public void testisPalindrome1(){
        String t1 = "flake";
        assertTrue(palindrome.isPalindrome(t1,offbyone));

    }

}