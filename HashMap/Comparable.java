import java.util.*;
class Student implements Comparable<Student>
{
 int roll,age;
 String name;
 Student(int roll,int age,String name)
 {
  this.roll=roll;
  this.age=age;
  this.name=name;
 }
 public int getAge()
 {
     return age;
 }
 public int getRoll()
 {
     return roll;
 }
 public String getName()
 {
    return name;
 }
 public String toString()
 {
    return getName()+" "+getAge();
 }
public int compareTo(Student st)
{
  return this.age-st.age;
}
}
public class Test {
    public static void main(String[] args) {
    ArrayList<Student> list = new ArrayList<>();
    list.add(new Student(1,10,"shifa"));
    list.add(new Student(2,20,"xyz"));
    list.add(new Student(3,5,"abc"));
    list.add(new Student(4,4,"shifa"));
    Collections.sort(list);
    for(Student st:list)
    {
        System.out.println(st);
    }
    }
}
