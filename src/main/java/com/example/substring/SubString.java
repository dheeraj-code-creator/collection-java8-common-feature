package com.example.substring;

import org.apache.tomcat.util.buf.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class SubString {
    public static void main(String[] args) {
        // print substring put from the string
       /* String input = "computer";
        String output = input.substring(3,6);
        System.out.println("substring of a string is: " + output);

        // print all the character after '-' from the string
        String str = "2024-04";
        int inWeek = Integer.parseInt(str.substring(str.lastIndexOf("-") + 1));
        int outWeek = inWeek + 1;
        System.out.println("substring of a string is: " + outWeek);

        System.out.println("############################################################################");*/

        // for integer
       /* List<Integer> policyIdList = Arrays.asList(1001, 1002, 1003);
        String query = "SELECT * from GISUserAccountMgmt.Policies p where p.policyId IN (?)";
        String fetchFirstPart = query.substring(0, query.indexOf("where"));
        System.out.println("first part: " + fetchFirstPart);
        System.out.println("Policy Id list is : " + policyIdList);

        List<Integer> result = new ArrayList<>();
        if (!policyIdList.isEmpty()) {
            for (int flow : policyIdList) {
                int value = flow;
                result.add(value);
            }

            String listString = String.valueOf(result);
            listString = listString.replace("[", "");
            listString = listString.replace("]", "");

            fetchFirstPart = fetchFirstPart + " where p.policyId IN (" + listString + ")";
        }
        System.out.println(" updated query is : " + fetchFirstPart);*/




        // for String

       /* String query = "SELECT COUNT(DISTINCT container.equipmentNumber) as continerOnWater " +
                "          FROM  GISRefDataMgmt.CTContainers container " +
                "          WHERE container.distributionCenters IN (?) " +
                "                AND container.eta IS NOT NULL " +
                "                AND container.ata IS NULL " +
                "                AND container.atainlandTerminal IS NULL " +
                "                AND (container.deliveryFlag = 'N' OR container.deliveryFlag IS NULL ) " +
                "              UNION ALL " +
                " SELECT COUNT(DISTINCT container.equipmentNumber) as availableAtPort " +
                "          FROM  GISRefDataMgmt.CTContainers container " +
                "          WHERE container.distributionCenters IN (?) " +
                "                AND container.ata IS NOT NULL " +
                "                AND container.atainlandTerminal IS NULL " +
                "                AND (container.deliveryFlag = 'N' OR container.deliveryFlag IS NULL ) " +
                "              UNION ALL " +
                "SELECT COUNT(DISTINCT container.equipmentNumber) as customsBlocked " +
                "          FROM  GISRefDataMgmt.CTContainers container " +
                "          WHERE container.distributionCenters IN (?) " +
                "                AND container.customscode IS NOT NULL " +
                "                AND (container.deliveryFlag = 'N' OR container.deliveryFlag IS NULL ) " +
                "              UNION ALL " +
                "SELECT COUNT(DISTINCT container.equipmentNumber) as availableAtInlandTerminal " +
                "          FROM  GISRefDataMgmt.CTContainers container " +
                "          WHERE container.distributionCenters IN (?) " +
                "                AND container.atainlandTerminal IS NOT NULL " +
                "                AND (container.deliveryFlag = 'N' OR container.deliveryFlag IS NULL )";

        List<String> distributionCenter = Arrays.asList("SEF","UFF");
        String fetchFirstPart = query.substring(0, query.indexOf("distributionCenters"));
        String fetchSecondPart = query.substring(query.indexOf("AND container"));

        List<String> result = new ArrayList<>();
        if(!distributionCenter.isEmpty()) {
            for (String flow : distributionCenter) {
                String value = flow;
                result.add(value);
            }
            String listString = String.join("', '", result);
            fetchFirstPart = fetchFirstPart + " distributionCenters IN ('" + listString + "')";
            fetchSecondPart = fetchSecondPart.replace("distributionCenters IN (?)", "distributionCenters IN ('" + listString + "')");
        }
        String updatedQuery = fetchFirstPart + " " + fetchSecondPart;
        System.out.println(" updated query is : " + updatedQuery);*/


        // DC with Join
        /*List<String> flows = Arrays.asList("SEF", "UFF", "Others");
        String query = "SELECT container.*, lineitems.* FROM  GISRefDataMgmt.CTContainers container \n" +
                "LEFT JOIN GISRefDataMgmt.CTContainerLineItems lineitems  ON container.journeyid  = lineitems.journeyid\n" +
                "WHERE container.deliveryFlag = 'N'";

        StringBuilder updatedQuery = new StringBuilder(query);
        if(Objects.nonNull(flows) && !flows.isEmpty()){
            String fetchDcQueryPart = "AND distributionCenters REGEXP (?)";
            System.out.println("11111111111 fetchDcQueryPart = " + fetchDcQueryPart );
            String regexPattern = StringUtils.join(flows, '|');
            System.out.println("22222222222 regexPattern = " + regexPattern );
            fetchDcQueryPart = fetchDcQueryPart.replace("(?)","('"+regexPattern+"')");
            System.out.println("3333333333 fetchDcQueryPart = " + fetchDcQueryPart );
            updatedQuery.append(fetchDcQueryPart);
            System.out.println("44444444444 updatedQuery = " + updatedQuery );
        }*/


        // finding unique data from two lists

        System.out.println("finding unique data from two lists");
        List<String>  duplicateEquipmentNumberList = new ArrayList<>();
        List<String>  uniqueEquipmentNumberList = new ArrayList<>();
        List<String> deleteCTContainerList = Arrays.asList("A", "B", "C");
        List<String> equipmentNumberList = Arrays.asList("A", "B");
        if(!equipmentNumberList.isEmpty() && equipmentNumberList.size() != deleteCTContainerList.size()){
            System.out.println("&&&&&&&&&&&&&& inside one delete and one not delete");
            for (String containerNumber : deleteCTContainerList) {
                if (equipmentNumberList.contains(containerNumber)) {
                    duplicateEquipmentNumberList.add(containerNumber);
                } else {
                    uniqueEquipmentNumberList.add(containerNumber);
                }
            }
            System.out.println("************ container cannot delete " + duplicateEquipmentNumberList);
            System.out.println("************ container to delete " + uniqueEquipmentNumberList);
        }




    }
}
