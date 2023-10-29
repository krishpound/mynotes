package com.mckinley.lexi.mynotes.model;

import java.time.Instant;
import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "client")
public class EntityClient {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "client_id")
    private int client_id;

    @Column(name = "name", unique = true)
    private String name;

    //functions and triggers definded in pgAdmin4 - see also ddl file in resources
    @Column(name = "created", nullable = false)
    private Instant created;

    @Column(name = "modified", nullable = false)
    private Instant modified;

    public EntityClient() {
        super();
    }

    public EntityClient(int client_id, String name, Instant created, Instant modified) {
        this.client_id = client_id;
        this.name = name;
        this.created = created;
        this.modified = modified;
    }

    public int getClient_id() {
        return this.client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getCreated() {
        return this.created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return this.modified;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public EntityClient client_id(int client_id) {
        setClient_id(client_id);
        return this;
    }

    public EntityClient name(String name) {
        setName(name);
        return this;
    }

    public EntityClient created(Instant created) {
        setCreated(created);
        return this;
    }

    public EntityClient modified(Instant modified) {
        setModified(modified);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof EntityClient)) {
            return false;
        }
        EntityClient entityClient = (EntityClient) o;
        return client_id == entityClient.client_id && Objects.equals(name, entityClient.name) && Objects.equals(created, entityClient.created) && Objects.equals(modified, entityClient.modified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client_id, name, created, modified);
    }

    @Override
    public String toString() {
        return "{" +
            " client_id='" + getClient_id() + "'" +
            ", name='" + getName() + "'" +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            "}";
    }
    

}




