package co.edu.itm.Model;

import java.util.Arrays;

public class Store {
    private String name;
    private Costumer[] costumers;

    public Store(String dataStore) {
        String[] dataStoreSplited = dataStore.split(":");
        this.name = dataStoreSplited[0];
        setCostumersByString(dataStoreSplited[1]);
    }

    private void setCostumersByString(String costumersString) {
        String[] costumersStringSplited = costumersString.split(";");
        costumers = new Costumer[costumersStringSplited.length];
        for (int i = 0; i < costumersStringSplited.length; i++) {
            costumers[i] = new Costumer(costumersStringSplited[i]);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Costumer[] getCostumers() {
        return costumers;
    }

    public void setCostumers(Costumer[] costumers) {
        this.costumers = costumers;
    }

    public String toStringCostumers() {
        String costumersToString = "";
        for (int i = 0; i < costumers.length; i++) {
            costumersToString+= costumers[i].toStringSimple();
        }
        return costumersToString;
    }

    public String getBiggestUnitPurchase() {
        int positionOfCostumer = 0;
        Purchase biggestPurchase = costumers[0].getBiggerPurchase();
        for (int i = 1; i < costumers.length; i++) {
            Purchase temporalPurchase = costumers[i].getBiggerPurchase();
            if(biggestPurchase.getUnit()<temporalPurchase.getUnit()){
                biggestPurchase = temporalPurchase;
                positionOfCostumer = i;
            }
        }
        return "Biggest units purchase{" + '\'' +
                "Costumer name='" + costumers[positionOfCostumer].getName() + '\'' +
                ", purcharse=" + biggestPurchase.toString() +
                '}';
    }

    //TODO
    // concat all purchases in a new object(purchase,costumerName) array, sort it by amount
    //@return array of costumer name + purchase.toString()
    public String getThreeExpensivePurchases() {
        int positionOfCostumerFirst = 0;
        int positionOfCostumerSecond = 0;
        int positionOfCostumerThird = 0;
        Purchase firstBiggestPurchase = null;
        Purchase secondBiggestPurchase = null;
        Purchase thirdBiggestPurchase = null;
        for (int i = 0; i < costumers.length; i++) {
            for (int j = 0; j < costumers[i].getPurchases().length; j++) {
                Purchase temporalPurchase = costumers[i].getPurchases()[j];
                Purchase purchaseToInterchange = null;
                int positionToInterChange = i;
                int temporalPosition = i;
                if(firstBiggestPurchase== null || firstBiggestPurchase.getAmount()<temporalPurchase.getAmount()){
                    purchaseToInterchange = firstBiggestPurchase;
                    firstBiggestPurchase = temporalPurchase;
                    temporalPurchase = purchaseToInterchange;
                    positionToInterChange = positionOfCostumerFirst;
                    positionOfCostumerFirst = temporalPosition;
                    temporalPosition = positionToInterChange;
                }
                if(secondBiggestPurchase== null || (secondBiggestPurchase.getAmount()<temporalPurchase.getAmount() && temporalPurchase!=null)){
                    purchaseToInterchange = secondBiggestPurchase;
                    secondBiggestPurchase = temporalPurchase;
                    temporalPurchase = purchaseToInterchange;
                    positionToInterChange = positionOfCostumerSecond;
                    positionOfCostumerSecond = temporalPosition;
                    temporalPosition = positionToInterChange;
                }
                if(thirdBiggestPurchase== null || (thirdBiggestPurchase.getAmount()<temporalPurchase.getAmount() && temporalPurchase!=null)){
                    purchaseToInterchange = thirdBiggestPurchase;
                    thirdBiggestPurchase = temporalPurchase;
                    temporalPurchase = purchaseToInterchange;
                    positionToInterChange = positionOfCostumerThird;
                    positionOfCostumerThird = temporalPosition;
                    temporalPosition = positionToInterChange;
                }
            }

        }

        return "Three biggest purchases{" + '\'' +
                "first='" + "owner: " + costumers[positionOfCostumerFirst].toStringSimple() + '\'' +
                firstBiggestPurchase.toString() + '\'' +
                "second='" + "owner: " + costumers[positionOfCostumerSecond].toStringSimple() + '\'' +
                secondBiggestPurchase.toString() + '\'' +
                "third='" + "owner: " + costumers[positionOfCostumerThird].toStringSimple() + '\'' +
                thirdBiggestPurchase.toString() + '\'' +
                '}';
    }

    @Override
    public String toString() {
        return "Store{" +
                "name='" + name + '\'' +
                ", costumers=" + Arrays.toString(costumers) +
                '}';
    }
}
