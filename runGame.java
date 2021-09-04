import java.util.ArrayList;

/**
 * 
 * @author Group24
 * @version 2.5
 * @since 2019-11-18
 *
 */


public class runGame {
	
	/**Displays both player's pokemons.
	 * @param p Player.
	 * @param PPokemon Pokemon.
	 */
	public static void displayTable(Player p, ArrayList<Pokemon> PPokemon) {
		System.out.printf("%s's cards\n", p.getPlayername());
		System.out.println("| No.|    Type    | Stage | Exp | HP | Energy | Energy Colour | AP | RP | Status |");
		
		for (int i = 0; i < 6; i++) {
			Pokemon t = PPokemon.get(i);
			System.out.printf("|%-4d|%-12s|%-7d|%-5d|%-4d|%-8d|%-15s|%-4d|%-4d|%-8s|\n", i+1, t.getType(), t.getStage(), t.getExp(), t.getHp(), t.getEnergy(), t.getEnergycolour(), t.getAttackPoint(), t.getResistancePoint(), t.getStatus() );
			
		}
	}
	
	/**Menu options at the beginning of the game.
	 * Player can choose 1 to start new game or 2 to show leaderboard.
	 * @param option Player's menu options.
	 */
	public static void gameOption(int option) {
		switch(option) {
		case 1:
			System.out.println("Option 1:");
			System.out.printf("Drawing card for Player 1...\n","Drawing card for Player 2...\n");
			System.out.println("****display the players’ card******");
			break;
		case 2:
			top10leaderboard hm = new top10leaderboard();
			System.out.println("top 10 score");
			
			break;
		default:
			break;
		}
	}
}
