package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;

public class ChangePasswordService {
	private MemberDao memberDao = new MemberDao();

	// 비밀번호 변경
	public void changePassword(String userId, String currentPassword, String newPassword) {
		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);

			// 로그인된 id와 일치하는 멤버 계정을 찾음
			Member existedMember = memberDao.selectById(conn, userId);

			// 로그인된 id와 일치하는 멤버 계정이 없으면 멤버 찾을 수 없음 예외 발생
			if (existedMember == null) {
				throw new MemberNotFoundException();
			}

			// 비밀번호가 일치하지 않으면 유효하지 않은 비밀번호 예외 발생
			if (!existedMember.matchPassword(currentPassword)) {
				throw new InvalidPasswordException();
			}

			// 비밀번호 변경
			existedMember.changePassword(newPassword);

			// 멤버 정보 변경
			memberDao.update(conn, existedMember);

			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
}
