package auth.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;

public class LoginService {
	private MemberDao memberDao = new MemberDao();

	public User login(String id, String password) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			// 아이디 검색
			Member member = memberDao.selectById(conn, id);

			// 아이디 없으면 예외
			if (member == null) {
				throw new LoginFailException();
			}

			// 암호틀리면 예외
			if (!member.matchPassword(password)) {
				throw new LoginFailException();
			}

			return new User(member.getId(), member.getName());
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
}
