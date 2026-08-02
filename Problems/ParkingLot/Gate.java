package ParkingLot;

public class Gate {
    private final int gateId;
    private final int x;
    private final int y;
    private final int z;

    public Gate(int gateId) {
        this(gateId, 0, 0, 0);
    }

    public Gate(int gateId, int x, int y, int z) {
        this.gateId = gateId;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getGateId() {
        return gateId;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }
}
