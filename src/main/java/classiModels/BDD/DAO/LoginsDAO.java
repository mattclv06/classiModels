// package com.classicModel.models.dao.impl;
//
// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
//
// import com.classicModel.models.beans.Logins;
// import com.classicModel.models.dao.AbstractDAO;
// import com.classicModel.models.dao.DAOFactory;
//
// public class LoginsDAO extends AbstractDAO<Logins> {
//
// private static final String CHECK_LOG = "SELECT * FROM Logins WHERE login = ?
// AND password = ?";
//
// // CONSTRUCTEUR
// public LoginsDAO( DAOFactory daoFactory ) {
// super( daoFactory );
// }
//
// public Logins checkLog( String login, String pass ) {
// Logins log = null;
// Connection connexion = null;
// PreparedStatement state = null;
// ResultSet result = null;
// try {
// connexion = daoFactory.getConnection();
// state = initialisationRequetePreparee( connexion, CHECK_LOG, false, login,
// pass );
// result = state.executeQuery();
//
// if ( result.first() ) {
// log = map( result );
// }
//
// } catch ( SQLException e ) {
// e.printStackTrace();
// } finally {
// fermeturesSilencieuses( result, state, connexion );
// }
// return log;
// }
//
// // METHODE DE CREATION / RECUPERATION DE L'OBJET LOGINS
// @Override
// public Logins map( ResultSet result ) throws SQLException {
// Logins log = new Logins();
// log.setCustomerNumber( result.getInt( 1 ) );
// log.setEmployeeNumber( result.getInt( 2 ) );
// log.setLogin( result.getString( 3 ) );
// log.setPassword( result.getString( 4 ) );
// return log;
// }
//
// }
