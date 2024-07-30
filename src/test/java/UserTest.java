import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    @Test
    public void testGetLogin() {
        User user = new User("testLogin", "testPassword123", "test@example.com");
        assertEquals("testLogin", user.getLogin());
    }

    @Test
    public void testGetPassword() {
        User user = new User("testLogin", "testPassword123", "test@example.com");
        assertEquals("testPassword123", user.getPassword());
    }

    @Test
    public void testGetEmail() {
        User user = new User("testLogin", "testPassword123", "test@example.com");
        assertEquals("test@example.com", user.getEmail());
    }

    @Test
    public void testSetLogin() {
        User user = new User("testLogin", "testPassword123", "test@example.com");
        user.setLogin("newLogin");
        assertEquals("newLogin", user.getLogin());
    }

    @Test
    public void testSetLoginException() {
        User user = new User("testLogin", "testPassword123", "test@example.com");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            user.setLogin("ab");
        });
        assertEquals("Логин должен быть не менее 3 символов!", exception.getMessage());
    }

    @Test
    public void testSetPassword() {
        User user = new User("testLogin", "testPassword123", "test@example.com");
        user.setPassword("newPassword123");
        assertEquals("newPassword123", user.getPassword());
    }

    @Test
    public void testSetPasswordException() {
        User user = new User("testLogin", "testPassword123", "test@example.com");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            user.setPassword("short");
        });
        assertEquals("Пароль должен быть не менее 8 символов!", exception.getMessage());
    }

    @Test
    public void testSetEmail() {
        User user = new User("testLogin", "testPassword123", "test@example.com");
        user.setEmail("new@example.com");
        assertEquals("new@example.com", user.getEmail());
    }

    @Test
    public void testSetEmailException() {
        User user = new User("testLogin", "testPassword123", "test@example.com");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            user.setEmail("invalidEmail");
        });
        assertEquals("Email должен содержать '@'!", exception.getMessage());
    }

    @Test
    public void testIsValidPassword() {
        User user = new User("testLogin", "testPassword123", "test@example.com");
        assertTrue(user.isValidPassword("testPassword123"));
        assertFalse(user.isValidPassword("wrongPassword"));
    }
}
