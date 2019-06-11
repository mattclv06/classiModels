package classiModels.DAOFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.exceptions.DataTruncationException;

import classiModels.LoginConnectDAO.LoginConnectDAO;

public class DAOFactory {
    private static final String FICHIER_PROPERTIES       = "/classiMOdels/DAOFactory/properties.props";
    private static final String PROPERTY_URL             = "jdbc.url";
    private static final String PROPERTY_DRIVER          = "jdbc.driver.class";
    private static final String PROPERTY_NOM_UTILISATEUR = "jdbc.login";
    private static final String PROPERTY_MOT_DE_PASSE    = "jdbc.passwd";

    private String              url;
    private String              Loginname;
    private String              password;

    DAOFactory( String url, String Loginname, String password ) {
        this.url = url;
        this.Loginname = Loginname;
        this.password = password;
    }

    public DAOFactory() {

    }

    /*
     * M�thode charg�e de r�cup�rer les informations de connexion � la base de
     * donn�es, charger le driver JDBC et retourner une instance de la Factory
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

    /* M�thode charg�e de fournir une connexion � la base de donn�es */
    public Connection getConnection() throws SQLException {
        System.out.println( "Connexion a la base de donn�e !" );
        return DriverManager.getConnection( url, Loginname, password );
    }

    public LoginConnectDAO getLoginConnectDAO() {
        System.out.println( "entr�e getLoginDAO" );
        return new LoginConnectDAO( this );
    }

}