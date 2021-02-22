public class metodosLab {

	public static void main(String[] args) {
        double vida = 100;
        atual(vida);
        vida = ganha(vida);
        atual(vida);
        vida = perde(vida);
        atual(vida);
        vida = ganha(vida);
        atual(vida);

    }

    private static int ganha(double vida) {
        double n1 = ((Math.random() * 20) + 1) * 100 / 100;
        return (int) (vida + n1);
    }

    private static int perde(double vida) {
        double n1 = ((Math.random() * 20) + 1) * 100 / 100;
        return (int) (vida - n1);
    }

    private static void atual(double vida) {
        System.out.println(vida);
    }
    
}