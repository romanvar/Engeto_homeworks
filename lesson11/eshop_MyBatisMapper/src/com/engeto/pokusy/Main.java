package com.engeto.pokusy;

import com.mysql.cj.xdevapi.InsertStatement;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        Reader reader = Resources.getResourceAsReader("MyBatisConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        sqlSessionFactory.getConfiguration().addMapper(GoodsMethods.class);


        try (SqlSession session = sqlSessionFactory.openSession()) {
            GoodsMethods goodsMethods = session.getMapper(GoodsMethods.class);


            Item item = goodsMethods.loadItemById(2);
            System.out.println("ID is: " + item.getId() + " Name: " + item.getName() + " Number in Stock: " + item.getNumberInStock() + " Price is: " + item.getPrice());
            goodsMethods.deleteAllOutOfStockItems();


            List<Item> itemList = goodsMethods.loadAllAvailableItems();
            for (Item i : itemList) {
                System.out.println("Name: " + i.getName() + " Number in Stock: " + i.getNumberInStock() + " Price is: " + i.getPrice());
            }

            Item insertItem = new Item(0, "935", "AB12769", "Kabat", "Prsiplast na jedno pouziti", 202, BigDecimal.valueOf(120.99));
            goodsMethods.saveItem(insertItem);

            goodsMethods.updatePrice(1, BigDecimal.valueOf(32.99));

            session.commit();


        }
    }
}
