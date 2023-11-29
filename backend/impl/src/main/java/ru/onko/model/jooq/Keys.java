/*
 * This file is generated by jOOQ.
 */
package ru.onko.model.jooq;


import org.jooq.ForeignKey;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;

import ru.onko.model.jooq.tables.Account;
import ru.onko.model.jooq.tables.AccountRoles;
import ru.onko.model.jooq.tables.Article;
import ru.onko.model.jooq.tables.ArticlePhotos;
import ru.onko.model.jooq.tables.FavoriteArticles;
import ru.onko.model.jooq.tables.Note;
import ru.onko.model.jooq.tables.NoteTag;
import ru.onko.model.jooq.tables.NotesSymptoms;
import ru.onko.model.jooq.tables.NotesTags;
import ru.onko.model.jooq.tables.Photo;
import ru.onko.model.jooq.tables.Symptom;
import ru.onko.model.jooq.tables.records.AccountRecord;
import ru.onko.model.jooq.tables.records.AccountRolesRecord;
import ru.onko.model.jooq.tables.records.ArticlePhotosRecord;
import ru.onko.model.jooq.tables.records.ArticleRecord;
import ru.onko.model.jooq.tables.records.FavoriteArticlesRecord;
import ru.onko.model.jooq.tables.records.NoteRecord;
import ru.onko.model.jooq.tables.records.NoteTagRecord;
import ru.onko.model.jooq.tables.records.NotesSymptomsRecord;
import ru.onko.model.jooq.tables.records.NotesTagsRecord;
import ru.onko.model.jooq.tables.records.PhotoRecord;
import ru.onko.model.jooq.tables.records.SymptomRecord;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AccountRecord> ACCOUNT_EMAIL_KEY = Internal.createUniqueKey(Account.ACCOUNT_ENTITY, DSL.name("account_email_key"), new TableField[] { Account.ACCOUNT_ENTITY.EMAIL }, true);
    public static final UniqueKey<AccountRecord> ACCOUNT_PKEY = Internal.createUniqueKey(Account.ACCOUNT_ENTITY, DSL.name("account_pkey"), new TableField[] { Account.ACCOUNT_ENTITY.ID }, true);
    public static final UniqueKey<AccountRolesRecord> ACCOUNT_ROLES_PKEY = Internal.createUniqueKey(AccountRoles.ACCOUNT_ROLES_ENTITY, DSL.name("account_roles_pkey"), new TableField[] { AccountRoles.ACCOUNT_ROLES_ENTITY.ACCOUNT_ID, AccountRoles.ACCOUNT_ROLES_ENTITY.ACCOUNT_ROLE }, true);
    public static final UniqueKey<ArticleRecord> ARTICLE_PKEY = Internal.createUniqueKey(Article.ARTICLE_ENTITY, DSL.name("article_pkey"), new TableField[] { Article.ARTICLE_ENTITY.ID }, true);
    public static final UniqueKey<ArticlePhotosRecord> ARTICLE_PHOTOS_PKEY = Internal.createUniqueKey(ArticlePhotos.ARTICLE_PHOTOS_ENTITY, DSL.name("article_photos_pkey"), new TableField[] { ArticlePhotos.ARTICLE_PHOTOS_ENTITY.ARTICLE_ID, ArticlePhotos.ARTICLE_PHOTOS_ENTITY.PHOTO_ID }, true);
    public static final UniqueKey<FavoriteArticlesRecord> FAVORITE_ARTICLES_PKEY = Internal.createUniqueKey(FavoriteArticles.FAVORITE_ARTICLES_ENTITY, DSL.name("favorite_articles_pkey"), new TableField[] { FavoriteArticles.FAVORITE_ARTICLES_ENTITY.ACCOUNT_ID, FavoriteArticles.FAVORITE_ARTICLES_ENTITY.ARTICLE_ID }, true);
    public static final UniqueKey<NoteRecord> NOTE_PKEY = Internal.createUniqueKey(Note.NOTE_ENTITY, DSL.name("note_pkey"), new TableField[] { Note.NOTE_ENTITY.ID }, true);
    public static final UniqueKey<NoteTagRecord> NOTE_TAG_PKEY = Internal.createUniqueKey(NoteTag.NOTE_TAG_ENTITY, DSL.name("note_tag_pkey"), new TableField[] { NoteTag.NOTE_TAG_ENTITY.ID }, true);
    public static final UniqueKey<NotesSymptomsRecord> NOTES_SYMPTOMS_PKEY = Internal.createUniqueKey(NotesSymptoms.NOTES_SYMPTOMS_ENTITY, DSL.name("notes_symptoms_pkey"), new TableField[] { NotesSymptoms.NOTES_SYMPTOMS_ENTITY.NOTE_ID, NotesSymptoms.NOTES_SYMPTOMS_ENTITY.SYMPTOM_ID }, true);
    public static final UniqueKey<NotesTagsRecord> NOTES_TAGS_PKEY = Internal.createUniqueKey(NotesTags.NOTES_TAGS_ENTITY, DSL.name("notes_tags_pkey"), new TableField[] { NotesTags.NOTES_TAGS_ENTITY.NOTE_ID, NotesTags.NOTES_TAGS_ENTITY.TAG_ID }, true);
    public static final UniqueKey<PhotoRecord> PHOTO_NAME_KEY = Internal.createUniqueKey(Photo.PHOTO_ENTITY, DSL.name("photo_name_key"), new TableField[] { Photo.PHOTO_ENTITY.NAME }, true);
    public static final UniqueKey<PhotoRecord> PHOTO_PKEY = Internal.createUniqueKey(Photo.PHOTO_ENTITY, DSL.name("photo_pkey"), new TableField[] { Photo.PHOTO_ENTITY.ID }, true);
    public static final UniqueKey<SymptomRecord> SYMPTOM_PKEY = Internal.createUniqueKey(Symptom.SYMPTOM_ENTITY, DSL.name("symptom_pkey"), new TableField[] { Symptom.SYMPTOM_ENTITY.ID }, true);

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<AccountRecord, PhotoRecord> ACCOUNT__ACCOUNT_PHOTO_ID_FKEY = Internal.createForeignKey(Account.ACCOUNT_ENTITY, DSL.name("account_photo_id_fkey"), new TableField[] { Account.ACCOUNT_ENTITY.PHOTO_ID }, Keys.PHOTO_PKEY, new TableField[] { Photo.PHOTO_ENTITY.ID }, true);
    public static final ForeignKey<AccountRolesRecord, AccountRecord> ACCOUNT_ROLES__ACCOUNT_ROLES_ACCOUNT_ID_FKEY = Internal.createForeignKey(AccountRoles.ACCOUNT_ROLES_ENTITY, DSL.name("account_roles_account_id_fkey"), new TableField[] { AccountRoles.ACCOUNT_ROLES_ENTITY.ACCOUNT_ID }, Keys.ACCOUNT_PKEY, new TableField[] { Account.ACCOUNT_ENTITY.ID }, true);
    public static final ForeignKey<ArticleRecord, AccountRecord> ARTICLE__ARTICLE_ACCOUNT_ID_FKEY = Internal.createForeignKey(Article.ARTICLE_ENTITY, DSL.name("article_account_id_fkey"), new TableField[] { Article.ARTICLE_ENTITY.ACCOUNT_ID }, Keys.ACCOUNT_PKEY, new TableField[] { Account.ACCOUNT_ENTITY.ID }, true);
    public static final ForeignKey<ArticlePhotosRecord, ArticleRecord> ARTICLE_PHOTOS__ARTICLE_PHOTOS_ARTICLE_ID_FKEY = Internal.createForeignKey(ArticlePhotos.ARTICLE_PHOTOS_ENTITY, DSL.name("article_photos_article_id_fkey"), new TableField[] { ArticlePhotos.ARTICLE_PHOTOS_ENTITY.ARTICLE_ID }, Keys.ARTICLE_PKEY, new TableField[] { Article.ARTICLE_ENTITY.ID }, true);
    public static final ForeignKey<ArticlePhotosRecord, PhotoRecord> ARTICLE_PHOTOS__ARTICLE_PHOTOS_PHOTO_ID_FKEY = Internal.createForeignKey(ArticlePhotos.ARTICLE_PHOTOS_ENTITY, DSL.name("article_photos_photo_id_fkey"), new TableField[] { ArticlePhotos.ARTICLE_PHOTOS_ENTITY.PHOTO_ID }, Keys.PHOTO_PKEY, new TableField[] { Photo.PHOTO_ENTITY.ID }, true);
    public static final ForeignKey<FavoriteArticlesRecord, AccountRecord> FAVORITE_ARTICLES__FAVORITE_ARTICLES_ACCOUNT_ID_FKEY = Internal.createForeignKey(FavoriteArticles.FAVORITE_ARTICLES_ENTITY, DSL.name("favorite_articles_account_id_fkey"), new TableField[] { FavoriteArticles.FAVORITE_ARTICLES_ENTITY.ACCOUNT_ID }, Keys.ACCOUNT_PKEY, new TableField[] { Account.ACCOUNT_ENTITY.ID }, true);
    public static final ForeignKey<FavoriteArticlesRecord, ArticleRecord> FAVORITE_ARTICLES__FAVORITE_ARTICLES_ARTICLE_ID_FKEY = Internal.createForeignKey(FavoriteArticles.FAVORITE_ARTICLES_ENTITY, DSL.name("favorite_articles_article_id_fkey"), new TableField[] { FavoriteArticles.FAVORITE_ARTICLES_ENTITY.ARTICLE_ID }, Keys.ARTICLE_PKEY, new TableField[] { Article.ARTICLE_ENTITY.ID }, true);
    public static final ForeignKey<NoteRecord, AccountRecord> NOTE__NOTE_ACCOUNT_ID_FKEY = Internal.createForeignKey(Note.NOTE_ENTITY, DSL.name("note_account_id_fkey"), new TableField[] { Note.NOTE_ENTITY.ACCOUNT_ID }, Keys.ACCOUNT_PKEY, new TableField[] { Account.ACCOUNT_ENTITY.ID }, true);
    public static final ForeignKey<NoteTagRecord, AccountRecord> NOTE_TAG__NOTE_TAG_ACCOUNT_ID_FKEY = Internal.createForeignKey(NoteTag.NOTE_TAG_ENTITY, DSL.name("note_tag_account_id_fkey"), new TableField[] { NoteTag.NOTE_TAG_ENTITY.ACCOUNT_ID }, Keys.ACCOUNT_PKEY, new TableField[] { Account.ACCOUNT_ENTITY.ID }, true);
    public static final ForeignKey<NotesSymptomsRecord, NoteRecord> NOTES_SYMPTOMS__NOTES_SYMPTOMS_NOTE_ID_FKEY = Internal.createForeignKey(NotesSymptoms.NOTES_SYMPTOMS_ENTITY, DSL.name("notes_symptoms_note_id_fkey"), new TableField[] { NotesSymptoms.NOTES_SYMPTOMS_ENTITY.NOTE_ID }, Keys.NOTE_PKEY, new TableField[] { Note.NOTE_ENTITY.ID }, true);
    public static final ForeignKey<NotesSymptomsRecord, SymptomRecord> NOTES_SYMPTOMS__NOTES_SYMPTOMS_SYMPTOM_ID_FKEY = Internal.createForeignKey(NotesSymptoms.NOTES_SYMPTOMS_ENTITY, DSL.name("notes_symptoms_symptom_id_fkey"), new TableField[] { NotesSymptoms.NOTES_SYMPTOMS_ENTITY.SYMPTOM_ID }, Keys.SYMPTOM_PKEY, new TableField[] { Symptom.SYMPTOM_ENTITY.ID }, true);
    public static final ForeignKey<NotesTagsRecord, NoteRecord> NOTES_TAGS__NOTES_TAGS_NOTE_ID_FKEY = Internal.createForeignKey(NotesTags.NOTES_TAGS_ENTITY, DSL.name("notes_tags_note_id_fkey"), new TableField[] { NotesTags.NOTES_TAGS_ENTITY.NOTE_ID }, Keys.NOTE_PKEY, new TableField[] { Note.NOTE_ENTITY.ID }, true);
    public static final ForeignKey<NotesTagsRecord, NoteTagRecord> NOTES_TAGS__NOTES_TAGS_TAG_ID_FKEY = Internal.createForeignKey(NotesTags.NOTES_TAGS_ENTITY, DSL.name("notes_tags_tag_id_fkey"), new TableField[] { NotesTags.NOTES_TAGS_ENTITY.TAG_ID }, Keys.NOTE_TAG_PKEY, new TableField[] { NoteTag.NOTE_TAG_ENTITY.ID }, true);
    public static final ForeignKey<SymptomRecord, AccountRecord> SYMPTOM__SYMPTOM_ACCOUNT_ID_FKEY = Internal.createForeignKey(Symptom.SYMPTOM_ENTITY, DSL.name("symptom_account_id_fkey"), new TableField[] { Symptom.SYMPTOM_ENTITY.ACCOUNT_ID }, Keys.ACCOUNT_PKEY, new TableField[] { Account.ACCOUNT_ENTITY.ID }, true);
}
