public class Student implements Participant {
    private String id;
    private String answer = "";
    private boolean answered;

    public Student(String ID) {

        id = ID;
        answered = false;
    }

    public void setAnswer(String ans) {
        answer = ans;
    }

    public String getID() {
        return id;
    }

    public String getAnswer() { return answer; }

    public void hasAnswered() {
        answered = true;
    }

    public boolean answerStatus() {
        return answered;
    }
    
}
