package springcrm.data;

public class Customer {
    private int c_id;

    public Customer(int c_id) {
        this.c_id = c_id;
    }

    private String name;

    @Override
    public String toString() {
        return "Customer{" +
                "c_id=" + c_id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    private String email;

    public Customer(int c_id, String name, String email) {
        super();
        this.c_id = c_id;
        this.name = name;
        this.email = email;
    }

    public Customer() {
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
