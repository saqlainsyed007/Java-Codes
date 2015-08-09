package PatternPrograms;
public class Pattern4 
{
	public static void main(String[] args) 
	{
		int n=4;
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=n-i;j++) // Comment This Loop for Left Alignment
			{
				System.out.print("  "); //2 Space for Triangle, 4 Space for Right Angled Triangle
			}
			for(int k=1;k<=i;k++)
			{
				System.out.print(k+" ");
			}
			
			for(int l=i-1;l>=1;l--)
			{
				System.out.print(l+" ");
			}
			System.out.println();
		}
	}
}
