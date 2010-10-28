package org.workhabit.drupal.api.entity;

import org.workhabit.drupal.api.annotations.IdFieldName;

/**
 * Copyright 2009 - WorkHabit, Inc. - acs
 * Date: Sep 24, 2010, 4:40:51 PM
 */
@SuppressWarnings({"UnusedDeclaration"})
@IdFieldName("cid")
public class DrupalComment {
    private int nid;
    private int cid;
    private int uid;
    private String title;
    private String body;

    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
