package models;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Alexis on 21/10/2016.
 */

@Entity
public class User {

    @Id
    private String mail;

    private String password;

    public User() {
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public User(UserBuilder builder) {
        this.mail = builder.mail;
        this.password = builder.password;
    }

    public class UserBuilder{

        private String mail, password;

        public UserBuilder() {
            this.mail = "";
            this.password = "";
        }

        public UserBuilder setMail(String mail) {
            this.mail = mail;
            return this;
        }

        public UserBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}

