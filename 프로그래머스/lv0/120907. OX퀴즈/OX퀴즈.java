class Solution {
    public String[] solution(String[] quiz) {
        for(int i=0; i<quiz.length; i++){
            String[] text = quiz[i].split(" ");
            if(Integer.parseInt(text[0]) + ( Integer.parseInt(text[2]) * ( text[1].equals("+") ? 1:-1) ) == Integer.parseInt(text[4])) quiz[i] = "O";
            else quiz[i] = "X";
        }
        return quiz;
    }
}