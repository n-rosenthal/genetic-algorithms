package basis.automata;

/**
 * A {@code CellularMap} is a 2-dimensional grid for showing the evolution of cellular automata.
 */
public class CellularMap {
	public int size;
	public char[][] map;
	
	public CellularMap(int size) {
		this.size = size;
		this.map  = new char[size][size];
		initialize();
	};
	
	/**
	 * Initializes the map as blank
	 */
	public void initialize() {
		for (int i=0; i<size; i++) {
			for (int j=0; j<size; j++) {
				this.map[i][j] = ' ';
			};
		};
	};
	
	/**
	 * Inserts a char value at a position in the map.
	 * @param value
	 * @param xpos
	 * @param ypos
	 */
	public void set(char value, int xpos, int ypos) {
		if(xpos < this.size && xpos > 0 && ypos < this.size && ypos > 0) {
			this.map[xpos][ypos] = value;
		}
	};
	
	/**
	 * Gets the current char in the position of the map
	 * 
	 * @param xpos
	 * @param ypos
	 * @returns char
	 */
	public char get(int xpos, int ypos) {
		if(xpos < this.size && xpos > 0 && ypos < this.size && ypos > 0) {
			return this.map[xpos][ypos];
		};
		
		return ' ';
	};
	
	/**
	 * Returns a String representation of the current map
	 * 
	 * @returns map as a String
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<size; i++) {
			for (int j=0; j<size; j++) {
				sb.append("[" + this.map[i][j] + "]");
			};
			sb.append("\n");
		};
	
	return sb.toString();
	};
}
