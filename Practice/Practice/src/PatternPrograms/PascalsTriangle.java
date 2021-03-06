package PatternPrograms;
class PascalsTriangle 
{
	public static void main(String[] args) {
		int n=5;
		n=n+1;// To avoid ArrayIndexOutOfBoundsException
		int a[][] = new int[n][n];
			
		//Array initialization
		a[0][0]=a[1][0]=a[1][1]=1;
		for(int i=1;i<n;i++)
		{
			for(int j=1;j<n;j++)
			{
				if(i==j) a[i][j]=1;
				else if(j==1) a[i][j]=1;
				else if(j>i) a[i][j]=0;
				else a[i][j]=a[i-1][j]+a[i-1][j-1];
			}
		}
		
		//Printing Array
		for(int i=1;i<n;i++)
		{
			for(int j=1;j<n;j++)
			{
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		//Printing Pascals Triangle
		for(int i=1;i<n;i++)
		{
			for(int k=i;k<n-1;k++) // Comment This Loop for Left Alignment
			{
				System.out.print(" "); // 1 Space for Triangle, 2 Space for Right Angled Triangle
			}
			for(int j=1;j<n;j++)
			{
				if(a[i][j]!=0)
				{
					System.out.print(a[i][j]+" ");
				}
			}
			System.out.println();
		}
	}
}