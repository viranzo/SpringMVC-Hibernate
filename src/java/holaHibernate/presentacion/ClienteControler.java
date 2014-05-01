/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package holaHibernate.presentacion;

import holaHibernate.DAO.ClienteDAO;
import holaHibernate.entidades.Cliente;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    ClienteDAO clienteDAO;
  
    @RequestMapping({"/Cliente/Nuevo"})
    public ModelAndView nuevo() {
        
        Map<String, Object> model = new HashMap<>();
        String viewName;
        
        model.put("urlAction", "Guardar.html");
        viewName = "frmCliente";

        return new ModelAndView(viewName, model);
    }
    
    //@RequestMapping({"/ClienteEditar/{dni}"})
    //public ModelAndView Editar( @PathVariable( "dni" ) int dni) {
    
    @RequestMapping({"/Cliente/Editar"})
    public ModelAndView editar( @RequestParam("id") int dni) {
        
        Map<String, Object> model = new HashMap<>();
        String viewName;
      
        Cliente cliente;
        try {
            cliente = clienteDAO.read(dni);
            model.put("urlAction", "Guardar.html?id="+dni);
            model.put("cliente", cliente);
            viewName = "frmCliente";
        } catch (Exception ex) {
            model.put("mensaje", "Eror al leer el cliente");
            viewName = "redirect:/index.html";
        }
        return new ModelAndView(viewName, model);
    }
    
    @RequestMapping({"/Cliente/Guardar"})
    public ModelAndView guardar(@RequestParam("id") String strId,
                                @RequestParam("DNI") int dni,
                                @RequestParam("Nombre") String nombre,
                                @RequestParam("Ape1") String ape1,
                                @RequestParam("Ape2") String ape2,
                                @RequestParam("Nick") String nick,
                                @RequestParam("Passwd") String passwd, 
                                HttpServletRequest request, 
                                HttpServletResponse response    
                                ) throws Exception  {
        
        Map<String, Object> model = new HashMap<>();
        String viewName;
        Cliente cliente=null;
               
        if(strId!=null) { // si es una modificacion 
            int id = Integer.parseInt(strId);
            try { // leemos los datos 
                cliente=(Cliente)clienteDAO.read(id);
            } catch (Exception ex) {
                model.put("mensaje", "Error de lectura del cliente");
                viewName = "redirect:/index.html";
                return new ModelAndView(viewName, model);
            }
        } else {
            // si es nuevo creamos un cliente
            cliente = clienteDAO.create();
        }
        // actualizamos con los datos del formulario en el Cliente
        cliente.setDni(dni);
        cliente.setNombre(nombre);
        cliente.setApe1(ape1);
        cliente.setApe2(ape2);
        cliente.setNick(nick);
        cliente.setPasswd(passwd);
        
        try {
            clienteDAO.update(cliente);
            model.put("mensaje", "Ok");
            viewName = "redirect:/index.html";
        } catch (Exception e)
        {
            model.put("mensaje", "Error al guardar el cliente"+e.getMessage());
            model.put("cliente", cliente);
            viewName = "frmCliente";
        }
        return new ModelAndView(viewName, model);
    }
}
