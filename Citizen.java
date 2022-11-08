public class Citizen
{
    private String name;
    private String IC;
    private String state;
    private int age;
    private String category;
    private String vaccinedose1;
    private String vaccinedose2;
    private String vaccinecertification;

    //Constructor without parameter
    public Citizen()
    {
        name = " ";
        IC = " ";
        state = " ";
        age = 0;
        category = " ";
        vaccinedose1 = null;
        vaccinedose2 = null;
    }

    //Constructor with parameter
    public Citizen(String n, String ic, String s, int a, String c, String d1, String d2, String complete)
    {
        name = n;
        IC = ic;
        state = s;
        age = a;
        category = c;
        vaccinedose1 = d1;
        vaccinedose2 = d2;
        vaccinecertification = complete;
    }

    //Mutator and Accessor
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIC() {
        return IC;
    }

    public void setIC(String iC) {
        IC = iC;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getvaccinedose1() {
        return vaccinedose1;
    }

    public void setvaccinedose1(String vaccinedose1) {
        this.vaccinedose1 = vaccinedose1;
    }

    public String getvaccinedose2() {
        return vaccinedose2;
    }

    public void setvaccinedose2(String vaccinedose2) {
        this.vaccinedose2 = vaccinedose2;
    }

    public String getvaccinecertification() {
        return vaccinecertification;
    }

    public void setvaccinecertification(String vaccinecertification) {
        this.vaccinecertification = vaccinecertification;
    }

    //toString()
    @Override
    public String toString() {
        return String.format(" \t  | %15s | %11s | %20s | %5s | %10s | %15s | %15s | %23s | %n" , name, IC, state , age , category , vaccinedose1 , vaccinedose2 , vaccinecertification );
    }


}