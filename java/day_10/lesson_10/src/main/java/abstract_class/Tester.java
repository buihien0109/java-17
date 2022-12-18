package abstract_class;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Tester extends Employee {
    private int error;

    public Tester(int id, String name, int age, int salaryBasic, int error) {
        super(id, name, age, salaryBasic);
        this.error = error;
    }

    @Override
    public int calculateSalary() {
        return this.getSalaryBasic() + this.error * 50_000;
    }

    @Override
    void showInfo() {
        String message = String.format("id : %d, name : %s, age : %d, salaryBasic : %d, error : %d, salary : %d",
                this.getId(), this.getName(), this.getAge(), this.getSalaryBasic(), this.error, this.calculateSalary());
        System.out.println(message);
    }
}
