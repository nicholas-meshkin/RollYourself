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
	
}


