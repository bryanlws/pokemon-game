import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * @author Group24
 * @version 2.5
 * @since 2019-11-18
 *
 */


public class Player extends Pokemon {
	/**Number of the player.*/
	private int playerno;
	/**Name of the player.*/
	private String playername;
	/**Number of turns for the players.*/
	private int turn;
	/**Arraylist of pokemons.*/
	private ArrayList<Pokemon> PPokemon = new ArrayList<Pokemon>();
	/**Constructor.*/
	public Player(int playerno, String playername) {
		this.playerno = playerno;
		this.playername = playername;
		
		Random rand = new Random();
		/**One player has six pokemon.
		 * Must have at least two attacking and one defending type pokemon.
		 */
		AttackPokemon pokemon1= new AttackPokemon();
			PPokemon.add(pokemon1);
		AttackPokemon pokemon2= new AttackPokemon();
			PPokemon.add(pokemon2);
		DefPokemon pokemon3 = new DefPokemon();
			PPokemon.add(pokemon3);
		/**Randomize the remaining three pokemon for each player.*/
		AttackPokemon pokemon4 = new AttackPokemon();
		DefPokemon pokemon5 = new DefPokemon();
		Fairy pokemon6 = new Fairy();
		

		for(int i = 0; i < 3; i++){
			int type = rand.nextInt(3);
				if (type == 0){
					PPokemon.add(pokemon4);
				}
				else if(type == 1){
					PPokemon.add(pokemon5);
				}
				else 
					PPokemon.add(pokemon6);
				}
		}


	/**@return the playernumber.*/
	public int getPlayerno() {
		return playerno;
	}
	/**@return the playername.*/
	public String getPlayername() {
		return playername;
	}
	/**@return the number of turns.*/
	public int getTurn() {
		return turn;
	}
	/**@return the pokemon in the arraylist.*/
	public ArrayList<Pokemon> getPPokemon() {
		return PPokemon;
	}
	/**Sets the playernumber.
	 * @param playerno Player's number.
	 */
	public void setPlayerno(int playerno) {
		this.playerno = playerno;
	}
	/**Sets the player's name.
	 * @param playername Player's name.
	 */
	public void setPlayername(String playername) {
		this.playername = playername;
	}
	/**Sets the turn of the player.
	 * @param turn Turn of the player.
	 */
	public void setTurn(int turn) {
		this.turn = turn;
	}
	/**Sets the pokemon in the arraylist.
	 * @param pPokemon pokemon in the arraylist.
	 */
	public void setPPokemon(ArrayList<Pokemon> pPokemon) {
		PPokemon = pPokemon;
	}
	
	
	@Override
	public String toString() {
		return String.format("Player [playerno=%s, playername=%s]", playerno, playername);
	}
}