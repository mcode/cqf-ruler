package org.opencds.cqf.api.dao;

import org.hl7.fhir.instance.model.api.IBaseBundle;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.hl7.fhir.instance.model.api.IIdType;
import org.opencds.cqf.cql.engine.fhir.searchparam.SearchParameterMap;

public interface FhirResourceDao<T extends IBaseResource> {
    
    IBaseBundle search(SearchParameterMap searchParameterMap);

    void update(T resource);
    
    void create(T resource);
    
    T read(IIdType id);
    
    void delete(IIdType id);
}