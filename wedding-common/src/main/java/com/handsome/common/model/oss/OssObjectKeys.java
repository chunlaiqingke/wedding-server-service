package com.handsome.common.model.oss;

public class OssObjectKeys {

    private String prefix;

    private String key;

    public OssObjectKeys(){}

    public OssObjectKeys(String prefix, String key){
        this.prefix = prefix;
        this.key = key;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
