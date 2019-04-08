package fireflySnychronization;

public class Test1
{

	public static void main(String[] args)
	{
		Synchronization sy = new Synchronization(5, 5);

		int iter = 100;
		int i = 0;
		
		System.out.println(sy.toString());
		
		while(i<iter) {
			sy.run();
			i++;
			System.out.println(sy.toString());
		}
	}

}
