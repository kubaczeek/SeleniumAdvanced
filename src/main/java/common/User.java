package common;

public final class User {

    private String socialTitle;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String dateOfBirth;
    private String address;
    private String city;
    private String zipCode;
    private String country;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

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

    public static class UserBuilder {

        private String socialTitle;
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private String dateOfBirth;
        private String address;
        private String city;
        private String zipCode;
        private String country;

        public UserBuilder(User user) {
            this.socialTitle = user.socialTitle;
            this.firstName = user.firstName;
            this.lastName = user.lastName;
            this.email = user.email;
            this.password = user.password;
            this.dateOfBirth = user.dateOfBirth;
            this.address = user.address;
            this.city = user.city;
            this.zipCode = user.zipCode;
            this.country = user.country;
        }

        public UserBuilder() {

        }

        public UserBuilder country(String country) {
            this.country = country;
            return this;
        }

        public UserBuilder zipCode(String zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }

        public UserBuilder city(String city) {
            this.city = city;
            return this;
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
            user.firstName = this.firstName;
            user.email = this.email;
            user.lastName = this.lastName;
            user.password = this.password;
            user.dateOfBirth = this.dateOfBirth;
            user.socialTitle = this.socialTitle;
            user.address = this.address;
            user.city = this.city;
            user.zipCode = this.zipCode;
            user.country = this.country;
            return user;
        }
    }
}
