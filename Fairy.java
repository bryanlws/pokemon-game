import java.util.Random;

/**
 * 
 * @author Group24
 * @version 2.5
 * @since 2019-11-18
 *
 */

public class Fairy extends Pokemon {
	
	/**Status inflicted upon enemy pokemon. */
	private int statusFreeze;
	
	/**Constructor*/
	public Fairy() {
		super();
		setType("Fairy");
		setAttackPoint(0);
		setResistancePoint(0);
	}
	
	/**@return the status of the pokemon.*/
	public int getStatusFreeze() {
		return statusFreeze;
	}

	/**Sets the status of the pokemon.
	 * @param statusFreeze the status of the pokemon.
	 */
	public void setStatusFreeze(int statusFreeze) {
		this.statusFreeze = statusFreeze;
	}

	/** The pokemon that will be affected by the status effect.
	 * @param x The pokemon that will be affected by the status effect.
	 */
	public void takeFairyDemage(Pokemon x){
		Random random = new Random();
		/**Flips a coin.*/
		boolean coin = random.nextBoolean(); 
		
		/**If true, pokemon is poisoned.
		 * If false, pokemon is paralysed.
		 */
		if(coin){
			System.out.println("Enemy Pokemon is poisoned");
			x.setStatus("poisoned");
			statusFreeze = 1;
		}
			else{
				System.out.println("Enemy Pokemon is paralysed");
				x.setStatus("parlysed");
				statusFreeze = 2;
		}
	}
}