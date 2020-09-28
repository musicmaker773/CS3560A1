public class MCQuestion implements Question {

    private String question;
    private String answer;
    private String answerRange;

    public MCQuestion(String q, String a, String ar) {
        question = q;
        answer = a;
        answerRange = ar;

    }

    public String getQuestion(){
        return question;
    }

    public String getAnswer(){
        return answer;
    }

    public String getAnswerRange() {
        return answerRange;
    }

    public String printAnswerRange(){

       String stringReturn = "";

       for(int i = 0; i < answerRange.length(); i++) {
           stringReturn = stringReturn + answerRange.charAt(i) + " ";
       }
       return stringReturn;

    }

    @Override
    public boolean isSingle() {
        return false;
    }
}
