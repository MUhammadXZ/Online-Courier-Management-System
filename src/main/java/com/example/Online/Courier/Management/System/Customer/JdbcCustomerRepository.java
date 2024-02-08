package com.example.Online.Courier.Management.System.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcCustomerRepository implements CustomerRepository {

    private static final String URL = "jdbc:mysql://localhost:3306/courier_management";
    private static final String USERNAME = "springstudent";
    private static final String PASSWORD = "springstudent";

    private static final String SELECT_BY_ID = "SELECT * FROM customers WHERE id = ?";
    private static final String SELECT_ALL = "SELECT * FROM customers";
    private static final String INSERT = "INSERT INTO customers (name, email) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE customers SET name = ?, email = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM customers WHERE id = ?";

    @Override
    public Customer findById(Long id) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return extractCustomer(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                customers.add(extractCustomer(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public Customer save(Customer customer) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getEmail());
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    customer.setId(generatedKeys.getLong(1));
                    return customer;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(DELETE)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Customer extractCustomer(ResultSet resultSet) throws SQLException {
        Customer customer = new Customer();
        customer.setId(resultSet.getLong("id"));
        customer.setName(resultSet.getString("name"));
        customer.setEmail(resultSet.getString("email"));
        return customer;
    }
}

