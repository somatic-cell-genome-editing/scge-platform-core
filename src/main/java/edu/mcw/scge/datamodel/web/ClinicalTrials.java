package edu.mcw.scge.datamodel.web;

import java.util.Arrays;
import java.util.List;

public class ClinicalTrials {
    public static List<String> facets;
    static {
        facets= Arrays.asList("indication","fdaDesignations","status", "developmentStatus", "phases","standardAges"
                , "therapyType", "therapyRoute", "drugProductType",
                "deliverySystem","sponsorClass","sponsor","vectorType","editorType",
                "targetGeneOrVariant",  "targetTissueOrCell", "routeOfAdministration","mechanismOfAction","locations"
        );
    }

}
