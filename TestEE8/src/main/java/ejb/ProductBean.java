package ejb;

import entity.ProductEntity;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Stateless
public class ProductBean {
    @PersistenceContext
    private EntityManager em;

    public List<ProductEntity> getAllProducts() {
        try {
            Query query = em.createQuery("SELECT p FROM ProductEntity p");
            List<ProductEntity> products = (List<ProductEntity>) query.getResultList();

            return products;
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public ProductEntity findById(Integer productId) {
        ProductEntity product = em.find(ProductEntity.class, productId);

        return product;
    }

    public ProductEntity findByName(String productName) {
        Query query = em.createQuery("SELECT p FROM ProductEntity p WHERE p.productName = :productName").setParameter("productName", productName).setMaxResults(1);
        ProductEntity product = (ProductEntity) query.getSingleResult();

        return product;
    }

    public void createProduct(String productName, int idCategory, Double price, int idUnit, String imgPath) {
        System.getProperties().setProperty("derby.language.sequence.preallocator", String.valueOf(1));

        ProductEntity product = new ProductEntity();

        product.setProductName(productName);
        product.setIdCategory(idCategory);
        product.setPrice(price);
        product.setIdUnit(idUnit);
        product.setImgPath(imgPath);

        em.persist(product);
    }

    public void updateProduct(Integer id, String newProductName, int newIdCategory, Double newPrice, int newIdUnit, String newImgPath) {
        ProductEntity product = em.find(ProductEntity.class, id);

        product.setProductName(newProductName);
        product.setIdCategory(newIdCategory);
        product.setPrice(newPrice);
        product.setIdUnit(newIdUnit);
        product.setImgPath(newImgPath);
    }

    public void updateProductName(Integer id, String newProductName) {
        ProductEntity product = em.find(ProductEntity.class, id);

        product.setProductName(newProductName);
    }

    public void updateProductPrice(Integer id, double newProductPrice) {
        ProductEntity product = em.find(ProductEntity.class, id);

        product.setPrice(newProductPrice);
    }

    public void updateProductCategory(Integer id, int newIdCategory) {
        ProductEntity product = em.find(ProductEntity.class, id);

        product.setIdCategory(newIdCategory);
    }

    public void deleteProductsByIds(Collection<Integer> ids) {
        for (Integer id : ids) {
            ProductEntity product = em.find(ProductEntity.class, id);

            em.remove(product);
        }
    }
}
