package com.mckinley.lexi.mynotes.model;

import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "defaults")
public class EntityDefaults {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "default_id")
    private int default_id;

    @Column(name = "name", unique = true)
    private String client;

    @Column(name = "timezone", unique = true)
    private String timeZone;

    public EntityDefaults() {
        super();
    }

    public EntityDefaults(int default_id, String client, String timeZone) {
        this.default_id = default_id;
        this.client = client;
        this.timeZone = timeZone;
    }

    public int getDefault_id() {
        return this.default_id;
    }

    public void setDefault_id(int default_id) {
        this.default_id = default_id;
    }

    public String getClient() {
        return this.client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getTimeZone() {
        return this.timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public EntityDefaults default_id(int default_id) {
        setDefault_id(default_id);
        return this;
    }

    public EntityDefaults client(String client) {
        setClient(client);
        return this;
    }

    public EntityDefaults timeZone(String timeZone) {
        setTimeZone(timeZone);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof EntityDefaults)) {
            return false;
        }
        EntityDefaults entityDefaults = (EntityDefaults) o;
        return default_id == entityDefaults.default_id && Objects.equals(client, entityDefaults.client) && Objects.equals(timeZone, entityDefaults.timeZone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(default_id, client, timeZone);
    }

    @Override
    public String toString() {
        return "{" +
            " default_id='" + getDefault_id() + "'" +
            ", client='" + getClient() + "'" +
            ", timeZone='" + getTimeZone() + "'" +
            "}";
    }


}

