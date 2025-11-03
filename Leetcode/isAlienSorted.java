package Leetcode;
class isAlienSorted{
    public boolean isAlienSorted(String[] words, String order) {
        String word = "";
        for(int i = 0; i < words.length; i++){
            word = word + words[i].charAt(0);
        }
        if((order.substring(0, words.length).equals(word))){
            return true;
        }else{
            return false;
        }
    }
}
