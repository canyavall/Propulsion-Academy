package service;

public class GermanMessageService implements MessageService {

	@Override
	public String generateMessage(String name) {
		return "Hallo, " + name;
	}
	
	public void test(){
		
	}
}
