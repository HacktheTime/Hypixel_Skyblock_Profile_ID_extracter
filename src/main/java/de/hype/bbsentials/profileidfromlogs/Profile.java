package de.hype.bbsentials.profileidfromlogs;

import com.google.gson.JsonObject;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Locale;

public class Profile {
    JsonObject data;
    String profileId;
    Calendar creationDate = Calendar.getInstance();

    public Profile(JsonObject data, String profileId) {
        this.data = data;
        this.profileId = profileId;
        try {
            creationDate.setTimeInMillis(data.get("created_at").getAsLong());
        } catch (Exception e) {
            creationDate = null;
        }
    }

    public boolean isMember(String mcuuid) {
        try {
            return data.getAsJsonObject("members").get(mcuuid) != null;
        } catch (NullPointerException ignored) {
            return false;
        }
    }

    public boolean isBingoProfile() {
        try {
            return data.get("game_mode").getAsString().equals("bingo");
        } catch (NullPointerException ignored) {
            return false;
        }
    }

    public boolean isValid(String mcuuid) {
        return isMember(mcuuid) && isBingoProfile();
    }

    public Calendar getCreationDate() {
        return creationDate;
    }

    public int getBingoId() {
        if (creationDate == null)
            return -1;
        return ((creationDate.get(Calendar.YEAR) - 2022) * 12) + creationDate.get(Calendar.MONTH);
    }

    public String getBingoDatingString() {
        if (creationDate == null) return "Unknown Date. Sorry";
        return Month.of(creationDate.get(Calendar.MONTH) + 1).getDisplayName(TextStyle.FULL, Locale.US) + " Bingo in " + creationDate.get(Calendar.YEAR) + " AKA Bingo #" + (getBingoId() + 1) + " → API Bingo ID " + getBingoId();
    }

    public String getDisplayString() {
        return profileId + " : " + getBingoDatingString();
    }
}
