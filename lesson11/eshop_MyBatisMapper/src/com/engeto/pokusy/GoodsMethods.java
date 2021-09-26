package com.engeto.pokusy;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public interface GoodsMethods {
    /**
     * This method loads an item with given id
     *
     * @param id - id of the item which we want to load
     * @return
     */
    @Select("SELECT id, partNo, serialNo, name, description," +
            " numberInStock,price FROM ITEM WHERE id = #{id}")
    Item loadItemById(Integer id);

    /**
     * This method deletes all items that are not in stock
     */
    @Delete("DELETE FROM ITEM WHERE numberInStock = 0")
    void deleteAllOutOfStockItems();

    /**
     * This method loads all items that are in stock
     *
     * @return
     */
    @Select("SELECT id, partNo, serialNo, name, description," +
            " numberInStock,price FROM ITEM WHERE numberInStock > 0")
    List<Item> loadAllAvailableItems();

    /**
     * This method saves the given item
     *
     * @param item - item to be saved
     */
    @Insert("INSERT into ITEM(name, description, numberInStock, price, partNo, serialNo) VALUES(#{name}, #{description}, #{numberInStock}, #{price}, #{partNo}, #{serialNo})")
    void saveItem(Item item);

    /**
     * This method updates a price of an item
     *
     * @param id       - id of an item which price is to be updated
     * @param newPrice - new price
     */
    @Update("UPDATE ITEM SET price=#{param2} WHERE id = #{param1}")
    void updatePrice(Integer id, BigDecimal newPrice);


}
