import java.util.*;

public class CloneTest {

    public static void main(String[] args) {

        try{
            Employee original = new Employee("John Q. Public", 50000);
            original.setHireDay(2000,1,1);
            Employee copy = original.clone();
            copy.raiseSalary(10);
            copy.setHireDay(2002,12,31);
            System.out.println("original=" + original);
            System.out.println("copy=" + copy);
        }
        catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
    }
}

class Employee implements Cloneable{

    public Employee(String n, double s){
        name = n;
        salary = s;
    }

    public Employee clone() throws CloneNotSupportedException{
        Employee cloned = (Employee)super.clone();

        cloned.hireDay = (Date)hireDay.clone();

        return cloned;
    }

    /**
     * Установка даты найма на работу.
     * @param year год найма
     * @param month месяц найма
     * @param day день найма
     */

    public void setHireDay(int year, int month, int day){

        hireDay = new GregorianCalendar(year, month-1,day).getTime();

    }

    public void raiseSalary(double byPercent){
        double raise = salary*byPercent/100;
        salary += raise;
    }

    public String toString(){
        return "Employee[name=" + name
                + ", salary=" + salary
                + ", hireDay=" + hireDay
                + "]";
    }

    private String name;
    private double salary;
    private Date hireDay;
}
