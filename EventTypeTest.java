package io.github.team10.escapefromuni;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for the EventType enum.
 */
public class EventTypeTest extends HeadlessTestRunner {
    
    @Test
    public void testEnumValues() {
        assertEquals("POSITIVE should exist", EventType.POSITIVE, EventType.valueOf("POSITIVE"));
        assertEquals("NEGATIVE should exist", EventType.NEGATIVE, EventType.valueOf("NEGATIVE"));
        assertEquals("HIDDEN should exist", EventType.HIDDEN, EventType.valueOf("HIDDEN"));
        assertEquals("NONE should exist", EventType.NONE, EventType.valueOf("NONE"));
    }
    
    @Test
    public void testEnumCount() {
        assertEquals("Should have 4 event types", 4, EventType.values().length);
    }
}