package hospital;

import java.util.ArrayList;
import java.util.List;

public class Patient extends Person {
    private String type;
    private List<Service> services;
    
    public Patient(int id, String firstName, String lastName, String mobilePhoneNumber, String email, String type) {
        super(id, firstName, lastName, mobilePhoneNumber, email);
        this.type = type;
        this.services = new ArrayList<>();
    }
    
    public String getType() {
        return type;
    }

    public List<Service> getServices() {
        return services;
    }
    
    public void addService(Service service) {
        services.add(service);
    }
    
    @Override
    public String toString() {
        return super.toString()+", type: "+getType()+", services: "+services.toString();
    }
}
