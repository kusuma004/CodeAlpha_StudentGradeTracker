import java.util.Scanner;
import java.util.ArrayList;
class Student
{
   private String name;
   private int marks;

   public Student(String name,int marks)
   {
    this.name=name;
    this.marks=marks;
   }
   public String getName()
   {
    return name;
   }
   public int getMarks()
   {
    return marks;
   }
   public String getGrade()
   {
    if(marks>=90)
    {
        return "A";
    }
    else if(marks>=80)
    {
        return "B";
    }
    else if(marks>=70)
    {
        return "C";
    }
    else if(marks>=60)
    {
        return "D";
    }
    else if(marks>=50)
    {
        return "E";
    }
    else
    {
        return "F";
    }
   }
}

public class Main {
    static Scanner sc=new Scanner(System.in);
    static ArrayList<Student> list=new ArrayList<>();
    public static void main(String[] args)
    {
        int choice;
        do{
            System.out.println("**********Student Grade Tracker**********");
            System.out.println("1.Add Students");
            System.out.println("2.View all Students");
            System.out.println("3.Display grade summary");
            System.out.println("4.Exit");
            System.out.println("Enter your choice:");
            choice=sc.nextInt();
            sc.nextLine();

            if(choice==1)
            {
                addstudent();
            }
            else if(choice==2)
            {
                viewstudents();
            }
            else if(choice==3)
            {
                showsummary();
            }
            else if(choice==4)
            {
                System.out.println("program closed.");
            }
            else{
                System.out.println("Invalid choice....");
            }
        }while(choice!=4);
    }
       static  void addstudent()
        {
            System.out.println("Enter the name:");
            String name=sc.nextLine().trim();
            System.out.println("Enter the marks:");
            int marks=sc.nextInt();
            sc.nextLine();

            if(name.isEmpty() || marks<0 || marks>100)
            {
                System.out.println("Invalid student name or marks..");
                return;
            }
            list.add(new Student(name,marks));
            System.out.println("Student added successfully.....");

        }
       static void viewstudents()
        {
            if(list.size()==0)
            {
                System.out.println("No student is found...");
                return;
            }

            for(int i=0;i<list.size();i++)
            {
                Student s=list.get(i);
                System.out.println("Name:"+s.getName()+
                       ",Marks:"+s.getMarks()+",Grades:"+s.getGrade());
            }

        }
      static  void showsummary()
        {
           if(list.size()==0)
           {
            System.out.println("No student is found..");
            return;
           }
        int total=0;
        int highest=list.get(0).getMarks();
        int lowest=list.get(0).getMarks();

        for(int i=0;i<list.size();i++)
        {
            int marks=list.get(i).getMarks();
            total=total+marks;
            if(marks > highest)
            {
                highest=marks;
            }
            if(marks < lowest)
            {
                lowest=marks;
            }
        }
        double average=(double)total/list.size();
        System.out.println("**********Student Grade Tracker**********");
        System.out.println("Total Students:"+list.size());
        System.out.printf("Average Student Marks: %.2f %n",average);
        System.out.println("Highest Student Marks:"+highest);
        System.out.println("Lowest Student Marks:"+lowest);

        }
    }
    


