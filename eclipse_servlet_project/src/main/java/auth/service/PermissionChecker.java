package auth.service;

import member.model.Company;

public class PermissionChecker {
  // 사용자가 회사를 수정할 수 있는지 확인
  // ユーザーが会社を修正できるかどうかを確認
  public static boolean canModify(String userId, Company company) {
    // 사용자 ID와 회사 ID 출력
	// ユーザーIDと会社IDを出力
    System.out.println("userId: " + userId + ", " + "companyId: " + company.getId());
    // 회사 ID와 사용자 ID가 일치하는지 확인하여 반환
    // 会社IDとユーザーIDが一致しているか確認して返却
    return company.getId().equals(userId);
  }
}
