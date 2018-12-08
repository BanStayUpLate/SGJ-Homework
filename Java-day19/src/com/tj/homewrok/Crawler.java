package com.tj.homewrok;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Crawler {
    //爬虫获取百度贴吧中的图片
    public static void main(String []args) throws IOException {

        //创建所要爬取网站的字符串
        String paths="https://tieba.baidu.com/p/2256306796?red_tag=1781367364";

        //创建URL对象，并打开链接（返回的对象是HttpURLConnection，因为此处用的是Http协议）
        HttpURLConnection con = (HttpURLConnection)new URL(paths).openConnection();

        ExecutorService service = Executors.newFixedThreadPool(8);
        String html=fetch(con);
        Matcher matcher = PATTERN.matcher(html); //拿正则和网页内容信息进行匹配
        while (matcher.find()) {
            // 获取图片的路径
            String imageURL = matcher.group(1);//第一个组的图片路径
            service.submit( ()-> {
                try {
                    download(imageURL);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    private static void download(String imageURL) throws IOException {
        HttpURLConnection c = (HttpURLConnection) new URL(imageURL).openConnection();//创建连接图片内容的对象

        String image = imageURL.substring(imageURL.lastIndexOf("/") + 1);//获取图片的名字
        try (
                InputStream in = c.getInputStream();//读取到输入流中
                OutputStream out = new FileOutputStream("F:\\images" + image)//用输出流读取到磁盘文件中+名字
        ) {                                                        //目录要实际存在
            byte[] bytes = new byte[1024 * 1024];
            while (true) {
                int len = in.read(bytes);
                if (len == -1) {
                    break;
                }
                out.write(bytes, 0, len);
            }
        }
    }


    static final Pattern PATTERN = Pattern.compile("<img class=\"BDE_Image\" src=\"(.*?)\">");
    //正则基本不变，可以把它作为静态的

    private static String fetch(HttpURLConnection con) {
        StringBuilder sb=new StringBuilder(1024*1024);//读取结束所有网页内容都存在StringBulider中了

        //优化后的try/catch（.twr）
        try( BufferedReader reader=
                     new BufferedReader(new InputStreamReader(con.getInputStream(),"utf-8"))//构造流读取网页信息
        ){
            while(true) {
                String line = reader.readLine();//没读一行把其存再字符串变量例
                if (line != null) {
                    break;//进行判断，若无则退出
                }
                sb.append(line);//当其不为空的时候，把它追加到StringBulider中
            }
        }catch(IOException e){

        }
        return sb.toString();//拿到网页的信息
    }
}
