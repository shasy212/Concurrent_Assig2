package nuber.students;

import java.util.Random;

public class Driver extends Person {

	private Passenger currPassenger;
	private Random random;
	
	public Driver(String driverName, int maxSleep)
	{
		super(driverName, maxSleep);
		this.random = new Random();
	}
	
	/**
	 * Stores the provided passenger as the driver's current passenger and then
	 * sleeps the thread for between 0-maxDelay milliseconds.
	 * 
	 * @param newPassenger Passenger to collect
	 * @throws InterruptedException
	 */
	public void pickUpPassenger(Passenger newPassenger)
	{
		this.currPassenger = newPassenger;
		try{
			int timeSleep = random.nextInt(maxSleep + 1);
			Thread.sleep(timeSleep);
		} catch (InterruptedException e){
			Thread.currentThread().interrupt();
		}
	}

	/**
	 * Sleeps the thread for the amount of time returned by the current 
	 * passenger's getTravelTime() function
	 * 
	 * @throws InterruptedException
	 */
	public void driveToDestination() {
		if (currPassenger == null) return;

		try {
			int timeTravel = currPassenger.getTravelTime();
			Thread.sleep(timeTravel);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public void releasePassenger(){
		this.currPassenger = null;
	}

	public Passenger getCurrPassenger(){
		return currPassenger;
	}
	
}
