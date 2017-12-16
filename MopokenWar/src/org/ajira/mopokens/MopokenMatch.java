package org.ajira.mopokens;

public class MopokenMatch {

	public MopokenMatch() {
		
	}
	
	public static void main(String args[]) {
		
		BattleNominees nominees=new MopokenSquad("Fire#10;Water#20;Fighting#6;Psychic#10;Electric#12","Water#10;Fighting#10;Psychic#10;Fire#12;Grass#2");
		BattleFixtures selector=new MopokenSelector(nominees);
		selector.organizeMopokens();
		
	}
	
}
