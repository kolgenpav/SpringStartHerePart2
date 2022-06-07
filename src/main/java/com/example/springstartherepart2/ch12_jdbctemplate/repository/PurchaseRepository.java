package com.example.springstartherepart2.ch12_jdbctemplate.repository;

import com.example.springstartherepart2.ch12_jdbctemplate.model.Purchase;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/*If you use Spring but not Spring Boot, you need to define the DataSource bean and the
JdbcTemplate bean (you can add them in the Spring context using the @Bean annotation
in the configuration class, as you learned in chapter 2).
When Spring Boot saw you added the H2 dependency in pom.xml,
it automatically configured a data source and a JdbcTemplate instance*/
@Repository
public class PurchaseRepository {

    private final JdbcTemplate jdbc;

    public PurchaseRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void storePurchase(Purchase purchase){
        String sql = "INSERT INTO purchase VALUES(DEFAULT, ?, ?)";
        jdbc.update(sql, purchase.getProduct(), purchase.getPrice());
    }

    public List<Purchase> findAllPurchases(){
        String sql="SELECT * FROM purchase";

        /*Convert from ResultSet (r) each row (i) to Purchase instance*/
        RowMapper<Purchase> purchaseRowMapper = (r, i) -> {
            Purchase rowObject = new Purchase();
            rowObject.setId(r.getInt("id"));
            rowObject.setProduct(r.getString("product"));
            rowObject.setPrice(r.getBigDecimal("price"));
            return rowObject;
        };

        return jdbc.query(sql, purchaseRowMapper);
    }
}
