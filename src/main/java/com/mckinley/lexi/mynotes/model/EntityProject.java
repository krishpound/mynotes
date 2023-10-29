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
@Table(name = "project")
public class EntityProject {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "project_id")
    private int project_id;

    @Column(name="name", unique = true)
    private String name;

    //functions and triggers definded in pgAdmin4 - see also ddl file in resources
    @Column(name = "created", nullable = false)
    private Instant created;

    @Column(name = "modified", nullable = false)
    private Instant modified;

    public EntityProject() {
        super();
    }

    public EntityProject(int project_id, String name, Instant created, Instant modified) {
        this.project_id = project_id;
        this.name = name;
        this.created = created;
        this.modified = modified;
    }

    public int getProject_id() {
        return this.project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
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

    public EntityProject project_id(int project_id) {
        setProject_id(project_id);
        return this;
    }

    public EntityProject name(String name) {
        setName(name);
        return this;
    }

    public EntityProject created(Instant created) {
        setCreated(created);
        return this;
    }

    public EntityProject modified(Instant modified) {
        setModified(modified);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof EntityProject)) {
            return false;
        }
        EntityProject entityProject = (EntityProject) o;
        return project_id == entityProject.project_id && Objects.equals(name, entityProject.name) && Objects.equals(created, entityProject.created) && Objects.equals(modified, entityProject.modified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(project_id, name, created, modified);
    }

    @Override
    public String toString() {
        return "{" +
            " project_id='" + getProject_id() + "'" +
            ", name='" + getName() + "'" +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            "}";
    }

}
