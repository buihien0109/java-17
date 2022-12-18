package dependence_demo;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Person {
    private int id;
    private String name;
    private String email;
}
