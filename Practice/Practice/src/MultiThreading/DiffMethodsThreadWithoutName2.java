/*
Another Engineer has coded a class Calculator with add() and sub().
Make this class threaded such that one thread calls add() and one thread calls sub().
*/

package MultiThreading;

import java.util.Scanner;

class Calc
{
	int a,b;
	Calc(int a,int b)
	{
		this.a=a;
		this.b=b;
	}
	public int add()
	{
		return a+b;
	}
	public int sub()
	{
		return a-b;
	}
}

abstract class ThreadExmpApp extends Calc implements Runnable
{
	ThreadExmpApp(int a, int b)
	{
		super(a, b);
	}	
}

public class DiffMethodsThreadWithoutName2
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter 2 Numbers");
		int a=scan.nextInt();
		int b=scan.nextInt();
		ThreadExmpApp e1=new ThreadExmpApp(a,b)
		{
			public void run()
			{
				System.out.println("Thread 1 executing add()");
				System.out.println(add());
			}
		};
		ThreadExmpApp e2=new ThreadExmpApp(a,b)
		{
			public void run()
			{
				System.out.println("Thread 2 executing sub()");
				System.out.println(sub());
			}
		};
		Thread t1=new Thread(e1);
		Thread t2=new Thread(e2);
		t1.start();
		t2.start();
	}
}