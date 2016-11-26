package test;

import java.time.chrono.IsoChronology;

import junit.framework.TestCase;
import status.Person;
import status.statusSingle;

public class AutomatedTest extends TestCase{

	private Person person;
	
	protected void setUp()  throws Exception {
		person = new Person("Fred",IsoChronology.INSTANCE.date(1980, 6, 20),Person.Sex.MALE, new statusSingle(),"fred@example.com");
	}
	
	public void test1() throws Exception {
		System.out.println("Test case 1");
		person.die();
		assertTrue("1_1", person.isDead());
		try {
			person.die();
			System.out.println("Test failed at test 1_1_1: an expected exception is not thrown!");
			System.exit(1);
		} catch (Exception e) {}
		assertTrue("1_1_1", person.isDead());
	}
	
	public void test2() throws Exception {
		System.out.println("Test case 2");
		person.die();
		try {
			person.getMarried();
			System.out.println("Test failed at test 1_1_2: an expected exception is not thrown!");
			System.exit(1);
		} catch (Exception e) {}
		assertTrue("1_1_2", person.isDead());
	}
	
	public void test3() throws Exception {
		System.out.println("Test case 3");
		person.die();
		try {
			person.getSpouseDeceased();
			System.out.println("Test failed at test 1_1_3: an expected exception is not thrown!");
			System.exit(1);
		} catch (Exception e) {}
		assertTrue("1_1_3", person.isDead());
	}
	
	public void test4() throws Exception {
		System.out.println("Test case 4");
		person.die();
		try {
			person.getDivorced();
			System.out.println("Test failed at test 1_1_4: an expected exception is not thrown!");
			System.exit(1);
		} catch (Exception e) {}
		assertTrue("1_1_4", person.isDead());
	}
	
	public void test5() throws Exception {
		System.out.println("Test case 5");
		person.getMarried();
		assertTrue("1_2", person.isMarried());
		person.die();
		assertTrue("1_2_1", person.isDead());
	}
	
	public void test6() throws Exception {
		System.out.println("Test case 6");
		person.getMarried();
		try {
			person.getMarried();
			System.out.println("Test failed at test 1_2_2: an expected exception is not thrown!");
			System.exit(1);
		} catch (Exception e) {}
		assertTrue("1_2_2", person.isMarried());
	}
	
	public void test7() throws Exception {
		System.out.println("Test case 7");
		person.getMarried();
		person.getSpouseDeceased();
		assertTrue("1_2_3", person.isWidowed());
		person.die();
		assertTrue("1_2_3_1", person.isDead());
	}
	
	public void test8() throws Exception {
		System.out.println("Test case 8");
		person.getMarried();
		person.getSpouseDeceased();
		person.getMarried();
		assertTrue("1_2_3_2", person.isMarried());
	}
	
	public void test9() throws Exception {
		System.out.println("Test case 9");
		person.getMarried();
		person.getSpouseDeceased();
		try {
			person.getSpouseDeceased();
			System.out.println("Test failed at test 1_2_3_3: an expected exception is not thrown!");
			System.exit(1);
		} catch (Exception e) {}
		assertTrue("1_2_3_3", person.isWidowed());
	}
	
	public void test10() throws Exception {
		System.out.println("Test case 10");
		person.getMarried();
		person.getSpouseDeceased();
		try {
			person.getDivorced();
			System.out.println("Test failed at test 1_2_3_4: an expected exception is not thrown!");
			System.exit(1);
		} catch (Exception e) {}
		assertTrue("1_2_3_4", person.isWidowed());
	}
	
	public void test11() throws Exception {
		System.out.println("Test case 11");
		person.getMarried();
		person.getDivorced();
		assertTrue("1_2_4", person.isDivorced());
		person.die();
		assertTrue("1_2_4_1", person.isDead());
	}
	
	public void test12() throws Exception {
		System.out.println("Test case 12");
		person.getMarried();
		person.getDivorced();
		person.getMarried();
		assertTrue("1_2_4_2", person.isMarried());
	}
	
	public void test13() throws Exception {
		System.out.println("Test case 13");
		person.getMarried();
		person.getDivorced();
		try {
			person.getSpouseDeceased();
			System.out.println("Test failed at test 1_2_4_3: an expected exception is not thrown!");
			System.exit(1);
		} catch (Exception e) {}
		assertTrue("1_2_4_3", person.isDivorced());
	}
	
	public void test14() throws Exception {
		System.out.println("Test case 14");
		person.getMarried();
		person.getDivorced();
		try {
			person.getDivorced();
			System.out.println("Test failed at test 1_2_4_4: an expected exception is not thrown!");
			System.exit(1);
		} catch (Exception e) {}
		assertTrue("1_2_4_4", person.isDivorced());
	}
	
	public void test15() throws Exception {
		System.out.println("Test case 15");
		try {
			person.getSpouseDeceased();
			System.out.println("Test failed at test 1_3: an expected exception is not thrown!");
			System.exit(1);
		} catch (Exception e) {}
		assertTrue("1_3", person.isSingle());
	}
	
	public void test16() throws Exception {
		System.out.println("Test case 16");
		try {
			person.getDivorced();
			System.out.println("Test failed at test 1_4: an expected exception is not thrown!");
			System.exit(1);
		} catch (Exception e) {}
		assertTrue("1_4", person.isSingle());
	}

}
	