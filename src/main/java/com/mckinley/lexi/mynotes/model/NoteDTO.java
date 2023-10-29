package com.mckinley.lexi.mynotes.model;

import java.util.Objects;

public class NoteDTO {
    
    private String noteText;

    ///String gets converted to ZonedDateTime then to Instant then to UTC in postgresql
    private String noteDate;

    private String timeZone;

    private boolean iscomplete;

    private int client_id;

    private int project_id;

    private int notetype_id;

    public NoteDTO() {
        super();
    }

    public NoteDTO(String noteText, String noteDate, String timeZone, boolean iscomplete, int client_id, int project_id, int notetype_id) {
        this.noteText = noteText;
        this.noteDate = noteDate;
        this.timeZone = timeZone;
        this.iscomplete = iscomplete;
        this.client_id = client_id;
        this.project_id = project_id;
        this.notetype_id = notetype_id;
    }

    public String getNoteText() {
        return this.noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

    public String getNoteDate() {
        return this.noteDate;
    }

    public void setNoteDate(String noteDate) {
        this.noteDate = noteDate;
    }

    public String getTimeZone() {
        if (this.timeZone==null) this.timeZone="America/New_York";
        return this.timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
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

    public int getClient_id() {
        return this.client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public int getProject_id() {
        return this.project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public int getNotetype_id() {
        return this.notetype_id;
    }

    public void setNotetype_id(int notetype_id) {
        this.notetype_id = notetype_id;
    }

    public NoteDTO noteText(String noteText) {
        setNoteText(noteText);
        return this;
    }

    public NoteDTO noteDate(String noteDate) {
        setNoteDate(noteDate);
        return this;
    }

    public NoteDTO timeZone(String timeZone) {
        setTimeZone(timeZone);
        return this;
    }

    public NoteDTO iscomplete(boolean iscomplete) {
        setIscomplete(iscomplete);
        return this;
    }

    public NoteDTO client_id(int client_id) {
        setClient_id(client_id);
        return this;
    }

    public NoteDTO project_id(int project_id) {
        setProject_id(project_id);
        return this;
    }

    public NoteDTO notetype_id(int notetype_id) {
        setNotetype_id(notetype_id);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof NoteDTO)) {
            return false;
        }
        NoteDTO noteDTO = (NoteDTO) o;
        return Objects.equals(noteText, noteDTO.noteText) && Objects.equals(noteDate, noteDTO.noteDate) && Objects.equals(timeZone, noteDTO.timeZone) && iscomplete == noteDTO.iscomplete && client_id == noteDTO.client_id && project_id == noteDTO.project_id && notetype_id == noteDTO.notetype_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(noteText, noteDate, timeZone, iscomplete, client_id, project_id, notetype_id);
    }

    @Override
    public String toString() {
        return "{" +
            " noteText='" + getNoteText() + "'" +
            ", noteDate='" + getNoteDate() + "'" +
            ", timeZone='" + getTimeZone() + "'" +
            ", iscomplete='" + isIscomplete() + "'" +
            ", client_id='" + getClient_id() + "'" +
            ", project_id='" + getProject_id() + "'" +
            ", notetype_id='" + getNotetype_id() + "'" +
            "}";
    }

}
