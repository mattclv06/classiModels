package classiModels.BDD.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import classiModels.BDD.DAOFactory;
import classiModels.beans.Employees;

public class EmployeesDAO extends AbstractDAO<Employees> {

    // REQUETE
    private static final String FIND_EMP_BY_ID = "SELECT * FROM Employees WHERE employeeNumber = ?";

    // CONSTRUCTEUR
    public EmployeesDAO( DAOFactory daoFactory ) {
        super( daoFactory );
    }

    public Employees find( int id ) {
        Employees emp = null;
        Connection connexion = null;
        PreparedStatement state = null;
        ResultSet result = null;
        try {
            connexion = daofactory.getConnection();
            state = initialisationRequetePreparee( connexion, FIND_EMP_BY_ID, false, id );
            result = state.executeQuery();

            if ( result.first() )
                emp = map( result );

            if ( emp != null ) {
                // APPEL AU DAO LiensImagesDAO pour prendre le liens du profile
                emp.setLiensImage(
                        daofactory.getLiensImagesDAO().findLiensEmployee( emp.getEmployeeNumber(),
                                connexion ) );

                if ( emp.getLiensImage() != null )
                    // Appel du DAO ImageDAO pour recupérer le nom de la photo
                    emp.setImg(
                            daofactory.getImagesDAO().findImage( emp.getLiensImage().getImageId(),
                                    connexion ) );

                emp.setOffice( daofactory.getOfficesDAO().findOffice( emp.getOfficeCode(),
                        connexion ) );

            }
        } catch ( SQLException e ) {
            e.printStackTrace();
        } finally {
            fermeturesSilencieuses( result, state, connexion );
        }
        return emp;
    }

    // METHODE DE CREATION / RECUPERATION D'OBJET EMPLOYEES
    @Override
    public Employees map( ResultSet result ) throws SQLException {
        Employees employee = new Employees();
        employee.setEmployeeNumber( result.getInt( 1 ) );
        employee.setLastName( result.getString( 2 ) );
        employee.setFirstName( result.getString( 3 ) );
        employee.setExtension( result.getString( 4 ) );
        employee.setEmail( result.getString( 5 ) );
        employee.setOfficeCode( result.getString( 6 ) );
        employee.setReportsTo( result.getInt( 7 ) );
        employee.setJobTitle( result.getString( 8 ) );
        return employee;
    }

}
