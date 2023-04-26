package hospital;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HospitalSystem {
    List<Employee> staffs;
    List<Employee> doctors;
    List<Patient> patients;
    
    public HospitalSystem() {
        this.staffs = new ArrayList<>();
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
        
        addStaffs();
        addDoctors();
        run();
    }
    
    public static void main(String[]args) {
        new HospitalSystem();
    }
    
    private void run() {
        printNames();
        
        Scanner scan = new Scanner(System.in);
        int selection = 0;
        
        validateStaff(scan);
        do {
            printMenu();
            selection = scan.nextInt();
            switch (selection) {
                case 1:
                    System.out.println("enter doctor first name: ");
                    String docFirstName = scan.next();
                    System.out.println("enter doctor last name: ");
                    String docLastName = scan.next();
                    System.out.println("enter doctor id: ");
                    int docId = scan.nextInt();
                    System.out.println("enter doctor mobile phone number: ");
                    String docMobilePhoneNumber = scan.next();
                    System.out.println("enter doctor email: ");
                    String docEmail = scan.next();
                    System.out.println("enter doctor salary: ");
                    double docSalary = scan.nextDouble();
                    System.out.println("enter doctor rank: ");
                    String docRank = scan.next();
                    System.out.println("enter doctor speciality: ");
                    String docSpeciality = scan.next();
                    
                    doctors.add(new Doctor(docId, docFirstName, docLastName,
                            docMobilePhoneNumber, docEmail, docSalary, docRank, docSpeciality));
                    break;
                    
                case 2:
                    System.out.println("enter patient id: ");
                    int paId = scan.nextInt();
                    System.out.println("enter service name: ");
                    String serviceName = scan.next();
                    System.out.println("enter service id: ");
                    int serviceId = scan.nextInt();
                    System.out.println("enter service price");
                    double servicePrice = scan.nextDouble();
                    
                    Patient pat = findPatientById(paId);
                    if (pat == null) {
                        System.out.println("patient not found");
                    } else {
                        if (pat.getType().equalsIgnoreCase("A")) {
                            servicePrice -= (servicePrice * 40)/100;
                        }
                        pat.addService(new Service(serviceId, serviceName, servicePrice));
                    }
                    break;
                    
                case 3:
                    System.out.println("enter patient first name: ");
                    String patientFirstName = scan.next();
                    System.out.println("enter patient last name: ");
                    String patientLastName = scan.next();
                    System.out.println("enter patient id: ");
                    int patientId = scan.nextInt();
                    System.out.println("enter patient mobile phone number: ");
                    String patientMobilePhoneNumber = scan.next();
                    System.out.println("enter patient email: ");
                    String patientEmail = scan.next();
                    System.out.println("enter patient type: ");
                    String patientType = scan.next();
                    
                    patients.add(new Patient(patientId, patientFirstName, patientLastName, 
                            patientMobilePhoneNumber, patientEmail, patientType));
                    break;
                    
                case 4:
                    for (int i = 0; i <doctors.size(); i++) {
                        System.out.println(doctors.get(i));
                    }
                    break;
                    
                case 5:
                    for (int i = 0; i <patients.size(); i++) {
                        System.out.println(patients.get(i));
                    }
                    break;
                    
                case 6:
                    System.out.println("enter doctor id: ");
                    int doctorId = scan.nextInt();
                    Employee doctor = findDoctorById(doctorId);
                    if (doctor == null) {
                        System.out.println("doctor not found");
                    } else {
                        System.out.println(doctor.toString());
                    }
                    break;
                    
                case 7:
                    System.out.println("enter patient id: ");
                    int patId = scan.nextInt();
                    Patient patient = findPatientById(patId);
                    if (patient == null) {
                        System.out.println("doctor not found");
                    } else {
                        System.out.println(patient.toString());
                    }
                    break;
                    
                case 8:
                    System.out.println("enter patient id: ");
                    int patiId = scan.nextInt();
                    double bill = 0;
                    Patient pati = findPatientById(patiId);
                    
                    if (pati == null) {
                        System.out.println("patient not found");
                    } else {
                        for (Service s : pati.getServices()) {
                            bill += s.getPrice();
                        }
                    }
                    System.out.println("patinet's bill is $"+bill);
                    break;
                    
                case 9:
                    System.out.println("exiting from the program");
                    break;
                    
                default:
                    System.out.println("invalid input.\nplease try again");
                    break;
            }
        } while (selection != 9);
        scan.close();
    }
    
    private Employee findDoctorById(int doctorId) {
        for (Employee d : doctors) {
            if (d.getId() == doctorId) {
                return d;
            }
        } return null;
    }
    
    private Patient findPatientById(int patientId) {
        for (Patient p : patients) {
            if (p.getId() == patientId) {
                return p;
            }
        } return null;
    }
    
    private void validateStaff(Scanner scan) {
        boolean continueFlag = true;
        do {
            System.out.println("enter your first name: ");
            String saffName = scan.next();
            
            for (Employee e : staffs){
                if (e.getFirstName().equalsIgnoreCase(saffName)) {
                    continueFlag = false;
                }
            }
            if (continueFlag) {
                System.out.println("staff not found.\nplease try again");
            }
        } while (continueFlag);
    }
    
    private void addStaffs() {
        staffs.add(new AdministrationStaff(1, "bashar", "hamo", "0593140850", "bashar.hamo@gmail.com", 5000, "administrative manager"));
        staffs.add(new AdministrationStaff(2, "qusay", "al-sharif", "0568060015", "qusay.alsharif@gmail.com", 5000, "administrator"));
        staffs.add(new AdministrationStaff(3, "emma", "chamberlain", "0554534466", "emma.chamberlain@gmail.com", 4000, "administrative services officer"));
    }
    
    private void addDoctors() {
        doctors.add(new Doctor(4, "hammad", "mohammed", "0546065284", "hammad.mohammed@gmail.com", 30000, "medical director", "cardiologists"));
        doctors.add(new Doctor(5, "mohammed", "alguenioy", "0544010040", "mohammed.alguenioy@gmail.com", 25000, "head of department", "dermatologists"));
    }
    
    private static void printNames() {
        System.out.println("""
                           *****************************************************
                           *              welcome to our hospital              *
                           *    student 1: bashar khalid hamo, 442016709       *
                           *    student 2: qusay khalid al-sharif, 442002260   *
                           *****************************************************
                           """);
    }
    
    public void printMenu() {
        System.out.println("""
                           please select you choice or enter 9 to exit
                           --------------------------------------------
                           1. add doctor
                           2. add service
                           3. add patient
                           4. print all doctors information
                           5. print all patients information
                           6. display specific doctor data
                           7. display specific patient data
                           8. print a specific patinet's bill
                           9. exit the program
                           --------------------------------------------
                           enter your selection: 
                           """);
    }
}