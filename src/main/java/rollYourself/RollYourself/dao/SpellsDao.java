package rollYourself.RollYourself.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import rollYourself.RollYourself.DndCharacter;
import rollYourself.RollYourself.SpellsDetails;

@Repository
@Transactional
public class SpellsDao {
	@PersistenceContext
	private EntityManager em;
	
	public void create(SpellsDetails spellsDetails) {
		em.persist(spellsDetails);
	}
	
	public SpellsDetails findById(Long id) {
		return em.find(SpellsDetails.class, id);
	}
	
	public List<SpellsDetails> findByClassAndLevel(String classes, Integer level) {
		List<SpellsDetails> spellList = new ArrayList<>();
		em.createQuery("from SpellsDetails where level=:level AND LIKE classes=:classes", SpellsDetails.class)
		.setParameter("level", level).setParameter("classes", classes).getResultList();
		
		return spellList;
	}
}
