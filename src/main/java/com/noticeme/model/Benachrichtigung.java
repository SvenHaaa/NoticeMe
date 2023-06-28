package com.noticeme.model;

import com.noticeme.common.DateTimeConverter;

import java.time.LocalDateTime;

public class Benachrichtigung extends Note {

    private LocalDateTime notifyWhen;

    public Benachrichtigung() {
    }

    public Benachrichtigung(String title, String note, LocalDateTime date, String where, LocalDateTime notifyWhen) {
        super(title, note, date, where);
        setWhenNotify(notifyWhen);
    }

    public void update(Benachrichtigung newEntity) {
        super.update((Note) newEntity);
        this.notifyWhen = newEntity.notifyWhen;
    }

    private void setWhenNotify(LocalDateTime notifyWhen) {
        if (notifyWhen == null) {
            this.notifyWhen = getDate().minusDays(1L);
        } else {
            this.notifyWhen = notifyWhen;
        }
    }

    public LocalDateTime getNotifyWhen() {
        return notifyWhen;
    }

    public String getNotifyWhenAsString() {
        return notifyWhen.format(DateTimeConverter.DATE_TIME_FORMATTER);
    }
}
