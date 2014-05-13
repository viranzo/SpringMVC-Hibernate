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
@RequestMapping({"/Cliente"})
public class ClienteControler {
    
    @Autowired
    ClienteDAO clienteDAO;
  
    @RequestMapping({"/Nuevo"})
    public ModelAndView nuevo() {
        
        Map<String, Object> model = new HashMap<>();
        String viewName;
        
        model.put("urlAction", "Guardar.html");
        viewName = "frmCliente";

        return new ModelAndView(viewName, model);
    }
    
    //@RequestMapping({"/ClienteEditar/{dni}"})
    //public ModelAndView Editar( @PathVariable( "dni" ) int dni) {
    
    @RequestMapping({"/Editar"})
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
            model.put("mensaje", "Error al leer el cliente");
            viewName = "error";
        }
        return new ModelAndView(viewName, model);
    }
    
    @RequestMapping({"/Guardar"})
    public ModelAndView guardar(HttpServletRequest request, 
                                HttpServletResponse response    
                                ) throws Exception  {
        
        Map<String, Object> model = new HashMap<>();
        String viewName;
        Cliente cliente;
        
        String strId=request.getParameter("id");
        if(strId!=null) { // si es una modificacion 
            int id = Integer.parseInt(strId);
            try { // leemos los datos 
                cliente=(Cliente)clienteDAO.read(id);
            } catch (Exception ex) {
                model.put("mensaje", "Error de lectura del cliente");
                viewName = "error";
                return new ModelAndView(viewName, model);
            }
        } else {
            // si es nuevo creamos un cliente
            cliente = clienteDAO.create();
        }
       
               
        try { // actualizamos con los datos del formulario en el Cliente
            cliente.setDni(Integer.parseInt(request.getParameter("DNI")));
            cliente.setNombre(request.getParameter("Nombre"));
            cliente.setApe1(request.getParameter("Ape1"));
            cliente.setApe2(request.getParameter("Ape2"));
            cliente.setNick(request.getParameter("Nick"));
            cliente.setPasswd(request.getParameter("Passwd"));
            
            clienteDAO.update(cliente);
            viewName = "redirect:/index.html";
        } catch (Exception e)
        {
            model.put("mensaje", "Error al guardar el cliente:<br/>"+e.getMessage());
            model.put("cliente", cliente);
            viewName = "frmCliente";
        }
        return new ModelAndView(viewName, model);
    }
    @RequestMapping({"/Eliminar"})
    public ModelAndView eliminar( @RequestParam("id") int dni) {
        
        Map<String, Object> model = new HashMap<>();
        String viewName;
      
        Cliente cliente;
        try {
            clienteDAO.delete(dni);
            viewName = "redirect:/index.html";
        } catch (Exception ex) {
            model.put("mensaje", "Error al borrar el cliente:<br/>" + ex.getMessage());
            viewName = "error";
        }
        return new ModelAndView(viewName, model);
    }
}
