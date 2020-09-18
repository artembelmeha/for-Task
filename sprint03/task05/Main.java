package task05;
enum ClientType {

    NEW(1), SILVER(12) {

        @Override
        public double discount() {
            return (100 - SILVER.months*0.35)/100;
        }
    }, GOLD(30) {
        @Override
        public double discount() {
            return (100 - GOLD.months*0.30)/100;
        }
    }, PLATINUM(60) {
        @Override
        public double discount() {
            return (100 - PLATINUM.months*0.35)/100;
        }
    };


    public double discount() {
        return 1;
    }
    private int months;
    private ClientType clientType;

    ClientType(int month) {
        this.months = month;
    }

}
public class Main {
}
