package ejb;

import entity.UserTableEntity;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class UserBean {
    @PersistenceContext
    private EntityManager em;

    public void CreateUser(String username, String password, int role, String email){
        System.getProperties().setProperty("derby.language.sequence.preallocator", String.valueOf(1));

        UserTableEntity user = new UserTableEntity();

        user.setUsername(username);
        user.setPassword(password);
        user.setIdRole(role);
        user.setIdState(1);
        user.setEmail(email);

        em.persist(user);
    }

    public List<UserTableEntity> getAllUsers() {
        try {
            Query query = em.createQuery("SELECT u FROM UserTableEntity u");
            List<UserTableEntity> users = (List<UserTableEntity>) query.getResultList();
            return users;
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

}
