package eterea.programa.dia.service.service.deserializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import java.lang.reflect.Type;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.time.OffsetDateTime;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OffsetDateTimeDeserializerTest {
    @Test
    void deserialize_validString() {
        OffsetDateTimeDeserializer deserializer = new OffsetDateTimeDeserializer();
        JsonElement jsonElement = new JsonPrimitive("2020-01-01 12:00:00");
        Type type = OffsetDateTime.class;
        JsonDeserializationContext ctx = mock(JsonDeserializationContext.class);
        OffsetDateTime result = deserializer.deserialize(jsonElement, type, ctx);
        assertNotNull(result);
    }

    @Test
    void deserialize_emptyString_returnsNull() {
        OffsetDateTimeDeserializer deserializer = new OffsetDateTimeDeserializer();
        JsonElement jsonElement = new JsonPrimitive("");
        Type type = OffsetDateTime.class;
        JsonDeserializationContext ctx = mock(JsonDeserializationContext.class);
        OffsetDateTime result = deserializer.deserialize(jsonElement, type, ctx);
        assertNull(result);
    }
}
