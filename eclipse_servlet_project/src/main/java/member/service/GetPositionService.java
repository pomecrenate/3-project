package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import exception.PositionNotFoundException;
import jdbc.connection.ConnectionProvider;
import member.dao.PositionDao;

public class GetPositionService {
  private PositionDao positionDao = new PositionDao();

  public Map<Integer, String> get() {
    try (Connection conn = ConnectionProvider.getConnection()) {
      Map<Integer, String> positions = positionDao.selectAll(conn);

      if (positions.isEmpty()) {
        throw new PositionNotFoundException();
      }

      return positions;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
