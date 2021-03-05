package String_Calculator;

public class StringCalculator {
	public int Add(String numbers)
	{
		if(numbers.isEmpty())
		{
			return 0;
		}
		else
		{
			String[] nums = numbers.split(",|\n");
			int sum = 0;
			for(int i=0;i<nums.length;i++)
			{
				sum+=Integer.parseInt(nums[i]);
			}
			return sum;
		}
	}

}
