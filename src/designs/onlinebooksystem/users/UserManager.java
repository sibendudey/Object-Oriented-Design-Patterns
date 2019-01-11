package designs.onlinebooksystem.users;

public interface UserManager {
    boolean addUser(User user);
    boolean removeUser(User user);
    boolean removeUser(int userId);
}
