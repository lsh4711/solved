class Solution {
    public String[] solution(String[] quiz) {
        for(int i=0; i<quiz.length; i++) {
            String[] str = quiz[i].split(" ");
            quiz[i] = (Integer.parseInt(str[0])+Integer.parseInt(str[2])*(str[1].equals("+") ? 1 : -1) == Integer.parseInt(str[4])) ? "O" : "X";
        }
        
        return quiz;
    }
}