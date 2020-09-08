package ice.man.demo;

public class UserInfo {

        String url = "jdbc:mysql://49.235.38.160:3306/icemancrem";
        String user_name = "root";
        String psd = "Yaochen11";
        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getPsd() {
            return psd;
        }

        public void setPsd(String psd) {
            this.psd = psd;
        }
}
