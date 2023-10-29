package com.mckinley.lexi.mynotes.model;

import java.time.Instant;
import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="note",uniqueConstraints = { @UniqueConstraint(name = "UniqueNote", columnNames = { "notetext", "notedate","iscomplete","client_id","project_id","notetype_id" }) })

public class EntityNote {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "note_id")
    private int note_id;

    @Column(name="notetext")
    private String notetext;

    //postgresql: show timezone; returns "America/New_York"
    @Column(name="notedate")
    private Instant notedate;

    @Column(name="iscomplete")
    private boolean iscomplete;

    ///Using three uni-directional ManyToOne mappings in this entity
    ///Not defining inverse OneToMany mappings in parent tables because Hibernate gets confused and does a recursive loop
    @ManyToOne
    @JoinColumn(name="client_id", nullable=false)
    private EntityClient client;

    @ManyToOne
    @JoinColumn(name="project_id", nullable=false)
    private EntityProject project;

    @ManyToOne
    @JoinColumn(name="notetype_id", nullable=false)
    private EntityNoteType notetype;

    //functions and triggers definded in pgAdmin4 - see also ddl file in resources
    @Column(name = "created", nullable = false)
    private Instant created;

    @Column(name = "modified", nullable = false)
    private Instant modified;

    public EntityNote() {
        super();
    }

    public EntityNote(int note_id, String notetext, Instant notedate, boolean iscomplete, EntityClient client, EntityProject project, EntityNoteType notetype, Instant created, Instant modified) {
        this.note_id = note_id;
        this.notetext = notetext;
        this.notedate = notedate;
        this.iscomplete = iscomplete;
        this.client = client;
        this.project = project;
        this.notetype = notetype;
        this.created = created;
        this.modified = modified;
    }

    public int getNote_id() {
        return this.note_id;
    }

    public void setNote_id(int note_id) {
        this.note_id = note_id;
    }

    public String getNotetext() {
        return this.notetext;
    }

    public void setNotetext(String notetext) {
        this.notetext = notetext;
    }

    public Instant getNotedate() {
        return this.notedate;
    }

    public void setNotedate(Instant notedate) {
        this.notedate = notedate;
    }

    public boolean isIscomplete() {
        return this.iscomplete;
    }

    public boolean getIscomplete() {
        return this.iscomplete;
    }

    public void setIscomplete(boolean iscomplete) {
        this.iscomplete = iscomplete;
    }

    public EntityClient getClient() {
        return this.client;
    }

    public void setClient(EntityClient client) {
        this.client = client;
    }

    public EntityProject getProject() {
        return this.project;
    }

    public void setProject(EntityProject project) {
        this.project = project;
    }

    public EntityNoteType getNotetype() {
        return this.notetype;
    }

    public void setNotetype(EntityNoteType notetype) {
        this.notetype = notetype;
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

    public EntityNote note_id(int note_id) {
        setNote_id(note_id);
        return this;
    }

    public EntityNote notetext(String notetext) {
        setNotetext(notetext);
        return this;
    }

    public EntityNote notedate(Instant notedate) {
        setNotedate(notedate);
        return this;
    }

    public EntityNote iscomplete(boolean iscomplete) {
        setIscomplete(iscomplete);
        return this;
    }

    public EntityNote client(EntityClient client) {
        setClient(client);
        return this;
    }

    public EntityNote project(EntityProject project) {
        setProject(project);
        return this;
    }

    public EntityNote notetype(EntityNoteType notetype) {
        setNotetype(notetype);
        return this;
    }

    public EntityNote created(Instant created) {
        setCreated(created);
        return this;
    }

    public EntityNote modified(Instant modified) {
        setModified(modified);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof EntityNote)) {
            return false;
        }
        EntityNote entityNote = (EntityNote) o;
        return note_id == entityNote.note_id && Objects.equals(notetext, entityNote.notetext) && Objects.equals(notedate, entityNote.notedate) && iscomplete == entityNote.iscomplete && Objects.equals(client, entityNote.client) && Objects.equals(project, entityNote.project) && Objects.equals(notetype, entityNote.notetype) && Objects.equals(created, entityNote.created) && Objects.equals(modified, entityNote.modified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(note_id, notetext, notedate, iscomplete, client, project, notetype, created, modified);
    }

    @Override
    public String toString() {
        return "{" +
            " note_id='" + getNote_id() + "'" +
            ", notetext='" + getNotetext() + "'" +
            ", notedate='" + getNotedate() + "'" +
            ", iscomplete='" + isIscomplete() + "'" +
            ", client='" + getClient() + "'" +
            ", project='" + getProject() + "'" +
            ", notetype='" + getNotetype() + "'" +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            "}";
    }
         
}
