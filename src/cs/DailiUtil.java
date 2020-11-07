package cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author macfmc
 * @date 2020/6/14-17:56
 */
public class DailiUtil {

    public static String STATU_OK = "OK";

    public static void main(String[] args) {

        String targetUrl = "https://blog.csdn.net/FMC_WBL/article/details/105896787";
        String para = "x=194047";

        List<Daili> dailis = getDailis();
        //dead loop
        while (true) {
            for (int i = 0; i < dailis.size() - 1; i++) {
                // set proxy IP and port
                System.getProperties().setProperty("http.proxyHost", dailis.get(i).getIP());
                System.getProperties().setProperty("http.proxyPort", dailis.get(i).getPort());
                // is success
                // send get requst
                String result = sendGet(targetUrl, para);
                System.out.println("result=" + result);
                if (STATU_OK.equals(result)) {
                    System.out.println(i + "--OK--" + dailis.get(i).getIP() + ":" + dailis.get(i).getPort());
                } else {
                    System.out.println(i + "--FAIL--" + dailis.get(i).getIP() + ":" + dailis.get(i).getPort());
                }
                try {
                    final double d = Math.random();
                    final double e = Math.random();
                    final int o = (int) (d * 200 + e * 100);
                    Thread.sleep(o);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // send post
            }
        }
    }

    /**
     * all of proxy server
     *
     * @return
     */
    public static List<Daili> getDailis() {
        List<Daili> dailis = new ArrayList<>();
        dailis.add(new Daili("61.135.217.7", "80"));
        dailis.add(new Daili("119.29.12.129", "8888"));
        dailis.add(new Daili("112.114.97.180", "8118"));
        dailis.add(new Daili("115.55.144.101", "8118"));
        dailis.add(new Daili("112.114.97.65", "8118"));
        dailis.add(new Daili("219.138.58.96", "3128"));
        dailis.add(new Daili("219.138.58.146", "3128"));
        dailis.add(new Daili("113.242.132.76", "8118"));
        dailis.add(new Daili("222.172.188.37", "8118"));
        dailis.add(new Daili("112.114.93.229", "8118"));
        dailis.add(new Daili("106.81.230.186", "8118"));
        dailis.add(new Daili("113.67.164.133", "8118"));
        dailis.add(new Daili("113.218.218.216", "8888"));
        dailis.add(new Daili("223.150.219.96", "8888"));
        dailis.add(new Daili("222.182.53.114", "8118"));
        dailis.add(new Daili("220.168.237.182", "8888"));
        dailis.add(new Daili("113.221.45.161", "8888"));
        dailis.add(new Daili("122.136.212.132", "53281"));
        dailis.add(new Daili("113.65.8.221", "9999"));
        dailis.add(new Daili("220.249.185.178", "9999"));
        dailis.add(new Daili("58.252.6.165", "9000"));
        dailis.add(new Daili("123.138.89.133", "9999"));
        dailis.add(new Daili("61.155.164.109", "3128"));
        dailis.add(new Daili("112.74.94.142", "3128"));
        dailis.add(new Daili("139.224.24.26", "8888"));
        dailis.add(new Daili("121.43.178.58", "3128"));
        dailis.add(new Daili("122.72.18.34", "80"));
        dailis.add(new Daili("124.89.33.75", "9999"));
        dailis.add(new Daili("123.139.56.238", "9999"));
        dailis.add(new Daili("114.115.217.39", "3128"));
        dailis.add(new Daili("123.207.218.139", "8080"));
        dailis.add(new Daili("123.207.55.239", "1080"));
        dailis.add(new Daili("123.207.58.85", "1080"));
        dailis.add(new Daili("103.12.69.55", "1080"));
        dailis.add(new Daili("139.198.6.166", "3128"));
        dailis.add(new Daili("123.207.154.239", "1080"));
        dailis.add(new Daili("139.199.172.100", "3128"));
        dailis.add(new Daili("139.199.199.222", "8080"));
        dailis.add(new Daili("117.48.199.20", "3128"));
        dailis.add(new Daili("139.224.118.55", "3128"));
        dailis.add(new Daili("139.224.130.225", "3128"));
        dailis.add(new Daili("139.224.131.100", "1080"));
        dailis.add(new Daili("139.199.201.27", "808"));
        dailis.add(new Daili("120.52.73.173", "8080"));
        dailis.add(new Daili("139.196.243.30", "8080"));
        dailis.add(new Daili("112.17.14.27", "8080"));
        dailis.add(new Daili("139.196.140.130", "3128"));
        dailis.add(new Daili("123.206.93.108", "8081"));
        dailis.add(new Daili("139.196.196.74", "80"));
        dailis.add(new Daili("110.73.35.152", "8123"));
        dailis.add(new Daili("112.114.93.138", "8118"));
        dailis.add(new Daili("122.114.31.177", "808"));

        dailis.add(new Daili("113.200.214.164", "9999"));
        dailis.add(new Daili("182.121.204.0", "9999"));
        dailis.add(new Daili("122.114.122.212", "9999"));
        dailis.add(new Daili("203.174.112.13", "3128"));
        dailis.add(new Daili("61.155.164.110", "3128"));
        dailis.add(new Daili("180.137.232.76", "53281"));
        dailis.add(new Daili("101.81.106.155", "9797"));
        dailis.add(new Daili("112.74.94.142", "3128"));
        dailis.add(new Daili("139.224.24.26", "8888"));
        dailis.add(new Daili("121.43.178.58", "3128"));
        dailis.add(new Daili("122.72.18.34", "80"));
        dailis.add(new Daili("123.139.56.238", "9999"));
        dailis.add(new Daili("112.114.93.138", "8118"));
        dailis.add(new Daili("182.121.204.0", "9999"));
        dailis.add(new Daili("180.137.232.76", "53281"));
        dailis.add(new Daili("101.81.106.155", "9797"));
        dailis.add(new Daili("112.114.97.65", "8118"));
        dailis.add(new Daili("183.51.191.127", "9999"));
        dailis.add(new Daili("182.88.151.107", "9797"));
        dailis.add(new Daili("120.9.76.55", "9999"));
        dailis.add(new Daili("124.152.32.140", "53281"));
        dailis.add(new Daili("120.78.78.141", "8888"));
        dailis.add(new Daili("113.242.132.76", "8118"));
        dailis.add(new Daili("112.93.198.114", "9797"));
        dailis.add(new Daili("202.98.197.243", "3128"));
        dailis.add(new Daili("223.243.201.214", "54132"));
        dailis.add(new Daili("122.72.18.35", "80"));
        dailis.add(new Daili("61.155.164.109", "3128"));
        dailis.add(new Daili("124.89.33.75", "9999"));
        dailis.add(new Daili("112.117.59.203", "9999"));

        dailis.add(new Daili("122.114.31.177", "808"));
        dailis.add(new Daili("61.135.217.7", "80"));
        dailis.add(new Daili("122.114.122.212", "9999"));
        dailis.add(new Daili("203.174.112.13", "3128"));
        dailis.add(new Daili("112.114.76.176", "6668"));
        dailis.add(new Daili("222.172.239.69", "6666"));
        dailis.add(new Daili("112.114.78.54", "6673"));
        dailis.add(new Daili("121.31.103.33", "6666"));
        dailis.add(new Daili("113.121.245.32", "6667"));
        dailis.add(new Daili("110.73.30.246", "6666"));
        dailis.add(new Daili("114.239.253.38", "6666"));
        dailis.add(new Daili("116.28.106.165", "6666"));
        dailis.add(new Daili("220.179.214.77", "6666"));
        dailis.add(new Daili("110.73.32.7", "6666"));
        dailis.add(new Daili("114.139.48.8", "6668"));
        dailis.add(new Daili("111.124.231.101", "6668"));
        dailis.add(new Daili("118.80.181.186", "6675"));
        dailis.add(new Daili("113.122.42.161", "6675"));
        dailis.add(new Daili("60.211.17.10", "6675"));
        dailis.add(new Daili("110.72.20.245", "6673"));
        dailis.add(new Daili("110.73.33.207", "6673"));
        dailis.add(new Daili("122.89.138.20", "6675"));
        dailis.add(new Daili("61.138.104.30", "1080"));
        dailis.add(new Daili("121.31.199.91", "6675"));
        return dailis;
    }

    /**
     * GET
     *
     * @param url   URL
     * @param param eg: name1=value1&name2=value2
     * @return result
     */
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.setConnectTimeout(10000);
            connection.setReadTimeout(5000);
            connection.setDoOutput(true);
            connection.setUseCaches(false);
            // connect
            connection.connect();
//            Map<String, List<String>> map = connection.getHeaderFields();
//            for (String key : map.keySet()) {
//                System.out.println(key + "--->" + map.get(key));
//            }
//            in = new BufferedReader(new InputStreamReader(
//                    connection.getInputStream()));
//            String line;
//            while ((line = in.readLine()) != null) {
//                result += line;
//            }
            int status = connection.getResponseCode();
            if (200 == status) {
                // 200
                result = STATU_OK;
            }
        } catch (Exception e) {
            System.out.println("request get Exception" + e);
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    /**
     * POST
     *
     * @param url   URL
     * @param param name1=value1&name2=value2
     * @return result
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // must
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            out = new PrintWriter(conn.getOutputStream());
            out.print(param);
            out.flush();
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("request post Exception" + e);
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public static String escape(String src) {
        int i;
        char j;
        StringBuffer tmp = new StringBuffer();
        tmp.ensureCapacity(src.length() * 6);
        for (i = 0; i < src.length(); i++) {
            j = src.charAt(i);
            if (Character.isDigit(j) || Character.isLowerCase(j)
                    || Character.isUpperCase(j))
                tmp.append(j);
            else if (j < 256) {
                tmp.append("%");
                if (j < 16)
                    tmp.append("0");
                tmp.append(Integer.toString(j, 16));
            } else {
                tmp.append("%u");
                tmp.append(Integer.toString(j, 16));
            }
        }
        return tmp.toString();
    }

    /**
     * class proxy
     */
    public static class Daili {
        private String IP;
        private String port;

        public Daili(String IP, String port) {
            this.IP = IP;
            this.port = port;
        }

        public String getIP() {
            return IP;
        }

        public void setIP(String IP) {
            this.IP = IP;
        }

        public String getPort() {
            return port;
        }

        public void setPort(String port) {
            this.port = port;
        }
    }
}

