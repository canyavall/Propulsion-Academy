
public class Finance extends Department{
	
	
	public String getDepartmentName(int year){
		String res = "Fin";
		if (year == 2017)res = "Finance";
		return super.getName(res);
	}
}
