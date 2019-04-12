package rollYourself.RollYourself.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import rollYourself.RollYourself.citygenmodel.NameItem;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public class NamesDao {
	
	@PersistenceContext
	private EntityManager em;

	public List<NameItem> findNames(Integer cultureId, String type, String gender) {
		return em.createQuery("FROM NameItem WHERE cultureId = :cultureId AND type = :type AND gender = :gender", NameItem.class)
				.setParameter("cultureId", cultureId).setParameter("type", type).setParameter("gender", gender)
				.getResultList();
	}
	
	public List<NameItem> findNamestest() {
		return em.createQuery(" FROM NameItem WHERE cultureId = '2' AND type = 'F'", NameItem.class)
				.getResultList();
	}
//	public List<Name> findLastNameByCultureId(Integer cultureId) {
//		return em.createQuery("FROM Name WHERE cultureId = :cultureId AND type = S", Name.class)
//				.setParameter("cultureId", cultureId).getResultList();
//}
//	public List<Name> findFemaleFirstNameByCultureId(Integer cultureId){
//		return em.createQuery("FROM Name WHERE cultureId = :cultureId AND type = `F` AND gender= `F`", Name.class)
//				.setParameter("cultureId", cultureId).getResultList();
//	}
//	public List<Name> findMaleFirstNameByCultureId(Integer cultureId){
//		return em.createQuery("FROM Name WHERE cultureId = :cultureId AND type = `F` AND gender= `M`", Name.class)
//				.setParameter("cultureId", cultureId).getResultList();
//	}
	
}