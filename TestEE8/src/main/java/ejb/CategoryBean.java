package ejb;

import entity.CategoryEntity;
import entity.ProductEntity;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;

@Stateless
public class CategoryBean {
    @PersistenceContext
    private EntityManager em;

    public List<CategoryEntity> getAllCategories() {
        try {
            Query query = em.createQuery("SELECT c FROM CategoryEntity c");
            List<CategoryEntity> categories = (List<CategoryEntity>) query.getResultList();

            return categories;
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public CategoryEntity findById(Integer categoryId) {
        CategoryEntity category = em.find(CategoryEntity.class, categoryId);

        return category;
    }

    public CategoryEntity findByName(String categoryName) {
        Query query = em.createQuery("SELECT c FROM CategoryEntity c WHERE c.category = :categoryName").setParameter("category", categoryName).setMaxResults(1);
        CategoryEntity category = (CategoryEntity) query.getSingleResult();

        return category;
    }

    public void createCategory(String description) {
        System.getProperties().setProperty("derby.language.sequence.preallocator", String.valueOf(1));

        CategoryEntity category = new CategoryEntity();

        category.setCategory(description);

        em.persist(category);
    }

    public void updateCategory(Integer id, String newCategoryName) {
        CategoryEntity category = em.find(CategoryEntity.class, id);

        category.setCategory(newCategoryName);
    }

    public void deleteCategoriesByIds(Collection<Integer> ids) {
        for (Integer id : ids) {
            CategoryEntity category = em.find(CategoryEntity.class, id);

            em.remove(category);
        }
    }
}
