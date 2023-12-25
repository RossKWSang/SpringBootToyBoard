package com.fastcampus.springboottoyboard.jdbc_repository;

import com.fastcampus.springboottoyboard.dto.ProductJoinResult;
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

    public List<ProductJoinResult> getAll() {
        return loadProducts("SELECT * "
                + "FROM PRODUCT p "
                + "INNER JOIN CART c ON p.ID = c.PRODUCT_ID "
                + "INNER JOIN MEMBER m ON c.PRODUCT_ID = m.ID "
                + "INNER JOIN MEMBERSHIP ms ON m.ID = ms.MEMBER_ID "
                + "INNER JOIN SHIP s ON ms.SHIP_ID = s.ID "
                + "ORDER BY ms.LEVEL, p.NAME"
        );
    }

    List<ProductJoinResult> loadProducts(String sql) {
        try (
                Connection con = ds.getConnection();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql)
        ) {
            List<ProductJoinResult> l = new LinkedList<>();
            while (rs.next()) {
                ProductJoinResult joinResult = new ProductJoinResult(
                        rs.getString(2),
                        rs.getString(3),
                        null,
                        null
                //        rs.getString(13),
                //        rs.getString(17)
                );
                l.add(joinResult);
            }
            return l;
        }
        catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to fetch data from the database", e);
        }
    }
}
