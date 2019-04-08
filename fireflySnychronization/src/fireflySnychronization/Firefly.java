package fireflySnychronization;

import java.util.Random;

public class Firefly
{

	private int timer = 0;
	
	public Firefly()
	{
	}
	
	public void setTimer() {
		Random rn = new Random();
		this.timer = rn.nextInt(9); 
	}
	
	public int getTimer() {
		return timer;
	}
	
	public void tick() {
		timer += 1;
		
		if(timer >= 10) {
			timer = 0;
		}
	}
	
	public void decrement() {
		timer -= 1;
		
		if(timer < 0) {
			timer = 9;
		}
	}
	
	public void increment() {
		timer += 1;
		
		if(timer >= 10) {
			timer = 0;
		}
	}

}
