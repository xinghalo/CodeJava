package xing.test.thinking.chap19;
import static xing.test.thinking.chap19.Outcome.*;
public enum RoShamBo3 implements Competitor<RoShamBo3>{
	PAPER{
		public Outcome compete(RoShamBo3 it){
			switch(it){
			default:
			case PAPER: return DRAW;
			case SCISSORS: return LOSE;
			case ROCK: return WIN;
			}
		}
	},
	SCISSORS{
		public Outcome compete(RoShamBo3 it){
			switch(it){
			default:
			case PAPER: return DRAW;
			case SCISSORS: return LOSE;
			case ROCK: return WIN;
			}
		}
	},
	ROCK{
		public Outcome compete(RoShamBo3 it){
			switch(it){
			default:
			case PAPER: return DRAW;
			case SCISSORS: return LOSE;
			case ROCK: return WIN;
			}
		}
	};
	public abstract Outcome compete(RoShamBo3 it);
	public static void main(String[] args) {
		RoShamBo.play(RoShamBo3.class,20);
	}
}
