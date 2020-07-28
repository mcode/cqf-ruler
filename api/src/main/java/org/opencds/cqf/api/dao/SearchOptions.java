package org.opencds.cqf.api.dao;

import java.util.Objects;

import org.opencds.cqf.cql.engine.fhir.searchparam.SearchParameterMap;

import ca.uhn.fhir.rest.param.UriParam;

public class SearchOptions {
    public static SearchParameterMap byUrl(String url) {
        Objects.requireNonNull(url, "url can not be null");
        return new SearchParameterMap().add("url", new UriParam(url));
    }
}