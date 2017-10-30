import java.util.Scanner;

public class RollingDice {

	/**
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Boolean proceedAgain = true;
		int currentRoll = 0;

		System.out.println("Welcome to the Grand Circus Virtual Casino! \n");

		while (proceedAgain) {
			currentRoll++;

			int dieOne = Validator.getInt(scan, "How many sides does your first die have? \n");
			int dieTwo = Validator.getInt(scan, "How many sides does your second die have? \n");

			String finalResult = rollDice(dieOne, dieTwo, currentRoll);

			ProgressBar bar = new ProgressBar();

			System.out.println("Throw the dice now!");

			bar.update(0, 1000);
			for (int i = 0; i < 1000; i++) {
				// do something!
				for (int j = 0; j < 10000000; j++)
					for (int p = 0; p < 10000000; p++)
						;
				// update the progress bar
				bar.update(i, 1000);
			}

			System.out.println(finalResult);
			String userChoice = Validator.getString(scan, "Roll again? (y/n): ...");

			if (!Character.toString(userChoice.charAt(0)).matches("y")) {

				System.out.println("Please come back when you're feeling lucky!");
				proceedAgain = false;
			}
		}
		scan.close();
	}

	/**
	 * 
	 * @param die1
	 *            int representing user's first roll
	 * @param die2
	 *            int representing user's second roll
	 * 
	 * @param roll
	 *            int representing the current roll count
	 * @return returns the dice rolls, current roll number, and special conditions
	 */
	public static String rollDice(int die1, int die2, int roll) {
		String result = null;
		System.out.println(roll);

		int rollOne = (int) (Math.random() * die1) + 1;
		int rollTwo = (int) (Math.random() * die1) + 1;

		String bonus = (DiceRollerApp.specialCondition(rollOne, rollTwo));

		if (bonus != null) {

			result = ("Roll " + roll + ":\n" + rollOne + "\n" + rollTwo + "\n" + "Congratulations for getting a "
					+ (DiceRollerApp.specialCondition(rollOne, rollTwo)) + "!");
		} else {
			result = ("Roll " + roll + ":\n" + rollOne + "\n" + rollTwo);
		}
		return result;
	}
}
