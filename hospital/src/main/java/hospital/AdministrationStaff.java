package hospital;

public class AdministrationStaff extends Employee {
    private String position;
    
    public AdministrationStaff(int id, String firstName, String lastName, String mobilePhoneNumber, String email, double salary, String position) {
        super(id, firstName, lastName, mobilePhoneNumber, email, salary);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }
    
    @Override
    public String toString() {
        return super.toString()+", position: "+getPosition();
    }
}