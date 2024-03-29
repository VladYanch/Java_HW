package users;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserService {

    private static UserService service;
    private static UserRepository repository;
    private static User user1;
    private static User user2;

    public UserService(UserRepository repository) {
    }

    @BeforeEach
    public void init() {
//        repository = new UserRepositoryImpl();
        repository = Mockito.mock(UserRepository.class);
        service = new UserService(repository);
        user1 = new User(1, "Test user 1", true);
        user2 = new User(2, "Test user 2", false);
        Mockito.when(repository.getUserById(1)).thenReturn(user1);
        Mockito.when(repository.getUserById(2)).thenReturn(user2);
//        Mockito.when(repository.getUserById(Mockito.anyInt())).thenReturn(user2);
    }


    @Test
    public void isActive() {
        assertTrue(service.isActive(1));
        assertFalse(service.isActive(2));
    }

    @Test
    public void deactivate() {
        assertTrue(user1.isActive());
        service.deactivate(1);
        assertFalse(user1.isActive());
        Mockito.verify(repository).saveUser(user1);

        service.deactivate(2);
        assertFalse(user2.isActive());
        Mockito.verify(repository).saveUser(user2);

        Mockito.verify(repository, Mockito.times(2)).saveUser(Mockito.any());
    }

    @Test
    public void deleteInactive(List<User> users){
        for (User user : users) {
            if (!user.isActive()){
                repository.deleteUser(user.getId());
            }
        }
    }
}