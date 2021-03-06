package String_Calculator;

//This exception is throw if negative numbers are occurs.
public class NegativeNumberException extends Exception {
	NegativeNumberException(String nums)
	{
		super("Negatives not allowed \n Numbers are "+nums);
	}
}
