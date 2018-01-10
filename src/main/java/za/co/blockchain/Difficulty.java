package za.co.blockchain;

/**
 * Mining difficulty.
 * 
 * @author Msawenkosi Ntuli
 *
 */
public enum Difficulty {
	
	EASY(3), // 3 zeros prefix
	MEDIUM(5), // 4 zeros prefix
	DIFFICULT(7); // 7 zeros prefix
	
	private int level;
	
	public int getLevel() {
		
		return this.level;
	}
	
	public void setLevel(int level) {
		
		this.level = level;
	}
	
	private Difficulty(int level) {
		
		this.level = level;
	}
}
