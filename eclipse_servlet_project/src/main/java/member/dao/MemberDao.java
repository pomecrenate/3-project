package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import jdbc.JdbcUtil;
import member.model.Member;

public class MemberDao {

	// 아이디 검색
	public Member selectById(Connection conn, String id) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement("select * from member where id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			Member member = null;

			if (rs.next()) {
				String memberId = rs.getString("id");
				String memberName = rs.getString("name");
				String memberPassword = rs.getString("password");
				Date memberRegDate = toDate(rs.getTimestamp("reg_date"));

				member = new Member(memberId, memberName, memberPassword, memberRegDate);
			}

			return member;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	// regDate 값이 있으면 TimeStamp를 Date로 변환
	// DB에는 TimeStamp로 저장, Java에는 Date로 저장
	private Date toDate(Timestamp timestamp) {
		return timestamp == null ? null : new Date(timestamp.getTime());
	}

	// 멤버 추가
	public void insert(Connection conn, Member member) throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement("insert into member values (?, ?, ?, ?)")) {
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getPassword());
			pstmt.setTimestamp(4, new Timestamp(member.getRegDate().getTime()));

			pstmt.executeUpdate();
		}
	}

	// 멤버 변경
	public void update(Connection conn, Member member) throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement("update member set name = ?, password = ? where id = ?")) {
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getId());

			pstmt.executeUpdate();
		}
	}
}
