import java.util.Random;
public class Grades 
{
	   private int[] grade;
	   private int[] gradeD;
	   private int high,mode;
	   private double average, median;
	   public Grades(int no)
	   {
		   Random gr=new Random();
		   gradeD= new int[no];
		   grade= new int[no];
		   for (int i=0;i<no;i++)
		   {
			  grade[i]= gradeD[i]=Math.abs(gr.nextInt())%101;
		   }
	   }
	  public double getTotal()
      {
		  int total=0;
		  for(int i=0;i<grade.length;i++)
		  {
				   total+=grade[i];
		  }
		  return total;
	  }
	  public double getAverage()
	  {
		  average=getTotal()/(double)grade.length;
		  return average;	  
	  }
	  public int getHighest()
	  {
		  high=grade[grade.length-1];
		  return high;
	  }
	  public double getMedian()
	  {
		  if(grade.length%2==0)
		  {
			  median=(grade[grade.length/2-1]+grade[(grade.length)/2])/2;
		  }
		  else
		  {
			  median=grade[grade.length/2];
		  }
		  return median;		  
	  }
	  public int getMode()
	  {
		  int[]A=new int[101];
		  int m=0;
		  for(int i=0;i<grade.length;i++)
		  {
			  A[i]=0;
		  }
		  for(int i=0;i<grade.length;i++)
		  {
			  A[grade[i]]++;
		  }
		  for(int i=0;i<A.length;i++)
		  {
			  if(A[i]>A[m])
			  {
				  m=i;
			  }
		  }
		  mode=m;
		  return mode;
	  }
	  public void sort1()
	  {
		  int temp;
		  for(int i=0;i<grade.length-1;i++)
		  {
			  for(int j=i+1;j<grade.length;j++)
			  {
				  if(grade[i]>grade[j])
				  {
					  temp=grade[i];
					  grade[i]=grade[j];
					  grade[j]=temp;
				  }
			  }
		  }
	  }
	  public void sort2()
	  {
		  int temp;
		  for(int i=0;i<gradeD.length-1;i++)
		  {
			  for(int j=i+1;j<gradeD.length;j++)
			  {
				  if(gradeD[i]<gradeD[j])
				  {
					  temp=gradeD[i];
					  gradeD[i]=grade[j];
					  gradeD[j]=temp;
				  }
			  }
		  }
	  }
	  public String toStringA()
	  {
		  String s="";
		  for (int i=0; i<grade.length;i++)
		  {
			  s=s+grade[i]+" ";
			  if((i+1)%10==0)
			  {
				  s=s+'\n';
			  }
		  }
		  return s;
	  }
	  public String toStringD()
	  {
		  String s="";
		  for (int i=0; i<gradeD.length;i++)
		  {
			  s=s+gradeD[i]+" ";
			  if((i+1)%10==0)
			  {
				  s=s+'\n';
			  }
		  }
		  return s;
	  }
}