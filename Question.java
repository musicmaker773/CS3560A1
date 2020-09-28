public interface Question {


    // returns a string of the question
    public String getQuestion();

    // returns a string of the answer
    public String getAnswer();

    // returns a string of the choices
    public String getAnswerRange();

    // returns a string of the choices in an organized manner
    public String printAnswerRange();

    // checks if the question is single choice or otherwise
    public boolean isSingle();

}
