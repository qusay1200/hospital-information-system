package hospital;

public abstract class Person {
    private int id;
    private String firstName, lastName, mobilePhoneNumber, email;
    
    public Person(int id, String firstName, String lastName, String mobilePhoneNumber, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public String getEmail() {
        return email;
    }
    
    @Override
    public String toString() {
        return "id: "+getId()+", name: "+getFirstName()+" "+getLastName()+
                ", mobile phone number: "+getMobilePhoneNumber()+", email: "+getEmail();
    }
}
