package africa.semicolon.Unicoin.user;


public interface UserService {
    public String createAccount(User user);
    public void enableUser(String emailAddress);
}
