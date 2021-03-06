package String_Calculator;

public class StringCalculator {
	public int Add(String numbers) throws NegativeNumberException
	{
		if(numbers.isEmpty())
		{
			return 0;
		}
		else
		{
			int sum = 0;
			int tem;
			String neg_nums="";
			int flag = 0;
			if(numbers.charAt(0)=='/')
			{
				String del = "";
				String[] nums;
				if(numbers.charAt(2)!='[')
				{
					del+=numbers.charAt(2);
					del="["+del+"]";
					nums = numbers.substring(4).split(del,-1);
				}
				else
				{
					int j=3;
					del+='(';
					while(numbers.charAt(j)!=']')
					{
						if(numbers.charAt(j)=='*' || numbers.charAt(j)=='(' || numbers.charAt(j)=='.' || numbers.charAt(j)=='+' || numbers.charAt(j)=='?' || numbers.charAt(j)==')')
						{
							del+='\\';
						}
						del+=numbers.charAt(j);
						j+=1;
					}
					del+=')';
					nums = numbers.substring(j+2).split(del);
				}
				for(int i=0;i<nums.length;i++)
				{
					tem = Integer.parseInt(nums[i]);
					if(tem<0)
					{
						flag=1;
						neg_nums+=(nums[i]+" ");
					}
					if(tem>1000)
					{
						continue;
					}
					sum+=tem;
				}
				if(flag==1)
				{
					throw new NegativeNumberException(neg_nums); 
				}
			}
			else
			{
				String[] nums = numbers.split(",|\n");
				for(int i=0;i<nums.length;i++)
				{
					tem = Integer.parseInt(nums[i]);
					if(tem<0)
					{
						flag=1;
						neg_nums+=(nums[i]+" ");
					}
					if(tem>1000)
					{
						continue;
					}
					sum+=tem;
				}
				if(flag==1)
				{
					throw new NegativeNumberException(neg_nums); 
				}
			}
			return sum;
		}
	}

}
