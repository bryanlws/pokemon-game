import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Group24
 * @version 2.5
 * @since 2019-11-18
 *
 */

public class testpokemon {
	
	/**Main method.
	 * @param args Arguments.
	 */
	public static void main(String[] args) {
		boolean gameOver = false;
		
		
		top10leaderboard hm = new top10leaderboard();
		Scanner keyboard = new Scanner(System.in);
		String name1, name2;
		int option,action;
		
		int die = 0;
		int die2 = 0;
		int noturn = 0;
		
		System.out.println("Welcome to play Pokemon Card Game");
		System.out.print("Key in the name for player 1: ");
		name1 = keyboard.nextLine();
		Player player1 = new Player(1, name1);
		ArrayList<Pokemon> PPokemon1 =  player1.getPPokemon();
		
			
		System.out.print("Key in the name for player 2: ");
		name2 = keyboard.nextLine();
		Player player2 = new Player(2, name2);
		ArrayList<Pokemon> PPokemon2 = player2.getPPokemon();
			
		System.out.println("\n1. Start game");
		System.out.println("2. display top 10 scores");
		System.out.println("Choose Option: ");
		option = keyboard.nextInt();
		runGame.gameOption(option);
		
		if (option == 1) {
			while (gameOver = true) {
				while (die <= 3) {
				
				
					/**Displays both player's pokemon.*/
					runGame.displayTable(player1, PPokemon1);
					System.out.println();
					runGame.displayTable(player2, PPokemon2);
					
					/**Displays options for player1.*/
					System.out.printf("%s:", name1);
					System.out.println("Option 1: Attack");
					System.out.println("Option 2: Recharge");
					System.out.println("Option 3: Train");
					System.out.println("Choose the option: ");
					int option2 = keyboard.nextInt();
					System.out.println("Choose Pokemon: ");
					int p = keyboard.nextInt();
					Pokemon cb = PPokemon1.get(p-1);
					
					switch(option2) {
						case 1: //attack
							System.out.println("Attack Pokemon: ");
							int B = keyboard.nextInt();
							Pokemon cb2 = PPokemon2.get(B-1);
							
							if (cb.getType().equals(cb2.getType())) {
								System.out.println("weakness:on, double attack point");
								if (cb instanceof AttackPokemon) {
									cb.attack(true);
									System.out.printf("HP for Pokemon %d damaged!\n", B);
									break;
								}
								
							}
							
							else {
								cb.attack(false);
								System.out.printf("HP for Pokemon %d damaged!\n", B);
								break;
							}
							
							
							
						case 2: //recharge
							cb.reCharge();
							System.out.printf("Pokemon %d recharged!\n", p);
							break;
								
						case 3: //train
							cb.train();
							System.out.printf("Pokemon %d trained!\n", p);
							if(cb.getExp()>=20){
								cb.promote();
								System.out.printf("pokemon %d evolved!\n", p);
							}
							break;
					}
							
					/**Displays options for player2.*/
					System.out.printf("%s:", name2);
					System.out.println("Option 1: Attack");
					System.out.println("Option 2: Recharge");
					System.out.println("Option 3: Train");
					System.out.println("Choose the option: ");
					int option3 = keyboard.nextInt();
					System.out.println("Choose Pokemon: ");
					int p2 = keyboard.nextInt();
					Pokemon cb3 = PPokemon2.get(p2-1);
					
					switch(option2) {
						case 1: //attack
							System.out.println("Attack Pokemon: ");
							int B2 = keyboard.nextInt();
							Pokemon cb4 = PPokemon1.get(B2-1);
							
							if (cb3.getType().equals(cb4.getType())) {
								System.out.println("weakness:on, double attack point");
								if (cb3 instanceof AttackPokemon) {
									cb3.attack(true);
									System.out.printf("HP for Pokemon %d damaged!\n", B2);
									break;
								}
								
							}
							else {
								cb3.attack(false);
								System.out.printf("HP for Pokemon %d damaged!\n", B2);
								break;
							}
							
						
						case 2: //recharge
							cb3.reCharge();
							System.out.printf("Pokemon %d recharged!\n", p2);
							break;
								
						case 3: //train
							cb3.train();
							System.out.printf("Pokemon %d trained!\n", p2);
							if(cb3.getExp()>=20){
								cb3.promote();
								System.out.printf("pokemon %d evolved!\n", p2);
							}
							break;
					}
					
					
					noturn += 1;
				
					for (int i = 0; i<(PPokemon1.size()); i++) {
						if ((PPokemon1.get(i)).getHp() == 0) {
							die +=1;
						}
						if ((PPokemon2.get(i)).getHp() == 0) {
							die2 +=1;	
						}
					if (die == 3) {
						System.out.println("Player 2 is da winner!!!");
						hm.addScore(name2, noturn);
						gameOver = true;
					}
					
					else if (die2 == 3) {
						System.out.println("Player 1 is da winner!!!");
							hm.addScore(name1, noturn);
							gameOver = true;
					}
					}
				}
			}
		}
		
		if (option == 2) {
			System.out.print("Here are the scores!");
			hm.addScore(name1, noturn);
			System.out.print(hm.getHighscoreString());			
		}
	}
}

		
		
		


	

