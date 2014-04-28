/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package holaHibernate.presentacion;

import holaHibernate.entidades.Cliente;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
        
        model.put("urlAction", "Guardar.html");
        //model.put("cliente", cliente);
        viewName = "frmCliente";

        return new ModelAndView(viewName, model);
    }
    
    //@RequestMapping({"/ClienteEditar/{dni}"})
    //public ModelAndView Editar( @PathVariable( "dni" ) int dni) {
    
    @RequestMapping({"/Cliente/Editar"})
    public ModelAndView editar( @RequestParam("id") int dni) {
        
        Map<String, Object> model = new HashMap<>();
        String viewName;

        Session session=sessionFactory.openSession();
        session.beginTransaction();
        Cliente cliente=(Cliente)session.get(Cliente.class,dni);
        session.getTransaction().commit();
        
        model.put("urlAction", "Guardar.html?id="+dni);
        model.put("cliente", cliente);
        viewName = "frmCliente";

        return new ModelAndView(viewName, model);
    }
    
    @RequestMapping({"/Cliente/Guardar"})
    public ModelAndView guardar(HttpServletRequest request, 
                                HttpServletResponse response) {
        
        Map<String, Object> model = new HashMap<>();
        String viewName;
        Cliente cliente;
        String strId=request.getParameter("id");
        Session session=sessionFactory.openSession();
        
        session.beginTransaction();
        
        if(strId!=null) { // si es una modificacion lo leemos primero
            int id = Integer.parseInt(request.getParameter("id"));
            cliente=(Cliente)session.get(Cliente.class,id);
        } else { // si es nuevo creamos un cliente
            cliente = new Cliente();
        }
        // actualizamos los datos del formulario en el Cliente
        cliente.setDni(Integer.parseInt(request.getParameter("DNI")));
        cliente.setNombre(request.getParameter("Nombre"));
        cliente.setApe1(request.getParameter("Ape1"));
        cliente.setApe2(request.getParameter("Ape2"));
        cliente.setNick(request.getParameter("Nick"));
        cliente.setPasswd(request.getParameter("Passwd"));
        
        try {
            session.saveOrUpdate(cliente);
            session.getTransaction().commit();
        
            model.put("mensaje", "Ok");
            viewName = "redirect:/index.html";
        } catch (Exception e)
        {
            session.getTransaction().rollback();
            model.put("mensaje", "Error al guardar el cliente"+e.getMessage());
            model.put("cliente", cliente);
            viewName = "frmCliente";
        }
        return new ModelAndView(viewName, model);
    }
}
