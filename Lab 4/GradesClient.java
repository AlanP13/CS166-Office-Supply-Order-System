import java.util.Scanner;
public class GradesClient {
	public static void main(String[] args)
	{
	Scanner input= new Scanner(System.in);
	int studentCount;
	System.out.print("Enter the number of Students: ");
	studentCount=input.nextInt();
	Grades g1= new Grades(studentCount);
	g1.sort1();
	g1.sort2();
	System.out.println("The grades sorted in ascending order: "+g1.toStringA());
	System.out.println("The grades sorted in descending order: "+g1.toStringD());
	System.out.println("Highest grade: "+g1.getHighest());
	System.out.println("Average grade: "+g1.getAverage());
	System.out.println("Median grade: "+g1.getMedian());
	System.out.println("Mode: "+g1.getMode());
}
}