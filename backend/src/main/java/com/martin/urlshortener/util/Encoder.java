package com.martin.urlshortener.util;

import java.net.*;
import java.nio.charset.StandardCharsets;

public class Encoder {
    public static String encode(String urlStr){
        try {
            URL url = new URL(urlStr);
            URI uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef());

            return uri.toASCIIString();
        } catch (MalformedURLException | URISyntaxException e) {
            return null;
        }

//        URI uri = null;
//        try {
//            uri = new URI(link);
//        } catch (URISyntaxException e) {
//            return null;
//        }
//
//        String encodedQuery = URLEncoder.encode(uri.getPath(), StandardCharsets.UTF_8);
//
//        return uri.getScheme() + "://" + uri.getHost()  + "/" + encodedQuery;
    }
}
