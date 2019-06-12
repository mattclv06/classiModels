package classiModels.BDD.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import classiModels.BDD.DAOFactory;
import classiModels.beans.UserConnect;

public class UserConnectDAOImpl extends AbstractDAO<UserConnect> implements UserConnectDAO {

    public UserConnectDAOImpl( DAOFactory daofactory ) {
        super( daofactory );
        System.out.println( "je me connect" );
        // TODO Auto-generated constructor stub
    }

    private static final String SQL_Count = "SELECT count(*) from logins where login = ? and password = ? ;";

    /*
     * Méthode générique utilisée pour retourner un utilisateur depuis la base
     * de données, correspondant à la requête SQL donnée prenant en paramètres
     * les objets passés en argument.
     */
    @Override
    public UserConnect trouver( String login, String password ) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        UserConnect userconnect = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daofactory.getConnection();
            /*
             * Préparation de la requête avec les objets passés en arguments
             * (ici, uniquement une adresse email) et exécution.
             */
            preparedStatement = initialisationRequetePreparee( connexion, SQL_Count, false, login, password );
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données retournée dans le ResultSet */
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
     * Simple méthode utilitaire permettant de faire la correspondance (le
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

    public int checklog( String login, String password ) {

        int checklog = 0;
        String sql = "SELECT count(*) FROM logins where login = '" + login + "' and password = '"
                + password + "'";

        try {
            // Crï¿½Ã©tion de la requï¿½te
            PreparedStatement statement = daofactory.getConnection().prepareStatement( sql );
            ResultSet resultat = statement.executeQuery( sql );
            resultat.next();

            checklog = resultat.getInt( 1 );

            resultat.close();

            statement.close();
            daofactory.getConnection().close();
        } catch ( SQLException exe ) {
            System.out.println( exe.getMessage() );
        }

        return checklog;

    }

}
