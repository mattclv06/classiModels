package classiModels.BDD.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import classiModels.BDD.DAOFactory;
import classiModels.beans.UserConnect;

/* (5)
 * cr�ation de UserConnectDAOimpl qui �tend abstractDAO qui prend en objet un userConnect
 * et qui impl�mente L'interface UserConnectDAO avec sa m�thode 
 * commenc� par connect� l'objet � la connexion ! 
 */
public class UserConnectDAOImpl extends AbstractDAO<UserConnect> implements UserConnectDAO {
    int    checklogCustom   = 0;
    int    customNumber     = 0;

    int    checklogEmployee = 0;
    int    employee         = 0;

    String nomPhoto;

    public UserConnectDAOImpl( DAOFactory daofactory ) {
        super( daofactory );
        System.out.println( "je me connect" );
        // TODO Auto-generated constructor stub
    }

    private static final String SQL_Count = "SELECT count(*) from logins where login = ? and password = ? ;";

    /*
     * M�thode g�n�rique utilis�e pour retourner un utilisateur depuis la base
     * de donn�es, correspondant � la requ�te SQL donn�e prenant en param�tres
     * les objets pass�s en argument.
     */
    @Override
    public UserConnect trouver( String login, String password ) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        UserConnect userconnect = null;

        try {
            /* R�cup�ration d'une connexion depuis la Factory */
            connexion = daofactory.getConnection();
            /*
             * Pr�paration de la requ�te avec les objets pass�s en arguments
             * dans la DAOFactory (ici, la connexion + la requete SQL + le
             * boolean + les param ) et ex�cution.
             */
            preparedStatement = initialisationRequetePreparee( connexion, SQL_Count, false, login, password );
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de donn�es retourn�e dans le ResultSet */
            if ( resultSet.next() ) {
                userconnect = map( resultSet );
            }
        } catch ( SQLException e ) {
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }

        return userconnect;
    }

    /*
     * Simple m�thode utilitaire permettant de faire la correspondance (le
     * mapping) entre une ligne issue de la table des utilisateurs (un
     * ResultSet) et un bean Utilisateur.
     */
    private static UserConnect map( ResultSet resultSet ) throws SQLException {
        UserConnect userconnect = new UserConnect();
        userconnect.setLogin( resultSet.getString( "login" ) );
        userconnect.setPassword( resultSet.getString( "password" ) );
        // userconnect.setId( resultSet.getLong( "id" ) );
        return userconnect;
    }

    public int checklogCustom( String login, String password ) {

        String sql = "SELECT count(*),customerNumber FROM logins where login = '" + login + "' and password = '"
                + password + "' and customerNumber";

        try {
            // Cr�étion de la requ�te
            PreparedStatement statement = daofactory.getConnection().prepareStatement( sql );
            ResultSet resultat = statement.executeQuery( sql );
            resultat.next();

            checklogCustom = resultat.getInt( 1 );
            customNumber = resultat.getInt( 2 );
            resultat.close();

            statement.close();
            daofactory.getConnection().close();
        } catch ( SQLException exe ) {
            System.out.println( exe.getMessage() );
        }

        return checklogCustom;

    }

    public int checklogEmployee( String login, String password ) {

        String sql = "SELECT count(*), employeeNumber FROM logins where login = '" + login + "' and password = '"
                + password + "' and employeeNumber";

        try {
            // Cr�étion de la requ�te
            PreparedStatement statement = daofactory.getConnection().prepareStatement( sql );
            ResultSet resultat = statement.executeQuery( sql );
            resultat.next();

            checklogEmployee = resultat.getInt( 1 );
            employee = resultat.getInt( 2 );
            resultat.close();

            statement.close();
            daofactory.getConnection().close();
        } catch ( SQLException exe ) {
            System.out.println( exe.getMessage() );
        }

        return checklogEmployee;

    }

    public String getPhoto() {
        String sql = "SELECT nom FROM images inner join  liensimages on imageId = id where ";
        if ( customNumber == 0 ) {
            sql += " employeeNumber = " + employee;
        } else {
            sql += " customerNumber = " + customNumber;
        }

        try {
            // Cr�étion de la requ�te
            PreparedStatement statement = daofactory.getConnection().prepareStatement( sql );
            ResultSet resultat = statement.executeQuery( sql );
            resultat.next();

            nomPhoto = resultat.getString( 1 );

            resultat.close();

            statement.close();
            daofactory.getConnection().close();
        } catch ( SQLException exe ) {
            System.out.println( exe.getMessage() );
        }
        return nomPhoto;
    }

}
