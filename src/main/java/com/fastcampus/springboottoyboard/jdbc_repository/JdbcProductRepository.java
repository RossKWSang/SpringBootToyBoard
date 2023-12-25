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
        return loadProducts("SELECT p.name, c.member_id, ms.level, s.nationality "
                + "FROM data_test.product p "
                + "LEFT JOIN data_test.cart c ON p.id = c.product_id "
                + "LEFT JOIN data_test.member m ON c.product_id = m.id "
                + "LEFT JOIN data_test.membership ms ON m.id = ms.member_id "
                + "LEFT JOIN data_test.ship s ON ms.ship_id = s.id "
                + "ORDER BY ms.level, p.name"
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
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
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
