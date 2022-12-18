package team_management.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Player {
    private int number;
    private String name;
    private Position position;
}
