package org.opencds.cqf.api.dao;

import org.junit.Test;

public class SearchOptionsTests {

    @Test(expected = NullPointerException.class)
    public void  nullUrlThrowsException(String url) {
        SearchOptions.byUrl(null);
    }
}