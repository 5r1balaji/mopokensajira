package org.ajira.mopokens;

import java.util.Map;

public class MopokenSelector implements BattleFixtures {

	private BattleNominees nominees;

	public BattleNominees getNominees() {
		return nominees;
	}

	public void setNominees(BattleNominees nominees) {
		this.nominees = nominees;
	}

	public MopokenSelector() {
		// TODO Auto-generated constructor stub
	}

	public MopokenSelector(BattleNominees nominees) {
		this.nominees = nominees;
	}

	@Override
	public void organizeMopokens() {
		Map<String, Mopokens> opponents = BattleNominees.enemySquad;
		Adaptable adapt = new MopokenAdapter(BattleNominees.mySquad);
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
			// output=output+m.getKey().getName()+m.getKey().getLevel()+":"+m.getValue().getName()+m.getValue().getLevel()+"\n";
		}
		System.out.println(output);
	}

}
