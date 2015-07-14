package com.youguu.asteroid.convert.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.io.*;
import java.net.*;

/**
 * Created by lqipr on 2015/7/10.
 */
public class BdApiUtil {
    public static void main(String[] args) throws IOException {
        File file = new File("d:/2.jpg");
        String result = getStringByImg(file);
        System.out.println("===========================");
        System.out.println(result);


        FileInputStream inputFile = new FileInputStream(file);
        byte[] buffer = new byte[(int) file.length()];
        inputFile.read(buffer);
        inputFile.close();
        result = getStringByImg(buffer);
        System.out.println("===========================");
        System.out.println(result);

    }

    private static final String api_key = "4fa66531be27c35d51cc89f6c3672dfe";
    private static final String encode = "utf-8";

    private static final String http_url = "http://apis.baidu.com/apistore/idlocr/ocr";
    private static final String http_arg = "fromdevice=%s&clientip=%s&detecttype=%s&languagetype=%s&imagetype=%s&image=%s";

    private static final String from_device = "pc";
    private static final String detect_type = "LocateRecognize";
    private static final String language_type = "CHN_ENG";
    private static final String image_type = "1";

    public static String getStringByImg(File img) {
        return getStringByImg(from_device, "", detect_type, language_type, image_type, img);
    }
    public static String getStringByImg(byte[] img) {
        return getStringByImg(from_device, "", detect_type, language_type, image_type, img);
    }

    private static String getStringByImg(String fromDevice, String ip, String detectType, String languageType, String imageType, File img) {
        String imageStr;
        try {
            imageStr = getBdBase64File(img);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return getResult(fromDevice, ip, detectType, languageType, imageType, imageStr);
    }

    private static String getStringByImg(String fromDevice, String ip, String detectType, String languageType, String imageType, byte[] img) {
        String imageStr;
        try {
            imageStr = getBdBase64File(img);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return getResult(fromDevice, ip, detectType, languageType, imageType, imageStr);
    }

    private static String getResult(String fromDevice, String ip, String detectType, String languageType, String imageType, String imageStr) {
        ip = ip == null || "".equals(ip.trim()) ? getLocalIp() : ip;
        String httpArg = String.format(http_arg, fromDevice, ip, detectType, languageType, imageType, imageStr);
        String jsonResult = request(http_url, httpArg);

        JSONObject json = JSONObject.parseObject(jsonResult);
        String responseCode = json.getString("errNum");

        StringBuffer result = new StringBuffer();

        if ("0".equals(responseCode)) {
            JSONArray array = json.getJSONArray("retData");
            for (int i = 0; i < array.size(); i++) {
                result.append(array.getJSONObject(i).getString("word"));
            }
        }
        return result.toString();
    }


    private static String request(String httpUrl, String httpArg) {
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();

        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");
            // 填入apikey到HTTP header
            connection.setRequestProperty("apikey", api_key);
            connection.setDoOutput(true);
            connection.getOutputStream().write(httpArg.getBytes("UTF-8"));
            connection.connect();
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
                sbf.append("\r\n");
            }
            reader.close();
            result = sbf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private static String getBdBase64File(File file) throws IOException {
        FileInputStream inputFile = new FileInputStream(file);
        byte[] buffer = new byte[(int) file.length()];
        inputFile.read(buffer);
        inputFile.close();
        return getBdBase64File(buffer);
    }

    private static String getBdBase64File(byte[] buffer) throws UnsupportedEncodingException {
        return URLEncoder.encode(Base64.encode(buffer), encode);
    }

    private static String getLocalIp() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            return null;
        }
    }

}
