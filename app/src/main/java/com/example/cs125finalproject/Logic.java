package com.example.cs125finalproject;

import java.util.ArrayList;
import java.util.Map;

public class Logic {

    Map<String, ArrayList<String>> fifteenMileGroceries;
    Map<String, ArrayList<String>> thirtyMileGroceries;
    Map<String, ArrayList<String>> fiftyMileGroceries;
    private int userDistance;
    private ArrayList<String> groceriesSelected;


    public Logic(int setUserDistance, ArrayList<String> setGroceriesSelected) {

        userDistance = setUserDistance;
        groceriesSelected = setGroceriesSelected;

        // For fifteen mile distance
        ArrayList<String> SaveALot = new ArrayList<String>();
        SaveALot.add("220 N Broadway Ave, Urbana, IL 61801");
        ArrayList<String> ALDI = new ArrayList<String>();
        ALDI.add("3102 E University Ave, Urbana, IL 61802");
        ALDI.add("801 W Interstate Dr, Champaign, IL 61822");
        ALDI.add("605 N. Dunlap Ave, Savoy, IL 61874");
        ArrayList<String> CountyMarket = new ArrayList<String>();
        CountyMarket.add("331 E Stoughton St, Champaign, IL 61820");
        CountyMarket.add("2901 W Kirby Ave, Champaign, IL 61821");
        CountyMarket.add("1201 E Grove Ave, Rantoul, IL 61866");
        CountyMarket.add("1628 Georgetown Road, Tilton, IL 61833");
        ArrayList<String> WalmartSupercenter = new ArrayList<String>();
        WalmartSupercenter.add("100 S High Cross Rd, Urbana, IL 61802 ");
        WalmartSupercenter.add("2610 N Prospect Ave, Champaign, IL 61822");
        WalmartSupercenter.add("505 S Dunlap Ave, Savoy, IL 61874");
        WalmartSupercenter.add("845 Broadmeadow Rd, Rantoul, IL 61866");
        fifteenMileGroceries.put("Save-a-Lot", SaveALot);
        fifteenMileGroceries.put("ALDI",ALDI);
        fifteenMileGroceries.put("County Market", CountyMarket);
        fifteenMileGroceries.put("Walmart Supercenter", WalmartSupercenter);

        //for approximately 30 miles distance

        ArrayList<String> SaveALot30 = new ArrayList<String>();
        SaveALot30.add("2 E Main St, Danville, IL 61832");
        ArrayList<String> ALDI30 = new ArrayList<String>();
        ALDI30.add("4101 N Vermilion St UNIT A, Danville, IL 61832");
        ALDI30.add("502 S Gilbert Street, Danville, IL 61832");
        ArrayList<String> CountyMarket30 = new ArrayList<String>();
        CountyMarket30.add("2917 N Vermilion St, Danville, IL 61832");
        CountyMarket30.add("422 S Market St, Monticello, IL 61856");
        CountyMarket30.add("1628 Georgetown Rd, Tilton, IL 61833");
        ArrayList<String> WalmartSuperCenter30 = new ArrayList<String>();
        WalmartSuperCenter30.add("4101 N Vermilion St UNIT A, Danville, IL 6183");
        thirtyMileGroceries.put("Save-a-lot", SaveALot30);
        thirtyMileGroceries.put("ALDI", ALDI30);
        thirtyMileGroceries.put("County Market", CountyMarket30);
        thirtyMileGroceries.put("Walmart Supercenter", WalmartSuperCenter30);

        //for approximately 50 miles of distance

        ArrayList<String> CountyMarket50 = new ArrayList<>();
        CountyMarket50.add("1185 W Grand Ave, Decatur, IL 62522");
        CountyMarket50.add("551 West Lincoln Ave, Charleston, IL, 61920");
        CountyMarket30.add("2000 Western Ave, Mattoon, IL, 61938");

        ArrayList<String> ALDI50 = new ArrayList<>();
        ALDI50.add("510 E. Pershing Rd, Decatur, IL, 62526");
        ALDI50.add("2075 Mount Zion Rd, Decatur, IL, 62526");
        ALDI50.add("2240 Shawnee Dr, Charleston, IL, 61920");
        ALDI50.add("1220 Fort Worth Way, Mattoon, IL, 61938");
        ALDI50.add("301 Greenbriar Dr, Normal, IL, 61761");
        ALDI50.add("1025 Wylie Dr, Bloomington, IL, 61705");

        ArrayList<String> SaveALot50 = new ArrayList<>();
        SaveALot50.add("2280 E William St, Decatur, IL 62521");
        SaveALot50.add("1175 W Grand Ave, Decatur, IL, 62521");

        ArrayList<String> WalmartSuperCenter50 = new ArrayList<>();
        WalmartSuperCenter50.add("4224 N Prospect St, Decatur, IL, 62526");
        WalmartSuperCenter50.add("2250 Lincoln Ave, Charleston, IL, 61920");
        WalmartSuperCenter50.add("101 Dettro Dr, Mattoon, IL, 61928");
        WalmartSuperCenter50.add("15015 Us Highway 150, Paris, IL, 61944");
        WalmartSuperCenter50.add("300 Greenbriar Dr, Normal, IL, 61761");
        WalmartSuperCenter50.add("2225 W Market St, Bloomington, IL, 61705");
        fiftyMileGroceries.put("Save-a-lot", SaveALot50);
        fiftyMileGroceries.put("ALDI", ALDI50);
        fiftyMileGroceries.put("CountyMarket", CountyMarket50);
        fiftyMileGroceries.put("Walmart Supercenter", WalmartSuperCenter50);
    }

    public Map<String, ArrayList<String>> returnLocations() {

        Map<String, ArrayList<String>> toReturn = null;

        if (userDistance == 15) {
            for (int i = 0; i < groceriesSelected.size(); i++) {
                if (groceriesSelected.get(i).equals("Save-a-lot")) {
                    toReturn.put("Save-a-lot", fifteenMileGroceries.get("Save-a-lot"));
                }
                if (groceriesSelected.get(i).equals("ALDI")) {
                    toReturn.put("ALDI", fifteenMileGroceries.get("ALDI"));
                }
                if (groceriesSelected.get(i).equals("Country Market")) {
                    toReturn.put("Country Market", fifteenMileGroceries.get("County Market"));
                }
                if (groceriesSelected.get(i).equals("Walmart Supercenter")) {
                    toReturn.put("Walmart Supercenter", fifteenMileGroceries.get("Walmart Supercenter"));
                }
            }
        }

        if (userDistance == 30) {
            for (int i = 0; i < groceriesSelected.size(); i++) {
                if (groceriesSelected.get(i).equals("Save-a-lot")) {
                    ArrayList<String> totalStores = fifteenMileGroceries.get("Save-a-lot");
                    ArrayList<String> toAdd = thirtyMileGroceries.get("Save-a-lot");
                    totalStores.addAll(toAdd);
                    toReturn.put("Save-a-lot", totalStores);
                }
                if (groceriesSelected.get(i).equals("ALDI")) {
                    ArrayList<String> totalStores = fifteenMileGroceries.get("ALDI");
                    ArrayList<String> toAdd = thirtyMileGroceries.get("ALDI");
                    totalStores.addAll(toAdd);
                    toReturn.put("ALDI", totalStores);
                }
                if (groceriesSelected.get(i).equals("Country Market")) {
                    ArrayList<String> totalStores = fifteenMileGroceries.get("CountryMarket");
                    ArrayList<String> toAdd = thirtyMileGroceries.get("CountyMarket");
                    totalStores.addAll(toAdd);
                    toReturn.put("Country Market", totalStores);
                }
                if (groceriesSelected.get(i).equals("Walmart Supercenter")) {
                    ArrayList<String> totalStores = fifteenMileGroceries.get("Walmart Supercenter");
                    ArrayList<String> toAdd = thirtyMileGroceries.get("Walmart Supercenter");
                    totalStores.addAll(toAdd);
                    toReturn.put("Walmart Supercenter", totalStores);
                }
                if (groceriesSelected.get(i).equals("Family Dollar")) {
                    ArrayList<String> totalStores = fifteenMileGroceries.get("Family Dollar");
                    ArrayList<String> toAdd = thirtyMileGroceries.get("Family Dollar");
                    totalStores.addAll(toAdd);
                    toReturn.put("Family Dollar", totalStores);
                }
                if (groceriesSelected.get(i).equals("Dollar Center")) {
                    ArrayList<String> totalStores = fifteenMileGroceries.get("Dollar Center");
                    ArrayList<String> toAdd = thirtyMileGroceries.get("Dollar Center");
                    totalStores.addAll(toAdd);
                    toReturn.put("Dollar Center", toAdd);
                }
                if (groceriesSelected.get(i).equals("Dollar General")) {
                    ArrayList<String> totalStores = fifteenMileGroceries.get("Dollar General");
                    ArrayList<String> toAdd = thirtyMileGroceries.get("Dollar General");
                    totalStores.addAll(toAdd);
                    toReturn.put("Dollar General", totalStores);
                }
            }
        }

        if (userDistance == 50) {
            for (int i = 0; i < groceriesSelected.size(); i++) {
                if (groceriesSelected.get(i).equals("Save-a-lot")) {
                    ArrayList<String> totalStores = fifteenMileGroceries.get("Save-a-lot");
                    ArrayList<String> toAdd = thirtyMileGroceries.get("Save-a-lot");
                    ArrayList<String> toAdd1 = fiftyMileGroceries.get("Save-a-lot");
                    totalStores.addAll(toAdd);
                    totalStores.addAll(toAdd1);
                    toReturn.put("Save-a-lot", totalStores);
                }
                if (groceriesSelected.get(i).equals("ALDI")) {
                    ArrayList<String> totalStores = fifteenMileGroceries.get("ALDI");
                    ArrayList<String> toAdd = thirtyMileGroceries.get("ALDI");
                    ArrayList<String> toAdd1 = fiftyMileGroceries.get("ALDI");
                    totalStores.addAll(toAdd);
                    totalStores.addAll(toAdd1);
                    toReturn.put("ALDI", totalStores);
                }
                if (groceriesSelected.get(i).equals("Country Market")) {
                    ArrayList<String> totalStores = fifteenMileGroceries.get("Country Market");
                    ArrayList<String> toAdd = thirtyMileGroceries.get("County Market");
                    ArrayList<String> toAdd1 = fiftyMileGroceries.get("County Market");
                    totalStores.addAll(toAdd);
                    totalStores.addAll(toAdd1);
                    toReturn.put("Country Market", totalStores);
                }
                if (groceriesSelected.get(i).equals("Walmart Supercenter")) {
                    ArrayList<String> totalStores = fifteenMileGroceries.get("Walmart Supercenter");
                    ArrayList<String> toAdd = thirtyMileGroceries.get("Walmart Supercenter");
                    ArrayList<String> toAdd1 = fiftyMileGroceries.get("County Market");
                    totalStores.addAll(toAdd);
                    toReturn.put("Walmart Supercenter", totalStores);
                }
            }
        }
        return toReturn;
    }
}

