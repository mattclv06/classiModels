package classiModels.LoginConnectDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import classiModels.DAOFactory.AbstractDAO;
import classiModels.DAOFactory.DAOFactory;
import classiModels.LoginConnectDTO.LoginConnectDTO;

public class LoginConnectDAO extends AbstractDAO<LoginConnectDTO> {

    public LoginConnectDAO( DAOFactory daofactory ) {
        super( daofactory );
        // TODO Auto-generated constructor stub
    }

    int    idLoginConnect = 0;
    String Login          = "";
    String Password       = "";

    public int checklog( LoginConnectDTO obj ) {

        int checklog = 0;
        String Login = obj.getLogin();
        String Password = obj.getPassword();
        String sql = "SELECT count(*) FROM logins where login = '" + Login.toString()
                + "' and password = '"
                + Password.toString() + "'";

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