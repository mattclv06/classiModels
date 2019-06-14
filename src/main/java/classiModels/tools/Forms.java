package classiModels.tools;

import javax.servlet.http.HttpServletRequest;

import classiModels.BDD.DAO.UserConnectDAOImpl;
import classiModels.beans.UserConnect;

public class Forms {

    String             login;
    String             password;
    UserConnectDAOImpl userDAO;
    UserConnect        user;
    int                resultat;
    String             lienImage;

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

    public UserConnect ConnectionCustom( HttpServletRequest req ) {
        login = req.getParameter( "log" );
        System.out.println( login );
        password = req.getParameter( "pass" );
        user = new UserConnect();
        user.setLogin( login );
        user.setPassword( password );

        resultat = userDAO.checklogCustom( login, password );

        return user;
    }

    public UserConnect ConnectionEmploy( HttpServletRequest req ) {
        login = req.getParameter( "log" );
        password = req.getParameter( "pass" );
        user = new UserConnect();
        user.setLogin( login );
        user.setPassword( password );

        resultat = userDAO.checklogEmployee( login, password );

        return user;
    }

    public int getResultat() {
        return resultat;
    }

    public void setResultat( int resultat ) {
        this.resultat = resultat;
    }

    public String getLienImage() {
        return lienImage;
    }

    public void setLienImage( String lienImage ) {
        this.lienImage = lienImage;
    }

}
