package classiModels.BDD.DAO;

import classiModels.beans.UserConnect;

/* (2)
 * Interface qui oblige UserConnectDAO a avoir une m�thode trouver qui prend en param�tre login et password
 */
public interface UserConnectDAO {

    UserConnect trouver( String login, String password );

}
