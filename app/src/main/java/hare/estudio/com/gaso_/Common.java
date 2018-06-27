package hare.estudio.com.gaso_;

import hare.estudio.com.gaso_.Model.Results;
import hare.estudio.com.gaso_.Remote.IGoogleAPIService;
import hare.estudio.com.gaso_.Remote.RetrofitClient;
import hare.estudio.com.gaso_.Remote.RetrofitScalarsClient;

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
