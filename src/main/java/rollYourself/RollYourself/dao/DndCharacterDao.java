package rollYourself.RollYourself.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import rollYourself.RollYourself.DndCharacter;

@Repository
@Transactional
public class DndCharacterDao {

	@PersistenceContext
	private EntityManager em;


	public List<DndCharacter> findAll() {
		return em.createQuery("FROM DndCharacter", DndCharacter.class).getResultList();
	}

	public DndCharacter findById(Long id) {
		return em.find(DndCharacter.class, id);
	}
	
	
	public void create(DndCharacter dndCharacter) {
		em.persist(dndCharacter);
	}

	public void update(DndCharacter dndCharacter) {
		em.merge(dndCharacter);
	}

	public void delete(Long id) {
		DndCharacter dndCharacter = em.getReference(DndCharacter.class, id);
		em.remove(dndCharacter);
	}
	
}
