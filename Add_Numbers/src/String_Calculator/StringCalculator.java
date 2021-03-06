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
			int sum = 0;
			if(numbers.charAt(0)=='/')
			{
				String del = "";
				del+=numbers.charAt(2);
				del="["+del+"]";
				String[] nums = numbers.substring(4).split(del);
				for(int i=0;i<nums.length;i++)
				{
					sum+=Integer.parseInt(nums[i]);
				}
			}
			else
			{
				String[] nums = numbers.split(",|\n");
				for(int i=0;i<nums.length;i++)
				{
					sum+=Integer.parseInt(nums[i]);
				}
			}
			return sum;
		}
	}

}
