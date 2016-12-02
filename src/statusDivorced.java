
public class statusDivorced implements ICivilStatus {
	public String getCivilStatusString(){return "divorced";};
	public ICivilStatus getMarried(){return new status.statusMarried();};
	public ICivilStatus getDivorced()throws CivilException{throw new CivilException("A divorced person cannot get divorced");};
	public ICivilStatus getSpouseDeceased()throws CivilException{throw new CivilException("A divorced person cannot get widowed");};
}
