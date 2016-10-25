package models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * Created by Alexis on 25/10/2016.
 */
public class Registrant {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int id;

    private String lastName;

    private String firstName;

    private String companyName;

    private String address;

    @ManyToOne
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

    public String getAddress() {
        return address;
    }

    public Event getEvent() {
        return event;
    }

    public Registrant(Registrant.RegistrantBuilder builder) {
        this.lastName = builder.lastName;
        this.firstName = builder.firstName;
        this.companyName = builder.companyName;
        this.address = builder.address;
        this.event = builder.event;
    }

    public static class RegistrantBuilder{

        private String lastName, firstName, companyName, address;
        private Event event;

        public RegistrantBuilder() {
            this.lastName = "";
            this.firstName = "";
            this.companyName = "";
            this.address = "";
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

        public Registrant.RegistrantBuilder setAddress(String address) {
            this.address = address;
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
