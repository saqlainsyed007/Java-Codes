package MultiThreading;

class Queue
{
	int x;
	boolean value_is_present=false;
	
	synchronized public void get()
	{
		try
		{
			if(value_is_present==false)
			{
				wait();
			}
			System.out.println("I have taken "+x);
			value_is_present=false;
			notify();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	synchronized public void put(int j)
	{
		try
		{
			if(value_is_present==true)
			{
				wait();
			}
			x=j;
			System.out.println("I have put "+x);
			value_is_present=true;
			notify();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}

class Producer implements Runnable
{
	Queue q;
	int i=0;
	
	Producer(Queue q)
	{
		Thread t=new Thread(this);
		t.start();
		this.q=q;
	}
	
	synchronized public void run()
	{
		while(i<=10) 
		{
			q.put(i++);
		}
	}
}

class Consumer implements Runnable
{
	int x;
	Queue q;
	
	Consumer(Queue q)
	{
		Thread t=new Thread(this);
		t.start();
		this.q=q;
	}
	
	synchronized public void run()
	{
		while(true) 
		{
			q.get();
		}
	}
}

class ProducerConsumer 
{
	public static void main(String args[])
	{
		Queue q=new Queue();
		Producer p=new Producer(q);
		Consumer c=new Consumer(q);
	}

}
