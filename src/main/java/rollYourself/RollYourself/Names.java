package rollYourself.RollYourself;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Names {
	
	String name = "";
	String race = "";
	
	public String selectName(DndCharacter dndCharacter) {
		
		List<String> nameList = new ArrayList<>();
		race = dndCharacter.getRace();
		Random rand = new Random();
		int x = rand.nextInt(20) + 1;
		
		if (dndCharacter.getRace().equals("Human")) {
		
			nameList.addAll(Arrays.asList("Hezum Damud", "Gravodd Terrasworn", "Renvog Tarrenriver", "Bodrol Deg", "Ol Ronen", "Brurder Suncreek",
					"Fram Hammergem", "Ziozeth Vunskib", "Mourdordald Grorkimzokye", "Drourak Hodzoldi", "Uh Uan", "Qip Hiam", "Muenrolbar Bodrohos",
					"Zomos Bibrisqos", "Oveh Resta", "Corlurrih Ragepike", "Silro Fireblade", "Rolme Chitsk", "Lo Solan", "Virhivey Wiseleaf"));
			name = nameList.get(x);
			return name;
		}
	
		if (dndCharacter.getRace().equals("Dwarf")) {
			
			nameList.addAll(Arrays.asList("Urmgus", "Belkohm", "Tymyr", "Gimkuhm", "Maldek", "Randuhr",
					"Grenmiir", "Krumdir", "Hordor", "Banthran", "Kathvian", "Nesdielle", "Mystdille",
					"Nesniss", "Branbera", "Nesmyl", "Gemdyl", "Gymryl", "Brilwynn", "Bendain"));
			name = nameList.get(x);
			return name;
		}

		if (dndCharacter.getRace().equals("Dragonborn")) {
			
			nameList.addAll(Arrays.asList("Caerqrin Yiccis", "Lumiziros Myilred", "Worrash Naankiakmas", "Shadhall Pristin", "Krivroth Shunxoston", 
					"Tazhadur Drilkuan", "Ghewarum Clemtos", "Zrahazar Cruunkuushtirduath", "Wulqull Preldul", "Narturim Tuphikith", "Sucoria Firrhur", 
					"Kelvyre Fostuntharrar", "Ariwyn Liciseardel", "Erlithibra Calkenillal", "Arinn Kracciseardir", "Oripora Kriphutoc", 
					"Xisbith Klelkorianuul", "Urihime Klestokilaac", "Dayassa Claanxasak", "Therrith Shemphaxec"));
			name = nameList.get(x);
			return name;
		}
		
		if (dndCharacter.getRace().equals("Elf")) {
			
			nameList.addAll(Arrays.asList("Lukian", "Ersalor", "Zumwraek", "Adjeon", "Norgolor", "Mirazeiros",
					"Dorris", "Perran", "Yinmenor", "Tracan", "Torharice", "Wynkrana", "Krisnala",
					"Eildove", "Ularalei", "Qiwynn", "Sylralei", "Ulawynn", "Qicaryn", "Qinbalar"));
			name = nameList.get(x);
			return name;
		}
		
		if (dndCharacter.getRace().equals("Gnome")) {
			
			nameList.addAll(Arrays.asList("Jebis", "Yebar", "Gator", "Hispos", "Briji", "Qualen",
					"Kashim", "Zilrug", "Zancryn", "Salzu", "Xyrofyx", "Daphimila", "Xatina",
					"Jelmila", "Fennove", "Venfi", "Isodysa", "Ufegyra", "Qikini", "Krissa"));
			name = nameList.get(x);
			return name;
		}
		
		if (dndCharacter.getRace().equals("Halfling")) {
		
			nameList.addAll(Arrays.asList("Pimser", "Corbin", "Pimvias", "Halric", "Noros", "Yenos",
					"Lary", "Quinhace", "Norumo", "Marwan", "Grala", "Uvialyn", "Jillile",
					"Qialyn", "Frone", "Frowyn", "Eihaly", "Grafira", "Thamjen", "Marleigh"));
			name = nameList.get(x);
			return name;
		}
		
		if (dndCharacter.getRace().equals("Half-Orc")) {
			
			nameList.addAll(Arrays.asList("Thragul", "Mukegall", "Thodurk", "Urabur", "Bobur", "Grabark",
					"Malorth", "Mudark", "Sorugark", "Ogguotar", "Ubegu", "Ubizi", "Samazira",
					"Sumazar", "Ritar", "Rawine", "Rawutur", "Shari", "Rugri", "Gorazur"));
			name = nameList.get(x);
			return name;
		}
		
		if (dndCharacter.getRace().equals("Tiefling")) {
		
			nameList.addAll(Arrays.asList("Gumir", "Shamir", "Thymus", "Carrakas", "Rolvius", "Eril",
					"Dharvenom", "End", "Anivari", "Rilia", "Dinirith", "Dayola", "Qulaia",
					"Seiridani", "Yameia", "Adventure", "Mantra", "Sly", "Aranron", "Zordos"));
			name = nameList.get(x);
			return name;
			
		// Half-Elf names (default if getRace doesn't work)	
		} else {
		
			nameList.addAll(Arrays.asList("Rafparin", "Gaerminar", "Corynor", "Osfyr", "Uanben", "Belqarim",
					"Sylfaerd", "Rifaelor", "Zylhomin", "Lorwarith", "Reskilia", "Jencharis", "Relnoa",
					"Jenxipha", "Fhathana", "Darlynn", "Norwaris", "Yllmae", "Tylxaris", "Unakaen"));
			name = nameList.get(x);
			return name;
		}
	
	}
}