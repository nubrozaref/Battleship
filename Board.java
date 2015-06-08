public class Board implements GBoard{
	Ship[] board; // Contains all the ships.
	boolean[][] hits; // 10 by 10 board that contains all the current hit locations.
	Ship[][] shipsOnBoard; // 10 by 10 board that contains all the ship locations.

	// Initializes the Ship array list board. Also creates the hits array list.
	public Board()
	{
		hits = new boolean[10][10];
		board = new Ship[0];
		shipsOnBoard = new Ship[10][10];
	}
	
	public void placeShip(Location l, Direction d, Ship s){
		for(int i = 0; i < s.getLength(); i++){
			switch(d){
				case Up:
					shipsOnBoard[l.getX()][l.getY()-i] = s;
					break;
				case Down:
					shipsOnBoard[l.getX()][l.getY()+i] = s;
					break;
				case Left:
					shipsOnBoard[l.getX()-i][l.getY()] = s;
					break;
				case Right:
					shipsOnBoard[l.getX()+i][l.getY()] = s;
					break;
			}
		}
		Ship[] temp = new Ship[board.length + 1];
		for(int i = 0; i < board.length; i++){
			temp[i] = board[i];
		}
		temp[board.length] = s;
		board = temp;
	}
	// Checks if all ships are alive by looping through the hits board and checking if each ship in the board array 
	// is hit.
	public boolean allShipsIsKill()
	{
		for(int i = 0; i < 10; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				if (shipsOnBoard[i][j].isKill() == false)
				{
					return false;
				}
			}
		}
		return true;
	}
	// Checks if a certain location contains a ship.
	public boolean isShip(int x, int y)
	{
		if (shipsOnBoard[x][y] instanceof Ship)
		{
			return true;
		}
		return false;
	}
	// Checks if a location is hit or not.
	public boolean isHit(int x, int y)
	{
		if (hits[x][y] == true)
		{
			return true;
		}
		return false;
	}
	// Attacks a specified location, returning false if that location has been attacked and true if it succesfully attacked that location.
	public boolean attack(int x, int y)
	{
		if (this.isHit(x, y))
		{
			return false;
		}
		else
		{
			hits[x][y] = true;
			return true;
		}
	}

	@Override
	public Ship getShip(int x, int y) {
		return shipsOnBoard[x][y];
	}

	@Override
	public int getLength() {
		return hits.length;
	}
	
}
