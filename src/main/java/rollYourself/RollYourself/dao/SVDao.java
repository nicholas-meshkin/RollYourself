package rollYourself.RollYourself.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import rollYourself.RollYourself.SpellsDetails;
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
		
		public List<DefaultSV> findByTownType(String townType){
			return em.createQuery("FROM DefaultSV WHERE townType = :townType", DefaultSV.class).setParameter("townType", townType).getResultList();
		}
		
		public List<DefaultSV> findByFamJob(Boolean famjob){
			return em.createQuery("FROM DefaultSV WHERE famjob = :famjob", DefaultSV.class).setParameter("famjob", famjob).getResultList();
		}

	}
