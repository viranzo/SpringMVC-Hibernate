/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package holaHibernate.presentacion;

import holaHibernate.entidades.Cliente;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Vicente
 */
@Controller
public class RootControler {
    
    @Autowired
    SessionFactory sessionFactory;
    
    @RequestMapping({"/index.html"})
    public ModelAndView listaClientes(HttpServletRequest request, HttpServletResponse response) {
        
        Map<String, Object> model = new HashMap<>();
        String viewName;
        
        //SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        
        session.beginTransaction();
        Query query = session.createQuery("FROM Cliente");
        List<Cliente> listaClientes = query.list();
        session.getTransaction().commit();
        
        //model.put("mensaje", "ok");
        model.put("listaClientes", listaClientes);
        viewName = "listaClientes";

        return new ModelAndView(viewName, model);
    }
    
}
