package holaHibernate.DAO;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Vicente
 */
public interface GenericDAO<T, ID extends Serializable> {
    T create() throws Exception;
    T read(ID id) throws Exception;
    void update(T obj) throws Exception;
    void delete(ID id) throws Exception;
    List<T> findAll() throws Exception;
}