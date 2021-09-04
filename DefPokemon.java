import java.util.Random;

/**
 * 
 * @author Group24
 * @version 2.5
 * @since 2019-11-18
 *
 */

public class DefPokemon extends Pokemon {
	Random rand = new Random();
	
	/**Constructor*/
	public DefPokemon(){
		super();
	
		setType("Defending");
		setAttackPoint(0);
		setResistancePoint(rand.nextInt(5));
	}
	
	/**The defend method for defending type pokemon.
	 * @param weakness Whether the pokemon has weakness.
	 */
	public void defend (boolean weakness) {
		boolean coin;
		coin = rand.nextBoolean();
		
		int damage = 0;
		/**If weakness is true, energy will minus 2.
		 * If weakness is false, energy will minus 1.
		 */
		if(weakness == true){
			setEnergy(getEnergy() - 2);
		}
		else {
			setEnergy(getEnergy() - 1);
			
		}
		
		setExp(getExp() + 1);
		
		/**If coin is true, resistance points will be added to the hp.
		 * If coin is false, resistance points will not be added to the hp.
		 */
		if (coin == true) { 
			setHp(getHp() + getResistancePoint());
			System.out.println("Resistance power is triggered!");
		}
		else {
			System.out.println("The pokemon failed to defend.\n");
		}
	}
}
