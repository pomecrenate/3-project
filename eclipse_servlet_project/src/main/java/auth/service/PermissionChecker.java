package auth.service;

import member.model.Company;

public class PermissionChecker {
  public static boolean canModify(String userId, Company company) {
    System.out.println("userId: " + userId + ", " + "companyId: " + company.getId());
    return company.getId().equals(userId);
  }
}
