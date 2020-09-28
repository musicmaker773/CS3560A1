public interface Participant {


    // puts in the answer that student answered with
    public void setAnswer(String ans);

    // returns a string of student ID
    public String getID();

    // returns a string of that student's particular answer
    public String getAnswer();

    // changes the status of the student to answered
    public void hasAnswered();

    // checks if the student has answered or not
    public boolean answerStatus();
}
