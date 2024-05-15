package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import exception.CompanyNotFoundException;
import jdbc.connection.ConnectionProvider;
import member.dao.CompanyDao;
import member.model.Company;

public class GetCompanyService {
  // CompanyDao 객체를 생성
  private CompanyDao companyDao = new CompanyDao();

  // 코드를 통해 회사 정보를 가져오는 메서드
  //当社のDaoオブジェクトを作成
  public Company get(int code) {
    try (Connection conn = ConnectionProvider.getConnection()) {
      // companyDao.selectByCode를 사용하여 코드로 회사 정보를 가져옴
      // companyDao.selectByCodeを使用してコードで会社情報を取得
      Company company = companyDao.selectByCode(conn, code);

      // 가져온 회사가 없는 경우 예외를 던짐
      // 持ってきた会社がない場合、例外を投げる
      if (company == null) {
        throw new CompanyNotFoundException();
      }

      // 가져온 company를 반환
      // 持ってきたcompanyを返却
      return company;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
  
  // 아이디를 통해 회사 정보를 가져오는 메서드
  // IDで会社情報を取得するメソッド
  public Company get(String id) {
    try (Connection conn = ConnectionProvider.getConnection()) {
      // companyDao.selectById를 사용하여 아이디로 회사 정보 가져옴
      // company Dao.select ByIdを使用してIDで会社情報を取得
      Company company = companyDao.selectById(conn, id);

      // 가져온 회사가 없는 경우 예외를 던짐.
      // 持ってきた会社がない場合は例外を投げる
      if (company == null) {
        throw new CompanyNotFoundException();
      }

      // 가져온 회사를 반환
      // 持ってきた会社を返却
      return company;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
