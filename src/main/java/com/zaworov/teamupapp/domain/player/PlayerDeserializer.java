package com.zaworov.teamupapp.domain.player;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class PlayerDeserializer extends JsonDeserializer<Player> {

    public Player deserialize(String jsonString) throws IOException, JacksonException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(jsonString, VolleyballPlayer.class);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public Player deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        return null;
    }
}
