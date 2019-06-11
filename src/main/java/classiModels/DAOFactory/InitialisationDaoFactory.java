package classiModels.DAOFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class InitialisationDaoFactory implements ServletContextListener {

    private static final String ATT_DAO_FACTORY = "daofactory";

    private DAOFactory          daofactory;

    @Override
    public void contextInitialized( ServletContextEvent sce ) {

        /* Récupération du ServletContext lors du chargement de l'application */
        ServletContext servletContext = sce.getServletContext();
        /* Instanciation de la daoFactory */
        this.daofactory = DAOFactory.getInstance();
        /*
         * Enregistrement dans un attribut ayant pour portée toute l'application
         */
        servletContext.setAttribute( ATT_DAO_FACTORY, this.daofactory );
    }

    @Override
    public void contextDestroyed( ServletContextEvent sce ) {
    }

}
