import java.util.Arrays;
import java.util.Scanner;

public class StudentRecordManager {

    public static double calculateAverage(int[] marks) {
        if (marks == null || marks.length == 0) {
            return 0.0;
        }

        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }

        return (double) sum / marks.length;
    }

    public static int findMax(int[] marks) {
        if (marks == null || marks.length == 0) {
            return 0;
        }

        int max = marks[0];
        for (int mark : marks) {
            if (mark > max) {
                max = mark;
            }
        }

        return max;
    }

    public static int findMin(int[] marks) {
      Arrays.sort(marks);
      int max= marks[(marks.length-1)];
      return max;
    }

    public static void displayStudentDetails(int studentId, String name, int[] marks) {
        System.out.println("Student ID: " + studentId);
        System.out.println("Student Name: " + name);
        System.out.println("Marks: ");
        for (int i = 0; i < marks.length; i++) {
            System.out.println("Marks of Subject " + (i + 1) + ": " + marks[i]);
        }
        double average = calculateAverage(marks);
        int max = findMax(marks);
        int min = findMin(marks);

        System.out.println("Average Mark: " + average);
        System.out.println("Maximum Mark: " + max);
        System.out.println("Minimum Mark: " + min);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of Students : ");
        int n=input.nextInt();

        for(int i=0;i<n;i++){
            System.out.print("Enter the ID of "+(i+1)+" student : ");
            int studentId=input.nextInt();
            input.nextLine(); // Consume the newline character
            System.out.print("Enter the Name of "+(i+1)+" student : ");
            String studentName=input.nextLine();
            System.out.print("Enter Number of Subjects: ");
            int numSubjects = input.nextInt();
            int[] studentMarks=new int[numSubjects];
            for(int j=0;j<numSubjects;j++){
                System.out.print("Enter the marks of "+(j+1)+" Subject : ");
                studentMarks[j]=input.nextInt();
            }
            displayStudentDetails(studentId, studentName, studentMarks);
        }
        input.close();
    }
}
