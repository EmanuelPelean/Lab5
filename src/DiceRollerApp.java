
public class DiceRollerApp {

	/*
	 * Class for checking if the user's dice rolls equal a special condition in
	 * Craps
	 */

	public static String specialCondition(int roll1, int roll2) {

		String specialCon = null;

		if (roll1 == 1 && roll2 == 1) {
			specialCon = "Snake Eyes";
		} else if (roll1 == 6 && roll2 == 6) {
			specialCon = "Box Cars";
		} else {
			// Do nothing for now, add more options here if needed
		}

		return specialCon;

	}

}
