package xing.test.thinking.chap19;
import static xing.test.thinking.chap19.Outcome.*;
interface  Competitor<T extends Competitor<T>>{
	Outcome compete(T competitor);
}
public enum RoShamBo2 implements Competitor<RoShamBo2>{
	PAPER(DRAW,LOSE,WIN),
	SCISSORS(WIN,DRAW,LOSE),
	ROCK(LOSE,WIN,DRAW);
	private Outcome vPAPER,vSCISSOR,vROCK;
	RoShamBo2(Outcome paper,Outcome scissors,Outcome rock) {
		this.vPAPER = paper;
		this.vSCISSOR = scissors;
		this.vROCK = rock;
	}
	public Outcome compete(RoShamBo2 it){
		switch(it){
		default:
		case PAPER: return vPAPER;
		case SCISSORS: return vSCISSOR;
		case ROCK: return vROCK;
		}
	}
	public static void main(String[] args) {
		RoShamBo.play(RoShamBo2.class,20);
	}
}
