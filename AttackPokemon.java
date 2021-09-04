import java.util.Random;

/**
 * 
 * @author Group24
 * @version 2.5
 * @since 2019-11-18
 *
 */


public class AttackPokemon extends Pokemon {
	
	
	/**Constructor.*/
	public AttackPokemon() {
		super();
		Random rand = new Random();
		
		setType("Attacking");
		setAttackPoint(2 + rand.nextInt(4));
		setResistancePoint(0);
	}
	
	
	/**Overrides the attack method for attacking pokemon.
	 * @param weakness Whether the pokemon has weakness.
	 */
	@Override
	public int attack(boolean weakness){
		boolean coin;
		
		Random rand = new Random();
		
		coin = rand.nextBoolean();
		
		int damage = 5;
		
		/**If weakness is true, energy will minus 2.
		* If weakness is false, energy will minus 1.
		*/
		if (weakness == true) {
			setEnergy(getEnergy() - 2);
		}
		else {
			setEnergy(getEnergy() - 1);
		}
		
		setExp(getExp() + 1);
		
		/**If coin is true, Pokemon's attacking power is triggered.
		* If coin is false, Pokemon's attacking power will not be triggered.
		*/
		if (coin == true) { 
			System.out.println("Pokemon attacks!\n");
			return getAttackPoint();
		}
		else {
			System.out.println("The pokemon failed to boost its attack.\n");
			return 1;
		}
	}
}