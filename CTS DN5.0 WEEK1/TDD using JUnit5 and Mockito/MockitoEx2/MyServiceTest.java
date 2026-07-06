package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    public void testExternalApi() {

        // Create mock object
        ExternalApi mockApi = mock(ExternalApi.class);

        // Stub method
        when(mockApi.getData()).thenReturn("Mock Data");

        // Test service
        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        // Verify
        assertEquals("Mock Data", result);
    }

    @Test
    public void testVerifyInteraction() {

        ExternalApi mockApi = mock(ExternalApi.class);

        MyService service = new MyService(mockApi);

        service.fetchData();

        verify(mockApi).getData();
    }
}