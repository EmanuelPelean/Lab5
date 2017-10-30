
/**
 * http://masterex.github.io/archive/2011/10/23/java-cli-progress-bar.html Ascii
 * progress meter. On completion this will reset itself, so it can be reused
 * <br />
 * <br />
 * 100% ################################################## |
 */
public class ProgressBar {
	private StringBuilder progress;

	/**
	 * initialize progress bar properties.
	 */
	public ProgressBar() {
		init();
	}

	/**
	 * called whenever the progress bar needs to be updated. that is whenever
	 * progress was made.
	 *
	 * @param done
	 *            an int representing the work done so far
	 * @param total
	 *            an int representing the total work
	 */
	public void update(int done, int total) {
		// contains the characters that create the spinning wait symbol
		char[] workchars = { '|', '/', '-', '\\' };

		/**
		 * it is the progress bar format. let's have a closer look: - \r is the carriage
		 * return, in other words it moves the "cursor" to the first position on the
		 * same line - %3d is a 3 digit decimal integer - %% is the literal % character
		 * - %s is a string, particularly the "###...#" symbols - %c is a character,
		 * particularly the spinning wait symbol
		 */
		String format = "\r%3d%% %s %c";

		// calculates how much work units per cent have been completed
		int percent = (++done * 100) / total;

		// total number of # to be appended
		int extrachars = (percent / 2) - this.progress.length();

		// append the # to the progress bar
		while (extrachars-- > 0) {
			progress.append('#');
		}

		// updates/redraws the progress bar
		System.out.printf(format, percent, progress, workchars[done % workchars.length]);

		if (done != total) {
			System.out.println("Dice are currently spinning extremely fast... please wait!");
		}
		// use this to hide the previous progress par from the user in the console
		// you may need to add more "\n" if demo is using full screen
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

		/**
		 * if the work have been completed it forces the output to be written, changes
		 * line and resets itself so it can be reused.
		 */
		if (done == total) {
			System.out.flush();
			System.out.println();
			init();
		}
	}

	private void init() {
		this.progress = new StringBuilder(60);
	}
}