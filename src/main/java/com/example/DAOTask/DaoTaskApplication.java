package com.example.DAOTask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class DaoTaskApplication {

	public DaoTaskApplication()  {
	}

	public static void main(String[] args) {
		SpringApplication.run(DaoTaskApplication.class, args);
		}

}
