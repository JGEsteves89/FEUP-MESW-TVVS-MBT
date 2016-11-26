package status;

import java.time.chrono.IsoChronology;

import org.junit.Assert;

public class Program {

	public static void main(String[] args){
		Person fred= new Person("Fred",
		IsoChronology.INSTANCE.date(1980, 6, 20),
		Person.Sex.MALE, new statusSingle(),
		"fred@example.com");
		        
		Person jane=new Person("Jane",
		IsoChronology.INSTANCE.date(1990, 7, 15),
		Person.Sex.FEMALE, new statusWidowed(), "jane@example.com");
		
		Person george=new Person("George",
		IsoChronology.INSTANCE.date(1991, 8, 13),
		Person.Sex.MALE,new statusMarried(), "george@example.com");
		
		Person bob=new Person("Bob",
		IsoChronology.INSTANCE.date(2000, 9, 12),
		Person.Sex.MALE, new statusDivorced(), "bob@example.com");
		
		System.out.println("Program Civil Status started:\n");
		
	}

}
