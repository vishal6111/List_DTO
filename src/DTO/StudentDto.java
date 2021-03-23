package DTO;

public class StudentDto {

    private int id;
    private String name;
    private String age;

    /**
     * Argument Constructor
     * @param id : id
     * @param name : name
     * @param age :age
     */
    public StudentDto(int id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = ages;
    }

    /**
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @return age
     */
    public String getAge() {
        return age;
    }

    /**
     * @param id : id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param name :name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param age : age
     */
    public void setAge(String age) {
        this.age = age;
    }

}
