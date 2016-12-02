
public interface ICivilStatus {
	public default String getCivilStatusString(){return "";};
	public default ICivilStatus getMarried() throws CivilException{return null;};
	public default ICivilStatus getDivorced() throws CivilException{return null;};
	public default ICivilStatus getSpouseDeceased() throws CivilException{return null;};
}
