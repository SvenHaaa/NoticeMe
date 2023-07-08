package com.noticeme.model;

import com.noticeme.common.DateTimeConverter;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "note")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title, notiz;
    private LocalDateTime date;
    private String where;

    public Note() {
    }

    public Note(String title, String notiz) {
        this.title = title;
        this.notiz = notiz;
        setDate();
    }

    public Note(String title, String notiz, LocalDateTime date) {
        this(title, notiz);
        setDate(date);
    }

    public Note(String title, String notiz, LocalDateTime date, String where) {
        this.title = title;
        this.notiz = notiz;
        setDate(date);
        this.where = where;
    }

    public String getUhrzeit() {
        int currentHour = date.getHour(), currentMinute = date.getMinute();
        StringBuilder sb = new StringBuilder();
        if (currentHour <= 9) {
            sb.append("0");
        }
        sb.append(currentHour).append(":");
        if (currentMinute <= 9) {
            sb.append("0");
        }
        return sb.append(currentMinute).toString();
    }

    public Long getId() {
        return this.id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNotiz(String notiz) {
        this.notiz = notiz;
    }

    public String getDateFormatted() {
        return date.format(DateTimeConverter.DATE_TIME_FORMATTER);
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate() {
        this.date = LocalDateTime.now();
    }

    public void setDate(LocalDateTime date) {
        setCorrectedDateTime(date);
    }

    private void setCorrectedDateTime(LocalDateTime date) {
        if (date == null) {
            this.date = LocalDateTime.now();
        } else {
            this.date = date;
        }
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public String getTitle() {
        return title;
    }

    public String getNotiz() {
        return notiz;
    }

    public String getWhere() {
        return where;
    }

    public void update(Note newEnity) {
        this.title = newEnity.title;
        this.notiz = newEnity.notiz;
        this.date = newEnity.date;
        this.where = newEnity.where;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.title);
        hash = 37 * hash + Objects.hashCode(this.date);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Note)){
            return false;
        }
        Note other = (Note) obj;


        return Objects.equals(this.title, other.title)
                && Objects.equals(this.date, other.date)
                && Objects.equals(this.notiz, other.notiz)
                && Objects.equals(this.where, other.where);
    }
}