package com.company;

import java.io.*;
import java.nio.charset.Charset;
import java.net.URISyntaxException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class Weather {
    public static String weatherRequest(String city) {
        String apiEndPoint="https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/";
        String location=city;
        String startDate="next3days"; //optional (omit for forecast)
        String endDate=null; //optional (requires a startDate if present)
        String unitGroup="us"; //us,metric,uk
        String apiKey="6EUE539ELNQPB57UN8Q2ZVCLL";

        //Build the URL pieces
        StringBuilder requestBuilder=new StringBuilder(apiEndPoint);
        requestBuilder.append(location);

        if (startDate!=null && !startDate.isEmpty()) {
            requestBuilder.append("/").append(startDate);
            if (endDate!=null && !endDate.isEmpty()) {
                requestBuilder.append("/").append(endDate);
            }
        }

//Build the parameters to send via GET or POST

        URIBuilder builder = null;
        try {
            builder = new URIBuilder(requestBuilder.toString());
        }
        catch (URISyntaxException e) {
            e.printStackTrace();
        }
        builder.setParameter("unitGroup", unitGroup)
                .setParameter("key", apiKey);

        HttpGet get = null;
        try {
            get = new HttpGet(builder.build());
        }
        catch (URISyntaxException e) {
            e.printStackTrace();
        }
        CloseableHttpClient httpclient = HttpClients.createDefault();

        CloseableHttpResponse response = null;
        try{
            response = httpclient.execute(get);
        }
        catch(IOException ie){
            ie.printStackTrace();
        }

        String rawResult=null;
        try {
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                System.out.printf("Bad response status code:%d%n", response.getStatusLine().getStatusCode());
            }

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                try{
                    rawResult=EntityUtils.toString(entity, Charset.forName("utf-8"));
                }
                catch(IOException ie){
                    ie.printStackTrace();
                }
            }


        } finally {
            try{
                response.close();
            }
            catch (IOException ie){

            }
        }
        String weather = parseTimelineJson(rawResult);

        return weather;
    }
    private static String parseTimelineJson(String rawResult) {

        if (rawResult==null || rawResult.isEmpty()) {
            System.out.printf("No raw data%n");
        }

        JSONObject timelineResponse = new JSONObject(rawResult);

        ZoneId zoneId=ZoneId.of(timelineResponse.getString("timezone"));

        System.out.printf("Weather data for: %s%n", timelineResponse.getString("resolvedAddress"));
        String weather = "Woof Woof! Fetching weather data for: " + timelineResponse.getString("resolvedAddress")
                + "\n" + "\n";
        JSONArray values=timelineResponse.getJSONArray("days");

        //System.out.printf("Date\tMaxTemp\tMinTemp\tPrecip\tSource%n");
        for (int i = 0; i < values.length(); i++) {
            JSONObject dayValue = values.getJSONObject(i);

            ZonedDateTime datetime=ZonedDateTime.ofInstant(Instant.ofEpochSecond(dayValue.getLong("datetimeEpoch")), zoneId);

            double maxtemp=dayValue.getDouble("tempmax");
            double mintemp=dayValue.getDouble("tempmin");
            double pop=dayValue.getDouble("precip");
            String source=dayValue.getString("source");
            //System.out.printf("%s\t%.1f\t%.1f\t%.1f\t%s%n", datetime.format(DateTimeFormatter.ISO_LOCAL_DATE), maxtemp, mintemp, pop,source );
            //Date\tMaxTemp\tMinTemp\tPrecip\tSource" + "\n";
            weather = weather + datetime.format(DateTimeFormatter.ISO_LOCAL_DATE) + ", High: " + Double.toString(maxtemp) +
                    "F, Low: " + Double.toString(mintemp) + "F, Precip: " + Double.toString(pop) + "\n" + "\n";
        }
        return weather;
    }
}
