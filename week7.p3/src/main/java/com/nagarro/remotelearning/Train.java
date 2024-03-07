package com.nagarro.remotelearning;

public class Train {
    private int trainNumber;
    private String trainType;
    private int numberOfWagons;

    public Train(int trainNumber, String trainType, int numWagons) {
        this.trainNumber = trainNumber;
        this.trainType = trainType;
        this.numberOfWagons = numWagons;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Train train = (Train) obj;
        return trainNumber == train.trainNumber &&
                numberOfWagons == train.numberOfWagons &&
                trainType.equals(train.trainType);
    }

    @Override
    public int hashCode() {

        return trainNumber;
    }

}
