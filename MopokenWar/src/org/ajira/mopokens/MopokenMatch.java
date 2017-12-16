package org.ajira.mopokens;

public class MopokenMatch {

	public MopokenMatch() {
		
	}
	
	public static void main(String args[]) {
		//BattleNominees nominees=new MopokenSquad("Fire#10;Water#20;Fighting#6;Psychic#10;Electric#12","Water#10;Fighting#10;Psychic#10;Fire#12;Grass#2");
		BattleNominees nominees=new MopokenSquad("Fire#3;Water#2;Psychic#12;Fighting#1;Electric#100","Fire#1;Fighting#1;Water#100;Electric#12;Ghost#10");
		BattleFixtures selector=new MopokenSelector(nominees);
		selector.organizeMopokens();
		
	}
	
}
