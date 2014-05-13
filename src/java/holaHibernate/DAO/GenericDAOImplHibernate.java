package holaHibernate.DAO;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Vicente
 */
public class GenericDAOImplHibernate<T, ID extends Serializable> 
             implements GenericDAO<T, ID> {

    @Autowired
    SessionFactory sessionFactory;
    
    public GenericDAOImplHibernate() {
    }
    private Class<T> getEntityClass() {
        return (Class<T>) ((ParameterizedType) 
                getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
    @Override
    public T create() throws InstantiationException, IllegalAccessException {
       return getEntityClass().newInstance();
    }
    @Override
    public T read(ID id) throws Exception {
        Session session = sessionFactory.getCurrentSession();
        
        session.beginTransaction();
        T entity = (T) session.get(getEntityClass(), id);
        if (entity == null) {
            throw new Exception("Los datos a ya no existen");
        }
        session.getTransaction().commit();
        return entity;
    }
    @Override
    public void update(T entity) throws Exception {
        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();
        session.saveOrUpdate(entity);
        session.getTransaction().commit();
    }
    @Override
    public void delete(ID id) throws Exception  {
        Session session = sessionFactory.getCurrentSession();
       
        session.beginTransaction();
        T entity = (T) session.get(getEntityClass(), id);
        if (entity == null) {
            throw new Exception("Los datos a borrar ya no existen");
        }
        session.delete(entity);
        session.getTransaction().commit();
    }
    @Override
    public List<T> findAll() throws Exception {
        Session session = sessionFactory.getCurrentSession();
        
        session.beginTransaction();
        Query query = session.createQuery("FROM " + getEntityClass().getName());
        List<T> entities = query.list();
        session.getTransaction().commit();
        return entities;
    }
}