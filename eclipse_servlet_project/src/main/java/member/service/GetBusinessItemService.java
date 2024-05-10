package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import exception.BusinessItemNotFoundException;
import jdbc.connection.ConnectionProvider;
import member.dao.BusinessItemDao;

public class GetBusinessItemService {
  private BusinessItemDao businessItemDao = new BusinessItemDao();

  public Map<Integer, String> get() {
    try (Connection conn = ConnectionProvider.getConnection()) {
      Map<Integer, String> businessItems = businessItemDao.selectAll(conn);

      if (businessItems.isEmpty()) {
        throw new BusinessItemNotFoundException();
      }

      return businessItems;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
