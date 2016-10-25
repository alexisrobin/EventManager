package models;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Alexis on 17/10/2016.
 */

@Entity
public class Event {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int id;

    private String name;

    private String address;

    private Date startDate;

    private Date endDate;

    @ManyToOne
    private User user;

    public Event() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public User getUser() {
        return user;
    }

    public Event(EventBuilder builder) {
        this.name = builder.name;
        this.address = builder.address;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.user = builder.user;
    }

    public static class EventBuilder{

        private String name, address;
        private Date startDate, endDate;
        private User user;

        public EventBuilder() {
            this.name = "";
            this.address = "";
            this.startDate = null;
            this.endDate = null;
            this.user = null;
        }

        public EventBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public EventBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public EventBuilder setStartDate(Date startDate) {
            this.startDate = startDate;
            return this;
        }

        public EventBuilder setEndDate(Date endDate) {
            this.endDate = endDate;
            return this;
        }

        public EventBuilder setUser(User user) {
            this.user = user;
            return this;
        }

        public Event build() {
            return new Event(this);
        }
    }
}
