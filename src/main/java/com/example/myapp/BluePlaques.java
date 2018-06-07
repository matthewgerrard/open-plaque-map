package com.example.myapp;

import com.example.myapp.ImmutablePlaquePhoto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

import javax.annotation.Nullable;
import java.util.List;

@Value.Immutable
@Value.Style(jdkOnly=true)
@JsonDeserialize(as = com.example.myapp.ImmutableBluePlaques.class)
public abstract class BluePlaques {
    public abstract List<BluePlaque> bluePlaques();

    @Value.Immutable
    @JsonDeserialize(as = com.example.myapp.ImmutableBluePlaque.class)
    public static abstract class BluePlaque {
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        public abstract int id();

        @JsonProperty(value = "erected_at", access = JsonProperty.Access.WRITE_ONLY)
        @Nullable
        public abstract String erectedAt();

        @Nullable
        public abstract String latitude();
        @Nullable
        public abstract String longitude();

        @JsonProperty(value = "updated_at", access = JsonProperty.Access.WRITE_ONLY)
        public abstract String updatedAt();

        public abstract String inscription();

        @JsonProperty(value = "is_current", access = JsonProperty.Access.WRITE_ONLY)
        public abstract String isCurrent();

        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        public abstract String uri();

        public abstract String title();

        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        public abstract String address();

        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        @Nullable
        public abstract String subjects();

        @JsonProperty(value = "colour_name", access = JsonProperty.Access.WRITE_ONLY)
        @Nullable
        public abstract String colourName();

        @JsonProperty(value = "machine_tag", access = JsonProperty.Access.WRITE_ONLY)
        public abstract String machineTag();

        @JsonProperty("geolocated?")
        public abstract boolean isGeolocated();


        @JsonProperty(value = "photographed?", access = JsonProperty.Access.WRITE_ONLY)
        public abstract String isPhotographed();

        @JsonProperty(value = "thumbnail_url")
        @Nullable
        public abstract String thumbnailUrl();

        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        public abstract List<PlaquePhoto> photos();

        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        public abstract List<PlaqueOrganisation> organisations();

        @Nullable
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        public abstract PlaqueLanguage language();

        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        public abstract PlaqueArea area();

        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        public abstract List<PlaquePerson> people();

        @JsonProperty(value = "see_also", access = JsonProperty.Access.WRITE_ONLY)
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
