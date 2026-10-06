package db;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {

    private static final Logger log = LogManager.getLogger(DbConnection.class);
    private static final Properties props = new Properties();

    static {
        try (InputStream is = DbConnection.class.getClassLoader()
                .getResourceAsStream("db.properties")) {
            if (is == null) {
                throw new IllegalStateException("Не найден db.properties в classpath");
            }
            props.load(is);
        } catch (IOException e) {
            throw new IllegalStateException("Не удалось прочитать db.properties", e);
        }
    }

    private DbConnection() {
    }

    public static Connection getConnection() {
        try {
            log.debug("Подключение к БД: {}", props.getProperty("db.url"));
            return DriverManager.getConnection(
                    props.getProperty("db.url"),
                    props.getProperty("db.user"),
                    props.getProperty("db.password"));
        } catch (SQLException e) {
            throw new IllegalStateException("Ошибка подключения к БД", e);
        }
    }
}