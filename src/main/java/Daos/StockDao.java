package Daos;

import Negocio.Stock;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StockDao {

    public void createStock(Stock stock) throws SQLException;
    public void deleteStock(Stock stock) throws SQLException;
    public void updateStock(Stock stock) throws SQLException;
    public ArrayList getStock(int id_planta) throws SQLException;

}
