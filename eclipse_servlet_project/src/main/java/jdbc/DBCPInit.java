package jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class DBCPInit extends HttpServlet {

    @Override
    public void init() throws ServletException {
        loadJDBCDriver();
        initConnectionPool();
    }

    private void loadJDBCDriver() {
        try {
            // Oracle JDBC 드라이버 클래스 로드
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException ex) {
            // 드라이버 클래스를 찾을 수 없을 때 예외 처리
            throw new RuntimeException("Failed to load JDBC Driver", ex);
        }
    }

    private void initConnectionPool() {
        try {
            // 데이터베이스 연결 정보 설정
            String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
            String username = "system";
            String password = "1234";

            // ConnectionFactory, PoolableConnectionFactory 설정
            ConnectionFactory connFactory = new DriverManagerConnectionFactory(jdbcUrl, username, password);
            PoolableConnectionFactory poolableConnFactory = new PoolableConnectionFactory(connFactory, null);
            poolableConnFactory.setValidationQuery("SELECT 1 FROM DUAL");

            // Connection Pool 설정
            GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
            poolConfig.setTimeBetweenEvictionRunsMillis(1000L * 60L * 5L);
            poolConfig.setTestWhileIdle(true);
            poolConfig.setMinIdle(4);
            poolConfig.setMaxTotal(50);

            // Connection Pool 생성
            GenericObjectPool<PoolableConnection> connectionPool = 
                new GenericObjectPool<>(poolableConnFactory, poolConfig);
            poolableConnFactory.setPool(connectionPool);

            // PoolingDriver 등록
            Class.forName("org.apache.commons.dbcp2.PoolingDriver");
            PoolingDriver driver = (PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:");
            driver.registerPool("board", connectionPool);
        } catch (ClassNotFoundException | SQLException e) {
            // 예외 처리
            throw new RuntimeException("Failed to initialize connection pool", e);
        }
    }
}
