
import java.time.LocalDate;
import java.time.chrono.IsoChronology;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;

import status.Person.Sex;

public class Person {
    public enum Sex {
        MALE, FEMALE
    }

    String name; 
    LocalDate birthday;
    Sex gender;
    public ICivilStatus status;
    String emailAddress;
    Boolean Dead=false;
    
	public Person (String nameArg, LocalDate birthdayArg, Sex genderArg, ICivilStatus statusArg, String emailArg) {
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
    public Sex getGender() {return gender;}
    public String getName() {return name;}
    public String getEmailAddress() {return emailAddress;}
    public LocalDate getBirthday() {return birthday;}
	public void setStatus(ICivilStatus civilStatus) {status=civilStatus;}
    public ICivilStatus getStatus() {return status;}
    
    public void printPerson() {
      System.out.println(String.format("This is %1$s has %2$s years old and is %3$s.", name, getAge(), getStatusString()));
    }
    
    public String getStatusString() {
    	if(status==null) return "";
    	return status.getCivilStatusString();
    }

	public void die() throws CivilException {
		if( Dead) throw new CivilException("This person is already dead");
		Dead=true;
	}
	public void getMarried() throws CivilException {
		if( Dead) throw new CivilException("This person is already dead");
		status=status.getMarried();
	}
	public void getSpouseDeceased() throws CivilException {
		if( Dead) throw new CivilException("This person is already dead");
		status=status.getSpouseDeceased();
		
	}
	
	public void getDivorced() throws CivilException {
		if( Dead) throw new CivilException("This person is already dead");
		status=status.getDivorced();
	}

	public void getMarried(Person spouse) throws CivilException {
		if( Dead) throw new CivilException("This person is already dead");
		status=status.getMarried();
		spouse.getMarried();
	}
	public void getSpouseDeceased(Person spouse) throws CivilException {
		if( Dead) throw new CivilException("This person is already dead");
		spouse.die();
		status=status.getSpouseDeceased();
		
	}
	public void getDivorced(Person spouse) throws CivilException {
		if( Dead) throw new CivilException("This person is already dead");
		status=status.getDivorced();
		spouse.getDivorced();
	}

	
	public Boolean isDead() {return Dead;}
	public Boolean isSingle() {return (getStatusString()=="single");}
	public Boolean isDivorced() {return (getStatusString()=="divorced");}
	public Boolean isEmpty() {return (name==null);}
	public Boolean isMarried() {return (getStatusString()=="married");}
	public Boolean isWidowed() {return (getStatusString()=="widowed");}






}
