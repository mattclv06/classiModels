package classiModels.DAOFactory;

import javax.servlet.http.HttpServletRequest;

import classiModels.UserConnect.UserConnect;
import classiModels.UserConnectDAO.UserConnectDAO;
import classiModels.UserConnectDTO.UserConnectDTO;

public class ConnectionLog {
    String         login;
    String         password;
    UserConnectDAO userDAO;
    UserConnect    user = new UserConnect();
    int            resultat;

    public ConnectionLog( UserConnectDAO userDao ) {
        this.userDAO = userDao;
    }

    public ConnectionLog( String login, String password, UserConnect user ) {
        super();
        this.login = login;
        this.password = password;
        this.user = user;
    }

    public UserConnect Connection( HttpServletRequest req ) {
        login = req.getParameter( "txtLogin" );
        password = req.getParameter( "txtPassword" );

        user.setUser( login );
        user.setmdp( password );

        UserConnectDTO userDTO = new UserConnectDTO( user );
        resultat = userDAO.checklog( userDTO );

        return user;
    }

    public int getResultat() {
        return resultat;
    }

    public void setResultat( int resultat ) {
        this.resultat = resultat;
    }

}
