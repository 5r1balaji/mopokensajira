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
		this.nominees=nominees;
	}
	
	
	@Override
	public void organizeMopokens() {
		Map<String,Mopokens> mySquad=BattleNominees.mySquad;
		Adaptable adapt=new MopokenAdapter(BattleNominees.enemySquad);
		for(String sd:mySquad.keySet()) {
		     Mopokens opponent=adapt.match(mySquad.get(sd));
		     fights.put(mySquad.get(sd), opponent);
		}
		if(decideMatch(fights)) {
			printResult();
		}
		else {
			System.out.println("There are no chances of winning");
		}
	}

	

	
	
	
	

	private boolean decideMatch(Map<Mopokens, Mopokens> fights) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public void printResult() {
		// TODO Auto-generated method stub
		
	}
	
}
