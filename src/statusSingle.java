package status;

public class statusSingle implements ICivilStatus {
	public String getCivilStatusString(){return "single";};
	public ICivilStatus getMarried(){return new status.statusMarried();};
	public ICivilStatus getDivorced()throws CivilException{throw new CivilException("A single person cannot get divorced");};
	public ICivilStatus getSpouseDeceased()throws CivilException{throw new CivilException("A single person cannot get widowed");};
}
