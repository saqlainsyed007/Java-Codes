package MultiThreading;

class Team1 extends Thread
{
	String name;
	Team1 next;
	
	
	Team1(String name)
	{
		super(name);
		this.name=name;
	}
	
	Team1(String name, Team1 next)
	{
		super(name);
		this.next=next;
		this.name=name;
	}
	
	synchronized public void run()
	{
		try
		{
			if(!getName().equals("Team1Player1"))
				wait();
			System.out.println(getName()+" completed");
			Thread.sleep(5000);
			if(!getName().equals("Team1Player3"))
			synchronized(next)
			{
				next.notify();
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}	
	}
}

class Team2 extends Thread
{
	String name;
	Team2 next;
	
	Team2(String name)
	{
		super(name);
		this.name=name;
	}
	
	Team2(String name, Team2 next)
	{
		super(name);
		this.next=next;
		this.name=name;
	}
	
	synchronized public void run()
	{
		try
		{	
			if(!getName().equals("Team2Player1"))
				wait();
			System.out.println(getName()+" completed");
			Thread.sleep(5000);
			if(!getName().equals("Team2Player3"))

			synchronized(next)
			{
				next.notify();
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}	
	}
}

class RelayRaceSimulation extends Thread
{
	public static void main(String[] args) 
	{
		Team1 t1p3=new Team1("Team1Player3");
		Team1 t1p2=new Team1("Team1Player2",t1p3);
		Team1 t1p1=new Team1("Team1Player1",t1p2);
		
		Team2 t2p3=new Team2("Team2Player3");
		Team2 t2p2=new Team2("Team2Player2",t2p3);
		Team2 t2p1=new Team2("Team2Player1",t2p2);
		
		t1p1.start();
		t1p2.start();
		t1p3.start();
		
		t2p1.start();
		t2p2.start();
		t2p3.start();
	}

}
