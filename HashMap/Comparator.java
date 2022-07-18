import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

class Employee
{
    int no;
    String name;
    Employee(int no,String name)
    {
     this.no=no;
     this.name=name;
    }
    public int getno()
    {
     return no;
    }
    public String getName()
    {
     return name;
    }
}
class NameCompar implements Comparator<Employee>
{
    public int compare(Employee e,Employee e1)
    {
     return e.getName().compareTo(e1.getName());
    }
}
public class Students {
    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee(1,"abc"));
        list.add(new Employee(2,"xyz"));
        list.add(new Employee(3,"qrs"));
        list.add(new Employee(4,"fgh"));
        //Comparator<Employee> cm = Comparator.comparing(Employee::getName);
        Collections.sort(list,new NameCompar());
        for(Employee el:list)
        {
            System.out.println(el.getno()+" "+el.getName());
        }
    }
}
