
public class Logistic extends Department{
	
	public String getDepartmentName(int year){
		String res = "Log";
		if (year == 2017)res = "Logistic";
		return super.getName(res);
	}
}
