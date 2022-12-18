package interface_demo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Rectangle implements IShape, IOther {
    private double width;
    private double height;

    @Override
    public double getArea() {
        return this.width * this.height;
    }

    @Override
    public double getPerimeter() {
        return (this.width + this.height) * 2;
    }

    @Override
    public void sayHello() {
        System.out.println("I am rectangle");
    }

    @Override
    public void show() {
        System.out.println(this);
    }
}
