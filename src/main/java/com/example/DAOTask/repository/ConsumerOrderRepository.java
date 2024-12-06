package com.example.DAOTask.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ConsumerOrderRepository {

    private static Connection connection;
    private static NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private static JdbcOperations jdbcTemplate;
    private static String myScript;
    private static DataSource dataSource;

    @Autowired
    public ConsumerOrderRepository(JdbcTemplate jdbcTemplate, DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public void connectDB() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String passwd = "postgres";
        connection = DriverManager.getConnection(url, user, passwd);
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getProductName(String name) {
        myScript = read("mysql.sql");
        List<String> strLst = this.jdbcTemplate.query(myScript, (rs, rowNum) ->
                rs.getString(1), name);
        return strLst.toString();
    }
}
