class Solution {
    public String[] solution(String[] quiz) {
        for(int i=0; i<quiz.length; i++) {
            String[] str = quiz[i].split(" ");
            int op = 1;
            if(str[1].equals("-")) op = -1;
            quiz[i] = "O";
            if(Integer.parseInt(str[0])+Integer.parseInt(str[2])*op != Integer.parseInt(str[4])) quiz[i] = "X";
        }
        
        return quiz;
    }
}