package fireflySnychronization;

public class Synchronization
{

	public Firefly[][]	firefly;
	private int			x;
	private int			y;

	public Synchronization(int x, int y)
	{
		this.x = x - 1;
		this.y = y - 1;
		this.firefly = new Firefly[x][y];
		
		for(int i=0; i < x; i++) {
			for(int j=0; j < y; j++) {
		    
			firefly[i][j] = new Firefly();
			firefly[i][j].setTimer();
			}
		}
	}

	public void run()
	{
		for (int i = 0; i < firefly.length; i++)
		{
			for (int j = 0; j < firefly[i].length; j++)
			{
				if (isNeigbourflashing(i, j))
				{
					if (firefly[i][j].getTimer() >= 0 && firefly[i][j].getTimer() <= 3)
					{
						firefly[i][j].tick();
						firefly[i][j].decrement();

					}
					else if (firefly[i][j].getTimer() >= 4 && firefly[i][j].getTimer() <= 7)
					{
						firefly[i][j].tick();
						firefly[i][j].increment();
					}
					else if (firefly[i][j].getTimer() == 8 || firefly[i][j].getTimer() == 9)
					{
						firefly[i][j].tick();
					}
				}
				else
				{
					firefly[i][j].tick();
				}
			}
		}
	}

	public boolean isNeigbourflashing(int i, int j)
	{
		/**
		 * j j j j j
		 * 
		 * i 2 7 6 9 3 i 1 5 8 3 7 i 6 9 1 8 5 i 4 8 1 7 9 i 9 3 0 1 8
		 * 
		 */

		if (i == 0)
		{
			if (j == 0)
			{
				if (firefly[i + 1][j].getTimer() == 9 || firefly[i][j + 1].getTimer() == 9)
				{
					return true;
				}
			}
			else if (j == y)
			{
				if (firefly[i + 1][j].getTimer() == 9 || firefly[i][j - 1].getTimer() == 9)
				{
					return true;
				}
			}
			else
			{
				if (firefly[i][j - 1].getTimer() == 9 || firefly[i][j + 1].getTimer() == 9 || firefly[i + 1][j].getTimer() == 9)
				{
					return true;
				}
			}
		}
		else if (i == x)
		{
			if (j == 0)
			{
				if (firefly[i - 1][j].getTimer() == 9 || firefly[i][j + 1].getTimer() == 9)
				{
					return true;
				}
			}
			else if (j == y)
			{
				if (firefly[i - 1][j].getTimer() == 9 || firefly[i][j - 1].getTimer() == 9)
				{
					return true;
				}
			}
			else
			{
				if (firefly[i][j - 1].getTimer() == 9 || firefly[i][j + 1].getTimer() == 9 || firefly[i - 1][j].getTimer() == 9)
				{
					return true;
				}
			}
		}
		else if (i != 0 && i != x)
		{
			if (j == 0)
			{
				if (firefly[i - 1][j].getTimer() == 9 || firefly[i + 1][j].getTimer() == 9 || firefly[i][j + 1].getTimer() == 9)
				{
					return true;
				}
			}
			else if (j == y)
			{
				if (firefly[i - 1][j].getTimer() == 9 || firefly[i + 1][j].getTimer() == 9 || firefly[i][j - 1].getTimer() == 9)
				{
					return true;
				}
			}
		}
		else
		{
			if (firefly[i - 1][j].getTimer() == 9 || firefly[i + 1][j].getTimer() == 9 || firefly[i][j + 1].getTimer() == 9
					|| firefly[i][j - 1].getTimer() == 9)
			{
				return true;
			}
		}

		return false;
	}
	
	public String toString() {
		String graph ="";
		for(int i=0; i < firefly.length; i++) {
			for(int j=0; j < firefly[i].length; j++) {
				graph += firefly[i][j].getTimer()+",";
			}
			graph += "\n";
		}
		return graph;
	}
}
