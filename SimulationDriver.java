import java.util.Random;

public class SimulationDriver {



    // My IDE requires me to run main() in a file called Main.
    // This is why I don't have a main() in SimulationDriver.
    // Instead, I'm running it in simulation() and calling it in main() in Main file.
    public void simulation() {

        Random rand1 = new Random();

        // creating questions
        Question[] questions = new Question[6];
        questions[0] = new MCQuestion("What is described as _____?", "ADE","ABCDE");
        questions[1] = new MCQuestion("What is the difference?", "BC","ABCDE");
        questions[2] = new MCQuestion("What contains in____?", "ABC","ABCDE");
        questions[3] = new SCQuestion("What is the distance?", "D","ABCD");
        questions[4] = new SCQuestion("Mars is third planet from the sun.", "F","TF");
        questions[5] = new SCQuestion("How do you feel today?", "B","ABC");

        // choosing a question from rng and printing that question out of the Voting Service along with possible choices.
        VotingService vs = new VotingService(questions[rand1.nextInt(questions.length)]);
        System.out.println(vs.getQuestion());
        System.out.println(vs.printAnswerRange());

        // creating students
        Student[] students = new Student[5];
        students[0] = new Student("Ryan");
        students[1] = new Student("Ray");
        students[2] = new Student("183748937");
        students[3] = new Student("MahBoi");
        students[4] = new Student("jkjk");

        int uniqueStudentInput = 0;

        // simulating students choosing their answers and changing them in the process
        while (uniqueStudentInput < students.length) {
            int studentNumber = rand1.nextInt(students.length);
            String answerLine = "";

            // if student answers for the first time, increment the amount of unique students answered the question
            if (!students[studentNumber].answerStatus()) {
                uniqueStudentInput++;
            }

            // if multiple choice, use rng for each choice
            if(!vs.isSingle()) {
                for (int i = 0; i < vs.getAnswerRange().length(); i++) {
                    int tempSwitch = rand1.nextInt(2);
                    if (tempSwitch == 1) {
                        answerLine = answerLine + vs.getAnswerRange().charAt(i);
                    }
                }
            }
            // if single choice, pick one out of the many choices for the questions.
            else {
                int answerChoice = rand1.nextInt(vs.getAnswerRange().length());
                answerLine = "" +  vs.getAnswerRange().charAt(answerChoice);

            }
            students[studentNumber].setAnswer(answerLine);

            vs.receiveStudentAnswer(students[studentNumber]);

        }

        // prints each individual result from each student
        vs.printStudentAnswerStatus();

        // prints answer
        System.out.println("Here is the answer: " + vs.printAnswer() + "\n");

        // prints each choice chosen
        vs.printStatistics();






    }
}
