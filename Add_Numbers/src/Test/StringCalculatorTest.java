package Test;
import String_Calculator.StringCalculator;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
	private StringCalculator sc;
	
	@BeforeEach
	public void setup()
	{
		sc = new StringCalculator();
	}
	
	@Test
	@DisplayName("Addition of empty string should work")
	public void testAdd_Base_Condition()
	{
		assertEquals(0,sc.Add(""),"Additon should work");
	}
	
	@Test
	@DisplayName("Addition of string containg only one digit should work")
	public void testAdd_onedigit()
	{
		assertEquals(2,sc.Add("2"),"Additon with one digit should work");
		assertEquals(1,sc.Add("1"),"Additon with one digit should work");
	}
	
	@Test
	@DisplayName("Addition of string containg only two digit should work")
	public void testAdd_twodigit()
	{
		assertEquals(3,sc.Add("1,2"),"Additon with 2 digit should work");
	}
	@Test
	@DisplayName("Addition of string containg more than two digit should work")
	public void testAdd_digits()
	{
		assertEquals(10,sc.Add("1,2,3,4"),"Additon of digits should work");
		assertEquals(26,sc.Add("5,6,8,7"),"Additon of digits should work");
	}
	
}
