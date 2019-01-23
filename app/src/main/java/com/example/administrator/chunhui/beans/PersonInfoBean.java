package com.example.administrator.chunhui.beans;

public class PersonInfoBean {

    /**
     * code : 0
     * message : 登录成功
     * data : {"birthday":"2018-04-19","headImagePath":null,"nickname":null,"personalProfile":"哈哈哈哈哈","phone":"18301413850","professionId":"2188e7113b0411e8b64c00163e30445d","professionName":"学生","sex":"女","userId":"d56ea66e7ee741f498ca51242c8c6394"}
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
         * birthday : 2018-04-19
         * headImagePath : null
         * nickname : null
         * personalProfile : 哈哈哈哈哈
         * phone : 18301413850
         * professionId : 2188e7113b0411e8b64c00163e30445d
         * professionName : 学生
         * sex : 女
         * userId : d56ea66e7ee741f498ca51242c8c6394
         */

        private String birthday;
        private Object headImagePath;
        private Object nickname;
        private String personalProfile;
        private String phone;
        private String professionId;
        private String professionName;
        private String sex;
        private String userId;

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public Object getHeadImagePath() {
            return headImagePath;
        }

        public void setHeadImagePath(Object headImagePath) {
            this.headImagePath = headImagePath;
        }

        public Object getNickname() {
            return nickname;
        }

        public void setNickname(Object nickname) {
            this.nickname = nickname;
        }

        public String getPersonalProfile() {
            return personalProfile;
        }

        public void setPersonalProfile(String personalProfile) {
            this.personalProfile = personalProfile;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getProfessionId() {
            return professionId;
        }

        public void setProfessionId(String professionId) {
            this.professionId = professionId;
        }

        public String getProfessionName() {
            return professionName;
        }

        public void setProfessionName(String professionName) {
            this.professionName = professionName;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }
}
