package scheduling;

class RaceTest {

    public static void main(String args[]) {

//        Race race = new Race("fair");
        Race race = new Race("unfair");
        race.start();
    }
}
