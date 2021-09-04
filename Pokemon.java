import java.util.Random;

/**
 * 
 * @author Group24
 * @version 2.5
 * @since 2019-11-18
 *
 */

public class Pokemon {
	/**Pokemon's number.*/
	private int pokeno;
	/**Pokemon's stage.*/
	private int stage;
	/**Pokemon's experience.*/
	private int exp;
	/**Pokemon's hit points.*/
	private int hp;
	/**Pokemon's energy.*/
	private int energy;
	/**Pokemon's energy colour.*/
	private String energycolour;
	/**Pokemon's status.*/
	private String status;
	/**Pokemon's damage.*/
	private int bdamage;
	/**Pokemon's type.*/
	private String type;
	/**List of energy colours.*/
	public final String[] energylist = {"red","blue","yellow","colourless"};
	/**Pokemon's attack points.*/
	private int attackPoint;
	/**Pokemon's resistance points.*/
	private int resistancePoint;
	
	/**Constructor.*/
	public Pokemon() {
		Random rand = new Random();
		
		pokeno = 0;
		stage = 0;
		exp = 0;
		hp = 50 + rand.nextInt(31);
		energy = 20 + rand.nextInt(31);
		
		switch (rand.nextInt(4)) {
		
		case 0: energycolour = "Red";
				break;
				
		case 1: energycolour = "Blue";
				break;
		case 2 :energycolour = "Yellow";
				break;
		case 3 :energycolour = "Colourless";
				break;
		
		}
		status = "Active";
	}

	
	


	/**@return the pokemon's number.*/
	public int getPokeno() {
		return pokeno;
	}

	/**@return the pokemon's stage.*/
	public int getStage() {
		return stage;
	}

	/**@return the pokemon's experience.*/
	public int getExp() {
		return exp;
	}

	/**@return the pokemon's hit points.*/
	public int getHp() {
		return hp;
	}

	/**@return the pokemon's energy.*/
	public int getEnergy() {
		return energy;
	}

	/**@return the pokemon's energy colour.*/
	public String getEnergycolour() {
		return energycolour;
	}

	/**@return the pokemon's status.*/
	public String getStatus() {
		return status;
	}

	/**@return the pokemon's damage.*/
	public int getBdamage() {
		return bdamage;
	}

	/**@return the pokemon's type.*/
	public String getType() {
		return type;
	}

	/**@return the list of energy colours.*/
	public String[] getEnergylist() {
		return energylist;
	}

	/**@return the pokemon's attack point.*/
	public int getAttackPoint() {
		return attackPoint;
	}

	/**@return the pokemon's resistance point.*/
	public int getResistancePoint() {
		return resistancePoint;
	}
	
	/**Sets the pokemon's number.
	 * @param pokeno Pokemon's number.
	 */
	public void setPokeno(int pokeno) {
		this.pokeno = pokeno;
	}

	/**Sets the pokemon's stage.
	 * @param stage Pokemon's stage.
	 */
	public void setStage(int stage) {
		this.stage = stage;
	}

	/**Sets the pokemon's experience.
	 * @param exp Pokemon's experience.
	 */
	public void setExp(int exp) {
		this.exp = exp;
	}

	/**Sets the pokemon's hit points.
	 * @param hp Pokemon's hit points.
	 */
	public void setHp(int hp) {
		this.hp = hp;
	}

	/**Sets the pokemon's energy.
	 * @param energy Pokemon's energy.
	 */
	public void setEnergy(int energy) {
		this.energy = energy;
	}

	/**Sets the pokemon's energy colour.
	 * @param energycolour Pokemon's energy colour.
	 */
	public void setEnergycolour(String energycolour) {
		this.energycolour = energycolour;
	}

	/**Sets the pokemon's status.
	 * @param status Pokemon's status.
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**Sets the pokemon's damage.
	 * @param bdamage Pokemon's damage.
	 */
	public void setBdamage(int bdamage) {
		this.bdamage = bdamage;
	}

	/**Sets the pokemon's type.\
	 * @param type Pokemon's type.
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**Sets the pokemon's attack point.
	 * @param attackPoint Pokemon's attack point.
	 */
	public void setAttackPoint(int attackPoint) {
		this.attackPoint = attackPoint;
	}

	/**Sets the pokemon's resistance point.
	 * @param resistancePoint Pokemon's resistance point.
	 */
	public void setResistancePoint(int resistancePoint) {
		this.resistancePoint = resistancePoint;
	}
	
	/**Increases the pokemon's energy.
	 * @param energy Pokemon's energy.
	 */
	public void increaseEnergy(int energy){
		this.energy = this.energy + energy;
	}
	
	/**Increases the pokemon's experience.
	 * @param exp Pokemon's experience.
	 */
	public void increaseExp(int exp){
		this.exp = this.exp + exp;
	}
	
	/**Base attack method for all pokemon types.
	 * If energy is not sufficient, user will be alerted with a message.
	 * If weakness is true, energy will be deducted by two, otherwise, by one.
	 * @param weakness Whether pokemon has weakness.
	 * @return damage to be dealt.
	 */
	public int attack(boolean weakness){
		int damage = 0;
		
		if (energy <= 0) {
			System.out.println("no energy to attack");
			energy = 0;
		}
		else {
			if (weakness == true) {
				energy -= 2;
			}
			else {
				energy -= 1;
			}
			exp += 1;
			damage = 1;
		}
		return damage;
	}
	
		
	/**Damage calculation for pokemon affected by status effects or weakness.
	 * @param d Multiplier for status effects.
	 * @param weakness Whether pokemon has weakness.
	 */
	public void takeDamage(int d, boolean weakness) {
		if (status.equals("poisoned") || status.equals("paralysed") || weakness == true) {
			d *=2;
		}
		
		hp -= d;
		System.out.printf("Opponent took %d damage!", d);
	}
	

	/**Recharge method for all pokemon.*/
	public void reCharge() {
		Random rand = new Random();
		String plusEnergyCard = "";
		
		switch (rand.nextInt(3)) {
		case 0: plusEnergyCard = "Red";
				break;
		case 1: plusEnergyCard = "Blue";
				break;
		case 2: plusEnergyCard = "Yellow";
				break;
		}
		
		if (energycolour.equals("Colourless") || energycolour.equals(plusEnergyCard)) {
			energy += 5;
		}
		
		System.out.printf("Drew a %s card, energy become %d.\n\n", plusEnergyCard, energy);
	}
	
	/**Train method for all pokemon.*/
	public void train() {
		exp += 2;
		energy -= 5;
		System.out.println("Gained 2 experience.");	
	}
	
	/**Method that triggers when pokemon have enough experience to evolve to the next stage.*/
	public void promote() {
		if (exp >= 20) {
			stage +=1;
			exp = 0;
			hp *= 2;
			energy *= 2;
			attackPoint *= 2;
			resistancePoint *= 2;
		}
			
			System.out.printf("Pokemon has evolved!\n");
	}
	
	
	@Override
	public String toString() {
		return "Pokemon [stage=" + stage + ", exp=" + exp + ", hp=" + hp
				+ ", energy=" + energy + ", energycolour=" + energycolour
				+ ", status=" + status + "]";
	}
}
