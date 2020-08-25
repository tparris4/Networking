package com.example.mypackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try {
            URL url = new URL("http://example.org");

//            //reading a webpage using inputstreamreader
//            BufferedReader inputStream = new BufferedReader(
//                    new InputStreamReader(url.openStream()));
//
//            String line = "";
//            while(line != null){
//                line = inputStream.readLine();
//                System.out.println(line);
//
//            }
            //inputStream.close();
//            URI uri = url.toURI();

            //reading a webpage usin g urlconnection object
            //URLConnection urlConnection = url.openConnection();
            //doesnt connection to the url, returns an openconnection url/object
            //gives you a chance to influence how a connection is made before connection
            //can only read form a a connection with this method

            //getting a httpurlconnection class object
            //httpurlconnection uses option operations such as get or head requests
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            //using a user agent and setting it to chrome (k, v)
            connection.setRequestProperty("User-Agent", "Chrome");
            //can set a timeout value just in case the website hangs
            connection.setReadTimeout(30000);

            int responseCode = connection.getResponseCode();
            System.out.println("Response code: " + responseCode);
            //getresponsecode implicity performs the connection
            //if an object depends on a conneciton, it'll connect

            if(responseCode != 200){
                System.out.println("Error reading web page");
                System.out.println(connection.getResponseMessage());
                return;
            }

                        BufferedReader inputReader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            String line;
            while((line = inputReader.readLine()) != null){

                System.out.println(line);
            }
            inputReader.close();

//            urlConnection.setDoOutput(true);
//            //getting to write to a connection
//            urlConnection.connect();
//
            //getting header fields of a webpage
//            Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
//            //gets all header fields for the webpages
//            for(Map.Entry<String, List<String>> entry : headerFields.entrySet()){
//                String key = entry.getKey();
//                List<String> value = entry.getValue();
//                System.out.println("-----keey = " + key);
//                for(String string: value){
//                    System.out.println("Value = " + value);
//                }
//            }


//
//                        System.out.println("Scheme = " + uri.getScheme());
//            System.out.println("Sche0emespecifc part " + uri.getSchemeSpecificPart());
//            System.out.println("aurhority = " + uri.getAuthority());
//            System.out.println("user info " + uri.getUserInfo());
//            System.out.println("host = " + uri.getHost());
//            System.out.println("port = " + uri.getPort());
//            System.out.println("path = " + uri.getPath());
//            //database
//            System.out.println("query = " + uri.getQuery());
//            //separated by a question mark
//            System.out.println("fragment = " + uri.getFragment());

//absolute uri
            //URI uri = new URI("db://username:password@myserver.com:5000/catalogue/phones?os=andriod#samsung");
//converting uri to url
            //   URI uri = new URI("http://username:password@myserver.com:5000/catalogue/phones?os=andriod#samsung");

//
//            //base uri
//            URI baseURI = new URI("db://username:password@mynewserver.com:5000");
//            //relative URI
//            URI uri1 = new URI("/catalogue/phones?os=andriod#samsung");
//            URI uri2 = new URI("/catalogue/tvs?manufacturer=andriod#samsung");
//            URI uri3 = new URI("/stores/locations?zip=12345");
//            //cannot absolute url from a relative uri unless you use a baseURI
//
//            URI resolvedUri1 = baseURI.resolve(uri1);
//            URI resolvedUri2 = baseURI.resolve(uri2);
//            URI resolvedUri3 = baseURI.resolve(uri3);
//
//            URL url1 = uri1.toURL();
//            System.out.println("URL1 = " + url1);
//            URL url2 = uri2.toURL();
//            System.out.println("URL2 = " + url2);
//            URL url3 = uri3.toURL();
//            System.out.println("URL = " + url3);
//
////            System.out.println("Scheme = " + uri.getScheme());
////            System.out.println("Sche0emespecifc part " + uri.getSchemeSpecificPart());
////            System.out.println("aurhority = " + uri.getAuthority());
////            System.out.println("user info " + uri.getUserInfo());
////            System.out.println("host = " + uri.getHost());
////            System.out.println("port = " + uri.getPort());
////            System.out.println("path = " + uri.getPath());
////            //database
////            System.out.println("query = " + uri.getQuery());
////            //separated by a question mark
////            System.out.println("fragment = " + uri.getFragment());
//
//            URI relativezedURI = baseURI.relativize(resolvedUri2);
//            System.out.println("Relivate uri " + relativezedURI);
//
//        } catch(URISyntaxException e){
//           System.out.println("URI bad syntax: " + e.getMessage());
//        } catch(MalformedURLException e){
//            System.out.println("url malformed " + e.getMessage());
//        }


        }catch(MalformedURLException e){
            System.out.println("malformed url " + e.getMessage());
        }

        catch(IOException e){
            System.out.println("IOException: " + e.getMessage());
        }
    }
}
