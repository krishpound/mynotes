PostgreSQL JavaNotes database

NOTE: This is manual DDL.
NOTE: Hiberate will generate database for you automatically.
NOTE: Refer to application.properties:  spring.jpa.hibernate.ddl-auto=update

FUNCTIONS - do this in pgAdmin4
=========
CREATE OR REPLACE FUNCTION trigger_set_created_timestamp()
RETURNS TRIGGER AS $$
BEGIN
  NEW.created = NOW();
  RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION trigger_set_modified_timestamp()
RETURNS TRIGGER AS $$
BEGIN
  NEW.modified = NOW();
  RETURN NEW;
END;
$$ LANGUAGE plpgsql;

TABLES
======
create table client
(id serial not null primary key,
 name varchar(100),
 created timestamptz not null default now(),
 modified timestamptz not null default now());

create table project
(id serial not null primary key,
 name varchar(100),
 created timestamptz not null default now(),
 modified timestamptz not null default now()
);

create table notetype
(id serial not null primary key,
 name varchar(100),
 created timestamptz not null default now(),
 modified timestamptz not null default now());

create table note
(id serial not null primary key,
 client_id serial,
 project_id serial,
 notetype_id serial,
 notetext text,
 notedate date,
 iscomplete boolean,
 created timestamptz not null default now(),
 modified timestamptz not null default now(),
 constraint fk_client foreign key(client_id) references client(id),
 constraint fk_project foreign key(project_id) references project(id),
 constraint fk_notetype foreign key(notetype_id) references notetype(id)
);

TRIGGERS - do this in pgAdmin4 or dbVisualizer.
========
Note:  triggers are replaced with Java logic.  This section is not used but left in because it is an interesting technique.

CREATE TRIGGER set_client_created_timestamp
BEFORE INSERT ON client
FOR EACH ROW
EXECUTE PROCEDURE trigger_set_created_timestamp();

CREATE TRIGGER set_client_modified_timestamp
BEFORE UPDATE ON client
FOR EACH ROW
EXECUTE PROCEDURE trigger_set_modified_timestamp();

CREATE TRIGGER set_project_created_timestamp
BEFORE INSERT ON project
FOR EACH ROW
EXECUTE PROCEDURE trigger_set_created_timestamp();

CREATE TRIGGER set_project_modified_timestamp
BEFORE UPDATE ON project
FOR EACH ROW
EXECUTE PROCEDURE trigger_set_modified_timestamp();

CREATE TRIGGER set_notetype_created_timestamp
BEFORE INSERT ON notetype
FOR EACH ROW
EXECUTE PROCEDURE trigger_set_created_timestamp();

CREATE TRIGGER set_notetype_modified_timestamp
BEFORE UPDATE ON notetype
FOR EACH ROW
EXECUTE PROCEDURE trigger_set_modified_timestamp();

CREATE TRIGGER set_note_created_timestamp
BEFORE INSERT ON note
FOR EACH ROW
EXECUTE PROCEDURE trigger_set_created_timestamp();

CREATE TRIGGER set_note_modified_timestamp
BEFORE UPDATE ON note
FOR EACH ROW
EXECUTE PROCEDURE trigger_set_modified_timestamp();