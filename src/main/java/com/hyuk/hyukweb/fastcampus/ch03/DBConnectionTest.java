package com.hyuk.hyukweb.fastcampus.ch03;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.*;

public class DBConnectionTest {
    public static void main(String[] args) throws SQLException {
        String DB_URL = "jdbc:mariadb://localhost:3306";

        String DB_USER = "study";
        String DB_PASSWORD = "test1234";

        Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        Statement stmt = conn.createStatement();

        String query = "SELECT now()";
        ResultSet rs = stmt.executeQuery(query);

        // 실행결과가 담긴 rs에서 한 줄씩 읽어서 출력
        while (rs.next()) {
            String curDate = rs.getString(1);  // 읽어온 행의 첫번째 컬럼의 값을 String으로 읽어서 curDate에 저장
            System.out.println(curDate);       // 2022-01-11 13:53:00.0
        }
    }

        DataSource ds;
    @Test
    public void insertUserTest()throws Exception{
        User user = new User("asdf", "1234", "abc", "aaa@aaa.com", new Date(), "fb", new Date());
        int rowCnt = insertUser(user);
    }
    public int insertUser(User user) throws Exception{
        Connection conn = ds.getConnection();
        String sql = "insert into user_info values (?,?,?,?,?,?,now())";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,user.getId());
        pstmt.setString(2,user.getPwd());
        pstmt.setString(3,user.getName());
        pstmt.setString(4,user.getEmail());
        pstmt.setDate(5, new java.sql.Date(user.getBirth().getTime()));
        pstmt.setString(6,user.getSns());

        int rowCnt = pstmt.executeUpdate();

        return rowCnt;
    }
}
