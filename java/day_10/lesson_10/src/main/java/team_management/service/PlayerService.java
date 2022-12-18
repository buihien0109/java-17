package team_management.service;

import team_management.model.Player;
import team_management.model.Position;

import java.util.ArrayList;
import java.util.Random;

public class PlayerService {
    private ArrayList<Player> players;

    public PlayerService() {
        init();
    }

    // Khởi tạo danh sách cầu thủ
    private void init() {
        players = new ArrayList<>();
        // Các cầu thủ thuộc vị trí thủ môn
        players.add(new Player(1, "Bùi Tấn Trường", Position.GK));
        players.add(new Player(2, "Đặng Văn Lâm", Position.GK));
        players.add(new Player(3, "Nguyễn Văn Hoàng", Position.GK));
        players.add(new Player(4, "Quan Văn Chuẩn", Position.GK));

        // Các cầu thủ thuộc vị trí hậu vệ
        players.add(new Player(5, "Đỗ Duy Mạnh", Position.DF));
        players.add(new Player(6, "Nguyễn Thành Chung", Position.DF));
        players.add(new Player(7, "Trần Đình Trọng", Position.DF));
        players.add(new Player(8, "Nguyễn Phong Hồng Duy", Position.DF));
        players.add(new Player(9, "Vũ Văn Thanh", Position.DF));
        players.add(new Player(10, "Bùi Tiến Dũng", Position.DF));
        players.add(new Player(11, "Quế Ngọc Hải", Position.DF));
        players.add(new Player(12, "Hồ Tấn Tài", Position.DF));
        players.add(new Player(13, "Phạm Xuân Mạnh", Position.DF));
        players.add(new Player(14, "Đỗ Thanh Thịnh", Position.DF));

        // Các cầu thủ thuộc vị trí tiền vệ
        players.add(new Player(15, "Nguyễn Quang Hải", Position.MF));
        players.add(new Player(16, "Phạm Đức Huy", Position.MF));
        players.add(new Player(17, "Lương Xuân Trường", Position.MF));
        players.add(new Player(18, "Nguyễn Tuấn Anh", Position.MF));
        players.add(new Player(19, "Trần Minh Vương", Position.MF));
        players.add(new Player(20, "Phan Văn Đức", Position.MF));
        players.add(new Player(21, "Nguyễn Hoàng Đức", Position.MF));
        players.add(new Player(22, "Lý Công Hoàng Anh", Position.MF));

        // Các cầu thủ thuộc vị trí tiền đạo
        players.add(new Player(23, "Phạm Tuấn Hải", Position.FW));
        players.add(new Player(24, "Nguyễn Văn Toàn", Position.FW));
        players.add(new Player(25, "Nguyễn Công Phượng", Position.FW));
        players.add(new Player(26, "Hà Đức Chinh", Position.FW));
        players.add(new Player(27, "Nguyễn Tiến Linh", Position.FW));
    }

    // 1GK - 4DF - 4MF - 2FW
    // 1GK - 4DF - 3MF - 3FW
    // 1GK - 3DF - 5MF - 2FW
    // Tạo danh sách cầu thủ với số lượng cầu thủ mỗi vị trí đã được chỉ định sẵn
    public ArrayList<Player> buildTeam(int GKNumber, int DFNumber, int MFNumber, int FWNumber) {
        // Code thực thi
        ArrayList<Player> selectedPlayers = new ArrayList<>();
        selectedPlayers.addAll(getPlayers(Position.GK, GKNumber));
        selectedPlayers.addAll(getPlayers(Position.DF, DFNumber));
        selectedPlayers.addAll(getPlayers(Position.MF, MFNumber));
        selectedPlayers.addAll(getPlayers(Position.FW, FWNumber));

        return selectedPlayers;
    }

    // Phương thức lấy số lượng cầu thủ bất kỳ thuộc vị trí được chỉ định
    private ArrayList<Player> getPlayers(Position position, int number) {
        // Code thực thi
        ArrayList<Player> selectedPlayers = new ArrayList<>();
        int count = 0;

        Random rd = new Random();

        while (count < number) {
            // Random ra 1 player ngẫu nhiên
            int rdIndex = rd.nextInt(players.size());
            Player rdPlayer = players.get(rdIndex);

            // Nếu player được random có cùng vị trí và chưa ở trong danh sách => thêm vào danh sách
            if (rdPlayer.getPosition().equals(position) && !selectedPlayers.contains(rdPlayer)) {
                selectedPlayers.add(rdPlayer);
                count++;
            }
        }
        return selectedPlayers;
    }
}
