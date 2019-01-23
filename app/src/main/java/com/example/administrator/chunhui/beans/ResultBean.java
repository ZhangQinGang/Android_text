package com.example.administrator.chunhui.beans;

import java.util.List;

public class ResultBean {


    /**
     * code : 0
     * message : 成功
     * data : {"tagList":[{"id":"e49222bf3b0611e8b64c00163e30445d","tag":"通航展论"}],"cursor":"3"}
     */

    private int code;
    private String message;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * tagList : [{"id":"e49222bf3b0611e8b64c00163e30445d","tag":"通航展论"}]
         * cursor : 3
         */

        private String cursor;
        private List<TagListBean> tagList;

        public String getCursor() {
            return cursor;
        }

        public void setCursor(String cursor) {
            this.cursor = cursor;
        }

        public List<TagListBean> getTagList() {
            return tagList;
        }

        public void setTagList(List<TagListBean> tagList) {
            this.tagList = tagList;
        }

        public static class TagListBean {
            /**
             * id : e49222bf3b0611e8b64c00163e30445d
             * tag : 通航展论
             */

            private String id;
            private String tag;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTag() {
                return tag;
            }

            public void setTag(String tag) {
                this.tag = tag;
            }
        }
    }
}
