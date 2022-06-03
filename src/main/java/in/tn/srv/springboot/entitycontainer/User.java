package in.tn.srv.springboot.entitycontainer;

import javax.persistence.*;

@Entity
@Table(name = "Customers")
public class User {
    @Id
    @Column(name = "User_Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "User_Name", nullable = false)
    private String firstName;

    @Column(name = "User_Pass", nullable = false)
    private String password;

    @Column(name = "User_Email", nullable = false)
    private String eMail;

    @Column(name = "User_Mobile", nullable = false)
    private String mobile;

    @Column(name = "User_Role", nullable = false)
    private String role;

    public User() {
    }

    public User(String firstName, String password, String eMail, String mobile, String role) {
        this.firstName = firstName;
        this.password = password;
        this.eMail = eMail;
        this.mobile = mobile;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
}
