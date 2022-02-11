package common;

public final class User {

    private String socialTitle;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String dateOfBirth;

    public String getSocialTitle() {
        return socialTitle;
    }

    public void setSocialTitle(String socialTitle) {
        this.socialTitle = socialTitle;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

//    private User(UserBuilder builder) {
//        this.socialTitle = builder.socialTitle;
//        this.firstName = builder.firstName;
//        this.lastName = builder.lastName;
//        this.email = builder.email;
//        this.password = builder.password;
//        this.dateOfBirth = builder.dateOfBirth;
//    }

    public static class UserBuilder {

        private String socialTitle;
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private String dateOfBirth;

        public UserBuilder(User user) {
            this.socialTitle = user.socialTitle;
            this.firstName = user.firstName;
            this.lastName = user.lastName;
            this.email = user.email;
            this.password = user.password;
            this.dateOfBirth = user.dateOfBirth;
        }

        public UserBuilder() {

        }

        public UserBuilder socialTitle(String socialTitle) {
            this.socialTitle = socialTitle;
            return this;
        }

        public UserBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }


        public UserBuilder dateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public User build() {
            User user = new User();
            user.socialTitle = this.socialTitle;
            user.firstName = this.firstName;
            user.email = this.email;
            user.lastName = this.lastName;
            user.password = this.password;
            user.dateOfBirth = this.dateOfBirth;
            user.socialTitle = this.socialTitle;
            return user;
        }
    }
}
