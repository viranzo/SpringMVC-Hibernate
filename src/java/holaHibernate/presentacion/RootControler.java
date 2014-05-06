package holaHibernate.presentacion;

import holaHibernate.DAO.ClienteDAO;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    ClienteDAO clienteDAO;
    
    @RequestMapping({"/index.html"})
    public ModelAndView listaClientes(HttpServletRequest request, 
                                      HttpServletResponse response) {
        
        Map<String, Object> model = new HashMap<>();
        String viewName;
        
        try {
            model.put("listaClientes", clienteDAO.findAll());
            model.put("mensaje", "ok");
        } catch (Exception ex) {
            model.put("mensaje", "Error obteniendo la lista de clientes");
        }
        viewName = "listaClientes";

        return new ModelAndView(viewName, model);
    }
    
}
