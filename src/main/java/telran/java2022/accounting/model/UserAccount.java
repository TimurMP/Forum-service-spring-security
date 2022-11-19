package telran.java2022.accounting.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@EqualsAndHashCode(of = {"login"})
@Document(collection = "users")
public class UserAccount {
    @Id
    String login;
    @Setter
    String password;
    @Setter
    String firstName;
    @Setter
    String lastName;
    Set<String> roles;

    @Getter
    @Setter
    LocalDateTime passwordChanged;

    public UserAccount() {
        roles = new HashSet<>();
        roles.add("USER");
    }

    public UserAccount(String login, String password, String firstName, String lastName, LocalDateTime passwordChanged) {
        this();
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.passwordChanged = passwordChanged;

    }

    public boolean addRole(String role) {
        return roles.add(role);
    }

    public boolean removeRole(String role) {
        return roles.remove(role);
    }

}
