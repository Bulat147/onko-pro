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
import org.jooq.Function11;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row11;
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
import ru.onko.model.jooq.enums.AccountState;
import ru.onko.model.jooq.enums.Gender;
import ru.onko.model.jooq.tables.records.AccountRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Account extends TableImpl<AccountRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.account</code>
     */
    public static final Account ACCOUNT_ENTITY = new Account();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AccountRecord> getRecordType() {
        return AccountRecord.class;
    }

    /**
     * The column <code>public.account.id</code>.
     */
    public final TableField<AccountRecord, UUID> ID = createField(DSL.name("id"), SQLDataType.UUID.nullable(false).defaultValue(DSL.field(DSL.raw("uuid_generate_v4()"), SQLDataType.UUID)), this, "");

    /**
     * The column <code>public.account.email</code>.
     */
    public final TableField<AccountRecord, String> EMAIL = createField(DSL.name("email"), SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>public.account.hash_password</code>.
     */
    public final TableField<AccountRecord, String> HASH_PASSWORD = createField(DSL.name("hash_password"), SQLDataType.VARCHAR(72).nullable(false), this, "");

    /**
     * The column <code>public.account.state</code>.
     */
    public final TableField<AccountRecord, AccountState> STATE = createField(DSL.name("state"), SQLDataType.VARCHAR.nullable(false).defaultValue(DSL.field(DSL.raw("'NOT_CONFIRMED'::account_state"), SQLDataType.VARCHAR)).asEnumDataType(ru.onko.model.jooq.enums.AccountState.class), this, "");

    /**
     * The column <code>public.account.first_name</code>.
     */
    public final TableField<AccountRecord, String> FIRST_NAME = createField(DSL.name("first_name"), SQLDataType.VARCHAR(32).nullable(false), this, "");

    /**
     * The column <code>public.account.last_name</code>.
     */
    public final TableField<AccountRecord, String> LAST_NAME = createField(DSL.name("last_name"), SQLDataType.VARCHAR(32).nullable(false), this, "");

    /**
     * The column <code>public.account.gender</code>.
     */
    public final TableField<AccountRecord, Gender> GENDER = createField(DSL.name("gender"), SQLDataType.VARCHAR.nullable(false).asEnumDataType(ru.onko.model.jooq.enums.Gender.class), this, "");

    /**
     * The column <code>public.account.birth_date</code>.
     */
    public final TableField<AccountRecord, LocalDateTime> BIRTH_DATE = createField(DSL.name("birth_date"), SQLDataType.LOCALDATETIME(6), this, "");

    /**
     * The column <code>public.account.photo_id</code>.
     */
    public final TableField<AccountRecord, UUID> PHOTO_ID = createField(DSL.name("photo_id"), SQLDataType.UUID, this, "");

    /**
     * The column <code>public.account.created_date</code>.
     */
    public final TableField<AccountRecord, LocalDateTime> CREATED_DATE = createField(DSL.name("created_date"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field(DSL.raw("now()"), SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.account.updated_date</code>.
     */
    public final TableField<AccountRecord, LocalDateTime> UPDATED_DATE = createField(DSL.name("updated_date"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field(DSL.raw("now()"), SQLDataType.LOCALDATETIME)), this, "");

    private Account(Name alias, Table<AccountRecord> aliased) {
        this(alias, aliased, null);
    }

    private Account(Name alias, Table<AccountRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.account</code> table reference
     */
    public Account(String alias) {
        this(DSL.name(alias), ACCOUNT_ENTITY);
    }

    /**
     * Create an aliased <code>public.account</code> table reference
     */
    public Account(Name alias) {
        this(alias, ACCOUNT_ENTITY);
    }

    /**
     * Create a <code>public.account</code> table reference
     */
    public Account() {
        this(DSL.name("account"), null);
    }

    public <O extends Record> Account(Table<O> child, ForeignKey<O, AccountRecord> key) {
        super(child, key, ACCOUNT_ENTITY);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public UniqueKey<AccountRecord> getPrimaryKey() {
        return Keys.ACCOUNT_PKEY;
    }

    @Override
    public List<UniqueKey<AccountRecord>> getUniqueKeys() {
        return Arrays.asList(Keys.ACCOUNT_EMAIL_KEY);
    }

    @Override
    public List<ForeignKey<AccountRecord, ?>> getReferences() {
        return Arrays.asList(Keys.ACCOUNT__ACCOUNT_PHOTO_ID_FKEY);
    }

    private transient Photo _photo;

    /**
     * Get the implicit join path to the <code>public.photo</code> table.
     */
    public Photo photo() {
        if (_photo == null)
            _photo = new Photo(this, Keys.ACCOUNT__ACCOUNT_PHOTO_ID_FKEY);

        return _photo;
    }

    @Override
    public Account as(String alias) {
        return new Account(DSL.name(alias), this);
    }

    @Override
    public Account as(Name alias) {
        return new Account(alias, this);
    }

    @Override
    public Account as(Table<?> alias) {
        return new Account(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Account rename(String name) {
        return new Account(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Account rename(Name name) {
        return new Account(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Account rename(Table<?> name) {
        return new Account(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row11 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row11<UUID, String, String, AccountState, String, String, Gender, LocalDateTime, UUID, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row11) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function11<? super UUID, ? super String, ? super String, ? super AccountState, ? super String, ? super String, ? super Gender, ? super LocalDateTime, ? super UUID, ? super LocalDateTime, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function11<? super UUID, ? super String, ? super String, ? super AccountState, ? super String, ? super String, ? super Gender, ? super LocalDateTime, ? super UUID, ? super LocalDateTime, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
