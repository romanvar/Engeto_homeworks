package com.engeto.pokusy;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SqlQueries implements  GoodsMethods{

    private static final String LOADITEMBYID = "SELECT * FROM my_eshop.ITEM where ID = ?;";
    Connection dbconnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_eshop", "my_eshop_user", "Ferda123.");

    public SqlQueries() throws SQLException {
    }

    /**
     * This method loads an item with given id
     *
     * @param id - id of the item which we want to load
     * @return
     */
    @Override
    public Item loadItemById(Integer id) throws SQLException{
        PreparedStatement preparedStatement = dbconnection.prepareStatement(LOADITEMBYID);
        preparedStatement.setInt(1, id);
        return null;
    }

    /**
     * This method deletes all items that are not in stock
     */
    @Override
    public void deleteAllOutOfStockItems() {

    }

    /**
     * This method loads all items that are in stock
     *
     * @return
     */
    @Override
    public List<Item> loadAllAvailableItems() {
        return null;
    }

    /**
     * This method saves the given item
     *
     * @param item - item to be saved
     */
    @Override
    public void saveItem(Item item) {

    }

    /**
     * This method updates a price of an item
     *
     * @param id       - id of an item which price is to be updated
     * @param newPrice - new price
     */
    @Override
    public void updatePrice(Integer id, BigDecimal newPrice) {

    }
}
