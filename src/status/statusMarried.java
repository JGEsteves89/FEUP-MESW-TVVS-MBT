package status;

public class statusMarried implements ICivilStatus {
	public String getCivilStatusString(){return "married";};
	public ICivilStatus getMarried()throws CivilException{throw new CivilException("A married person cannot get married");};
	public ICivilStatus getDivorced(){return new statusDivorced();};
	public ICivilStatus getSpouseDeceased(){return new statusWidowed();};
}
