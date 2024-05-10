package auth.service;

import member.model.Company;

public class PermissionChecker {
  public static boolean canModify(String userId, Company company) {
    return company.getId().equals(userId);
  }
}
