import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class CompanyTest {
	@Test
	public void englishIntegrationTest() {
		Company comp = new Company();
		assertEquals("Fin/Log", comp.showDepartments(2016));
	}
}
