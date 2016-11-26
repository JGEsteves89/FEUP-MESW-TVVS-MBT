package status;

import java.time.LocalDate;
import java.time.chrono.IsoChronology;

public class Person {
    public enum Sex {
        MALE, FEMALE
    }

    String name; 
    LocalDate birthday;
    Sex gender;
    ICivilStatus status;
    String emailAddress;
  
    public Person(String nameArg, LocalDate birthdayArg,Sex genderArg,ICivilStatus statusArg, String emailArg) {
        name = nameArg;
        birthday = birthdayArg;
        status=statusArg;
        gender = genderArg;
        emailAddress = emailArg;
    }  

    public int getAge() {
        return birthday
            .until(IsoChronology.INSTANCE.dateNow())
            .getYears();
    }

    public void printPerson() {
      System.out.println(String.format("This is %1$s has %2$s years old and is %3$s.", name, getAge(), getStatusString()));
    }
    
    public Sex getGender() {
        return gender;
    }
    
    public String getName() {
        return name;
    }
    
    public String getEmailAddress() {
        return emailAddress;
    }
    
    public LocalDate getBirthday() {
        return birthday;
    }
    
	public void setStatus(ICivilStatus civilStatus) {
		status=civilStatus;
	}
	
    public ICivilStatus getStatus() {
        return status;
    }
    public String getStatusString() {
    	if(status==null) return "";
    	return status.getCivilStatusString();
    }

    public static int compareByAge(Person a, Person b) {
        return a.birthday.compareTo(b.birthday);
    }
    public static void getMarried(Person a, Person b) throws CivilException {
    	a.status=a.status.getMarried();
    	System.out.println(String.format("%1$s is now %2$s",a.getName(),a.getStatusString()));
    	b.status=b.status.getMarried();
    	System.out.println(String.format("%1$s is now %2$s",b.getName(),b.getStatusString()));
    }
    public static void getMarried(Person a) throws CivilException {
    	a.status=a.status.getMarried();
    	System.out.println(String.format("%1$s is now %2$s",a.getName(),a.getStatusString()));
    }
    public static void getDivorced(Person a, Person b) throws CivilException {
    	a.status=a.status.getDivorced();
    	System.out.println(String.format("%1$s is now %2$s",a.getName(),a.getStatusString()));
    	b.status=b.status.getDivorced();
    	System.out.println(String.format("%1$s is now %2$s",b.getName(),b.getStatusString()));
    }
    public static void getDivorced(Person a) throws CivilException {
    	a.status=a.status.getDivorced();
    	System.out.println(String.format("%1$s is now %2$s",a.getName(),a.getStatusString()));
    }
    public static void getSpouseDeceased(Person a) throws CivilException {
    	a.status=a.status.getSpouseDeceased();
    	System.out.println(String.format("%1$s is now %2$s",a.getName(),a.getStatusString()));
    }


}
