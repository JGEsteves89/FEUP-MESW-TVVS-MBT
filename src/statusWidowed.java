
public class statusWidowed implements ICivilStatus {
	public String getCivilStatusString(){return "widowed";};
	public ICivilStatus getMarried(){return new statusMarried();};
	public ICivilStatus getDivorced()throws CivilException{throw new CivilException("A widowed person cannot get divorced");};
	public ICivilStatus getSpouseDeceased()throws CivilException{throw new CivilException("A widowed person cannot get widowed");};
}
