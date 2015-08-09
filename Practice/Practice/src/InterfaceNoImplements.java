//Call Interface Method without using implements

interface I
{
	int process(int a);
}
class InterfaceNoImplements
{
	public static void main(String[] args) 
	{
		try
		{
			I i=new I() 
			{
				public int process(int a)
				{
					return a;
				}
			};
			System.out.println(i.process(50));
		}
		catch(Exception e)
		{
			
		}
	}
}
