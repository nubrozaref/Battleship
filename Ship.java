public class Ship {

	int hitPoints;
	int length;
	String name;

	public Ship( String name , int hitPoints)
	{
		this.name = name;
		this.hitPoints = hitPoints;
		this.length = hitPoints;
	}

	public void attack()
	{
		hitPoints --;
	}

	public boolean isKill()
	{
		return (hitPoints == 0);
	}

	public String toString()
	{
		return name;
	}

	public int getHitPoints()
	{
		return hitPoints;
	}

	public int getLength()
	{
		return length;
	}

}
