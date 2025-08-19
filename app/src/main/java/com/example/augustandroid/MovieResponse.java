package com.example.augustandroid;

import java.util.ArrayList;
import java.util.List;

public class MovieResponse {

    private List<Search> Search=new ArrayList<Search>();
    private int totalResults;
    private String Response;

    public MovieResponse(List<Search> search, int totalResults, String response) {
        Search = search;
        this.totalResults = totalResults;
        Response = response;
    }

    public List<Search> getSearch() {
        return Search;
    }

    public void setSearch(List<Search> search) {
        Search = search;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public String getResponse() {
        return Response;
    }

    public void setResponse(String response) {
        Response = response;
    }
}
