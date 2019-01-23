package com.example.administrator.chunhui.beans;

import java.io.Serializable;
import java.util.List;

public class ListNewsBean {

    /**
     * code : 0
     * message : 成功
     * data : {"newsChannelList":[{"channelId":"b93dcb5d3b0211e8b64c00163e30445d","channelName":"飞行运动"}]}
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
        private List<NewsChannelListBean> newsChannelList;

        public List<NewsChannelListBean> getNewsChannelList() {
            return newsChannelList;
        }

        public void setNewsChannelList(List<NewsChannelListBean> newsChannelList) {
            this.newsChannelList = newsChannelList;
        }

        /**
         *
         */
        public static class NewsChannelListBean implements Serializable{
            /**
             * channelId : b93dcb5d3b0211e8b64c00163e30445d
             * channelName : 飞行运动
             */

            private String channelId;
            private String channelName;

            public String getChannelId() {
                return channelId;
            }

            public void setChannelId(String channelId) {
                this.channelId = channelId;
            }

            public String getChannelName() {
                return channelName;
            }

            public void setChannelName(String channelName) {
                this.channelName = channelName;
            }
        }
    }
}
