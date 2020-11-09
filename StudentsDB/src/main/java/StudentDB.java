import java.util.*;
import java.sql.*;
import java.io.*;
import java.math.BigDecimal;

public class StudentDB {

        public static final String DB_URL = "jdbc:h2:/Users/georgyarjantsev/Downloads/Two-projects-main/Test2/db/Students";
        public static final String DB_Driver = "org.h2.Driver";

        public static void main(String[] args) {
            try {
                Class.forName(DB_Driver);

                Connection connection = DriverManager.getConnection(DB_URL);

                Statement statement = connection.createStatement();


                System.out.println("Соединение с СУБД выполнено.");
                connection.close();

                System.out.println("Отключение от СУБД выполнено.");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();

                System.out.println("JDBC драйвер для СУБД не найден!");
            } catch (SQLException e) {
                e.printStackTrace();

                System.out.println("Ошибка SQL !");
            }
        }
    }
