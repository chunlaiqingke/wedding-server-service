package com.handsome.images.bean;

import java.util.Date;

public class Image {

    private Integer id;
    private Integer userId;
    private String prefix;
    private String fileName;
    private String thumbnailPrefix;
    private String thumbnail;
    private Integer tagId;
    private Date createTime;
    private Date lastModifyTime;

    public Image(){}

    public Image(Integer userId, String prefix, String fileName, String thumbnailPrefix, String thumbnail, Integer tagId){
        this.userId = userId;
        this.prefix = prefix;
        this.fileName = fileName;
        this.thumbnailPrefix = thumbnailPrefix;
        this.thumbnail = thumbnail;
        this.tagId = tagId;
    }

    public String getThumbnailPrefix() {
        return thumbnailPrefix;
    }

    public void setThumbnailPrefix(String thumbnailPrefix) {
        this.thumbnailPrefix = thumbnailPrefix;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }
}
