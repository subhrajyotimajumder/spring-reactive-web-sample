package org.sj.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by subhrajyoti_majumder on 09/10/16.
 * Domain object
 */
@Document
public class Car {
    @Id
    private String id;
    private String name;
    private int releasedYear;

    public Car() {
    }

    public Car(String name, int releasedYear) {
        this.name = name;
        this.releasedYear = releasedYear;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReleasedYear() {
        return releasedYear;
    }

    public void setReleasedYear(int releasedYear) {
        this.releasedYear = releasedYear;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", releasedYear=" + releasedYear +
                '}';
    }
}
