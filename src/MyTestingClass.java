public class MyTestingClass {
    private int id;
    private String name;

    public MyTestingClass(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() { return id;}
    public String getName(){ return name;}
    @Override
    public String toString() { return "MyTestingClass{" + id + "id=" + id + ", name=" + name + '\'' + '}';}
    public int hashCode(){
        int hash = 17;
        hash = hash * 31 + id;
        hash = 31 * hash + name.hashCode();
        return hash;
    }
}
