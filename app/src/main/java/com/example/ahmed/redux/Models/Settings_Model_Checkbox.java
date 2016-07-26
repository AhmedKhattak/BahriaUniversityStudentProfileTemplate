package com.example.ahmed.redux.Models;

import android.widget.CheckBox;

/**
 * Created by Khattak on 7/26/2016.
 */
public class Settings_Model_Checkbox {
    private String header;
    private String summary;

    public Settings_Model_Checkbox(String header, String summary) {
        this.header = header;
        this.summary = summary;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getSummary() {
        return summary;
    }
    public void setSummary(String summary) {
        this.summary = summary;
    }
}
