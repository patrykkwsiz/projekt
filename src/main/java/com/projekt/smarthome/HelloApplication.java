package com.projekt.smarthome;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.*;
import java.io.IOException;
import java.io.File;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("design.fxml"));

                Connection c = null;
                Statement stmt = null;

                File dbFile = new File("project.db");
                if (dbFile.exists()) {
                    System.out.println("Baza danych już istnieje");
                    Scene scene = new Scene(fxmlLoader.load(), 1000, 562.5);
                    stage.setTitle("Smart Home Project");
                    stage.setScene(scene);
                    stage.show();
                    return;
                }

                try {
                    Class.forName("org.sqlite.JDBC");
                    c = DriverManager.getConnection("jdbc:sqlite:project.db");
                    System.out.println("Utworzono bazę danych");

                    stmt = c.createStatement();

                    String sql = "CREATE TABLE LIGHTS " +
                            "(ID INT PRIMARY KEY NOT NULL," +
                            " KITCHEN_MAIN INT NOT NULL, " +
                            " KITCHEN_CUPBOARDS INT NOT NULL, " +
                            " SALOON_MAIN INT NOT NULL, " +
                            " SALOON_LAMP INT NOT NULL, " +
                            " BEDROOM1 INT NOT NULL, " +
                            " BEDROOM2 INT NOT NULL, " +
                            " GUEST_ROOM INT NOT NULL, " +
                            " CORRIDOR1 INT NOT NULL, " +
                            " CORRIDOR2 INT NOT NULL)";
                    stmt.executeUpdate(sql);

                    sql = "CREATE TABLE ROLLER_BLINDS " +
                            "(ID INT PRIMARY KEY NOT NULL, " +
                            " KITCHEN_LEFT INT NOT NULL, " +
                            " KITCHEN_RIGHT INT NOT NULL, " +
                            " SALOON_MAIN INT NOT NULL, " +
                            " SALOON_MINOR INT NOT NULL, " +
                            " BEDROOM1 INT NOT NULL, " +
                            " BEDROOM2 INT NOT NULL, " +
                            " GUEST_ROOM INT NOT NULL, " +
                            " CORRIDOR1 INT NOT NULL, " +
                            " CORRIDOR2 INT NOT NULL)";
                    stmt.executeUpdate(sql);

                    sql = "CREATE TABLE TEMPERATURE " +
                            "(ID INT PRIMARY KEY NOT NULL," +
                            " KITCHEN INT NOT NULL, " +
                            " SALOON INT NOT NULL, " +
                            " BEDROOM1 INT NOT NULL, " +
                            " BEDROOM2 INT NOT NULL, " +
                            " GUEST_ROOM INT NOT NULL, " +
                            " CORRIDOR1 INT NOT NULL, " +
                            " CORRIDOR2 INT NOT NULL)";
                    stmt.executeUpdate(sql);

                    sql = "INSERT INTO LIGHTS (ID, KITCHEN_MAIN, KITCHEN_CUPBOARDS, SALOON_MAIN, SALOON_LAMP, BEDROOM1, BEDROOM2, GUEST_ROOM, CORRIDOR1, CORRIDOR2) " +
                            "VALUES (1, 0, 0, 0, 0, 0, 0, 0, 0, 0)";
                    stmt.executeUpdate(sql);

                    sql = "INSERT INTO ROLLER_BLINDS (ID, KITCHEN_LEFT, KITCHEN_RIGHT, SALOON_MAIN, SALOON_MINOR, BEDROOM1, BEDROOM2, GUEST_ROOM, CORRIDOR1, CORRIDOR2) " +
                            "VALUES (1, 0, 0, 0, 0, 0, 0, 0, 0, 0)";
                    stmt.executeUpdate(sql);

                    sql = "INSERT INTO TEMPERATURE (ID, KITCHEN, SALOON, BEDROOM1, BEDROOM2, GUEST_ROOM, CORRIDOR1, CORRIDOR2) " +
                            "VALUES (1, 16, 16, 16, 16, 16, 16, 16)";

                    stmt.executeUpdate(sql);

                    stmt.close();
                    c.close();
                } catch (Exception e) {
                    System.err.println(e.getClass().getName() + ": " + e.getMessage());
                    System.exit(0);
                }
                System.out.println("Utworzono tabele");

        Scene scene = new Scene(fxmlLoader.load(), 1000, 562.5);
        stage.setTitle("Smart Home Project");
        stage.setScene(scene);
        stage.show();
    }
}