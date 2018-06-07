package com.example.myapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
public class BluePlaqueDatabase {
    private BluePlaques bluePlaques;

    public BluePlaques getBluePlaques() {
        return this.bluePlaques;
    }

    public void loadBluePlaques() throws IOException {
        ClassLoader cl = this.getClass().getClassLoader();
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(cl);
        Resource facilitiesResource = resolver.getResource("blueplaquedata/open-plaques-United-Kingdom-2018-04-08.json");

        ObjectMapper mapper = new ObjectMapper();
        bluePlaques = mapper.readValue(facilitiesResource.getInputStream(), com.example.myapp.ImmutableBluePlaques.class);
    }
}
