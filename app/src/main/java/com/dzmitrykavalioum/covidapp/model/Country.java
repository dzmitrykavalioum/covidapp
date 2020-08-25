
package com.dzmitrykavalioum.covidapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Country implements Serializable {

    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("cases")
    @Expose
    private Integer cases;
    @SerializedName("todayCases")
    @Expose
    private Integer todayCases;
    @SerializedName("deaths")
    @Expose
    private Integer deaths;
    @SerializedName("todayDeaths")
    @Expose
    private Integer todayDeaths;
    @SerializedName("recovered")
    @Expose
    private Integer recovered;
    @SerializedName("active")
    @Expose
    private Integer active;
    @SerializedName("critical")
    @Expose
    private Integer critical;
    @SerializedName("casesPerOneMillion")
    @Expose
    private Integer casesPerOneMillion;
    @SerializedName("deathsPerOneMillion")
    @Expose
    private Integer deathsPerOneMillion;
    @SerializedName("totalTests")
    @Expose
    private Integer totalTests;
    @SerializedName("testsPerOneMillion")
    @Expose
    private Integer testsPerOneMillion;

    /**
     * No args constructor for use in serialization
     *
     */
    public Country() {
    }

    /**
     *
     * @param country
     * @param recovered
     * @param cases
     * @param critical
     * @param deathsPerOneMillion
     * @param active
     * @param casesPerOneMillion
     * @param deaths
     * @param testsPerOneMillion
     * @param todayCases
     * @param todayDeaths
     * @param totalTests
     */
    public Country(String country, Integer cases, Integer todayCases, Integer deaths, Integer todayDeaths, Integer recovered, Integer active, Integer critical, Integer casesPerOneMillion, Integer deathsPerOneMillion, Integer totalTests, Integer testsPerOneMillion) {
        super();
        this.country = country;
        this.cases = cases;
        this.todayCases = todayCases;
        this.deaths = deaths;
        this.todayDeaths = todayDeaths;
        this.recovered = recovered;
        this.active = active;
        this.critical = critical;
        this.casesPerOneMillion = casesPerOneMillion;
        this.deathsPerOneMillion = deathsPerOneMillion;
        this.totalTests = totalTests;
        this.testsPerOneMillion = testsPerOneMillion;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Country withCountry(String country) {
        this.country = country;
        return this;
    }

    public Integer getCases() {
        return cases;
    }

    public void setCases(Integer cases) {
        this.cases = cases;
    }

    public Country withCases(Integer cases) {
        this.cases = cases;
        return this;
    }

    public Integer getTodayCases() {
        return todayCases;
    }

    public void setTodayCases(Integer todayCases) {
        this.todayCases = todayCases;
    }

    public Country withTodayCases(Integer todayCases) {
        this.todayCases = todayCases;
        return this;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }

    public Country withDeaths(Integer deaths) {
        this.deaths = deaths;
        return this;
    }

    public Integer getTodayDeaths() {
        return todayDeaths;
    }

    public void setTodayDeaths(Integer todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public Country withTodayDeaths(Integer todayDeaths) {
        this.todayDeaths = todayDeaths;
        return this;
    }

    public Integer getRecovered() {
        return recovered;
    }

    public void setRecovered(Integer recovered) {
        this.recovered = recovered;
    }

    public Country withRecovered(Integer recovered) {
        this.recovered = recovered;
        return this;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Country withActive(Integer active) {
        this.active = active;
        return this;
    }

    public Integer getCritical() {
        return critical;
    }

    public void setCritical(Integer critical) {
        this.critical = critical;
    }

    public Country withCritical(Integer critical) {
        this.critical = critical;
        return this;
    }

    public Integer getCasesPerOneMillion() {
        return casesPerOneMillion;
    }

    public void setCasesPerOneMillion(Integer casesPerOneMillion) {
        this.casesPerOneMillion = casesPerOneMillion;
    }

    public Country withCasesPerOneMillion(Integer casesPerOneMillion) {
        this.casesPerOneMillion = casesPerOneMillion;
        return this;
    }

    public Integer getDeathsPerOneMillion() {
        return deathsPerOneMillion;
    }

    public void setDeathsPerOneMillion(Integer deathsPerOneMillion) {
        this.deathsPerOneMillion = deathsPerOneMillion;
    }

    public Country withDeathsPerOneMillion(Integer deathsPerOneMillion) {
        this.deathsPerOneMillion = deathsPerOneMillion;
        return this;
    }

    public Integer getTotalTests() {
        return totalTests;
    }

    public void setTotalTests(Integer totalTests) {
        this.totalTests = totalTests;
    }

    public Country withTotalTests(Integer totalTests) {
        this.totalTests = totalTests;
        return this;
    }

    public Integer getTestsPerOneMillion() {
        return testsPerOneMillion;
    }

    public void setTestsPerOneMillion(Integer testsPerOneMillion) {
        this.testsPerOneMillion = testsPerOneMillion;
    }

    public Country withTestsPerOneMillion(Integer testsPerOneMillion) {
        this.testsPerOneMillion = testsPerOneMillion;
        return this;
    }

}
