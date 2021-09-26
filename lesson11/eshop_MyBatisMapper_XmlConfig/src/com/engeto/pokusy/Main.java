package com.engeto.pokusy;

import com.mysql.cj.xdevapi.InsertStatement;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("ahoj");
        Reader reader = Resources.getResourceAsReader("MyBatisConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        try (SqlSession session = sqlSessionFactory.openSession()) {
            GoodsMethods goodsMethods = session.getMapper(GoodsMethods.class);
            Item item = goodsMethods.loadItemById(2);
            System.out.println(item.getName());
            List<Item> list;
           //  list = session.selectList("GoodsMethods.loadAllAvailableItems");
           // list = session.selectList("GoodsMethods.loadAllAvailableItems");




        }
    }
}
