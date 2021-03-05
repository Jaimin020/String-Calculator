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
			int sum,n1=0,n2=0;
			n1 = Integer.parseInt(st.nextToken());
			if(st.hasMoreTokens())
			{
				n2 = Integer.parseInt(st.nextToken());
			}
			sum=n1+n2;
			return(sum);
		}
	}

}
