package xing.test.thinking.chap19;
/**
 * 覆盖enum的toString方法与覆盖一般类的方法一样
 * @author xxh
  */
public enum SpaceShip {
	SCOUT, CARGO, TRANSPORT, CRUISER, BATTLESHIP, MOTHERSHOP;
	public String toString(){
		String id = name();
		String lower = id.substring(1).toLowerCase();
		return id.charAt(0)+lower;
	}
	public static void main(String[] args) {
		for(SpaceShip ss : SpaceShip.values()){
			System.out.println(ss);
		}
	}
}
