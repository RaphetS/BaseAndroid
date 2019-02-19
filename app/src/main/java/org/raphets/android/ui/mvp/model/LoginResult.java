package org.raphets.android.ui.mvp.model;

public class LoginResult  {



    private DataBean data;
    private String message;
    private int status_code;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public static class DataBean {
        /**
         * token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjEzNTAsImlzcyI6Imh0dHA6Ly93d3cubWguY29tL2FwaS92Ml8xL2xvZ2luIiwiaWF0IjoxNTMyOTk5NzYyLCJleHAiOjE1NTQ1OTk3NjIsIm5iZiI6MTUzMjk5OTc2MiwianRpIjoiSXpveUN0NFFwd01VQUpnViJ9.Lo3AF5nHE__9gMWrEYgqre395-jGMPnOASxC8vpmD3U
         * user : {"id":1350,"nickname":"帅小货","realname":"谢良强","username":"17386031710"}
         */

        private String token;
        private UserBean user;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class UserBean {
            /**
             * id : 1350
             * nickname : 帅小货
             * realname : 谢良强
             * username : 17386031710
             */

            private String id;
            private String nickname;
            private String realname;
            private String username;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getRealname() {
                return realname;
            }

            public void setRealname(String realname) {
                this.realname = realname;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

        }
    }



}
