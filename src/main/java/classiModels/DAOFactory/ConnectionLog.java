package classiModels.DAOFactory;

import javax.servlet.http.HttpServletRequest;

import classiModels.LoginConnect.LoginConnect;
import classiModels.LoginConnectDAO.LoginConnectDAO;
import classiModels.LoginConnectDTO.LoginConnectDTO;

public class ConnectionLog {
    String          login;
    String          password;
    LoginConnectDAO LoginDAO;
    LoginConnect    Login = new LoginConnect();
    int             resultat;

    public ConnectionLog( LoginConnectDAO LoginDao ) {
        this.LoginDAO = LoginDao;
    }

    public ConnectionLog( String login, String password, LoginConnect Login ) {
        super();
        this.login = login;
        this.password = password;
        this.Login = Login;
    }

    public LoginConnect Connection( HttpServletRequest req ) {
        login = req.getParameter( "txtLogin" );
        password = req.getParameter( "txtPassword" );

        Login.setLogin( login );
        Login.setPassword( password );

        LoginConnectDTO LoginDTO = new LoginConnectDTO( Login );
        resultat = LoginDAO.checklog( LoginDTO );

        return Login;
    }

    public int getResultat() {
        return resultat;
    }

    public void setResultat( int resultat ) {
        this.resultat = resultat;
    }

}
