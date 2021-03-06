package Test;
import String_Calculator.*;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

//Here all test cases are defined. Testing is done using JUnit 5.
public class StringCalculatorTest
{
	private StringCalculator sc;
	
	@BeforeEach
	public void setup()
	{
		sc = new StringCalculator();
	}
	
	
	@Test
	@DisplayName("Addition of empty string should work")
	public void testAdd_Base_Condition() throws NegativeNumberException
	{
		assertEquals(0,sc.Add(""),"Additon should work");
	}
	
	@Test
	@DisplayName("Addition of string containg only one digit should work")
	public void testAdd_onedigit() throws NegativeNumberException
	{
		assertEquals(2,sc.Add("2"),"Additon with one digit should work");
		assertEquals(1,sc.Add("1"),"Additon with one digit should work");
	}
	
	@Test
	@DisplayName("Addition of string containg only two digit should work")
	public void testAdd_twodigit() throws NegativeNumberException
	{
		assertEquals(3,sc.Add("1,2"),"Additon with 2 digit should work");
	}
	
	@Test
	@DisplayName("Addition of string containg more than two digit should work")
	public void testAdd_digits() throws NegativeNumberException
	{
		assertEquals(10,sc.Add("1,2,3,4"),"Additon of digits should work");
		assertEquals(26,sc.Add("5,6,8,7"),"Additon of digits should work");
	}
	
	@Test
	@DisplayName("Addition of string containg ',' and '\n' as delimeter")
	public void testAdd_with_new_delimeter() throws NegativeNumberException
	{
		assertEquals(3,sc.Add("1\n2"),"Additon of digits with multiple delimeter should work");
		assertEquals(6,sc.Add("1\n2,3"),"Additon of digits with multiple delimeter should work");
		assertEquals(18,sc.Add("5,6\n7"),"Additon of digits with multiple delimeter should work");
		assertEquals(18,sc.Add("5\n6\n7"),"Additon of digits with multiple delimeter should work");
	}
	
	@Test
	@DisplayName("Addition of string containg custom delimeter(optional)")
	public void testAdd_custom_delimeter() throws NegativeNumberException
	{
		assertEquals(3,sc.Add("//;\n1;2"),"Additon of digits with custom delimeter should work");
		assertEquals(5,sc.Add("//\n\n2\n3"),"Additon of digits with custom delimeter should work");
		assertEquals(18,sc.Add("//.\n5.6.7"),"Additon of digits with custom delimeter should work");
		assertEquals(18,sc.Add("5\n6,7"),"Additon of digits with custom delimeter should work");
	}
	
	@Test
	@DisplayName("Addition of string containg negative numbers")
	public void testAdd_negative_nums() throws NegativeNumberException
	{
		Exception exception = assertThrows(NegativeNumberException.class, () -> {
	        sc.Add("//;\n-1;2;-2");
	    });
		String expectedMessage = "Negatives not allowed";
	    String actualMessage = exception.getMessage();
	    System.out.print(actualMessage);
	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	@DisplayName("Addition of string containg numbers greater than 1000")
	public void testAdd_nums_greater_tha_1000() throws NegativeNumberException
	{
		assertEquals(2,sc.Add("//;\n1001;2"),"Additon of digits with custom delimeter should work");
		assertEquals(0,sc.Add("//\n\n10001\n10002"),"Additon of digits with custom delimeter should work");
		assertEquals(1011,sc.Add("//.\n5.6.1000"),"Additon of digits with custom delimeter should work");
		assertEquals(18,sc.Add("5\n6,7"),"Additon of digits with custom delimeter should work");
	}
	
	@Test
	@DisplayName("Addition of string containg delimiter of any lenth")
	public void testAdd_delimiter_of_any_lenth() throws NegativeNumberException
	{
		assertEquals(2,sc.Add("//[***]\n1001***2"),"Additon of digits should work");
		assertEquals(0,sc.Add("//[((]\n10001((10002"),"Additon of digits should work");
		assertEquals(1011,sc.Add("//[...]\n5...6...1000"),"Additon of digits should work");
		assertEquals(18,sc.Add("5\n6,7"),"Additon of digits should work");
		assertEquals(18,sc.Add("//[??]\n5??6??7"),"Additon of digits should work");
	}
	
	@Test
	@DisplayName("Addition of string containg Multiple delimiters")
	public void testAdd_Mul_delimiter() throws NegativeNumberException
	{
		assertEquals(5,sc.Add("//[*][?]\n1001*2?3"),"Additon of digits should work");
		assertEquals(0,sc.Add("//[(]\n10001(10002"),"Additon of digits should work");
		assertEquals(1011,sc.Add("//[.][*]\n5.6*1000"),"Additon of digits should work");
		assertEquals(18,sc.Add("5\n6,7"),"Additon of digits should work");
		assertEquals(18,sc.Add("//[??]\n5??6??7"),"Additon of digits should work");
	}
	
	@Test
	@DisplayName("Addition of string containg Multiple delimiters of any length")
	public void testAdd_Mul_delimiter_any_length() throws NegativeNumberException
	{
		assertEquals(5,sc.Add("//[**][?]\n1001**2?3"),"Additon of digits should work");
		assertEquals(0,sc.Add("//[(]\n10001(10002"),"Additon of digits should work");
		assertEquals(1011,sc.Add("//[...][**]\n5...6**1000"),"Additon of digits should work");
		assertEquals(18,sc.Add("5\n6,7"),"Additon of digits should work");
		assertEquals(18,sc.Add("//[???][**]\n5???6**7"),"Additon of digits should work");
	}
	
	
}