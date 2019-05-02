package controller;

import pokemon.*;

class FightEvent extends Event {
	Trainer trnr, opp;
	public FightEvent(long eventTime, Trainer trnr, Trainer opp) {
		super(eventTime);
		this.trnr = trnr;
		this.opp = opp;
	}
	
	public void action() {
		
	}
	
	public String description() {
		return null;
	}
	
}

class BagEvent extends Event {
	Trainer trnr;
	int heal;
	public BagEvent(long eventTime, Trainer trnr, int heal) {
		super(eventTime);
		this.trnr = trnr;
	}
	
	public void action() {
		
	}
	
	public String description() {
		String str;
		str = trnr.getTeam(trnr.getActive()) + " ganhou " + heal + "pontos de vida!";
		return null;
	}
	
}

class ShiftEvent extends Event {
	Trainer trnr;
	public ShiftEvent(long eventTime, Trainer trnr) {
		super(eventTime);
		this.trnr = trnr;
	}
	
	public void action() {
		
	}
	
	public String description() {
		String str;
		return null;
	}
	
}
