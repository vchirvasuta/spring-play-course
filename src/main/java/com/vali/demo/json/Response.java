package com.vali.demo.json;

import java.util.List;

public class Response {
    private List<Result> results;
    private String status;

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFormattedAddress() {
        return results.get(0).getFormattedAddress();
    }

    public Location getLocation() {
        return results.get(0).getGeometry().getLocation();
    }


    @Override
    public String toString() {
        return "Response{" +
                "results=" + results +
                ", status='" + status + '\'' +
                '}';
    }
}
