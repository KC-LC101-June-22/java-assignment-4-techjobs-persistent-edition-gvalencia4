package org.launchcode.techjobs.persistent.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Employer extends AbstractEntity {

    @NotNull
    @Size(max=100)
    private String location;

    @OneToMany
    @NotNull
    @JoinColumn(name="employer_id")
    private final List<Job> jobs  = new ArrayList<>();

    public Employer() {}

    public Employer (String location) {
        super();
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Job> getJobs() {
        return jobs;
    }

//    public void setJobs(List<Job> jobs) {
//        //this.jobs = jobs;
//        jobs.add(job);
//    }

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
