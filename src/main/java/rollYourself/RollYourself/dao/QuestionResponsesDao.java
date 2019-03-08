package rollYourself.RollYourself.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import rollYourself.RollYourself.model.QuestionResponses;

@Repository
@Transactional
public class QuestionResponsesDao {

	@PersistenceContext
	private EntityManager em;

	public List<QuestionResponses> findAll() {
		return em.createQuery("FROM QuestionResponses", QuestionResponses.class).getResultList();
	}

	public QuestionResponses findById(Long id) {
		return em.find(QuestionResponses.class, id);
	}
	
	
	public void create(QuestionResponses QuestionResponse) {
		em.persist(QuestionResponse);
	}

	public void update(QuestionResponses QuestionResponse) {
		em.merge(QuestionResponse);
	}

	public void delete(Long id) {
		QuestionResponses QuestionResponse = em.getReference(QuestionResponses.class, id);
		em.remove(QuestionResponse);
	}

}
