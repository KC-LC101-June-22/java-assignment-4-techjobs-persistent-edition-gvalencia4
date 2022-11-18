package org.launchcode.techjobs.persistent.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
public class Employer extends AbstractEntity {

    @NotNull
    @Size(max=100)
    private String location;

    public Employer() {}

    Employer(String location) {
        this();
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employer employer = (Employer) o;
        return Objects.equals(location, employer.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), location);
    }


}
