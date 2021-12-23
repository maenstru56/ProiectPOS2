package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "USER_TABLE", schema = "Database",  catalog = "")
public class UserTableEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "USERNAME", nullable = true, length = 64)
    private String username;
    @Basic
    @Column(name = "PASSWORD", nullable = true, length = 64)
    private String password;
    @Basic
    @Column(name = "ID_ROLE", nullable = false)
    private int idRole;
    @Basic
    @Column(name = "ID_STATE", nullable = false)
    private int idState;
    @Basic
    @Column(name = "EMAIL", nullable = true, length = 64)
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public int getIdState() {
        return idState;
    }

    public void setIdState(int idState) {
        this.idState = idState;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserTableEntity that = (UserTableEntity) o;
        return id == that.id && idRole == that.idRole && idState == that.idState && Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, idRole, idState, email);
    }
}
