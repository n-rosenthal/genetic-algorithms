package basis.automata;

public class CellularAutomata {
	private CellularMap 		map;
	private CellularRuleset 	rules;
	
	public CellularAutomata(int size) {
		this.map = new CellularMap(size);
	};
	
	
	//	Main
	public static void main(String[] args) {
		CellularAutomata cellAuto = new CellularAutomata(10);
		
		System.out.println(cellAuto.map);
	}
}
