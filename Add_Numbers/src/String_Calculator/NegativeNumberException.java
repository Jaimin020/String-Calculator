package String_Calculator;

public class NegativeNumberException extends Exception {
	NegativeNumberException(String nums)
	{
		super("Negatives not allowed \n Numbers are "+nums);
	}
}
