package classiModels.UserConnectDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import classiModels.DAOFactory.AbstractDAO;
import classiModels.DAOFactory.DAOFactory;
import classiModels.UserConnectDTO.UserConnectDTO;

public class UserConnectDAO extends AbstractDAO<UserConnectDTO> {

    public UserConnectDAO( DAOFactory daofactory ) {
        super( daofactory );
        // TODO Auto-generated constructor stub
    }

    int    idUserConnect = 0;
    String User          = "";
    String mdp           = "";

    public int checklog( UserConnectDTO obj ) {

        int checklog = 0;
        String user = obj.getUser();
        String mdp = obj.getmdp();
        String sql = "SELECT count(*) FROM userconnect where user = '" + user.toString()
                + "' and mdp = '"
                + mdp.toString() + "'";

        try {
            // Cr�étion de la requ�te
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