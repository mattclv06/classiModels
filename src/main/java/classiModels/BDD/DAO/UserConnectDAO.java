package classiModels.BDD.DAO;

import classiModels.beans.UserConnect;

/* (2)
 * Interface qui oblige UserConnectDAO a avoir une méthode trouver qui prend en paramètre login et password
 */
public interface UserConnectDAO {

    UserConnect trouver( String login, String password );

}
