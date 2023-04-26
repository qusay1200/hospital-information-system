package hospital;

public class Doctor extends Employee {
    private String rank, specialty;
    
    public Doctor(int id, String firstName, String lastName, String mobilePhoneNumber, String email, double salary, String rank, String specialty) {
        super(id, firstName, lastName, mobilePhoneNumber, email, salary);
        this.rank = rank;
        this.specialty = specialty;
    }
    
    public String getRank() {
        return rank;
    }

    public String getSpecialty() {
        return specialty;
    }
    
    @Override
    public String toString() {
        return super.toString()+", rank: "+getRank()+", specialty: "+getSpecialty();
    }
}
