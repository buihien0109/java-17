package encapsulation_practice;

public class Student {
    private String id;
    private double avgPoint;
    private int age;
    private String className;

    public Student() {
    }

    public Student(String id, double avgPoint, int age, String className) {
        setId(id);
        setAvgPoint(avgPoint);
        setAge(age);
        setClassName(className);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if(id.length() != 8) {
            System.out.println("Độ dài id phải = 8");
            return;
        }
        this.id = id;
    }

    public double getAvgPoint() {
        return avgPoint;
    }

    public void setAvgPoint(double avgPoint) {
        if(avgPoint < 0 || avgPoint > 10) {
            System.out.println("avgPoint phải trong khoảng từ  0 -> 10");
            return;
        }
        this.avgPoint = avgPoint;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age < 18) {
            System.out.println("Tuổi phải > 18");
            return;
        }
        this.age = age;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        if(!className.startsWith("A") && !className.startsWith("C")) {
            System.out.println("Tên lớp phải bắt đầu bằng A hoặc C");
            return;
        }
        this.className = className;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", avgPoint=" + avgPoint +
                ", age=" + age +
                ", className='" + className + '\'' +
                '}';
    }

    public void showInfo() {
        System.out.println(this);
    }

    public void calculateScholarship() {
        if(avgPoint >= 8) {
            System.out.println("Nhận được học bổng");
        } else {
            System.out.println("Không nhận được học bổng");
        }
    }
}
