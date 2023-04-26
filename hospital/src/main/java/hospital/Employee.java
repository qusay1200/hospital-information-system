package hospital;

public abstract class Employee extends Person {
    private double salary;
    
    public Employee(int id, String firstName, String lastName, String mobilePhoneNumber, String email, double salary) {
        super(id, firstName, lastName, mobilePhoneNumber, email);
        this.salary = salary;
    }
    
    public double getSalary() {
        return salary;
    }
    
    @Override
    public String toString() {
        return super.toString()+", salary: "+getSalary();
    }
}