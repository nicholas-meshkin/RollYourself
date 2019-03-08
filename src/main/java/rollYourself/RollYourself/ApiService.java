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
	
//	private RestTemplate restTemplate = new RestTemplate();
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
	
	public ClassDetail getClassDetail(/*will add parameter*/) {
		String url = "http://www.dnd5eapi.co/api/classes/2"; //TODO change url to include parameter
		ClassDetail response = restTemplateWithUserAgent.getForObject(url, ClassDetail.class);
		return response;
	}
	
	public RaceDetail getRaceDetail(/*TODO add params*/) {
		String url = "http://www.dnd5eapi.co/api/races/2";//TODO change url to include param
		RaceDetail response = restTemplateWithUserAgent.getForObject(url, RaceDetail.class);
		return response;
	}
	}


