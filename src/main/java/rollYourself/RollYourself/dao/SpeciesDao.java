package rollYourself.RollYourself.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import rollYourself.RollYourself.citygenmodel.Species;


@Repository
@Transactional
public class SpeciesDao {
	@PersistenceContext
	private EntityManager em;
	
	public void create(Species species) {
		em.persist(species);
	}
	
	public Species findById(Long id) {
		return em.find(Species.class, id);
	}
	
	public List<Species> findAll(){
		return em.createQuery("FROM Species", Species.class).getResultList();
	}
	
	public void update(Species species) {
		em.merge(species);
	}

	public void delete(Long id) {
		Species species = em.getReference(Species.class, id);
		em.remove(species);
	}

}
