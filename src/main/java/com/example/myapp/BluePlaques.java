package com.example.myapp;

import com.example.myapp.ImmutablePlaquePhoto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;

@Value.Immutable
@Value.Style(jdkOnly=true)
@JsonDeserialize(as = com.example.myapp.ImmutableBluePlaques.class)
public abstract class BluePlaques {
    public abstract List<BluePlaque> bluePlaques();

    @Value.Immutable
    @JsonDeserialize(as = com.example.myapp.ImmutableBluePlaque.class)
    public static abstract class BluePlaque {
        public abstract int id();
        @JsonProperty("erected_at")
        @Nullable
        public abstract String erectedAt();
        @Nullable
        public abstract String latitude();
        @Nullable
        public abstract String longitude();
        @JsonProperty("updated_at")
        public abstract String updatedAt();
        public abstract String inscription();
        @JsonProperty("is_current")
        public abstract String isCurrent();
        public abstract String uri();
        public abstract String title();
        public abstract String address();
        @Nullable
        public abstract String subjects();
        @JsonProperty("colour_name")
        @Nullable
        public abstract String colourName();
        @JsonProperty("machine_tag")
        public abstract String machineTag();
        @JsonProperty("geolocated?")
        public abstract boolean isGeolocated();
        @JsonProperty("photographed?")
        public abstract String isPhotographed();
        @JsonProperty("thumbnail_url")
        @Nullable
        public abstract String thumbnailUrl();
        public abstract List<PlaquePhoto> photos();
        public abstract List<PlaqueOrganisation> organisations();
        @Nullable
        public abstract PlaqueLanguage language();
        public abstract PlaqueArea area();
        public abstract List<PlaquePerson> people();
        @JsonProperty("see_also")
        public abstract List<SeeAlso> seeAlso();

        @Value.Immutable
        @JsonDeserialize(as = ImmutablePlaquePhoto.class)
        public static abstract class PlaquePhoto {
            public abstract String uri();
            @JsonProperty("thumbnail_url")
            @Nullable
            public abstract String thumbnailUrl();
            @JsonProperty("shot_name")
            @Nullable
            public abstract String shotName();
            public abstract String attribution();
        }

        @Value.Immutable
        @JsonDeserialize(as = com.example.myapp.ImmutablePlaqueOrganisation.class)
        public static abstract class PlaqueOrganisation {
            public abstract String name();
            public abstract String uri();
        }

        @Value.Immutable
        @JsonDeserialize(as = com.example.myapp.ImmutablePlaqueLanguage.class)
        public static abstract class PlaqueLanguage {
            public abstract String name();
            public abstract String alpha2();
        }

        @Value.Immutable
        @JsonDeserialize(as = com.example.myapp.ImmutablePlaqueArea.class)
        public static abstract class PlaqueArea {
            public abstract String uri();
            public abstract String name();
            public abstract PlaqueCountry country();

            @Value.Immutable
            @JsonDeserialize(as = com.example.myapp.ImmutablePlaqueCountry.class)
            public static abstract class PlaqueCountry {
                public abstract String uri();
                public abstract String name();
                public abstract String alpha2();
            }
        }

        @Value.Immutable
        @JsonDeserialize(as = com.example.myapp.ImmutablePlaquePerson.class)
        public static abstract class PlaquePerson {
            public abstract String uri();
            @JsonProperty("full_name")
            public abstract String fullName();
        }

        @Value.Immutable
        @JsonDeserialize(as = com.example.myapp.ImmutableSeeAlso.class)
        public static abstract class SeeAlso {
            public abstract String uri();
        }
    }
}
