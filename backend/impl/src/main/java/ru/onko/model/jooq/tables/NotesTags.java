/*
 * This file is generated by jOOQ.
 */
package ru.onko.model.jooq.tables;


import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function2;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row2;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;

import ru.onko.model.jooq.Keys;
import ru.onko.model.jooq.Public;
import ru.onko.model.jooq.tables.records.NotesTagsRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class NotesTags extends TableImpl<NotesTagsRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.notes_tags</code>
     */
    public static final NotesTags NOTES_TAGS_ENTITY = new NotesTags();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<NotesTagsRecord> getRecordType() {
        return NotesTagsRecord.class;
    }

    /**
     * The column <code>public.notes_tags.note_id</code>.
     */
    public final TableField<NotesTagsRecord, UUID> NOTE_ID = createField(DSL.name("note_id"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.notes_tags.tag_id</code>.
     */
    public final TableField<NotesTagsRecord, UUID> TAG_ID = createField(DSL.name("tag_id"), SQLDataType.UUID.nullable(false), this, "");

    private NotesTags(Name alias, Table<NotesTagsRecord> aliased) {
        this(alias, aliased, null);
    }

    private NotesTags(Name alias, Table<NotesTagsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.notes_tags</code> table reference
     */
    public NotesTags(String alias) {
        this(DSL.name(alias), NOTES_TAGS_ENTITY);
    }

    /**
     * Create an aliased <code>public.notes_tags</code> table reference
     */
    public NotesTags(Name alias) {
        this(alias, NOTES_TAGS_ENTITY);
    }

    /**
     * Create a <code>public.notes_tags</code> table reference
     */
    public NotesTags() {
        this(DSL.name("notes_tags"), null);
    }

    public <O extends Record> NotesTags(Table<O> child, ForeignKey<O, NotesTagsRecord> key) {
        super(child, key, NOTES_TAGS_ENTITY);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public UniqueKey<NotesTagsRecord> getPrimaryKey() {
        return Keys.NOTES_TAGS_PKEY;
    }

    @Override
    public List<ForeignKey<NotesTagsRecord, ?>> getReferences() {
        return Arrays.asList(Keys.NOTES_TAGS__NOTES_TAGS_NOTE_ID_FKEY, Keys.NOTES_TAGS__NOTES_TAGS_TAG_ID_FKEY);
    }

    private transient Note _note;
    private transient NoteTag _noteTag;

    /**
     * Get the implicit join path to the <code>public.note</code> table.
     */
    public Note note() {
        if (_note == null)
            _note = new Note(this, Keys.NOTES_TAGS__NOTES_TAGS_NOTE_ID_FKEY);

        return _note;
    }

    /**
     * Get the implicit join path to the <code>public.note_tag</code> table.
     */
    public NoteTag noteTag() {
        if (_noteTag == null)
            _noteTag = new NoteTag(this, Keys.NOTES_TAGS__NOTES_TAGS_TAG_ID_FKEY);

        return _noteTag;
    }

    @Override
    public NotesTags as(String alias) {
        return new NotesTags(DSL.name(alias), this);
    }

    @Override
    public NotesTags as(Name alias) {
        return new NotesTags(alias, this);
    }

    @Override
    public NotesTags as(Table<?> alias) {
        return new NotesTags(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public NotesTags rename(String name) {
        return new NotesTags(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public NotesTags rename(Name name) {
        return new NotesTags(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public NotesTags rename(Table<?> name) {
        return new NotesTags(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<UUID, UUID> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function2<? super UUID, ? super UUID, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function2<? super UUID, ? super UUID, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
