package throwExercise;
import java.io.FileReader;
import java.io.IOException;
public class ExceptionHandlingDemo {

	private static final String FILENAME = "E:\\test\\filename.txt";
	
	public static void main (String[] args){
		try {
			ioexc();
			argexc();
		}catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }  catch (IOException exception) {
            System.out.println(exception.getMessage());
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
		

	}
	
	//IOException()
	static FileReader ioexc() throws IOException{
		FileReader fr = null;
		fr = new FileReader(FILENAME);
		return fr;
	}
	
	//IllegalArgumentException
	static String argexc() throws IllegalArgumentException{
		return null;		
	}
	
	//Throwable
	static String thexc() throws Throwable{
		return null;
		
	}
	
	//AssertionError
		static String asexc() throws AssertionError{
			return null;			
		}
}
