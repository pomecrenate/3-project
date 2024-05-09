package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;

public class JoinService {
	private MemberDao memberDao = new MemberDao();

	// 회원가입
	public void join(JoinRequest joinRequest) {
		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);

			// id와 일치하는 멤버 계정을 찾음
			Member existedMember = memberDao.selectById(conn, joinRequest.getId());

			// id와 일치하는 멤버 계정이 이미 있으면 롤백 후 중복아이디 예외 발생
			if (existedMember != null) {
				JdbcUtil.rollback(conn);
				throw new DuplicateIdException();
			}

			String memberId = joinRequest.getId();
			String memberName = joinRequest.getName();
			String memberPassword = joinRequest.getPassword();
			Date memberRegDate = new Date();

			Member joinMember = new Member(memberId, memberName, memberPassword, memberRegDate);

			// 새로운 멤버 추가
			memberDao.insert(conn, joinMember);

			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
}
