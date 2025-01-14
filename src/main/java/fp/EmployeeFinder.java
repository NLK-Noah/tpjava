package fp;

import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.function.Function;

public class EmployeeFinder {
    // You can add new methods, inner classes, etc.
    // but do not modify the signature of the existing
    // methods or the types of existing fields.


    public static class Employee {
        public final int id;
        public final float experience;
        public final int salary;

        public Employee(int id, float experience, int salary) {
            this.id = id;
            this.experience = experience;
            this.salary = salary;
        }
    }

    /**
     * A company has two departments A and B.
     * Each department has a list of employees.
     */
    public static class Company {
        public final ArrayList<Employee> departmentA, departmentB;

        public Company(ArrayList<Employee> departmentA, ArrayList<Employee> departmentB) {
            this.departmentA = departmentA;
            this.departmentB = departmentB;
        }
    }

    /**
     * Write a method that returns the "best" employee from a list of employees.
     * To decide who is the best employee, the method should use the "scoreFunction".
     * The score function calculates a score for an employee. The SMALLER the score
     * the better the employee.
     * If there are multiple "best" employees (i.e., employees with the same score),
     * the method should return the first one in the list.
     * <p>
     * You can assume that the list "employees" is never empty.
     * <p>
     * See the unit test for an example.
     */
    public static Employee findBestEmployee(ArrayList<Employee> employees, Function<Employee, Float> scoreFunction) {
        Float score = 0.00F;
        int n = 0;
        Float bestScore = 0.00F;
        int size = employees.size();
        for (int i = 0; i < size; i++) {
            Employee employee = employees.get(i);
            System.out.println(employee);
            bestScore = scoreFunction.apply(employee);
            if (bestScore > score) {
                score = bestScore;
                n = i;
            }

        }
        Employee bestEmployee = employees.get(n);
        return bestEmployee;
    }

    /**
     * Write a method that returns the "best" employee in a company. The best
     * employee is the employee (in all departments of the company) with the smallest
     * score calculated by "scoreFunction".
     * <p>
     * If there are multiple "best" employees in a department, the method should
     * return the first one in the employee list of the department. If both departments
     * have best employees with the same score, the employee from department "A" should
     * be preferred.
     * <p>
     * You can assume that the employee lists of the departments are not empty.
     * <p>
     * See the unit test for an example.
     * <p>
     * WARNING:
     * - You MUST use two threads (or a threadpool) to search the two departments
     * in parallel.
     * You will get 0 points for this question if you don't use threads (or a
     * threadpool) even if your code returns the correct result on inginious!
     * - If you get a timeout on inginious, it probably means that your code is missing
     * something.
     * - You MUST catch all exceptions. You can return null if there is a problem.
     */
    public static Employee findBestEmployee(Company company, Function<Employee, Float> scoreFunction) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        try {

            Callable<Employee> taskA = () -> findBestEmployee(company.departmentA, scoreFunction);
            Callable<Employee> taskB = () -> findBestEmployee(company.departmentB, scoreFunction);


            Future<Employee> futureA = executor.submit(taskA);
            Future<Employee> futureB = executor.submit(taskB);


            Employee bestInA = null;
            try {
                bestInA = futureA.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Employee bestInB = futureB.get();


            float scoreA = scoreFunction.apply(bestInA);
            float scoreB = scoreFunction.apply(bestInB);


            return (scoreA <= scoreB) ? bestInA : bestInB;

        } catch (ExecutionException | InterruptedException e) {return null;} finally {
            executor.shutdown();
        }
    }
}

