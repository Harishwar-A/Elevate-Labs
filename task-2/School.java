import java.util.*;
public class School {
    public static void main(String[]args)
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<StudentDetails> list = new ArrayList<>();
        String arr[] = {"Create", "View", "Update", "Delete"};
        Boolean gate = true;
        while(gate)
        {
            for(int i = 0 ; i  < arr.length; i++)
            {
                System.out.println((i+1)+") "+arr[i]);
            }
            System.out.print("Enter the serial no of the operation which you need to perform: ");
            System.out.println("");
            int operation = sc.nextInt();
            switch(operation)
            {
                case 1:
                    list.add(create(""));
                    gate = door();
                    break;
                case 2:
                    read(list);
                    gate = door();
                    break;
                case 3:
                    list = update(list);
                    gate = door();
                    break;
                case 4:
                    list = delete(list);
                    gate = door();
                    break;
                default: 
                    System.out.println("Invalid input: ");
            }
        }
    }
    public static Boolean door()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------");        
        while(true)
        {
        System.out.print("Do you want to perform any operations if yes enter 1: else enter 2 =>");
        int value = sc.nextInt();

            switch(value)
            {
                case 1:
                    return true;
                case 2:
                    return false;
                default:
                    System.out.println("Invalid input asking again");
            }
        }

    }
    public static StudentDetails create(String statement)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print(statement+"please enter the student rollno: ");
        int rollno = sc.nextInt();
        System.out.println();
        System.out.print(statement+"please enter the Student name: ");
        String name = sc.next();
        System.out.println();
        System.out.print(statement+"please enter the Student age: ");
        int age = sc.nextInt();
        System.out.println();
        System.out.print(statement+"please enter the Student grade: ");
        int grade = sc.nextInt();
        System.out.println();
        return new StudentDetails(rollno, name, age, grade);
    }
    public static void read(ArrayList<StudentDetails> list)
    {
        for(StudentDetails student:list)
        {
            System.out.print("student rollno: "+student.rollno);
            System.out.println();
            System.out.print("student name: "+student.name);
            System.out.println();
            System.out.print("student age: "+student.age);
            System.out.println();
            System.out.print("student grade: "+student.grade);
            System.out.println();
        }
    }
    public static ArrayList<StudentDetails> update(ArrayList<StudentDetails>list)
    {
        String statement = " If you want to update student detail enter the rollno: ";
        int index = findindex(list, statement);
        if(index == -1)
            System.out.print("Student not found");
        else
            list.set(index,create(statement));
        return list;
    }
    public static ArrayList<StudentDetails> delete(ArrayList<StudentDetails>list)
    {
        String statement = "which need to be deleted: ";
        int index = findindex(list,statement);
        list.remove(index);
        return list;
    }
    public static int findindex(ArrayList<StudentDetails>list, String statement)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Roll no "+statement);
        int rollno = sc.nextInt();
        int index = 0;
        for(StudentDetails student : list)
        {
            if(student.rollno == rollno)
                return index;
            index++;
        }
        return -1;
    }
}
class StudentDetails 
{
    int rollno;
    String name;
    int age;
    int grade;
    public StudentDetails(int rollno, String name, int age, int grade)
    {
        this.rollno = rollno;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
}

