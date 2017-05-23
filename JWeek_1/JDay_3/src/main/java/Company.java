
public class Company {
	
	public void main (String[] args){
		
	}

	public String showDepartments (int year){
		Finance fin = new Finance();
		Logistic log = new Logistic();
		String ret = fin.getDepartmentName(year) + "/" + log.getDepartmentName(year);
		return ret;
	}
}
