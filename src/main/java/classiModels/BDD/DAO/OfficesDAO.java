package classiModels.BDD.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import classiModels.BDD.DAOFactory;
import classiModels.beans.Offices;

public class OfficesDAO extends AbstractDAO<Offices> {

    private static final String FIND_OFFICE = "SELECT * FROM Offices WHERE officeCode = ? ";

    // CONSTRUCTEUR
    public OfficesDAO( DAOFactory daoFactory ) {
        super( daoFactory );
    }

    public Offices findOffice( String officeCode, Connection connexion ) {
        Offices office = null;
        PreparedStatement state = null;
        ResultSet result = null;

        try {
            state = initialisationRequetePreparee( connexion, FIND_OFFICE, false, officeCode );
            result = state.executeQuery();

            if ( result.first() )
                office = map( result );
        } catch ( SQLException e ) {
            e.printStackTrace();
        } finally {
            fermeturesSilencieuses( result, state );
        }
        return office;
    }

    // METHODE DE CREATION / RECUPERATION DE L'OBJET OFFICES
    @Override
    public Offices map( ResultSet result ) throws SQLException {
        Offices office = new Offices();
        office.setOfficeCode( result.getString( 1 ) );
        office.setCity( result.getString( 2 ) );
        office.setPhone( result.getString( 3 ) );
        office.setAddressLine1( result.getString( 4 ) );
        office.setAddressLine2( result.getString( 5 ) );
        office.setState( result.getString( 6 ) );
        office.setCountry( result.getString( 7 ) );
        office.setPostalCode( result.getString( 8 ) );
        office.setTerritory( result.getString( 9 ) );
        return office;
    }

}
