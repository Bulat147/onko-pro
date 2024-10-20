/*
 * This file is generated by jOOQ.
 */
package ru.onko.model.jooq.tables;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function7;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row7;
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
import ru.onko.model.jooq.tables.records.NoteRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Note extends TableImpl<NoteRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.note</code>
     */
    public static final Note NOTE_ENTITY = new Note();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<NoteRecord> getRecordType() {
        return NoteRecord.class;
    }

    /**
     * The column <code>public.note.id</code>.
     */
    public final TableField<NoteRecord, UUID> ID = createField(DSL.name("id"), SQLDataType.UUID.nullable(false).defaultValue(DSL.field(DSL.raw("uuid_generate_v4()"), SQLDataType.UUID)), this, "");

    /**
     * The column <code>public.note.account_id</code>.
     */
    public final TableField<NoteRecord, UUID> ACCOUNT_ID = createField(DSL.name("account_id"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.note.name</code>.
     */
    public final TableField<NoteRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(32), this, "");

    /**
     * The column <code>public.note.treatment</code>.
     */
    public final TableField<NoteRecord, String> TREATMENT = createField(DSL.name("treatment"), SQLDataType.VARCHAR(512), this, "");

    /**
     * The column <code>public.note.content</code>.
     */
    public final TableField<NoteRecord, String> CONTENT = createField(DSL.name("content"), SQLDataType.VARCHAR(512), this, "");

    /**
     * The column <code>public.note.created_date</code>.
     */
    public final TableField<NoteRecord, LocalDateTime> CREATED_DATE = createField(DSL.name("created_date"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field(DSL.raw("now()"), SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.note.updated_date</code>.
     */
    public final TableField<NoteRecord, LocalDateTime> UPDATED_DATE = createField(DSL.name("updated_date"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field(DSL.raw("now()"), SQLDataType.LOCALDATETIME)), this, "");

    private Note(Name alias, Table<NoteRecord> aliased) {
        this(alias, aliased, null);
    }

    private Note(Name alias, Table<NoteRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.note</code> table reference
     */
    public Note(String alias) {
        this(DSL.name(alias), NOTE_ENTITY);
    }

    /**
     * Create an aliased <code>public.note</code> table reference
     */
    public Note(Name alias) {
        this(alias, NOTE_ENTITY);
    }

    /**
     * Create a <code>public.note</code> table reference
     */
    public Note() {
        this(DSL.name("note"), null);
    }

    public <O extends Record> Note(Table<O> child, ForeignKey<O, NoteRecord> key) {
        super(child, key, NOTE_ENTITY);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public UniqueKey<NoteRecord> getPrimaryKey() {
        return Keys.NOTE_PKEY;
    }

    @Override
    public List<ForeignKey<NoteRecord, ?>> getReferences() {
        return Arrays.asList(Keys.NOTE__NOTE_ACCOUNT_ID_FKEY);
    }

    private transient Account _account;

    /**
     * Get the implicit join path to the <code>public.account</code> table.
     */
    public Account account() {
        if (_account == null)
            _account = new Account(this, Keys.NOTE__NOTE_ACCOUNT_ID_FKEY);

        return _account;
    }

    @Override
    public Note as(String alias) {
        return new Note(DSL.name(alias), this);
    }

    @Override
    public Note as(Name alias) {
        return new Note(alias, this);
    }

    @Override
    public Note as(Table<?> alias) {
        return new Note(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Note rename(String name) {
        return new Note(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Note rename(Name name) {
        return new Note(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Note rename(Table<?> name) {
        return new Note(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row7 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row7<UUID, UUID, String, String, String, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function7<? super UUID, ? super UUID, ? super String, ? super String, ? super String, ? super LocalDateTime, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function7<? super UUID, ? super UUID, ? super String, ? super String, ? super String, ? super LocalDateTime, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
