package rollYourself.RollYourself.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import rollYourself.RollYourself.citygenmodel.DefaultSV;

	@Repository
	@Transactional
	public class SVDao {
		@PersistenceContext
		private EntityManager em;
		
		public void create(DefaultSV defaultSV) {
			em.persist(defaultSV);
		}
		
		public DefaultSV findById(Long id) {
			return em.find(DefaultSV.class, id);
		}
		
		public List<DefaultSV> findAll(){
			return em.createQuery("FROM DefaultSV", DefaultSV.class).getResultList();
		}
		
		public void update(DefaultSV defaultSV) {
			em.merge(defaultSV);
		}

		public void delete(Long id) {
			DefaultSV defaultSV = em.getReference(DefaultSV.class, id);
			em.remove(defaultSV);
		}

	}
