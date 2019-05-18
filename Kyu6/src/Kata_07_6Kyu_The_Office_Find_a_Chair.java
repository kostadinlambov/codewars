public class Kata_07_6Kyu_The_Office_Find_a_Chair {
    public static void main(String[] args) {
        Room[] rooms = new Room[]{
                new Room("XXX", 1),
                new Room("XXXXXX", 6),
                new Room("X", 2),
                new Room("XXXXXX", 8),
                new Room("X", 3),
                new Room("XXX", 1)
        };

        Object meeting = meeting(rooms, 5);
    }

    public static Object meeting(Room[] x, int need) {
        if(need == 0){
            return  "Game On";
        }

        StringBuilder chairsCountPerRoom =new StringBuilder();

        for (Room room : x) {
            int countOfPeopleInRoom = room.getOccupants().length();
            int countOfChairs = room.getChairs();
            if(countOfChairs > countOfPeopleInRoom){
                int diff = countOfChairs - countOfPeopleInRoom;
                if(diff > need){
                    chairsCountPerRoom.append(need);
                }else{
                    chairsCountPerRoom.append(diff);
                }
                need -= countOfChairs - countOfPeopleInRoom;
            }else{
                chairsCountPerRoom.append(0);
            }

            if(need <= 0){
                int[] result = new int[chairsCountPerRoom.length()];
                String chairs = chairsCountPerRoom.toString();
                for (int i = 0; i < chairs.length(); i++) {
                    result[i] = chairs.charAt(i) - '0';
                }
                return result;
            }
        }

        return "Not enough!";
    }
}

class Room {
    private String occupants;
    private int chairs;

    public Room() {
    }

    public Room(String occupants, int chairs) {
        this.occupants = occupants;
        this.chairs = chairs;
    }

    public String getOccupants() {
        return this.occupants;
    }

    public void setOccupants(String occupants) {
        this.occupants = occupants;
    }

    public int getChairs() {
        return this.chairs;
    }

    public void setChairs(int chairs) {
        this.chairs = chairs;
    }
}
