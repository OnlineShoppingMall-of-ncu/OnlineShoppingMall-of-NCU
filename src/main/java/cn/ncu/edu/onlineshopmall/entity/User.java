package cn.ncu.edu.onlineshopmall.entity;


public class User {
        private String username;
        private  String password;
        private int  role;
        private String sex;
        private String address;
        private String phone;
        private String name;
        private String idcard;

        public String getUsername() {
                return username;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public int getRole() {
                return role;
        }

        public void setRole(int role) {
                this.role = role;
        }

        public String getSex() {
                return sex;
        }

        public void setSex(String sex) {
                this.sex = sex;
        }

        public String getAddress() {
                return address;
        }

        public void setAddress(String address) {
                this.address = address;
        }

        public String getPhone() {
                return phone;
        }

        public void setPhone(String phone) {
                this.phone = phone;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getIdcard() {
                return idcard;
        }

        public void setIdcard(String idcard) {
                this.idcard = idcard;
        }
}
