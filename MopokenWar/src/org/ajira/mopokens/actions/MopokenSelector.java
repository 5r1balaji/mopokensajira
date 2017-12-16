package org.ajira.mopokens.actions;

import java.util.Map;

import org.ajira.mopokens.model.Mopokens;

public class MopokenSelector implements BattleFixtures {
	/*
	 * MopokenSelector decides whether the matches between the mopokens resulted in
	 * win or loss
	 */

	private BattleNominees nominees;

	public BattleNominees getNominees() {
		return nominees;
	}

	public void setNominees(BattleNominees nominees) {
		this.nominees = nominees;
	}

	public MopokenSelector() {

	}

	public MopokenSelector(BattleNominees nominees) {
		this.nominees = nominees;
	}

	@Override
	public void organizeMopokens() {
		Map<String, Mopokens> opponents = BattleNominees.opponentSquad;
		Adaptable adapt = new MopokenAdapter(BattleNominees.breederSquad);
		for (Map.Entry<String, Mopokens> m : opponents.entrySet()) {
			Mopokens myMopoken = adapt.match(m.getValue());
			fights.put(m.getValue(), myMopoken);
		}
		if (decideMatch(MopokenAdapter.deciderCount)) {
			System.out.println(MopokenAdapter.deciderCount);
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
