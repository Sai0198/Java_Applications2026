package corejavaprogramsarrays;
import java.util.Scanner;
public class StudentGradingSystem{
    public void inputData(Scanner scanner, String[] names, int[] totalMarks, double[] percentages, char[] grades){
        for (int i = 0; i < names.length; i++) {
            System.out.println("\nEnter details of student " + (i + 1));
            System.out.print("Enter name: ");
            names[i] = scanner.nextLine();
            System.out.print("Enter marks of subject 1: ");
            int m1 = scanner.nextInt();
            System.out.print("Enter marks of subject 2: ");
            int m2 = scanner.nextInt();
            System.out.print("Enter marks of subject 3: ");
            int m3 = scanner.nextInt();
            scanner.nextLine();
            totalMarks[i] = m1 + m2 + m3;
            percentages[i] = totalMarks[i]/3.0;
            grades[i] = Grade(percentages[i]);
        }
    }
    public char Grade(double percentage){
        if (percentage >= 90)
        	return 'A';
        else if (percentage >= 80)
        	return 'B';
        else if (percentage >= 70)
        	return 'C';
        else if (percentage >= 60)
        	return 'D';
        else 
        	return 'F';
    }
    public int findTopper(double[] percentages){
        int topperIndex = 0;
        for (int i = 1; i < percentages.length; i++) {
            if (percentages[i] > percentages[topperIndex]){
                topperIndex = i;
            }
        }
        return topperIndex;
    }
    public double classAverage(double[] percentages) {
        double sum = 0;
        for (double p : percentages) {
        	sum += p;
        }
        return sum / percentages.length;
    }
    public void display(String[] names, int[] totalMarks, double[] percentages, char[] grades, int topperIndex){
        System.out.println("===== CLASS PERFORMANCE REPORT =====");
        System.out.printf("%-15s %-12s %-12s %-8s\n", "Name", "TotalMarks", "Percentage", "Grade");
        for (int i = 0; i < names.length; i++) {
            if(i == topperIndex) {
            	System.out.printf("%-15s %-12d %-12.2f %-8c 🏆\n",
                        names[i], totalMarks[i], percentages[i], grades[i]);
            }else{
            	System.out.printf("%-15s %-12d %-12.2f %-8c\n",names[i], totalMarks[i], percentages[i], grades[i]);
            }
        }
    }
    public static void main(String[] args){
        StudentGradingSystem s1= new StudentGradingSystem();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();
        String[] names = new String[n];
        int[] totalMarks = new int[n];
        double[] percentages = new double[n];
        char[] grades = new char[n];
        s1.inputData(sc, names, totalMarks, percentages, grades);
        int topperIndex = s1.findTopper(percentages);
        double classAverage = s1.classAverage(percentages);
        s1.display(names, totalMarks, percentages, grades, topperIndex);
        System.out.printf("\nClass Average Percentage: %.2f\n", classAverage);
        sc.close();
    }
}