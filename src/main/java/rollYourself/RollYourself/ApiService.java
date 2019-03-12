package rollYourself.RollYourself;

import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import rollYourself.RollYourself.model.*;

@Component
public class ApiService {
	
	private RestTemplate restTemplate = new RestTemplate();
private RestTemplate restTemplateWithUserAgent;

	{
		ClientHttpRequestInterceptor interceptor = (request, body, execution) -> {
	        request.getHeaders().add(HttpHeaders.USER_AGENT, "Spring");
	        return execution.execute(request, body);
	    };
	    restTemplateWithUserAgent = new RestTemplateBuilder().additionalInterceptors(interceptor).build();
	}
	
	public List<ClassListItem> getClassList(){
		String url = "http://www.dnd5eapi.co/api/classes";
		ClassListResponse response = restTemplateWithUserAgent.getForObject(url, ClassListResponse.class);
		return response.getResults();
	}
	
	public ClassDetail getClassDetail(/*TODO add params*/) {
		Integer index = 6; //TODO delete once parameters are implemented
		String url = "http://www.dnd5eapi.co/api/classes/"+index; 
		ClassDetail response = restTemplateWithUserAgent.getForObject(url, ClassDetail.class);
		return response;
	}
	
	public ClassDetail getClassDetail(Integer index) {
		String url = "http://www.dnd5eapi.co/api/classes/"+index; 
		ClassDetail response = restTemplateWithUserAgent.getForObject(url, ClassDetail.class);
		return response;
	}
	
	public RaceDetail getRaceDetail(/*TODO add params*/) {
		Integer index = 4; //TODO delete once parameters are implemented
		String url = "http://www.dnd5eapi.co/api/races/"+index;
		RaceDetail response = restTemplateWithUserAgent.getForObject(url, RaceDetail.class);
		return response;
	}
	public RaceDetail getRaceDetail(Integer index) {
		String url = "http://www.dnd5eapi.co/api/races/"+index;
		RaceDetail response = restTemplateWithUserAgent.getForObject(url, RaceDetail.class);
		return response;
	}
	
	public SubraceDetail getSubraceDetail(/*TODO add params*/) {
		Integer index = 3; //TODO delete once parameters are implemented
		String url = "http://www.dnd5eapi.co/api/subraces/"+index;
		SubraceDetail response = restTemplateWithUserAgent.getForObject(url, SubraceDetail.class);
		return response;
	}
	
	public List<SkillItem> getSkillList(){
		String url="http://www.dnd5eapi.co/api/skills";
		SkillListResponse response = restTemplateWithUserAgent.getForObject(url, SkillListResponse.class);
		return response.getResults();
	}
	
	public Skill getSkill(/*TODO add param*/) {
		Integer index=4;
		String url="http://www.dnd5eapi.co/api/skills/"+index;
		Skill response = restTemplateWithUserAgent.getForObject(url, Skill.class);
		return response;
	}
	
	public Skill getSkill(Integer index) {
		String url="http://www.dnd5eapi.co/api/skills/"+index;
		Skill response = restTemplateWithUserAgent.getForObject(url, Skill.class);
		return response;
	}
	
	public List<AbilityScoreItem> getSavingThrowList(){
		String url="http://www.dnd5eapi.co/api/ability-scores";
		AbilityScoreList response  = restTemplateWithUserAgent.getForObject(url, AbilityScoreList.class);
		return response.getResults();
	}
	public AbilityScore abilityScoreDetail(int index) {
		String url="http://www.dnd5eapi.co/api/ability-scores/" + index;
		AbilityScore response = restTemplateWithUserAgent.getForObject(url, AbilityScore.class);
		return response;
	}
	
	public Equipment getEquipment(Integer index) {
		String url = "http://www.dnd5eapi.co/api/equipment/"+index;
		Equipment response = restTemplateWithUserAgent.getForObject(url, Equipment.class);
		return response;
	}
	}


