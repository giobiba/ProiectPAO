package com.company;

import java.sql.*;

public class DatabaseManager {
    public Connection conn;
    public DatabaseManager(String url) throws SQLException {
        this.conn = DriverManager.getConnection("jdbc:sqlite:database.db");
    }

    public void initializeDatabase() throws SQLException{
        Statement stmt = conn.createStatement();
        String city_sql = "CREATE TABLE IF NOT EXISTS CITIES " +
                "(city_id   INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "name       VARCHAR(20)," +
                "county    VARCHAR(20));";

        stmt.execute(city_sql);

        String location_sql = "CREATE TABLE IF NOT EXISTS LOCATIONS " +
                "(location_id   INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "street         VARCHAR(20)," +
                "number         INTEGER," +
                "city_id        INTEGER," +
                "FOREIGN KEY(city_id) REFERENCES cities(city_id));";

        stmt.execute(location_sql);

        String user_sql = "CREATE TABLE IF NOT EXISTS USERS " +
                "(user_id        INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "name       VARCHAR(10)," +
                "surname    VARCHAR(10)," +
                "phone      VARCHAR(10)," +
                "location_id    INTEGER," +
                "birthday   VARCHAR(20)," +
                "FOREIGN KEY(location_id) REFERENCES locations(location_id));";

        stmt.execute(user_sql);

        String locale_sql = "CREATE TABLE IF NOT EXISTS LOCALES " +
                "(locale_id     INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "name           VARCHAR(20)," +
                "location_id    INTEGER," +
                "open_hour      INTEGER," +
                "close_hour     INTEGER," +
                "FOREIGN KEY(location_id) REFERENCES locations(location_id));";

        stmt.execute(locale_sql);

        String menu_sql = "CREATE TABLE IF NOT EXISTS MENU " +
                "(menu_id       INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name           VARCHAR(20)," +
                "price          FLOAT," +
                "locale_id      INTEGER NOT NULL," +
                "FOREIGN KEY(locale_id) REFERENCES locales(locale_id)" +
                ");";

        stmt.execute(menu_sql);

        String delivery_sql = "CREATE TABLE IF NOT EXISTS DELIVERIES " +
                "(delivery_id       INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                "name               VARCHAR(10)," +
                "surname            VARCHAR(10)," +
                "vehicle            VARCHAR(6));";

        stmt.execute(delivery_sql);

        String order_sql = "CREATE TABLE IF NOT EXISTS ORDERS " +
                "(order_id      INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "date           VARCHAR(20)," +
                "locale_id      INTEGER," +
                "user_id        INTEGER," +
                "delivery_id    INTEGER," +
                "prices         FLOAT," +
                "hasChange      TINYINT," +
                "completed      TINYINT," +
                "cardNumber     VARCHAR(30)," +
                "cardHolder     VARCHAR(30)," +
                "FOREIGN KEY(locale_id) REFERENCES locales(locale_id)," +
                "FOREIGN KEY(user_id) REFERENCES users(user_id)," +
                "FOREIGN KEY(delivery_id) REFERENCES deliveries(delivery_id));";

        stmt.execute(order_sql);

        String menu_order_sql = "CREATE TABLE IF NOT EXISTS MENU_ORDER " +
                "(menu_order_id    INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "menu_id           INTEGER," +
                "order_id          INTEGER," +
                "FOREIGN KEY(menu_id) REFERENCES MENU(menu_id)," +
                "FOREIGN KEY(order_id) REFERENCES ORDERS(order_id));";

        stmt.execute(menu_order_sql);

        stmt.execute("INSERT INTO CITIES (city_id, name, county) VALUES (0, \"Bucuresti\", \"Ilfov\")");
        stmt.execute("INSERT INTO CITIES (city_id, name, county) VALUES (1, \"Galati\", \"Galati\")");
        stmt.execute("INSERT INTO CITIES (city_id, name, county) VALUES (2, \"Braila\", \"Braila\")");

        stmt.execute("INSERT INTO LOCATIONS (location_id, street, number, city_id) VALUES (0, \"Ferdinand I\", 2, 1)");
        stmt.execute("INSERT INTO LOCATIONS (location_id, street, number, city_id) VALUES (1, \"Ovidiu Mazepa\", 38, 1)");
        stmt.execute("INSERT INTO LOCATIONS (location_id, street, number, city_id) VALUES (2, \"Calea Galati\", 10, 2)");
        stmt.execute("INSERT INTO LOCATIONS (location_id, street, number, city_id) VALUES (3, \"Brailei\", 3, 1)");
        stmt.execute("INSERT INTO LOCATIONS (location_id, street, number, city_id) VALUES (4, \"Victoriei\", 29, 0)");
        stmt.execute("INSERT INTO LOCATIONS (location_id, street, number, city_id) VALUES (5, \"Bulevardul Unirii\", 102, 0)");
        stmt.execute("INSERT INTO LOCATIONS (location_id, street, number, city_id) VALUES (6, \"Mihai Bravu\", 17, 0)");

        stmt.close();

    }

}
