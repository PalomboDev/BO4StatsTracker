package com.palombodev.bo4statstracker.player;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Player {

    private String playerName;
    private String level;
    private String prestige;
    private String gamesplayed;
    private String wins;
    private String losses;
    private String ekia;
    private String kills;
    private String deaths;
    private String kd;
    private String hits;
    private String melee;
    private String longestkillstreak;
    private String curwinstreak;
    private String totalshots;
    private String teamkills;
    private String suicides;
    private String killsconfirmed;
    private String killsdenied;
    private String captures;
    private String defends;
    private String timeplayed;

    public Player(String playerName, String level, String prestige, String gamesplayed, String wins, String losses, String ekia, String kills, String deaths, String kd, String hits, String melee, String longestkillstreak, String curwinstreak, String totalshots, String teamkills, String suicides, String killsconfirmed, String killsdenied, String captures, String defends, String timeplayed) {
        this.playerName = playerName;
        this.level = level;
        this.prestige = prestige;
        this.gamesplayed = gamesplayed;
        this.wins = wins;
        this.losses = losses;
        this.ekia = ekia;
        this.kills = kills;
        this.deaths = deaths;
        this.kd = kd;
        this.hits = hits;
        this.melee = melee;
        this.longestkillstreak = longestkillstreak;
        this.curwinstreak = curwinstreak;
        this.totalshots = totalshots;
        this.teamkills = teamkills;
        this.suicides = suicides;
        this.killsconfirmed = killsconfirmed;
        this.killsdenied = killsdenied;
        this.captures = captures;
        this.defends = defends;
        this.timeplayed = timeplayed;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getLevel() {
        return level;
    }

    public String getPrestige() {
        return prestige;
    }

    public String getGamesplayed() {
        return gamesplayed;
    }

    public String getWins() {
        return wins;
    }

    public String getLosses() {
        return losses;
    }

    public String getEkia() {
        return ekia;
    }

    public String getKills() {
        return kills;
    }

    public String getDeaths() {
        return deaths;
    }

    public String getKd() {
        NumberFormat formatter = new DecimalFormat("##.00");

        return formatter.format(Double.valueOf(ekia) / Double.valueOf(deaths)) + "";
    }

    public String getHits() {
        return hits;
    }

    public String getMelee() {
        return melee;
    }

    public String getLongestkillstreak() {
        return longestkillstreak;
    }

    public String getCurwinstreak() {
        return curwinstreak;
    }

    public String getTotalshots() {
        return totalshots;
    }

    public String getTeamkills() {
        return teamkills;
    }

    public String getSuicides() {
        return suicides;
    }

    public String getKillsconfirmed() {
        return killsconfirmed;
    }

    public String getKillsdenied() {
        return killsdenied;
    }

    public String getCaptures() {
        return captures;
    }

    public String getDefends() {
        return defends;
    }

    public String getTimeplayed() {
        return timeplayed;
    }
}
