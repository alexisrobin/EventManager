package models;

import javax.persistence.*;

/**
 * Defines an event's registrant.
 */
@Entity
public class Registrant {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int id;

    private String lastName;

    private String firstName;

    private String companyName;

    private String mail;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Event event;

    public Registrant() {
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getMail() {
        return mail;
    }

    public Event getEvent() {
        return event;
    }

    public String getFullName(){
        return this.lastName + " " + this.firstName;
    }

    public Registrant(Registrant.RegistrantBuilder builder) {
        this.lastName = builder.lastName;
        this.firstName = builder.firstName;
        this.companyName = builder.companyName;
        this.mail = builder.mail;
        this.event = builder.event;
    }

    public static class RegistrantBuilder{

        private String lastName, firstName, companyName, mail;
        private Event event;

        public RegistrantBuilder() {
            this.lastName = "";
            this.firstName = "";
            this.companyName = "";
            this.mail = "";
            this.event = null;
        }

        public Registrant.RegistrantBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Registrant.RegistrantBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Registrant.RegistrantBuilder setCompanyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public Registrant.RegistrantBuilder setMail(String mail) {
            this.mail = mail;
            return this;
        }

        public Registrant.RegistrantBuilder setEvent(Event event) {
            this.event = event;
            return this;
        }

        public Registrant build() {
            return new Registrant(this);
        }
    }
}
