package ParkingLot.ParkingStratergy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import ParkingLot.Gate;
import ParkingLot.ParkingSpot.ParkingSpot;

public class NeatestToEntrance extends ParkingStratergy {
    private final Map<Gate, PriorityQueue<ParkingSpotEntry>> parkingSpotsByGate = new HashMap<>();
    @Override
    public void addGate(Gate g, List<ParkingSpot> parkingSpots) {
        if (g == null) {
            return;
        }
        PriorityQueue<ParkingSpotEntry> minHeap = new PriorityQueue<>();
        if (parkingSpots != null) {
            for (ParkingSpot parkingSpot : parkingSpots) {
                if (parkingSpot != null) {
                    int distance = calculateDistance(g, parkingSpot);
                    minHeap.offer(new ParkingSpotEntry(distance, parkingSpot));
                }
            }
        }

        parkingSpotsByGate.put(g, minHeap);
    }
    public void insertParkingSpot(Gate gate, ParkingSpot parkingSpot) {
        PriorityQueue<ParkingSpotEntry> minHeap = parkingSpotsByGate.computeIfAbsent(gate, key -> new PriorityQueue<>());
        int distance = calculateDistance(gate, parkingSpot);
        minHeap.offer(new ParkingSpotEntry(distance, parkingSpot));
    }

    public void addParkingSpotToAllGates(ParkingSpot parkingSpot) {
        for (Gate gate : parkingSpotsByGate.keySet()) {
            insertParkingSpot(gate, parkingSpot);
        }
    }

    private int calculateDistance(Gate gate, ParkingSpot parkingSpot) {
        int dx = gate.getX() - parkingSpot.getX();
        int dy = gate.getY() - parkingSpot.getY();
        int dz = gate.getZ() - parkingSpot.getZ();
        return (int) Math.round(Math.sqrt(dx * dx + dy * dy + dz * dz));
    }

    @Override
    public ParkingSpot getSpot(Gate g) {
        if (g == null) {
            return null;
        }

        PriorityQueue<ParkingSpotEntry> minHeap = parkingSpotsByGate.get(g);
        if (minHeap == null || minHeap.isEmpty()) {
            return null;
        }

        while (!minHeap.isEmpty()) {
            ParkingSpotEntry entry = minHeap.poll();
            ParkingSpot parkingSpot = entry.getParkingSpot();
            if (parkingSpot != null && parkingSpot.isEmpty()) {
                return parkingSpot;
            }
        }

        return null;
    }

    private static class ParkingSpotEntry implements Comparable<ParkingSpotEntry> {
        private final int distance;
        private final ParkingSpot parkingSpot;

        private ParkingSpotEntry(int distance, ParkingSpot parkingSpot) {
            this.distance = distance;
            this.parkingSpot = parkingSpot;
        }

        public int getDistance() {
            return distance;
        }

        public ParkingSpot getParkingSpot() {
            return parkingSpot;
        }

        @Override
        public int compareTo(ParkingSpotEntry other) {
            return Integer.compare(this.distance, other.distance);
        }
    }
}
