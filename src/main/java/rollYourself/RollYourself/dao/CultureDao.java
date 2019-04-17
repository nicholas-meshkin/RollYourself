package rollYourself.RollYourself.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import rollYourself.RollYourself.citygenmodel.Culture;

@Repository
@Transactional
public class CultureDao {

	@PersistenceContext
	private EntityManager em;
	
	public List<Culture> findAll(){
		return em.createQuery("FROM Culture", Culture.class).getResultList();
	}
	
	public Culture findById(Long id) {
		return em.find(Culture.class, id);
	}
}
