package team_management;

import team_management.model.Player;
import team_management.service.PlayerService;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        PlayerService playerService = new PlayerService();

        // 1GK - 4DF - 4MF - 2FW
        // 1GK - 4DF - 3MF - 3FW
        // 1GK - 3DF - 5MF - 2FW
        ArrayList<Player> players = playerService.buildTeam(1, 4, 4, 2);

        for (Player p: players) {
            System.out.println(p);
        }
    }
}
