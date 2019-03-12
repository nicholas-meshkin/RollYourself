package rollYourself.RollYourself;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rollYourself.RollYourself.StatRoller;
import rollYourself.RollYourself.model.AbilityScoreItem;

@Component
public class StatSetter {
	@Autowired
	StatRoller statRoller;
	
	public Integer calculateBonus(Integer abilityScore) {
		Integer bonus;
		if(abilityScore%2==0) {
			bonus = (abilityScore/2)-5;
		}else {
			bonus = ((abilityScore-1)/2)-5;
		}
		return bonus;
	}
	
	public List<Integer> calculateAbilityBonuses (DndCharacter dndCharacter){
		List<Integer> abilityBonuses = new ArrayList<>();
		abilityBonuses.add(calculateBonus(dndCharacter.getStrength()));
		abilityBonuses.add(calculateBonus(dndCharacter.getDexterity()));
		abilityBonuses.add(calculateBonus(dndCharacter.getConstitution()));
		abilityBonuses.add(calculateBonus(dndCharacter.getIntelligence()));
		abilityBonuses.add(calculateBonus(dndCharacter.getWisdom()));
		abilityBonuses.add(calculateBonus(dndCharacter.getCharisma()));
		return abilityBonuses;
	}
	
	public List<Integer> calculateSavingThrows(DndCharacter dndCharacter){
		List<Integer> savingThrows = new ArrayList<>();
		savingThrows.add(calculateBonus(dndCharacter.getStrength()));
		savingThrows.add(calculateBonus(dndCharacter.getDexterity()));
		savingThrows.add(calculateBonus(dndCharacter.getConstitution()));
		savingThrows.add(calculateBonus(dndCharacter.getIntelligence()));
		savingThrows.add(calculateBonus(dndCharacter.getWisdom()));
		savingThrows.add(calculateBonus(dndCharacter.getCharisma()));
		List<AbilityScoreItem> list = dndCharacter.getClassDetail().getSavingThrows();
		if(list.get(0).getName().equals("STR")||(list.get(1).getName().equals("STR"))) {
			savingThrows.set(0, savingThrows.get(0)+2);
		}
		if(list.get(0).getName().equals("DEX")||(list.get(1).getName().equals("DEX"))) {
			savingThrows.set(1, savingThrows.get(1)+2);
		}
		if(list.get(0).getName().equals("CON")||(list.get(1).getName().equals("CON"))) {
			savingThrows.set(2, savingThrows.get(2)+2);
		}
		if(list.get(0).getName().equals("INT")||(list.get(1).getName().equals("INT"))) {
			savingThrows.set(3, savingThrows.get(3)+2);
		}
		if(list.get(0).getName().equals("WIS")||(list.get(1).getName().equals("WIS"))) {
			savingThrows.set(4, savingThrows.get(4)+2);
		}
		if(list.get(0).getName().equals("CHA")||(list.get(1).getName().equals("CHA"))) {
			savingThrows.set(5, savingThrows.get(5)+2);
		}
		return savingThrows;
	}
	
	public DndCharacter raceStatAdjust(DndCharacter dndCharacter) {
		List<Integer> abBonus = dndCharacter.getRaceDetail().getAbilityBonuses();
		dndCharacter.setStrength(dndCharacter.getStrength()+abBonus.get(0));
		dndCharacter.setDexterity(dndCharacter.getDexterity()+abBonus.get(1));
		dndCharacter.setConstitution(dndCharacter.getConstitution()+abBonus.get(2));
		dndCharacter.setIntelligence(dndCharacter.getIntelligence()+abBonus.get(3));
		dndCharacter.setWisdom(dndCharacter.getWisdom()+abBonus.get(4));
		dndCharacter.setCharisma(dndCharacter.getCharisma()+abBonus.get(5));
		return dndCharacter;
	}
	
	public DndCharacter subraceStatAdjust(DndCharacter dndCharacter) {
		List<Integer> abBonus = dndCharacter.getSubraceDetail().getAbilityBonuses();
		dndCharacter.setStrength(dndCharacter.getStrength()+abBonus.get(0));
		dndCharacter.setDexterity(dndCharacter.getDexterity()+abBonus.get(1));
		dndCharacter.setConstitution(dndCharacter.getConstitution()+abBonus.get(2));
		dndCharacter.setIntelligence(dndCharacter.getIntelligence()+abBonus.get(3));
		dndCharacter.setWisdom(dndCharacter.getWisdom()+abBonus.get(4));
		dndCharacter.setCharisma(dndCharacter.getCharisma()+abBonus.get(5));
		return dndCharacter;
	}

	public DndCharacter setBarbarian(DndCharacter dndCharacter) {
		List<Integer> stats = statRoller.getStatList();
		Collections.sort(stats, Collections.reverseOrder());
		int j = 0;
		for(int i:stats) {
			if(j == 0) {
				dndCharacter.setStrength(i);
			}if(j == 2) {
				dndCharacter.setDexterity(i);
			}if(j == 1) {
				dndCharacter.setConstitution(i);
			}if(j == 5) {
				dndCharacter.setIntelligence(i);
			}if(j == 3) {
				dndCharacter.setWisdom(i);
			}if(j == 4) {
				dndCharacter.setCharisma(i);
			}j++;
		}
		return dndCharacter;
	}
	
	public DndCharacter setBard(DndCharacter dndCharacter) {
		List<Integer> stats = statRoller.getStatList();
		Collections.sort(stats, Collections.reverseOrder());
		int j = 0;
		for(int i:stats) {
			if(j == 4) {
				dndCharacter.setStrength(i);
			}if(j == 1) {
				dndCharacter.setDexterity(i);
			}if(j == 3) {
				dndCharacter.setConstitution(i);
			}if(j == 2) {
				dndCharacter.setIntelligence(i);
			}if(j == 5) {
				dndCharacter.setWisdom(i);
			}if(j ==0) {
				dndCharacter.setCharisma(i);
			}j++;
		}
		return dndCharacter;
	}
	
	public DndCharacter setCleric(DndCharacter dndCharacter) {
		List<Integer> stats = statRoller.getStatList();
		Collections.sort(stats, Collections.reverseOrder());
		int j = 0;
		for(int i:stats) {
			if(j == 4) {
				dndCharacter.setStrength(i);
			}if(j == 3) {
				dndCharacter.setDexterity(i);
			}if(j == 1) {
				dndCharacter.setConstitution(i);
			}if(j == 5) {
				dndCharacter.setIntelligence(i);
			}if(j == 0) {
				dndCharacter.setWisdom(i);
			}if(j == 2) {
				dndCharacter.setCharisma(i);
			}j++;
		}
		return dndCharacter;
	}
	
	public DndCharacter setDruid(DndCharacter dndCharacter) {
		List<Integer> stats = statRoller.getStatList();
		Collections.sort(stats, Collections.reverseOrder());
		int j = 0;
		for(int i:stats) {
			if(j == 4) {
				dndCharacter.setStrength(i);
			}if(j == 2) {
				dndCharacter.setDexterity(i);
			}if(j == 3) {
				dndCharacter.setConstitution(i);
			}if(j == 1) {
				dndCharacter.setIntelligence(i);
			}if(j == 0) {
				dndCharacter.setWisdom(i);
			}if(j == 5) {
				dndCharacter.setCharisma(i);
			}j++;
		}
		return dndCharacter;
	}

	public DndCharacter setFighter(DndCharacter dndCharacter) {
		List<Integer> stats = statRoller.getStatList();
		Collections.sort(stats, Collections.reverseOrder());
		int j = 0;
		for(int i:stats) {
			if(j == 0) {
				dndCharacter.setStrength(i);
			}if(j == 2) {
				dndCharacter.setDexterity(i);
			}if(j == 1) {
				dndCharacter.setConstitution(i);
			}if(j == 4) {
				dndCharacter.setIntelligence(i);
			}if(j == 5) {
				dndCharacter.setWisdom(i);
			}if(j == 3) {
				dndCharacter.setCharisma(i);
			}j++;
		}
		return dndCharacter;
	}
	
	public DndCharacter setMonk(DndCharacter dndCharacter) {
		List<Integer> stats = statRoller.getStatList();
		Collections.sort(stats, Collections.reverseOrder());
		int j = 0;
		for(int i:stats) {
			if(j == 3) {
				dndCharacter.setStrength(i);
			}if(j == 0) {
				dndCharacter.setDexterity(i);
			}if(j == 2) {
				dndCharacter.setConstitution(i);
			}if(j == 5) {
				dndCharacter.setIntelligence(i);
			}if(j == 1) {
				dndCharacter.setWisdom(i);
			}if(j == 4) {
				dndCharacter.setCharisma(i);
			}j++;
		}
		return dndCharacter;
	}
	
	public DndCharacter setPaladin(DndCharacter dndCharacter) {
		List<Integer> stats = statRoller.getStatList();
		Collections.sort(stats, Collections.reverseOrder());
		int j = 0;
		for(int i:stats) {
			if(j == 1) {
				dndCharacter.setStrength(i);
			}if(j == 5) {
				dndCharacter.setDexterity(i);
			}if(j == 2) {
				dndCharacter.setConstitution(i);
			}if(j == 4) {
				dndCharacter.setIntelligence(i);
			}if(j == 3) {
				dndCharacter.setWisdom(i);
			}if(j == 0) {
				dndCharacter.setCharisma(i);
			}j++;
		}
		return dndCharacter;
	}
	
	public DndCharacter setRanger(DndCharacter dndCharacter) {
		List<Integer> stats = statRoller.getStatList();
		Collections.sort(stats, Collections.reverseOrder());
		int j = 0;
		for(int i:stats) {
			if(j == 4) {
				dndCharacter.setStrength(i);
			}if(j == 0) {
				dndCharacter.setDexterity(i);
			}if(j == 1) {
				dndCharacter.setConstitution(i);
			}if(j == 3) {
				dndCharacter.setIntelligence(i);
			}if(j == 2) {
				dndCharacter.setWisdom(i);
			}if(j == 5) {
				dndCharacter.setCharisma(i);
			}j++;
		}
		return dndCharacter;
	}
	
	public DndCharacter setRogue(DndCharacter dndCharacter) {
		List<Integer> stats = statRoller.getStatList();
		Collections.sort(stats, Collections.reverseOrder());
		int j = 0;
		for(int i:stats) {
			if(j == 4) {
				dndCharacter.setStrength(i);
			}if(j == 0) {
				dndCharacter.setDexterity(i);
			}if(j == 3) {
				dndCharacter.setConstitution(i);
			}if(j == 1) {
				dndCharacter.setIntelligence(i);
			}if(j == 5) {
				dndCharacter.setWisdom(i);
			}if(j == 2) {
				dndCharacter.setCharisma(i);
			}j++;
		}
		return dndCharacter;
	}
	
	public DndCharacter setSorcerer(DndCharacter dndCharacter) {
		List<Integer> stats = statRoller.getStatList();
		Collections.sort(stats, Collections.reverseOrder());
		int j = 0;
		for(int i:stats) {
			if(j == 4) {
				dndCharacter.setStrength(i);
			}if(j == 1) {
				dndCharacter.setDexterity(i);
			}if(j == 2) {
				dndCharacter.setConstitution(i);
			}if(j == 3) {
				dndCharacter.setIntelligence(i);
			}if(j == 5) {
				dndCharacter.setWisdom(i);
			}if(j == 0) {
				dndCharacter.setCharisma(i);
			}j++;
		}
		return dndCharacter;
	}
	
	public DndCharacter setWarlock(DndCharacter dndCharacter) {
		List<Integer> stats = statRoller.getStatList();
		Collections.sort(stats, Collections.reverseOrder());
		int j = 0;
		for(int i:stats) {
			if(j == 4) {
				dndCharacter.setStrength(i);
			}if(j == 2) {
				dndCharacter.setDexterity(i);
			}if(j == 3) {
				dndCharacter.setConstitution(i);
			}if(j == 5) {
				dndCharacter.setIntelligence(i);
			}if(j == 1) {
				dndCharacter.setWisdom(i);
			}if(j == 0) {
				dndCharacter.setCharisma(i);
			}j++;
		}
		return dndCharacter;
	}
	
	public DndCharacter setWizard(DndCharacter dndCharacter) {
		List<Integer> stats = statRoller.getStatList();
		Collections.sort(stats, Collections.reverseOrder());
		int j = 0;
		for(int i:stats) {
			if(j == 5) {
				dndCharacter.setStrength(i);
			}if(j == 1) {
				dndCharacter.setDexterity(i);
			}if(j == 4) {
				dndCharacter.setConstitution(i);
			}if(j == 0) {
				dndCharacter.setIntelligence(i);
			}if(j == 2) {
				dndCharacter.setWisdom(i);
			}if(j == 3) {
				dndCharacter.setCharisma(i);
			}j++;
		}
		return dndCharacter;
	}
	
	public DndCharacter setStats(DndCharacter dndCharacter) {
		if(dndCharacter.getClassDetail().getIndex()==1) {
			setBarbarian(dndCharacter);
		}
		if(dndCharacter.getClassDetail().getIndex()==2) {
			setBard(dndCharacter);
		}
		if(dndCharacter.getClassDetail().getIndex()==3) {
			setCleric(dndCharacter);
		}
		if(dndCharacter.getClassDetail().getIndex()==4) {
			setDruid(dndCharacter);
		}
		if(dndCharacter.getClassDetail().getIndex()==5) {
			setFighter(dndCharacter);
		}
		if(dndCharacter.getClassDetail().getIndex()==6) {
			setMonk(dndCharacter);
		}
		if(dndCharacter.getClassDetail().getIndex()==7) {
			setPaladin(dndCharacter);
		}
		if(dndCharacter.getClassDetail().getIndex()==8) {
			setRanger(dndCharacter);
		}
		if(dndCharacter.getClassDetail().getIndex()==9) {
			setRogue(dndCharacter);
		}
		if(dndCharacter.getClassDetail().getIndex()==10) {
			setSorcerer(dndCharacter);
		}
		if(dndCharacter.getClassDetail().getIndex()==11) {
			setWarlock(dndCharacter);
		}
		if(dndCharacter.getClassDetail().getIndex()==12) {
			setWizard(dndCharacter);
		}
		return dndCharacter;
	}
}
