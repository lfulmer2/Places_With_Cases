package com.example.cs125finalproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Store {

    private String county;
    private String address;
    private String chain;
    private int distance;
    private static Map<String, Integer> casesPerCounty;

    static List<Store> storeList = new ArrayList<Store>();


    public Store(String setCounty, String setAddress, String setChain, int setDistance) {
        county = setCounty;
        address = setAddress;
        chain = setChain;
        distance = setDistance;

    }

    public static void initialize(Map<String, Integer> cases) {

        casesPerCounty = cases;
        
         Store[] stores = {
                 new Store("Champaign", "220 N Broadway Ave, Urbana, IL 61801", "Save-a-lot",15),
             new Store("Champaign", "3102 E University Ave, Urbana, IL 61802", "ALDI", 15 ),
             new Store("Champaign", "801 W Interstate Dr, Champaign, IL 61822", "ALDI", 15),
             new Store("Champaign", "605 N. Dunlap Ave, Savoy, IL 61874", "ALDI", 15),
             new Store("Champaign", "331 E Stoughton St, Champaign, IL 61820", "County Market", 15),
             new Store("Champaign", "2901 W Kirby Ave, Champaign, IL 61821", "County Market", 15),
             new Store("Champaign", "1201 E Grove Ave, Rantoul, IL 61866", "County Market", 15),
             new Store("Champaign", "100 S High Cross Rd, Urbana, IL 61802", "Walmart Supercenter", 15),
             new Store("Champaign", "2610 N Prospect Ave, Champaign, IL 61822", "Walmart Supercenter", 15),
             new Store("Champaign", "505 S Dunlap Ave, Savoy, IL 61874", "Walmart Supercenter", 15),
             new Store("Champaign", "845 Broadmeadow Rd, Rantoul, IL 61866", "Walmart Supercenter", 15),
             new Store("Vermilion","2 E Main St, Danville, IL 61832", "Save-a-lot", 30),
             new Store("Vermilion", "4101 N Vermilion St UNIT A, Danville, IL 61832", "ALDI", 30),
             new Store("Vermilion", "502 S Gilbert Street, Danville, IL 61832", "ALDI", 30),
             new Store("Vermilion", "2917 N Vermilion St, Danville, IL 61832", "County Market", 30),
             new Store("Piatt", "422 S Market St, Monticello, IL 61856", "County Market", 30),
             new Store("Vermilion", "1628 Georgetown Rd, Tilton, IL 61833", "County Market", 30),
             new Store("Vermilion", "4101 N Vermilion St UNIT A, Danville, IL 6183", "Walmart Supercenter", 30),
             new Store ("Macon", "1185 W Grand Ave, Decatur, IL 62522", "County Market", 50),
             new Store ("Coles", "551 West Lincoln Ave, Charleston, IL, 61920", "County Market", 50),
             new Store("Coles", "2000 Western Ave, Mattoon, IL, 61938", "County Market", 50),
             new Store("Macon", "510 E. Pershing Rd, Decatur, IL, 62526", "ALDI", 50),
             new Store("Macon", "2075 Mount Zion Rd, Decatur, IL, 62526", "ALDI", 50),
             new Store("Coles", "2240 Shawnee Dr, Charleston, IL, 61920", "ALDI", 50),
             new Store("Coles", "1220 Fort Worth Way, Mattoon, IL, 61938", "ALDI", 50),
             new Store("McLean", "301 Greenbriar Dr, Normal, IL, 61761", "ALDI", 50),
             new Store("McLean", "1025 Wylie Dr, Bloomington, IL, 61705", "ALDI", 50),
             new Store("Macon", "2280 E William St, Decatur, IL 62521", "Save-a-lot", 50),
             new Store("Macon", "1175 W Grand Ave, Decatur, IL, 62521", "Save-a-lot", 50),
             new Store("Macon", "4224 N Prospect St, Decatur, IL, 62526", "Walmart Supercenter", 50),
             new Store("Coles", "2250 Lincoln Ave, Charleston, IL, 61920", "Walmart Supercenter", 50),
             new Store("Coles", "101 Dettro Dr, Mattoon, IL, 61928", "Walmart Supercenter", 50),
             new Store("McLean", "15015 Us Highway 150, Paris, IL, 61944", "Walmart Supercenter", 50),
             new Store("McLean", "300 Greenbriar Dr, Normal, IL, 61761", "Walmart Supercenter", 50),
             new Store("McLean", "2225 W Market St, Bloomington, IL, 61705", "Walmart Supercenter", 50)
         };

         storeList = Arrays.asList(stores);
    }

    public String getCounty() {
        return county;
    }

    public String getAddress() {
        return address;
    }

    public int getDistance() {
        return distance;
    }

    public String getChain() {
        return chain;
    }

    public int getCovidCases() {
        int count = 0;
        String county = getCounty();
        if(casesPerCounty.get(county) != null) {
            count = casesPerCounty.get(county);
        }

        return count;

    }

    public static ArrayList<String> thePlacesWithCases(ArrayList<String> chainName, int distance) {

        ArrayList<String> toReturn = new ArrayList<>();

        for (int i = 0; i < storeList.size() ; i++) {
            String str = storeList.get(i).getChain();
            int storeDistance = storeList.get(i).getDistance();
            for (int j = 0; j < chainName.size(); j++) {
                if (storeDistance <= distance && str.equals(chainName.get(j))) {
                    toReturn.add("A " + str +  " store" + " with address " + storeList.get(i).getAddress() + " is located within or approximately " +  String.valueOf(storeDistance)
                            + " miles away from Champaign and has " + String.valueOf(storeList.get(i).getCovidCases()) + " cases in the county containing this store");
                }
            }
        }
        return toReturn;
    }

    public static String outputString(ArrayList<String> a, int distance) {

        ArrayList<String> output = thePlacesWithCases(a, distance);

        String str = "The following store have been identified based on you selections:\n\n";

        for (int i = 0; i < output.size(); i++) {
            str += output.get(i) + "\n\n";
        }
        return str;
    }




}
