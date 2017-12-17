package org.ajira.mopokens.actions;

import java.util.LinkedHashMap;
import java.util.Map;

import org.ajira.mopokens.model.Mopokens;

public class MopokenSelector implements BattleFixtures {
	/*
	 * MopokenSelector decides whether the matches between the mopokens resulted in
	 * win or loss
	 */

	private static Map<Mopokens, Mopokens> fights;// Maintains the battle fixture for every mopokens i.e Mopoken vs Mopoken
	private BattleNominee opponent;
	private Adaptable adapt;
	
	public MopokenSelector(BattleNominee breeder,BattleNominee opponent) {
		this.adapt=new MopokenAdapter(breeder.getMopokens()); 
		this.opponent=opponent;
		fights = new LinkedHashMap<Mopokens, Mopokens>();
	}

	@Override
	public void prepareBattles() {
		Map<String, Mopokens> opponents = opponent.getMopokens();
		for (Map.Entry<String, Mopokens> m : opponents.entrySet()) {
			Mopokens myMopoken = adapt.match(m.getValue());
			fights.put(m.getValue(), myMopoken); // Prepares the mopoken battles
		}
		if (decideMatch(MopokenAdapter.deciderCount)) {
			printResult();
		} else {
			System.out.println("There are no chances of winning");
		}
	}

	private boolean decideMatch(int count) {

		if (count < 3) {
			return false;
		}
		return true;

	}

	public void printResult() {
		String output = "";

		for (Map.Entry<Mopokens, Mopokens> m : fights.entrySet()) {
			output = output + m.getValue().getName() + "#" + m.getValue().getLevel() + ";";
		}
		System.out.println(output);
	}

}
