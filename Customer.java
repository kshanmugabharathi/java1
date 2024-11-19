import java.io.Serializable;

public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String email;
    private String phone;
    private boolean isRegular;
    private int rewardsPoints;

    public Customer(String name, String email, String phone, boolean isRegular) {
        this(name, email, phone, isRegular, isRegular ? 100 : 0); 
    }

    public Customer(String name, String email, String phone, boolean isRegular, int rewardsPoints) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.isRegular = isRegular;
        this.rewardsPoints = rewardsPoints;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public boolean isRegular() {
        return isRegular;
    }

    public int getRewardsPoints() {
        return rewardsPoints;
    }

    public void addRewardsPoints(int points) {
        if (isRegular) {
            rewardsPoints += points;
        }
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", isRegular=" + isRegular +
                ", rewardsPoints=" + rewardsPoints +
                '}';
    }
}
