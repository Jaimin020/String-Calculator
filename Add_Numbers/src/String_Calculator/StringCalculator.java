package String_Calculator;
import java.util.StringTokenizer;

public class StringCalculator {
	public int Add(String numbers)
	{
		if(numbers.isEmpty())
		{
			return 0;
		}
		else
		{
			StringTokenizer st = new StringTokenizer(numbers,",");
			int sum=0;
			while(st.hasMoreTokens())
			{
				sum+=Integer.parseInt(st.nextToken());
			}
			return(sum);
		}
	}

}
