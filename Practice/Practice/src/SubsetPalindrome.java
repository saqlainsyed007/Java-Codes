/*
 WAP to take an input as two integers X and Y. 
 
 X indicates the number of elements in the set and Y indicates the subset length.
 
 Input X number of elements through Console and print all possible subsets of length Y
 	of the set of input taken. Also print the Number of subsets that become palindrome
 	and those that do not.
 	
 Note : A subset may have repeated characters.
 */

import java.io.*;
import java.util.*;
public class SubsetPalindrome 
{

	char subsets[][];
	char elements[];
	static int x; //Number of elements
	static int y; //Number of elements in subset
	static int countP=0,countNP=0;
	
	boolean is_ValidIndex(int num)
	{
		while(num!=0)
		{
			int digit=num%10;
			if(digit>x-1)
			{
				return false;
			}
			num=num/10;
		}
		return true;
	}
	
	public boolean is_Palindrome(String str)
	{
		char temp[]=new char[str.length()];
		int j=0;
		for(int i=str.length()-1;i>=0;i--)
		{
			temp[j++]=str.charAt(i);
		}
		String strrev = new String(temp);
		if(strrev.equals(str))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static void main(String[] args)
	{
		try
		{
			SubsetPalindrome s=new SubsetPalindrome();
			int indexes[];
			int max_index=0;
			Scanner scan=new Scanner(System.in);
			System.out.println("Enter the number of elements");
			x=scan.nextInt();
			s.elements = new char[x];	
			System.out.println("Enter the elements");
			for(int i=0;i<x;i++)
			{
				s.elements[i]=(char) new InputStreamReader(System.in).read ();
			}
		
			System.out.print("The Elements are : ");
			for(int i=0;i<x;i++)
			{
				System.out.print(s.elements[i]+" ");
			}
			System.out.println();
			
			int n=x-1;
			System.out.println("Enter the length of the subset");
			y=scan.nextInt();
			s.subsets=new char[(int) Math.pow(x,y)][y];
			
			if(x<=y)
			{
				System.out.println("Cannot Find Subsets. Enter proper length");
				return;
			}	
		
			for(int i=0;i<y;i++)
			{
				max_index=max_index*10+n;
			}	
			//System.out.println("Max Index = "+max_index);
		
			indexes=new int[y];
			int k=0;
			//System.out.println("Indexes :");	// To print Indexes Remove this comment and also the below one
			for(int i=0;i<=max_index;i++)
			{
				int p=i;
				if(s.is_ValidIndex(i))
				{
					for(int j=y-1;j>=0;j--)
					{
						int digit=p%10;
						indexes[j]=digit;
						p=p/10;
					}
					/*for(int d=0;d<y;d++)
					{
						System.out.print(indices[d]);
					}
						System.out.print("\t");
					if(i%10==0)
					{
						System.out.println();
					}*/
					for(int l=0;l<y;l++)
					{
						s.subsets[k][l]=s.elements[indexes[l]];
					}
					k++;
				}
			}
			System.out.println();
			System.out.println("The subsets are ");
			for(int i=0;i<Math.pow(x, y);i++)
			{
				for(int j=0;j<y;j++)
				{
					System.out.print(s.subsets[i][j]);
				}
				System.out.print(" ");
				if(i%10==0)
				{
					System.out.println();
				}
			}
			System.out.println("\n");
			for(int i=0;i<Math.pow(x, y);i++)
			{
				String temp=new String(s.subsets[i]);
				if(s.is_Palindrome(temp))
				{
					countP++;
				}
				else if(!s.is_Palindrome(temp))
				{
					countNP++;
				}
			}
			System.out.println("Palindrome Count = "+countP+"\nNon Palindrome Count = "+countNP);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
