/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package holaHibernate.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebListener;

/**
 * 
 * Esta clase se ejecutará al inicio y final de la aplicación y en cada petición 
 * web cuya URL tenga el patrón ”*.html”.Para conseguirlo se han añadido 
 * anotaciones de Java EE 6 Web @WebListener y @WebFilter
 * 
 * contextInitialized
 *    Al inicio de la aplicación web se inicializa Hibernate con la llamada a 
 *    HibernateUtil.buildSessionFactory()
 * 
 * contextDestroyed
 *    Al finalizar la aplicación web se cierra Hibernate con la llamada a 
 *    HibernateUtil.closeSessionFactory()
 * 
 * doFilter try
 *    Al inicio de la petición web se crea la sesión de Hibernate con la llamada
 *    a HibernateUtil.openSessionAndAttachToThread()
 * doFilter finally
 *    Al finalizar la petición web se destruye la sesión de hibernate con la 
 *    llamada a HibernateUtil.closeSessionAndDeattachFromThread()
 */
@WebListener()
@WebFilter(urlPatterns = {"*.html"})
public class HibernateContextListenerAndFilter 
          implements Filter, ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        HibernateUtil.buildSessionFactory();
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, 
            ServletResponse servletResponse, FilterChain filterChain) 
            throws IOException, ServletException {
        try {
            HibernateUtil.openSessionAndBindToThread();
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            HibernateUtil.closeSessionAndUnbindFromThread();
        }
    }

    @Override
    public void destroy() {
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        HibernateUtil.closeSessionFactory();
    }
}
