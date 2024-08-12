package com.nbavis.nbavisualstats.player;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "player_stats")
public class Player {

    @Id
    @Column(name = "id", unique = true)
    private Integer id;
    private String name;
    private String imagesrc;
    private String team;
    private float ppg;
    private float fgm;
    private float fga;
    private float fgPercentage;
    private float threePointersMade;
    private float threePointersAttempted;
    @Column(name = "three_point_percentage")
    private float threePointerPercentage;
    private float ftm;
    private float fta;
    private float ftPercentage;
    private float apg;
    private float tov;
    private float rb;

    public Player() {
    }

    public Player(Integer id, String name, String imagesrc, String team, float ppg, float fgm, float fga,
            float fgPercentage, float threePointersMade, float threePointersAttempted, float threePointerPercentage,
            float ftm, float fta, float ftPercentage, float apg, float tov, float rb) {
        this.id = id;
        this.name = name;
        this.imagesrc = imagesrc;
        this.team = team;
        this.ppg = ppg;
        this.fgm = fgm;
        this.fga = fga;
        this.fgPercentage = fgPercentage;
        this.threePointersMade = threePointersMade;
        this.threePointersAttempted = threePointersAttempted;
        this.threePointerPercentage = threePointerPercentage;
        this.ftm = ftm;
        this.fta = fta;
        this.ftPercentage = ftPercentage;
        this.apg = apg;
        this.tov = tov;
        this.rb = rb;
    }

    public Integer getid() {
        return id;
    }

    public void setid(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getimagesrc() {
        return imagesrc;
    }

    public void setImageSrc(String imagesrc) {
        this.imagesrc = imagesrc;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public float getPpg() {
        return ppg;
    }

    public void setPpg(float ppg) {
        this.ppg = ppg;
    }

    public float getFgm() {
        return fgm;
    }

    public void setFgm(float fgm) {
        this.fgm = fgm;
    }

    public float getFga() {
        return fga;
    }

    public void setFga(float fga) {
        this.fga = fga;
    }

    public float getFgPercentage() {
        return fgPercentage;
    }

    public void setFgPercentage(float fgPercentage) {
        this.fgPercentage = fgPercentage;
    }

    public float getThreePointersMade() {
        return threePointersMade;
    }

    public void setThreePointersMade(float threePointersMade) {
        this.threePointersMade = threePointersMade;
    }

    public float getThreePointersAttempted() {
        return threePointersAttempted;
    }

    public void setThreePointersAttempted(float threePointersAttempted) {
        this.threePointersAttempted = threePointersAttempted;
    }

    public float getthreePointerPercentage() {
        return threePointerPercentage;
    }

    public void setthreePointerPercentage(float threePointerPercentage) {
        this.threePointerPercentage = threePointerPercentage;
    }

    public float getFtm() {
        return ftm;
    }

    public void setFtm(float ftm) {
        this.ftm = ftm;
    }

    public float getFta() {
        return fta;
    }

    public void setFta(float fta) {
        this.fta = fta;
    }

    public float getFtPercentage() {
        return ftPercentage;
    }

    public void setFtPercentage(float ftPercentage) {
        this.ftPercentage = ftPercentage;
    }

    public float getApg() {
        return apg;
    }

    public void setApg(float apg) {
        this.apg = apg;
    }

    public float getTov() {
        return tov;
    }

    public void setTov(float tov) {
        this.tov = tov;
    }

    public float getRb() {
        return rb;
    }

    public void setRb(float rb) {
        this.rb = rb;
    }
}