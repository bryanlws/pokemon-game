import java.util.*;
import java.io.*;


/**
 * 
 * @author Group24
 * @version 2.5
 * @since 2019-11-18
 *
 */

public class top10leaderboard {
	
	/**An arraylist of the type "score" we will use to work with the scores inside the class.*/
		private ArrayList<Score> scores;

		/**File where the highscores are saved*/
		private static final String HIGHSCORE_FILE = "scores.dat";

		/**Initializing inputStream and outputStream for working with the file.*/
		ObjectOutputStream outputStream = null;
		ObjectInputStream inputStream = null;

		public top10leaderboard() {
		/**initializing the scores in an arraylist.*/
		scores = new ArrayList<Score>();
			}
		
		/**Gets the scores from the arraylist.
		 * @return scores.
		 */
		public ArrayList<Score> getScores() {
	        loadScoreFile();
	        sort();
	        return scores;
	    }
		
		/**Sorts the scores.*/
		private void sort() {
	        ScoreComparator comparator = new ScoreComparator();
	        Collections.sort(scores, comparator);
		}
		
		/**Adds the scores to the list.*/
		public void addScore(String name, int score) {
	        loadScoreFile();
	        scores.add(new Score(name, score));
	        updateScoreFile();
		}
		
		/**Loads the score file.*/
		public void loadScoreFile() {
	        try {
	            inputStream = new ObjectInputStream(new FileInputStream(HIGHSCORE_FILE));
	            scores = (ArrayList<Score>) inputStream.readObject();
	        } catch (FileNotFoundException e) {
	            System.out.println("[Laad] FNF Error: " + e.getMessage());
	        } catch (IOException e) {
	            System.out.println("[Laad] IO Error: " + e.getMessage());
	        } catch (ClassNotFoundException e) {
	            System.out.println("[Laad] CNF Error: " + e.getMessage());
	        } finally {
	            try {
	                if (outputStream != null) {
	                    outputStream.flush();
	                    outputStream.close();
	                }
	            } catch (IOException e) {
	                System.out.println("[Laad] IO Error: " + e.getMessage());
	          }
	       }
		}

		/**Writes to the score file.*/
		public void updateScoreFile() {
	        try {
	            outputStream = new ObjectOutputStream(new FileOutputStream(HIGHSCORE_FILE));
	            outputStream.writeObject(scores);
	        } catch (FileNotFoundException e) {
	            System.out.println("[Update] FNF Error: " + e.getMessage() + ",the program will try and make a new file");
	        } catch (IOException e) {
	            System.out.println("[Update] IO Error: " + e.getMessage());
	        } finally {
	            try {
	                if (outputStream != null) {
	                    outputStream.flush();
	                    outputStream.close();
	                }
	            } catch (IOException e) {
	                System.out.println("[Update] Error: " + e.getMessage());
	            }
	        }
		}
		
		/**Converts scores into String format.
		 * @return scores in String format.
		 */
		public String getHighscoreString() {
	        String highscoreString = "";
	        int max = 10;

	        ArrayList<Score> scores;
	        scores = getScores();

	        int i = 0;
	        int x = scores.size();
	        if (x > max) {
	            x = max;
	        }
	        while (i < x) {
	            highscoreString += (i + 1) + ".\t" + scores.get(i).getNaam() + "\t\t" + scores.get(i).getScore() + "\n";
	            i++;
	        }
	        return highscoreString;
		}
		
		/**Implements the comparator to compare scores..*/
		public class ScoreComparator implements Comparator<Score> {
	        public int compare(Score score1, Score score2) {

	            int sc1 = score1.getScore();
	            int sc2 = score2.getScore();

	            if (sc1 > sc2){
	                return -1;
	            }else if (sc1 < sc2){
	                return +1;
	            }else{
	                return 0;
	            }
	        }
		}
		
		public class Score implements Serializable {
			/**Player's score.*/
		    private int score;
		    /**Player's name.*/
		    private String naam;
		    
		    /**Constructor.*/
		    public Score(String naam, int score) {
		        this.score = score;
		        this.naam = naam;
		    }
		    
		    /**Gets the player's score.
		     * @return player's score.
		     */
		    public int getScore() {
		        return score;
		    }
		    
		    /**Gets the player's name.
		     * @return player's name.
		     */
		    public String getNaam() {
		        return naam;
		    }
		}
	}