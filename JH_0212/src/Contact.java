public class Contact {
    String name;
    String surname;
    String tel;
    String email;

    String address;

    public Contact(String name, String surname, String tel, String email, String address) {
        this.name = name;
        this.surname = surname;
        this.tel = tel;
        this.email = email;
        this.address = address;
    }

    @Override
    public String toString() {
        return name + " " + surname + " " + tel + " " + address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
