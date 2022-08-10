package com.example.WebService;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class WebServiceApplication{
	
	
static String jdbcURL = "jdbc:h2:~/WebService";
static String username = "Naili";
static String password = "nami1980";

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(WebServiceApplication.class, args);

	Connection connection = DriverManager.getConnection(jdbcURL, username, password);
    	System.out.println("Connected to H2 embedded database.");

    connection.close();
		}

	public static String getJdbcURL() {
		return jdbcURL;
	}

	public static void setJdbcURL(String jdbcURL) {
		WebServiceApplication.jdbcURL = jdbcURL;
	}

	public static String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		WebServiceApplication.username = username;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		WebServiceApplication.password = password;
	}

	}