public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        LinkedListDeque<Character> d = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            d.addLast(word.charAt(i));
        }
        return d;
    }

    private boolean isPalindrome(Deque<Character> d){
        if (d.size() == 0 || d.size() ==1){
            return true;
        }
        if (d.removeFirst() == d.removeLast()){
            return isPalindrome(d);
        } else {
            return  false;
        }
    }

    private boolean isPalindrome(Deque<Character> d, CharacterComparator c){
        if (d.size() == 0 || d.size() ==1){
            return true;
        }
        if (c.equalChars(d.removeFirst(), d.removeLast())){
            return isPalindrome(d, c);
        } else {
            return  false;
        }
    }

    public boolean isPalindrome(String word){
        Palindrome p = new Palindrome();
        Deque<Character> d = p.wordToDeque(word);
        return isPalindrome(d);
    }
    public boolean isPalindrome(String word, CharacterComparator cc){
        Palindrome p = new Palindrome();
        Deque<Character> d = p.wordToDeque(word);
        return isPalindrome(d, cc);
    }
}
