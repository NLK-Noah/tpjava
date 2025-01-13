package parallelization;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExamGrader {



    public interface RoundingFunction {
        int roundGrade(double grade);
    }


    public static class ExamQuestion {
        private double pointsObtained;
        private ExamQuestion nextQuestion;

        public ExamQuestion(double points, ExamQuestion next) {
            this.pointsObtained = points;
            this.nextQuestion = next;
        }

        public double getPointsObtained() {
            return pointsObtained;
        }

        public ExamQuestion getNextQuestion() {
            return nextQuestion;
        }
    }

    /**
     *  Write a method calculateExamGrade that calculates the grade
     *  obtained for an exam. The grade is the sum of the points
     *  obtained in all questions. The questions are provided in a
     *  linked list (class ExamQuestion).
     *
     *  However, the points are real numbers, while the exam grade
     *  is a natural number. To round the grade, the caller of this
     *  method provides a rounding function that you have to use
     *  to obtain the final result.
     *
     *  Look at the test "testWithTwoQuestions" to see how users will
     *  call this method.
     *
     *  You can assume that all points are positive numbers and that
     *  the list of questions is not empty.
     */
    public static int calculateExamGrade(ExamQuestion questions, RoundingFunction roundingFunction) {
        double grades =0;
        ExamQuestion current = questions;
        while (current != null) {
            grades += current.getPointsObtained();
            current = current.getNextQuestion();
        }

        return roundingFunction.roundGrade(grades);
    }


    /**
     * Write a method gradeExams that calculates the grades of two exams
     * using two threads to accelerate the grading (one exam graded per thread).
     * The method must return the two grades in an int array.
     * Like for the method calculateExamGrade, the caller of this method
     * provides a rounding function.
     *
     * Look at the test "testTwoShortExams" to see how users will
     * call this method.
     *
     * You MUST use threads (or a threadpool).
     * Catch (and ignore) all exceptions.
     */
    public static int[] gradeExams(ExamQuestion exam1, ExamQuestion exam2, RoundingFunction roundingFunction)  {
        int[] grades= new int[2];
        class Mythreads extends Thread {
            private ExamQuestion question;
            private int index;
            public Mythreads(ExamQuestion question, int index) {
                this.question = question;
                this.index = index;
            }

            public void run() {
                try{
                    grades[index] = calculateExamGrade(question, roundingFunction);
                }catch(Exception e) {
                }

            }
        }
        Mythreads thread1 = new Mythreads(exam1, 0);
        Mythreads thread2 = new Mythreads(exam2, 1);
        thread1.start();
        thread2.start();
        try{
            thread1.join();
            thread2.join();
        }catch(Exception e) {}

         return grades ;
    }
}