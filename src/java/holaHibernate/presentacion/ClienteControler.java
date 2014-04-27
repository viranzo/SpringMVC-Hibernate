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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Vicente
 */
@Controller
public class ClienteControler {
    
    @Autowired
    SessionFactory sessionFactory;
    
    
    @RequestMapping({"/Cliente/Nuevo"})
    public ModelAndView nuevo() {
        
        Map<String, Object> model = new HashMap<>();
        String viewName;
        
        model.put("urlAction", "Guardar");
        //model.put("cliente", cliente);
        viewName = "frmCliente";

        return new ModelAndView(viewName, model);
    }
    
    //@RequestMapping({"/ClienteEditar/{dni}"})
    //public ModelAndView Editar( @PathVariable( "dni" ) int dni) {
    
    @RequestMapping({"/Cliente/Editar"})
    public ModelAndView editar( @RequestParam("dni") int dni) {
        
        Map<String, Object> model = new HashMap<>();
        String viewName;

        Session session=sessionFactory.openSession();
        session.beginTransaction();
        Cliente cliente=(Cliente)session.get(Cliente.class,dni);
        session.getTransaction().commit();
        
        model.put("urlAction", "Guardar.html");
        model.put("cliente", cliente);
        viewName = "frmCliente";

        return new ModelAndView(viewName, model);
    }
    
    @RequestMapping({"/Cliente/Guardar"})
    public ModelAndView guardar(HttpServletRequest request, 
                                HttpServletResponse response) {
        
        Map<String, Object> model = new HashMap<>();
        String viewName;
        
        int dni = Integer.parseInt(request.getParameter("dni"));
        
        Session session=sessionFactory.openSession();
        
        session.beginTransaction();
        Cliente cliente=(Cliente)session.get(Cliente.class,dni);
        cliente.setNombre(request.getParameter("nombre"));
        cliente.setApe1(request.getParameter("ape1"));
        cliente.setApe2(request.getParameter("ape2"));
        cliente.setNick(request.getParameter("nick"));
        
        try {
            session.update(cliente);
            session.getTransaction().commit();
        
            model.put("mensaje", "Ok");
            viewName = "redirect:/index.html";
        } catch (Exception e)
        {
            session.getTransaction().rollback();
            model.put("mensaje", "Error al guardar el cliente");
            model.put("cliente", cliente);
            viewName = "frmCliente";
        }
        return new ModelAndView(viewName, model);
    }
}
