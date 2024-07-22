import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Room {
        private final ArrayList<String> player = new ArrayList<>();

        public void addPlayer(String player) {
            this.player.add(player);
        }

        public boolean checkLvl(int level) {
            int fPlayerLvl = Integer.parseInt(this.player.get(0).split(" ")[0]);
            return Math.abs(fPlayerLvl - level) <= 10;
        }

        public boolean isFull(int m) {
            return this.player.size() == m;
        }

        public void print() {
            this.player.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    String nameO1 = o1.split(" ")[1];
                    String nameO2 = o2.split(" ")[1];
                    return nameO1.compareTo(nameO2);
                }
            });
            for (String p : this.player) {
                System.out.println(p);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Room> rooms = new ArrayList<>();
        for (int i = 0; i < p; i++) {
            String player = br.readLine();

            st = new StringTokenizer(player);

            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            if (rooms.isEmpty()) {
                Room firstRoom = new Room();
                firstRoom.addPlayer(player);
                rooms.add(firstRoom);
            } else {
                boolean check = false;
                for (Room room : rooms) {
                    if (!room.isFull(m) && room.checkLvl(level)) {
                        room.addPlayer(player);
                        check = true;
                        break;
                    }
                }

                if (!check) {
                    Room newRoom = new Room();
                    newRoom.addPlayer(player);
                    rooms.add(newRoom);
                }
            }
        }

        for(Room room : rooms) {
            if (room.isFull(m)) {
                System.out.println("Started!");
            } else {
                System.out.println("Waiting!");
            }

            room.print();
        }
        br.close();
    }
}