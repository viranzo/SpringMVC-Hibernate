package holaHibernate.DAO;

import holaHibernate.entidades.Cliente;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vicente
 */
@Repository
public class ClienteDAOImplHibernate extends 
        GenericDAOImplHibernate<Cliente,Integer> implements  ClienteDAO {
}
