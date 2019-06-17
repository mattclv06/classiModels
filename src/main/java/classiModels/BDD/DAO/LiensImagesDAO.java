package classiModels.BDD.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import classiModels.BDD.DAOFactory;
import classiModels.beans.LiensImages;

public class LiensImagesDAO extends AbstractDAO<LiensImages> {

    // REQUETE
    // Liens employee
    private static final String FIND_EMPLOYEE_LINK = "SELECT * FROM LiensImages WHERE employeeNumber = ?";
    // Lien customer
    private static final String FIND_CUSTOM_LINK = "SELECT * FROM LiensImages WHERE customerNumber = ?";
    // Lien products
    private static final String FIND_PRODUCT_LINK = "SELECT * FROM LiensImages WHERE productCode = ?";

    // CONSTRUCTEUR
    public LiensImagesDAO( DAOFactory daoFactory ) {
        super( daoFactory );
    }

    // METHODE DE RECUPERATION PAR ID ET AVEC CONNEXION EXISTANTE
    public LiensImages findLiensCustom( int id, Connection connexion ) {
        LiensImages lienImage = null;
        PreparedStatement state = null;
        ResultSet result = null;
        try {
            state = initialisationRequetePreparee( connexion, FIND_CUSTOM_LINK, false, id );
            result = state.executeQuery();

            if ( result.first() )
                lienImage = map( result );

        } catch ( SQLException e ) {
            e.printStackTrace();
        } finally {
            fermeturesSilencieuses( result, state );
        }
        return lienImage;
    }

    // METHODE DE RECUPERATION PAR ID ET AVEC CONNEXION EXISTANTE
    public LiensImages findLiensEmployee( int id, Connection connexion ) {
        LiensImages lienImage = null;
        PreparedStatement state = null;
        ResultSet result = null;
        try {
            state = initialisationRequetePreparee( connexion, FIND_EMPLOYEE_LINK, false, id );
            result = state.executeQuery();

            if ( result.first() )
                lienImage = map( result );

        } catch ( SQLException e ) {
            e.printStackTrace();
        } finally {
            fermeturesSilencieuses( result, state );
        }
        return lienImage;
    }

    // METHODE DE RECUPERATION PAR ID ET AVEC CONNEXION EXISTANTE
    public LiensImages findLiensProducts( String codeProduit, Connection connexion ) {
        LiensImages lienImage = null;
        PreparedStatement state = null;
        ResultSet result = null;
        try {
            state = initialisationRequetePreparee( connexion, FIND_PRODUCT_LINK, false, codeProduit );
            result = state.executeQuery();

            if ( result.first() )
                lienImage = map( result );

        } catch ( SQLException e ) {
            e.printStackTrace();
        } finally {
            fermeturesSilencieuses( result, state );
        }
        return lienImage;
    }

    // METHODE DE CREATION / RECUPERATION DE L'OBJET LIENSIMAGES
    @Override
    public LiensImages map( ResultSet result ) throws SQLException {
        LiensImages liensImages = new LiensImages();
        liensImages.setCustomerNumber( result.getInt( 1 ) );
        liensImages.setEmployeeNumber( result.getInt( 2 ) );
        liensImages.setProductCode( result.getString( 3 ) );
        liensImages.setImageId( result.getInt( 4 ) );
        return liensImages;
    }

}
