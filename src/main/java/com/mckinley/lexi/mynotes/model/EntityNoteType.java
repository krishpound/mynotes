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
@Table(name = "notetype")
public class EntityNoteType {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "notetype_id")
    private int notetype_id;

    @Column(name="name", unique = true)
    private String name;

    //functions and triggers definded in pgAdmin4 - see also ddl file in resources
    //@Column(name = "created", columnDefinition = "timestamptz not null default now()")
    @Column(name = "created", nullable = false)
    private Instant created;

    //@Column(name = "modified", columnDefinition = "timestamptz not null default now()")
    @Column(name = "modified", nullable = false)
    private Instant modified;

    public EntityNoteType() {
        super();
    }

    public EntityNoteType(int notetype_id, String name, Instant created, Instant modified) {
        this.notetype_id = notetype_id;
        this.name = name;
        this.created = created;
        this.modified = modified;
    }

    public int getNotetype_id() {
        return this.notetype_id;
    }

    public void setNotetype_id(int notetype_id) {
        this.notetype_id = notetype_id;
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

    public EntityNoteType notetype_id(int notetype_id) {
        setNotetype_id(notetype_id);
        return this;
    }

    public EntityNoteType name(String name) {
        setName(name);
        return this;
    }

    public EntityNoteType created(Instant created) {
        setCreated(created);
        return this;
    }

    public EntityNoteType modified(Instant modified) {
        setModified(modified);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof EntityNoteType)) {
            return false;
        }
        EntityNoteType entityNoteType = (EntityNoteType) o;
        return notetype_id == entityNoteType.notetype_id && Objects.equals(name, entityNoteType.name) && Objects.equals(created, entityNoteType.created) && Objects.equals(modified, entityNoteType.modified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(notetype_id, name, created, modified);
    }

    @Override
    public String toString() {
        return "{" +
            " notetype_id='" + getNotetype_id() + "'" +
            ", name='" + getName() + "'" +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            "}";
    }
    
}
