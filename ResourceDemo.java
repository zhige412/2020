class ResourceDemo 
{
	public static void main(String[] args) 
	{
		Resource r = new Resource();
		Input t1  = new Input(r);
		Output t2 = new Output(r);
		Thread d1 = new Thread(t1);
		Thread d2 = new Thread(t2);
		d1.start();
		d2.start();
		//System.out.println("Hello World!");
	}
}
class Resource
{
	String name;
	String sex;
}
class Input implements Runnable
{
	Resource r;
	Input(Resource r)
	{
		this.r = r;
	}
	public void run()
	{
		int x = 0;
		while(true)
		{
			synchronized(r)
			{
				if(x==0)
				{
					r.name = "mike";
					r.sex  = "nan";
				}
				else
				{
					r.name = "丽丽";
					r.sex  = "女女女女女女";
				}
				x = (x+1)%2;
			}
		}
	}
}
class Output implements Runnable
{
	Resource r;
	Output(Resource r)
	{
		this.r = r;
	}
	public void run()
	{
		while(true)
			synchronized(r)
		{
			System.out.println(r.name+"....."+r.sex);
		}
	}
}