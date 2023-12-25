package com.fastcampus.springboottoyboard.jdbc_repository;

import com.fastcampus.springboottoyboard.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

@Repository
public class JdbcProductRepository {

    @Autowired
    DataSource ds;

    public List<Product> getAll() throws SQLException {
        return loadProducts("SELECT *"
                + "FROM PRODUCT p "
                + "LEFT JOIN CART c ON p.ID = c.PRODUCT_ID "
                + "LEFT JOIN MEMBER m ON c.PRODUCT_ID = m.ID "
                + "LEFT JOIN MEMBERSHIP ms ON m.ID = ms.MEMBER_ID "
                + "LEFT JOIN SHIP s ON ms.SHIP_ID = s.ID "
                + "ORDER BY ms.LEVEL, p.name");
    }

    List<Product> loadProducts(String sql) throws SQLException {
        try (
                Connection con = ds.getConnection();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql)
        ) {
            List<Product> l = new LinkedList<>();
            rs.setFetchSize(10000);
            while (rs.next()) {
                Product p = new Product(rs.getString(1), rs.getString(2));
                Cart c = new Cart(rs.getInt(4), rs.getString(5));
                c.getFilms().add(a);
                a.getCategories().add(new Category(rs.getInt(6), rs.getString(7)));
                l.add(c);
            }
            return l;
        }
    }

}
