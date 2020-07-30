package Daos;

import Negocio.Stock;

import java.sql.SQLException;

public interface StockDao {

    public void createStock(Stock stock) throws SQLException;
    public void deleteStock(Stock stock) throws SQLException;
    public void updateStock(Stock stock) throws SQLException;
    public Stock getStock(int id_stock) throws SQLException;

}
