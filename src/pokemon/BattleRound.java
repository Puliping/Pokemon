package pokemon;

import controller.*;

public class BattleRound extends Controller {
	Trainer trnr1, trnr2;
	int[] res1, res2;
	
	public BattleRound(Trainer trnr1, int[] res1, Trainer trnr2, int[] res2) {
		this.trnr1 = trnr1;
		this.res1 = res1;
		this.trnr2 = trnr2;
		this.res2 = res2;
	}
	
	class FightEvent extends Event {
		int num, dmg;
		
		public FightEvent(long eventTime, int num) {
			super(eventTime);
			this.num = num;
		}
		
		public void action() {
			if (num == 1 && trnr1.getTeam(trnr1.getActive()).getHP() > 0) {
				dmg = trnr2.takeDamage(res1[2]);
				Wild.c = 0;
			} else if (trnr2.getTeam(trnr2.getActive()).getHP() > 0) {
				dmg = trnr1.takeDamage(res2[2]);
			}
		}
		
		public String description() {
			String str = "";
			if (num == 1 && trnr1.getTeam(trnr1.getActive()).getHP() > 0) {
				str += trnr1.getTeam(trnr1.getActive()) + " usou ";
				switch (res1[1]) {
				case 1:
					str += trnr1.getMove(1) + ".\n";
					break;
				case 2:
					str += trnr1.getMove(2) + ".\n";
					break;
				case 3:
					str += trnr1.getMove(3) + ".\n";
					break;
				case 4:
					str += trnr1.getMove(4) + ".\n";
					break;
				}
				str += trnr2.getTeam(trnr2.getActive()) + " tomou " + dmg + " de dano!";
				if (trnr2.getTeam(trnr2.getActive()).getHP() <= 0) {
					str += "\n" + trnr2.getTeam(trnr2.getActive()) + " desmaiou!";
				}
			} else if (num == 2 && trnr2.getTeam(trnr2.getActive()).getHP() > 0) {
				str += trnr2.getTeam(trnr2.getActive()) + " usou ";
				switch (res2[1]) {
				case 1:
					str += trnr2.getMove(1) + ".\n";
					break;
				case 2:
					str += trnr2.getMove(2) + ".\n";
					break;
				case 3:
					str += trnr2.getMove(3) + ".\n";
					break;
				case 4:
					str += trnr2.getMove(4) + ".\n";
					break;
				}
				str += trnr1.getTeam(trnr1.getActive()) + " tomou " + dmg + " de dano!";
				if (trnr1.getTeam(trnr1.getActive()).getHP() <= 0) {
					str += "\n" + trnr1.getTeam(trnr1.getActive()) + " desmaiou!";
				}
			}
			return str;
		}
		
	}
	
	class BagEvent extends Event {
		int num;
		
		public BagEvent(long eventTime, int num) {
			super(eventTime);
			this.num = num;
		}
		
		public void action() {
			if (num == 1) {
				trnr1.getTeam(trnr1.getActive()).heal(res1[2]);
				trnr1.potQty[res1[1] - 1]--;
			} else {
				trnr2.getTeam(trnr2.getActive()).heal(res2[2]);
			}
		}
		
		public String description() {
			String str = "";
			if (num == 1) {
				switch (res1[1]) {
				case 1:
					str += trnr1 + " usou Potion!\n";
					break;
				case 2:
					str += trnr1 + " usou Super Potion!\n";
					break;
				case 3:
					str += trnr1 + " usou Hyper Potion!\n";
					break;
				case 4:
					str += trnr1 + " usou Max Potion!\n";
					break;
				}
				str += trnr1.getTeam(trnr1.getActive()) + " recuperou " + res1[2] + " pontos de vida!";
			} else {
				switch (res2[1]) {
				case 1:
					str += trnr2 + " usou Potion!\n";
					break;
				case 2:
					str += trnr2 + " usou Super Potion!\n";
					break;
				case 3:
					str += trnr2 + " usou Hyper Potion!\n";
					break;
				case 4:
					str += trnr2 + " usou Max Potion!\n";
					break;
				}
				str += trnr2.getTeam(trnr2.getActive()) + " recuperou " + res2[2] + " pontos de vida!";
			}
			return str;
		}
		
	}
	
	class ShiftEvent extends Event {
		int num;
		
		public ShiftEvent(long eventTime, int num) {
			super(eventTime);
			this.num = num;
		}
		
		public void action() {
			if (num == 1) {
				trnr1.shift(res1[1] - 1);
			} else {
				trnr2.shift(res2[1] - 1);
			}
		}
		
		public String description() {
			String str = "";
			if (num == 1) {
				str += trnr1 + " trocou para " + trnr1.getTeam(trnr1.getActive()) + "!";
			} else {
				str += trnr2 + " trocou para " + trnr2.getTeam(trnr2.getActive()) + "!";
			}
			return str;
		}
		
	}
	
	class CatchEvent extends Event {
		public CatchEvent(long eventTime) {
			super(eventTime);
		}
		
		public void action() {
		
		}
		
		public String description() {
			String str = "";
			if (res1[2] == 1) {
				str += "O " + trnr2.getTeam(trnr2.getActive()) + " selvagem foi capturado!\n";
				if (trnr1.getTeam().size() < 6) {
					str += "E foi adicionado ao time!";
					trnr1.addToTeam(trnr2.getTeam(trnr2.getActive()));
				} else {
					str += "E foi enviado ao banco!";
				}
				trnr2.getTeam(trnr2.getActive()).hp = 0;
			} else {
				str += "O " + trnr2.getTeam(trnr2.getActive()) + " selvagem escapou!";
			}
			return str;
		}
	}
	
	class FleeEvent extends Event {
		int num;
		
		public FleeEvent(long eventTime, int num) {
			super(eventTime);
			this.num = num;
		}
		
		public void action() {
			
		}
		
		public String description() {
			String str = "";
			if (num == 1) {
				if (res1[1] == 1) {
					str += trnr1 + " fugiu com segurança!";
					trnr2.getTeam(0).hp = 0;
				} else {
					str += "Nao foi possivel fugir!";
				}
			} else {
				str += "O POKeMON selvagem fugiu!";
			}
			return str;
		}
		
	}
	
	@Override
	public void run() {
		long tm = System.currentTimeMillis();
		int mod1 = 0, mod2 = 0;
		if (res1[0] == 1)
			mod1 = trnr1.getTeam(trnr1.getActive()).getSpeed() + trnr1.getMove(res1[1]).getPriority() * 500;
		if (res2[0] == 1)
			mod2 = trnr2.getTeam(trnr2.getActive()).getSpeed() + trnr2.getMove(res2[1]).getPriority() * 500;
		switch (res1[0]) {
		case 4:
			addEvent(new FleeEvent(tm, 1));
			break;
		case 5:
			addEvent(new CatchEvent(tm + 100));
			break;
		case 3:
			addEvent(new ShiftEvent(tm + 250, 1));
			break;
		case 2:
			addEvent(new BagEvent(tm + 500, 1));
			break;
		case 1:
			addEvent(new FightEvent(tm + 2000 - mod1, 1));
			break;
		}
		switch (res2[0]) {
		case 4:
			addEvent(new FleeEvent(tm, 2));
			break;
		case 3:
			addEvent(new ShiftEvent(tm + 250, 2));
			break;
		case 2:
			addEvent(new BagEvent(tm + 500, 2));
			break;
		case 1:
			addEvent(new FightEvent(tm + 2000 - mod2, 2));
			break;
		}
		super.run();
	}
}
