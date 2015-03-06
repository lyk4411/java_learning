package DAO;

public abstract class DAOFactory {

    public abstract TaskDAO getTaskDAO();

    public static DAOFactory getDAOFactory(){
        return new OracleDAOFactory();
    }

    public static void destroy(){
        OracleDAOFactory.closeConnection();
    }
}