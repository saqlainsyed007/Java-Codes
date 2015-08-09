package Patterns;

class Pattern3 {
	public static void main(String[] args) {
		int n=4,m=1;
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=4-i;j++)  // Comment This Loop for Left Alignment
			{
				System.out.print(" "); // 1 Space for Triangle, 2 Space for Right Angled Triangle
			}
			for(int k=1;k<=i;k++)
			{
				System.out.print(m++ +" ");
			}
			System.out.println();
		}
	}
}
