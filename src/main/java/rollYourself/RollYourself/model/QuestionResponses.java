package rollYourself.RollYourself.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Mark all entity classes with @Entity so that Hibernate knows about them.
@Entity
@Table(name="question_responses")
public class QuestionResponses {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Integer q1Response;
	private Integer q2Response;
	private Integer q3Response;
	private Integer q4Response;
	private Integer q5Response;
	private Integer q6Response;
	private Integer q7Response;
	private Integer q8Response;
	
	
	public QuestionResponses () {}
	
	
	public QuestionResponses(Long id, Integer q1Response, Integer q2Response, Integer q3Response, Integer q4Response,
			Integer q5Response, Integer q6Response) {
		this.id = id;
		this.q1Response = q1Response;
		this.q2Response = q2Response;
		this.q3Response = q3Response;
		this.q4Response = q4Response;
		this.q5Response = q5Response;
		this.q6Response = q6Response;
	}



	public QuestionResponses(Integer q1Response, Integer q2Response, Integer q3Response, Integer q4Response,
			Integer q5Response, Integer q6Response) {
		this.q1Response = q1Response;
		this.q2Response = q2Response;
		this.q3Response = q3Response;
		this.q4Response = q4Response;
		this.q5Response = q5Response;
		this.q6Response = q6Response;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Integer getQ1Response() {
		return q1Response;
	}
	public void setQ1Response(Integer q1Response) {
		this.q1Response = q1Response;
	}
	
	public Integer getQ2Response() {
		return q2Response;
	}
	public void setQ2Response(Integer q2Response) {
		this.q2Response = q2Response;
	}
	
	public Integer getQ3Response() {
		return q3Response;
	}
	public void setQ3Response(Integer q3Response) {
		this.q3Response = q3Response;
	}
	
	public Integer getQ4Response() {
		return q4Response;
	}
	public void setQ4Response(Integer q4Response) {
		this.q4Response = q4Response;
	}
	
	public Integer getQ5Response() {
		return q5Response;
	}
	public void setQ5Response(Integer q5Response) {
		this.q5Response = q5Response;
	}
	
	public Integer getQ6Response() {
		return q6Response;
	}
	public void setQ6Response(Integer q6Response) {
		this.q6Response = q6Response;
	}


	public Integer getQ7Response() {
		return q7Response;
	}


	public void setQ7Response(Integer q7Response) {
		this.q7Response = q7Response;
	}


	public Integer getQ8Response() {
		return q8Response;
	}


	public void setQ8Response(Integer q8Response) {
		this.q8Response = q8Response;
	}
	

}
