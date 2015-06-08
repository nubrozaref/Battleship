import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.Random;

public class Program {

	public static void main(String[] arg)
	{

		String userName = "";
		String userDialog = "";
		JOptionPane jPane = new JOptionPane();

		/**
		 * these are the arrays of player's ship locations,
		 * the user will set each one in the command prompt
		 */
		Location playerLoc[] = new Location[5];
		Location enemyLoc[] = new Location[5];


		String userIn = "";
		//player ships
		AircraftCarrier ship1 =  new AircraftCarrier();
		BattleShip ship2 = new BattleShip();
		Destroyer ship3 = new Destroyer();
		Submarine ship4 = new Submarine();
		PatrolBoat ship5 = new PatrolBoat();

		//enemy ships
		AircraftCarrier ship6 =  new AircraftCarrier();
		BattleShip ship7 = new BattleShip();
		Destroyer ship8 = new Destroyer();
		Submarine ship9 = new Submarine();
		PatrolBoat ship10 = new PatrolBoat();


		Ship playerShips[] = {ship1,ship2,ship3,ship4,ship5};
		Ship enemyShips[] = {ship6,ship7,ship8,ship9,ship10};


		Board playerBoard = new Board();
		Board enemyBoard = new Board();

		BGraphics g = new BGraphics((GBoard)playerBoard,(GBoard)enemyBoard);
		g.setLocation(200,150);
		g.setVisible(true);
		g.update(g.getGraphics());

		boolean done = false;
		System.out.println("Welcome to BattleShip! \n"
				+ "specify your ship locations."); 


		while ( !done )
		{	

			for( int i = 0 ; i < 5 ; i ++)
			{
				userDialog = jPane.showInputDialog(playerShips[i] , "text");
				if(userDialog != null)
				{
					//System.out.println(userDialog);
					if((PlaceShip(playerShips[i],playerBoard,userDialog)))
					{
						Location loc = new Location(Integer.valueOf(userDialog.substring(0,1))
								,Integer.valueOf(userDialog.substring(1,2))); //TODO assuming we use just nums
						System.out.println("X = " +loc.getX() + " " + "Y = " +loc.getY()); // test

						Direction setDir = (setDirection(userDialog.substring(3,4)));

						playerBoard.placeShip(loc, setDir, playerShips[i]);
						g.update(g.getGraphics());
					}
				}
				else
					done = true;
					break;
			}



			if (userIn.equals("quit"))
			{
				done = true;
				System.out.println("Goodbye");
			}
			g.update(g.getGraphics());
		}

	}

	private static boolean PlaceShip(Ship s , Board b, String line)
	{
		if(line.split(",").length != 2){ // ex. A4, D
			return false;
		}else 


			return true;
	}

	private static Direction setDirection(String dir)
	{
		switch(dir){

			case "U": return Direction.Up;
			case "D": return Direction.Down;
			case "L": return Direction.Left;
			case "R": return Direction.Right;
			default : return Direction.Right;

		}		
	}

}
