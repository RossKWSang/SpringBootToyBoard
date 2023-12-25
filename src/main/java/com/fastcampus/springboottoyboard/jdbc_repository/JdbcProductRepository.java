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

    public List<ProductJoinResult> getAll() throws SQLException {
        return loadProducts("SELECT *"
                + "FROM PRODUCT p "
                + "LEFT JOIN CART c ON p.ID = c.PRODUCT_ID "
                + "LEFT JOIN MEMBER m ON c.PRODUCT_ID = m.ID "
                + "LEFT JOIN MEMBERSHIP ms ON m.ID = ms.MEMBER_ID "
                + "LEFT JOIN SHIP s ON ms.SHIP_ID = s.ID "
                + "ORDER BY ms.LEVEL, p.name");
    }

    List<ProductJoinResult> loadProducts(String sql) throws SQLException {
        try (
                Connection con = ds.getConnection();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql)
        ) {
            List<ProductJoinResult> l = new LinkedList<>();
            rs.setFetchSize(10000);
            while (rs.next()) {
                ProductJoinResult joinResult = new ProductJoinResult(
                        rs.getString(1),
                        rs.getInt(2),
                        rs.getString(12),
                        rs.getString(16)
                );
                l.add(joinResult);
            }
            return l;
        }
    }

}
