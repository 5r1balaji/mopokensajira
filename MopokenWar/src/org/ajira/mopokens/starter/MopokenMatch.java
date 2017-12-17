package org.ajira.mopokens.starter;

import org.ajira.mopokens.actions.BattleFixtures;
import org.ajira.mopokens.actions.MopokenSelector;
import org.ajira.mopokens.actions.MopokenSquad;

public class MopokenMatch {

	public MopokenMatch() {

	}

	public static void main(String args[]) {

		MopokenSquad breeder = new MopokenSquad("Fire#3;Water#2;Psychic#12;Fighting#1;Electric#100");
		MopokenSquad opponent = new MopokenSquad("Fire#1;Fighting#1;Water#100;Electric#12;Ghost#10");
		BattleFixtures selector = new MopokenSelector(breeder,opponent);
		selector.prepareBattles();

	}

}
