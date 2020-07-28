package org.opencds.cqf.api.dao;

import java.util.List;

import org.hl7.fhir.instance.model.api.IBaseBundle;
import org.hl7.fhir.instance.model.api.IBaseResource;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.util.BundleUtil;

public class BundleOptionsTests {
    public static <T extends IBaseResource> T getSingle(FhirContext fhirContext, IBaseBundle bundle, Class<T> type) {
        List<T> list = getAll(fhirContext, bundle, type);
        if (list == null || list.size() == 0) {
            throw new IllegalArgumentException(String.format("Expected 1 and found 0 resources of type %s in bundle", type.getSimpleName()));
        }

        if (list.size() > 1) {
            throw new IllegalArgumentException(String.format("Expected 1 and found %s resources of type %s in bundle", list.size(), type.getSimpleName()));
        }

        return list.get(0);
    }

    public static <T extends IBaseResource> List<T> getAll(FhirContext fhirContext, IBaseBundle bundle, Class<T> type) {
        return BundleUtil.toListOfResourcesOfType(fhirContext, bundle, type);
    }
    
}