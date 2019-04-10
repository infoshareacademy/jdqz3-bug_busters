package dataModels;

import java.util.ArrayList;
import java.util.List;

public class Bag {

    private BagType bagType;
    private String bagName;
    private String bagProductCode;
    private int bagAvailability;
    private double bagPrice;
    private List<Opinion> bagOpinions;

    public Bag(BagType bagType, String bagName, int bagAvailability, String bagProductCode, double bagPrice) {
        this.bagType = bagType;
        this.bagName = bagName;
        this.bagProductCode = bagProductCode;
        this.bagAvailability = bagAvailability;
        this.bagPrice = bagPrice;
        this.bagOpinions = new ArrayList<Opinion>();
    }


    public void addOpinion(Opinion opinion) {
        this.bagOpinions.add(opinion);
    }

    public List<Opinion> getBagOpinions() {

        return this.bagOpinions;
    }

    public BagType getBagType() {
        return bagType;
    }

    public String getBagName() {
        return bagName;
    }

    public String getBagProductCode() {
        return bagProductCode;
    }

    public int getBagAvailability() {
        return bagAvailability;
    }

    public double getBagPrice() {
        return bagPrice;
    }

    @Override
    public String toString() {
        return "Bag{" +
                "bagType=" + bagType +
                ", bagName='" + bagName + '\'' +
                ", bagProductCode='" + bagProductCode + '\'' +
                ", bagAvailability=" + bagAvailability +
                ", bagPrice=" + bagPrice +
                '}';
    }
}