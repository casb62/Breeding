package entities;

public abstract class Person {
    
    private String id;
    private String name;
    private String addressId;
    private Integer farmId;
    private String password;
    private Boolean userValidated;

    public Person() {
    }

    public Person(String id, String name, String addressId, Integer farmId, String password, Boolean userValidated) {
        this.id = id;
        this.name = name;
        this.addressId = addressId;
        this.farmId = farmId;
        this.password = password;
        this.userValidated = userValidated;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public Integer getFarmId() {
        return farmId;
    }

    public void setFarmId(Integer farmId) {
        this.farmId = farmId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getUserValidated() {
        return userValidated;
    }

    public void setUserValidated(Boolean userValidated) {
        this.userValidated = userValidated;
    }
}