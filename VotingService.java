import java.util.ArrayList;


public class VotingService {

    private String question;
    private String answer;
    private  String answerRange;
    private boolean isSingle;

    private ArrayList<String> students = new ArrayList<>();
    private ArrayList<String> answers = new ArrayList<>();


    // created an object that takes every choice and keep count of how many times that particular choice was
    // chosen based on the students's answers
    class answerCount {

        private int count = 0;
        private String choice;

        public answerCount(String ch){
            choice = ch;
        }

        public void increment(){
            count++;
        }
        public int getCount() {
            return count;
        }
        public String getChoice(){
            return choice;
        }

    }
    answerCount[] ac;


    public VotingService(Question q) {
        question = q.getQuestion();
        answer = q.getAnswer();
        answerRange = q.getAnswerRange();
        isSingle = q.isSingle();

        ac = new answerCount[answerRange.length()];

        for(int i = 0; i < answerRange.length(); i++) {
            ac[i] = new answerCount("" + answerRange.charAt(i));
        }
    }

    // takes what the student answered with and inputs the student's name and answer to respective Array List
    public void receiveStudentAnswer(Student student) {

        // if student changes answer, take name and original answer out of Array Lists
        if(student.answerStatus()) {
            int temp = students.indexOf(student.getID());
            answers.remove(temp);
            students.remove(student.getID());

            System.out.println(student.getID() + " changed their answer.");
        }
        students.add(student.getID());
        answers.add(student.getAnswer());

        if(!student.answerStatus()) {
            System.out.println(student.getID() + " chose their answer.");

            student.hasAnswered();
        }
        System.out.println();

    }

    // prints all of the student's name, answer, and whether if they go the answer right or not
    public void printStudentAnswerStatus() {

        if(isSingle) {
            for(int i = 0; i < students.size(); i++) {
                System.out.println("Student : " + students.get(i));
                System.out.println("Answer: " + answers.get(i));
                if(answers.get(i).equals(answer)){
                    System.out.println("That answer was correct!");
                }
                else {
                    System.out.println("That answer was not correct!");
                }
                System.out.println();
            }

        }
        else {

            for(int i = 0; i < answers.size(); i++) {
                int right = 0;
                int wrong = 0;

                System.out.println("Student : " + students.get(i));

                System.out.print("Answers: ");

                for(int j = 0; j < answers.get(i).length(); j++) {

                    System.out.print(answers.get(i).charAt(j) + " ");
                    for(int k = 0; k < answer.length(); k++) {
                        String tempS = "" + answer.charAt(k);
                        if(tempS.equals("" + answers.get(i).charAt(j))) {
                            right++;
                            break;
                        }
                        if (k == answer.length() - 1) {
                            wrong++;
                        }
                    }
                }
                System.out.println();

                if(right > 0 && wrong == 0) {
                    if(right < answer.length()) {
                        System.out.println("You got some of the answers right!");
                    }
                    else {
                        System.out.println("You got all of the answers right!");
                    }
                }
                else if (right == 0 && wrong > 0) {
                    System.out.println("You got all of the answers wrong!");
                }
                else if (right > 0 && wrong > 0) {
                    System.out.println("You are partially right and wrong with your answers!");
                }
                else {
                    System.out.println("You didn't answer anything!");
                }
                System.out.println();

            }

        }
        System.out.println();
    }

    // prints the amount of times each choice was chosen based on students's choices
    public void printStatistics() {

        System.out.println("Here is the count for each choice:");

        for(int i = 0; i < ac.length; i++){
            for(int j = 0; j < answers.size(); j++) {
                for(int k = 0; k < answers.get(j).length(); k++) {
                    if(ac[i].getChoice().equals("" + answers.get(j).charAt(k))) {
                        ac[i].increment();
                    }
                }
            }
            System.out.println(ac[i].getChoice() + " : " + ac[i].getCount());
        }



    }

    public boolean isSingle() {
        return isSingle;
    }

    public String getQuestion() {
        return question;
    }
    public String getAnswer() {
        return answer;
    }
    public String printAnswer() {
        String stringReturn = "";

        if(!isSingle()) {
            for (int i = 0; i < answer.length(); i++) {
                stringReturn = stringReturn + answer.charAt(i) + " ";
            }
        }
        else {
            stringReturn = answer;
        }
        return stringReturn;

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


}
