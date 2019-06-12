package classiModels.BDD.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;

import classiModels.BDD.DAOFactory;

@WebListener
public class InitialisationDAOFactory {
    private static final String ATT_DAO_FACTORY = "daofactory";

    private DAOFactory          daoFactory;

    public void contextInitialized( ServletContextEvent event ) {
        /* R�cup�ration du ServletContext lors du chargement de l'application */
        System.out.println( "je rentre dans linit" );
        ServletContext servletContext = event.getServletContext();
        /* Instanciation de notre DAOFactory */
        this.daoFactory = DAOFactory.getInstance();
        /*
         * Enregistrement dans un attribut ayant pour port�e toute l'application
         */
        servletContext.setAttribute( ATT_DAO_FACTORY, this.daoFactory );
    }

    public void contextDestroyed( ServletContextEvent event ) {
        /* Rien � r�aliser lors de la fermeture de l'application... */
    }
}
