package MultiThreading;

class Acquirer extends Thread
{
	String resource1="Resource1";
	String resource2="Resource2";
	String resource3="Resource3";
	
	Acquirer(String name)
	{
		super(name);
	}
	
	public void run()
	{
		if(getName().equals("Process1"))
		{
			proc1AcqRsc();
		}
		else if(getName().equals("Process2"))
		{
			proc2AcqRsc();
		}
	}
	
	public void proc1AcqRsc()
	{
		synchronized(resource1)
		{
			System.out.println("Process 1 Acquired Resource 1 waiting for Resource 2");
			
			synchronized(resource2)
			{
				System.out.println("Process 1 Acquired Resource 2 waiting for Resource 3");
				
				synchronized(resource3)
				{
					System.out.println("Process 1 Acquired Resource 3");
				}
			}
		}
	}
	
	public void proc2AcqRsc()
	{
		synchronized(resource3)
		{
			System.out.println("Process 2 Acquired Resource 3 waiting for Resource 2");
			
			synchronized(resource2)
			{
				System.out.println("Process 2 Acquired Resource 2 waiting for Resource 1");
				
				synchronized(resource1)
				{
					System.out.println("Process 2 Acquired Resource 1");
				}
			}
		}
	}
}

class Deadlock 
{
	public static void main(String[] args) 
	{
		Acquirer a1=new Acquirer("Process1");
		Acquirer a2=new Acquirer("Process2");
		
		a1.start();
		a2.start();
	}

}
