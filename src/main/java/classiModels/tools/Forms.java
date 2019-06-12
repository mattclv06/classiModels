package classiModels.tools;

import javax.servlet.http.HttpServletRequest;

import classiModels.BDD.DAO.UserConnectDAOImpl;
import classiModels.beans.UserConnect;

public class Forms {

    String             login;
    String             password;
    UserConnectDAOImpl userDAO;
    UserConnect        user = new UserConnect();
    int                resultat;

    public Forms( UserConnectDAOImpl userDao ) {
        this.userDAO = userDao;
    }

    public Forms() {

    }

    public Forms( String login, String password, UserConnect user ) {
        super();
        this.login = login;
        this.password = password;
        this.user = user;
    }

    public UserConnect Connection( HttpServletRequest req ) {
        login = req.getParameter( "log" );
        password = req.getParameter( "pass" );

        user.setLogin( login );
        user.setPassword( password );

        resultat = userDAO.checklog( login, password );

        return user;
    }

    public int getResultat() {
        return resultat;
    }

    public void setResultat( int resultat ) {
        this.resultat = resultat;
    }

}
