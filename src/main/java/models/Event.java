package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    public Event(EventBuilder builder) {
        this.name = builder.name;
        this.address = builder.address;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
    }

    public class EventBuilder{

        private String name, address;
        private Date startDate, endDate;

        public EventBuilder() {
            this.name = "";
            this.address = "";
            this.startDate = null;
            this.endDate = null;
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

        public Event build() {
            return new Event(this);
        }
    }
}
