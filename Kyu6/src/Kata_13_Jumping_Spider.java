public class Kata_13_Jumping_Spider {
    public static void main(String[] args) {
//            assertEquals(4.63522d, Dinglemouse.spiderToFly("H3", "E2"), 1e-3d);
//            assertEquals(0d, Dinglemouse.spiderToFly("C2", "C2"), 1e-3d);
//            assertEquals(0d, Dinglemouse.spiderToFly("A0", "A0"), 1e-3d);
//            assertEquals(0d, Dinglemouse.spiderToFly("F3", "F3"), 1e-3d);
//            assertEquals(1d, Dinglemouse.spiderToFly("H1", "H2"), 1e-3d);
//            assertEquals(3d, Dinglemouse.spiderToFly("H1", "H4"), 1e-3d);
//            assertEquals(8d, Dinglemouse.spiderToFly("G4", "C4"), 1e-3d);
//            assertEquals(7d, Dinglemouse.spiderToFly("G4", "C3"), 1e-3d);

        System.out.println(spiderToFly("H3", "E2"));
        System.out.println(spiderToFly("C2", "C2"));
        System.out.println(spiderToFly("H1", "H2"));
        System.out.println(spiderToFly("H1", "H4"));
        System.out.println(spiderToFly("G4", "C3"));
    }

    private static double spiderToFly(final String spider, final String fly) {
        char spiderRadial = spider.charAt(0);
        int spiderRing = Integer.parseInt(spider.substring(1));

        char flyRadial = fly.charAt(0);
        int flyRing = Integer.parseInt(fly.substring(1));

        int angle = Math.abs((spiderRadial - flyRadial) * 45);
        double radians = Math.toRadians(angle);

        return Math.sqrt(Math.pow(spiderRing, 2)
                + Math.pow(flyRing, 2)
                - 2 * spiderRing * flyRing * Math.cos(radians));
    }
}
