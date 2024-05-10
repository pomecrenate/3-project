package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import exception.BusinessTypeNotFoundException;
import jdbc.connection.ConnectionProvider;
import member.dao.BusinessTypeDao;

public class GetBusinessTypeService {
  private BusinessTypeDao businessTypeDao = new BusinessTypeDao();

  // 업태의 전체 목록을 가져오는 역할
  public Map<Integer, String> get() {
    try (Connection conn = ConnectionProvider.getConnection()) {
      Map<Integer, String> businessTypes = businessTypeDao.selectAll(conn);

      if (businessTypes.isEmpty()) {
        throw new BusinessTypeNotFoundException();
      }

      return businessTypes;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
