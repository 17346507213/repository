package com.book.entity;

import java.io.Serializable;

/**
 * 图书作者信息表
 * @author lilei 
 *
 */
public class BooksAuthor implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
    //作者名称
    private String authorName;
    //性别
    private String authorSex;
    //国籍
    private String authorNationality;
    //简介
    private String authorProfile;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorSex() {
        return authorSex;
    }

    public void setAuthorSex(String authorSex) {
        this.authorSex = authorSex;
    }

    public String getAuthorNationality() {
        return authorNationality;
    }

    public void setAuthorNationality(String authorNationality) {
        this.authorNationality = authorNationality;
    }

    public String getAuthorProfile() {
        return authorProfile;
    }

    public void setAuthorProfile(String authorProfile) {
        this.authorProfile = authorProfile;
    }
}