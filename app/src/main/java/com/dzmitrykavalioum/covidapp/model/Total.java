

package com.dzmitrykavalioum.covidapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Total implements Serializable {

    @SerializedName("cases")
    @Expose
    private Integer cases;
    @SerializedName("deaths")
    @Expose
    private Integer deaths;
    @SerializedName("recovered")
    @Expose
    private Integer recovered;

    /**
     * No args constructor for use in serialization
     *
     */
    public Total() {
    }

    /**
     *
     * @param recovered
     * @param cases
     * @param deaths
     */
    public Total(Integer cases, Integer deaths, Integer recovered) {
        super();
        this.cases = cases;
        this.deaths = deaths;
        this.recovered = recovered;
    }

    public Integer getCases() {
        return cases;
    }

    public void setCases(Integer cases) {
        this.cases = cases;
    }

    public Total withCases(Integer cases) {
        this.cases = cases;
        return this;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }

    public Total withDeaths(Integer deaths) {
        this.deaths = deaths;
        return this;
    }

    public Integer getRecovered() {
        return recovered;
    }

    public void setRecovered(Integer recovered) {
        this.recovered = recovered;
    }

    public Total withRecovered(Integer recovered) {
        this.recovered = recovered;
        return this;
    }

}
