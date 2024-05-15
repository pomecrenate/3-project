package auth.model;

public class User {
  private String id; // 사용자 ID | ユーザーID
  private String name; // 사용자 이름 | ユーザー名

  public User(String id, String name) { // 생성자 | コンストラクタ
    this.id = id; // 사용자 ID 설정 | ユーザーIDを設定
    this.name = name; // 사용자 이름 설정 | ユーザー名を設定
  }

  public String getId() { // 사용자 ID 반환 메서드 | ユーザーIDを取得するメソッド
    return id;
  }

  public String getName() { // 사용자 이름 반환 메서드 | ユーザー名を取得するメソッド
    return name;
  }
}