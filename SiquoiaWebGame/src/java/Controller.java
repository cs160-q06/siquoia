
import DataOOD.Node;
import DataOOD.Question;
import DataOOD.Quiz;
import DataOOD.Topic;
import Miscellanea.EnumString;
import Miscellanea.EnumValue;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mr.nam
 */
public class Controller {

    private static Node root;
    private static ArrayList<Question> questionList;
    private static EnumString menuLevel;

    public static void main(String[] args) throws FileNotFoundException {

        //test2();
//        test3("dataset1.txt");
        test();

    }

    private static int addTopic(Node<Topic> currentNode, Node<Topic> previousNode, String line, int count) {
        Node root = previousNode;
        Scanner sc = new Scanner(line);
        sc.useDelimiter(">");

        while (sc.hasNext()) {
            String s = sc.next();
            List<Node<Topic>> children = currentNode.getChildren();
            boolean isNew = true;
            if (children != null) {
                for (Node<Topic> child : children) {
                    if (child.getData().getTopic().equals(s)) {
                        previousNode = child;
                        currentNode = child;
                        isNew = false;
                        //count = currentNode.getData().getId();
                        break;
                    }

                }
            }
            if (children == null || isNew) {
                count++;
                Topic topic = new Topic(count, s);
                previousNode = currentNode;
                currentNode = new Node(count, topic);
                currentNode.setParent(previousNode);
            }
        }
        // System.out.println(currentNode.toString());

        return count;
    }

    private static void loadData(String dataset) throws FileNotFoundException {
        System.out.println("--------------------------------");
        System.out.println("Data is loading from " + dataset);

        File file = new File(dataset);
        Scanner scLine = new Scanner(file);
        questionList = new ArrayList();
        int countTopic = 0;
        int countQuestion = 0;
        root = new Node(countTopic, new Topic(countTopic, "root"));
        Node<Topic> currentNode;
        Node<Topic> previousNode;
        boolean isTopic = true;
        while (scLine.hasNextLine()) {
            String line = scLine.nextLine().trim();
            if (isTopic) {
                currentNode = root;
                previousNode = root;
                countTopic = addTopic(currentNode, previousNode, line, countTopic);
                isTopic = false;
                //System.out.println(currentNode.toString());
            } else if (line.isEmpty()) {
                if (scLine.hasNextLine()) {
                    line = scLine.nextLine();
                    if (line.isEmpty()) {
                        isTopic = true;
                    } else {
                        countQuestion++;
                        String q = line;
                        String c = scLine.nextLine().trim();
                        String a1 = scLine.nextLine().trim();
                        String a2 = scLine.nextLine().trim();
                        String a3 = scLine.nextLine().trim();
                        Node<Topic> node = root.getChildByID(countTopic);
                        Question question = new Question(countQuestion, node.getData(), q, c, a1, a2, a3, 0);
                        questionList.add(question);
                    }
                }
            }

        }
        System.out.println("Data is loaded from " + dataset);
        System.out.println("--------------------------------");

    }

    private static void test2() throws FileNotFoundException {
        File file = new File("dataset2.txt");
        Scanner scLine = new Scanner(file);
        int count = 0;
        Node<Topic> root = new Node(count, new Topic(count, "root"));

        while (scLine.hasNextLine()) {
            String line = scLine.nextLine().trim();

            if (!line.isEmpty()) {
                Node<Topic> currentNode = root;
                Node<Topic> previousNode = root;
                count = addTopic(currentNode, previousNode, line, count);
            }
        }
        System.out.println("root: " + root.toString());


    }

    private static void test3(String dataset) throws FileNotFoundException {
        File file = new File(dataset);
        Scanner scLine = new Scanner(file);
        System.out.println(scLine.nextLine());
        System.out.println(scLine.nextLine());
        System.out.println(scLine.nextLine());
        System.out.println(scLine.nextLine());

    }

    private static void printQuestionList(ArrayList<Question> questionList) {
        for (Question q : questionList) {
            System.out.println(q.toString());
        }
    }

    private static void test() throws FileNotFoundException {
        loadData("dataset1.txt");
        //printQuestionList(questionList);
        menuLevel = EnumString.MAIN;

        printMenu("main");
        Scanner scLine;
        while (true) {
            System.out.print(">");
            scLine = new Scanner(System.in);
            String in = scLine.nextLine();
            if (menuLevel == EnumString.MAIN) {
                if (in.equals(EnumString.EXIT_C.getValue())) {
                    System.exit(0);
                    //return;
                }
                printMenu(in);
                
            } else if (menuLevel == EnumString.LOGIN) {
                //in = scLine.nextLine();
                if (in.equals(EnumString.BACK_C.getValue())) {
                    backMainMenu();
                }
            } else if (menuLevel == EnumString.TUTORIAL) {
                if (in.equals(EnumString.BACK_C.getValue())) {
                    backMainMenu();
                } else if (in.equals(EnumString.START_C.getValue())) {
                    tutorial(scLine);
                    printMenu("");
                } else {
                    printMenu(in);
                }
            } else if (menuLevel == EnumString.OPTION) {
                if (in.equals(EnumString.BACK_C.getValue())) {
                    backMainMenu();
                }
            }

        }


    }

    private static void printMenu(String t) {
        String s = "";
        if (t.equals("main")) {
            s += "---Menu---\n";
            s += EnumString.LOGIN.getValue() + " (" + EnumString.LOGIN_C.getValue() + ")\n";
            s += EnumString.TUTORIAL.getValue() + " (" + EnumString.TUTORIAL_C.getValue() + ")\n";
            s += EnumString.OPTION.getValue() + " (" + EnumString.OPTION_C.getValue() + ")\n";
            s += EnumString.EXIT.getValue() + " (" + EnumString.EXIT_C.getValue() + ")\n";

        } else if (t.equals(EnumString.LOGIN_C.getValue())) {
            s += "---Menu > " + EnumString.LOGIN.getValue() + "---\n";
            s += EnumString.BACK.getValue() + " (" + EnumString.BACK_C.getValue() + ")\n";

            menuLevel = EnumString.LOGIN;

        } else if (t.equals(EnumString.TUTORIAL_C.getValue())) {
            s += "---Menu > " + EnumString.TUTORIAL.getValue() + "---\n";
            s += EnumString.START.getValue() + " (" + EnumString.START_C.getValue() + ")\n";

            s += EnumString.BACK.getValue() + " (" + EnumString.BACK_C.getValue() + ")\n";

            menuLevel = EnumString.TUTORIAL;

        } else if (t.equals(EnumString.OPTION_C.getValue())) {
            s += "---Menu > " + EnumString.OPTION.getValue() + "---\n";
            s += EnumString.BACK.getValue() + " (" + EnumString.BACK_C.getValue() + ")\n";

            menuLevel = EnumString.OPTION;
        } else { // wrong input, print the menu again
            if (menuLevel == EnumString.MAIN) {
                printMenu("main");
            } else {
                printMenu(menuLevel.getValue().substring(0, 1).toLowerCase());
            }
        }
        System.out.println(s);

    }

    private static void backMainMenu() {
        menuLevel = EnumString.MAIN;
        printMenu("");

    }

    private static void tutorial(Scanner scLine) {
        List<Question> list = new ArrayList();
        String topic = EnumString.TUTORIAL_TOPIC.getValue().toLowerCase();
        for (Question question : questionList) {
            if (question.getTopic().getTopic().toLowerCase().equals(topic)) {
                list.add(question);
            }
            if (list.size() == EnumValue.TUTORIAL_QUESTION_NUMBER.getValue()) {
                break;
            }
        }
        startQuiz(list, scLine);
    }

    private static void startQuiz(List<Question> questionList, Scanner scLine) {
        int correct = 0;
        int count = 0;
        Quiz quiz = new Quiz(questionList);
        while (quiz.hasNext()) {
            count++;
            String answer = "";
            quiz.next();
            Question question = quiz.getCurrentQuestion();
            printQuestion(question, count);
            while (true) {
                System.out.print("Your choice: ");
                scLine = new Scanner(System.in);
                answer = scLine.nextLine().toLowerCase().trim();

                if (answer.equals(EnumString.A.getValue())) {
                    answer = question.getCorrectAnswer();
                    break;
                } else if (answer.equals(EnumString.B.getValue())) {
                    answer = question.getAnswer1();

                    break;
                } else if (answer.equals(EnumString.C.getValue())) {
                    answer = question.getAnswer2();

                    break;
                } else if (answer.equals(EnumString.D.getValue())) {
                    answer = question.getAnswer3();

                    break;
                } else {
                    System.out.println("INVALID INPUT!");
                }
            }

            if (quiz.isCurrentCorrect(answer)) {
                System.out.println("Your answer for #" + count + " is correct!\n");
                correct++;
            }
            else {
                System.out.println("Your answer for #" + count + " is incorrect!\n");
            }

            if (!quiz.hasNext())
            {
                //count = (count > 0 ? count - 1 : count);
                System.out.println("You correctly answered a total of " + correct /*count*/
                        + (correct /*count*/ < 2 ? " question" : " questions"));
                break;
            }

        }
    }

    private static void printQuestion(Question question, int count) {
        String s = "Question #" + count + ": ";
        s += question.getQuestion() + "\n\t(" + EnumString.A.getValue() + ") " + question.getCorrectAnswer()
                + "\n\t(" + EnumString.B.getValue() + ") " + question.getAnswer1()
                + "\n\t(" + EnumString.C.getValue() + ") " + question.getAnswer2()
                + "\n\t(" + EnumString.D.getValue() + ") " + question.getAnswer3();
        System.out.println(s + "\n");
    }
}
