package classiModels.BDD;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.exceptions.DataTruncationException;

import classiModels.BDD.DAO.UserConnectDAOImpl;

public class DAOFactory {
    private static final String FICHIER_PROPERTIES       = "classiModels/BDD/properties.props";
    private static final String PROPERTY_URL             = "jdbc.url";
    private static final String PROPERTY_DRIVER          = "jdbc.driver.class";
    private static final String PROPERTY_NOM_UTILISATEUR = "jdbc.login";
    private static final String PROPERTY_MOT_DE_PASSE    = "jdbc.passwd";

    private String              url;
    private String              username;
    private String              password;

    DAOFactory( String url, String username, String password ) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public DAOFactory() {

    }

    /*
     * Méthode chargée de récupérer les informations de connexion à la base de
     * données, charger le driver JDBC et retourner une instance de la Factory
     */
    public static DAOFactory getInstance() {
        Properties properties = new Properties();
        String url;
        String driver;
        String nomUtilisateur;
        String motDePasse;

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream fichierProperties = classLoader.getResourceAsStream( FICHIER_PROPERTIES );

        if ( fichierProperties == null ) {
            throw new DataTruncationException( "Le fichier properties " + FICHIER_PROPERTIES + " est introuvable." );
        }

        try {
            System.out.println( "je rentre bien dans le daofactory pour le props" );
            properties.load( fichierProperties );
            url = properties.getProperty( PROPERTY_URL );
            driver = properties.getProperty( PROPERTY_DRIVER );
            nomUtilisateur = properties.getProperty( PROPERTY_NOM_UTILISATEUR );
            motDePasse = properties.getProperty( PROPERTY_MOT_DE_PASSE );
        } catch ( IOException e ) {
            throw new DataTruncationException( "Impossible de charger le fichier properties " + FICHIER_PROPERTIES,
                    e );
        }

        try {
            Class.forName( driver );
        } catch ( ClassNotFoundException e ) {
            throw new DataTruncationException( "Le driver est introuvable dans le classpath.", e );
        }

        DAOFactory instance = new DAOFactory( url, nomUtilisateur, motDePasse );
        return instance;
    }

    /* Méthode chargée de fournir une connexion à la base de données */
    /* package */ public Connection getConnection() throws SQLException {
        return DriverManager.getConnection( url, username, password );
    }

    public UserConnectDAOImpl getUserConnectDAO() {
        return new UserConnectDAOImpl( this );
    }

}
