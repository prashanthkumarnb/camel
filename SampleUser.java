package com.example.camel;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * Immutable User.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public final class SampleUser {

    private final String name;

    /**
     * Empty constructor for Jackson.
     */
    protected SampleUser() {
        name = null;
    }

    public SampleUser(final String name) {
        this.name = name;
    }

    public final String getName() {
        return name;
    }
}

