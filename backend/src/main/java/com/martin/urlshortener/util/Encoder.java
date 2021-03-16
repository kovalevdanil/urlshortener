package com.martin.urlshortener.util;

import java.net.*;
import java.nio.charset.StandardCharsets;

public class Encoder {
    public static String encode(String link){
        URI uri = null;
        try {
            uri = new URI(link);
        } catch (URISyntaxException e) {
            return null;
        }

        String encodedQuery = URLEncoder.encode(uri.getPath(), StandardCharsets.UTF_8);

        return uri.getScheme() + "://" + uri.getHost()  + "/" + encodedQuery;
    }
}
