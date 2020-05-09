package com.lib.management.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;

public class Decimal2Serializer extends JsonSerializer<Object> {
    @Override
    public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (o != null) {
            BigDecimal bigDecimal = new BigDecimal(o.toString()).setScale(2,BigDecimal.ROUND_HALF_UP);
            jsonGenerator.writeString(bigDecimal.toString());
        }
    }
}
