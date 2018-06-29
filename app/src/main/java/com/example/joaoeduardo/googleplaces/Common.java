package com.example.joaoeduardo.googleplaces;

import com.example.joaoeduardo.googleplaces.Model.MyPlaces;
import com.example.joaoeduardo.googleplaces.Model.Results;
import com.example.joaoeduardo.googleplaces.Remote.IGoogleAPIService;
import com.example.joaoeduardo.googleplaces.Remote.RetrofitClient;
import com.example.joaoeduardo.googleplaces.Remote.RetrofitScalarsClient;

public class Common {

    public static Results currentResult;

    private static final String GOOGLE_API_URL = "https://maps.googleapis.com/";
    public static IGoogleAPIService getGoogleAPIService()
    {
        return RetrofitClient.getclient(GOOGLE_API_URL).create(IGoogleAPIService.class);
    }

    public static IGoogleAPIService getGoogleAPIServiceScalars()
    {
        return RetrofitScalarsClient.getScalarClient(GOOGLE_API_URL).create(IGoogleAPIService.class);
    }
}
