package org.motechproject.tama.reports.domain.json;

import org.junit.Test;

import static java.util.Arrays.asList;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class PathTest {

    @Test
    public void shouldReturnComponentsInPath() {
        assertEquals(asList("a", "b"), new Path("a.b").components());
    }

    @Test
    public void shouldReturnEmptyListForEmptyPath() {
        assertTrue(new Path("").components().isEmpty());
    }

    @Test
    public void shouldReturnEmptyListForNullPath() {
        assertTrue(new Path(null).components().isEmpty());
    }
}
