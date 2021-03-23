import com.alibaba.fastjson.JSONObject;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.*;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Level;

/**
 * @Author: GSO
 * @Description:
 * @Date: 2021/3/22 1:51
 */
public class MiningSwitcher {
    private static double maxincome = 0;
    private static double maxincome_old = 0;
    private static String coin;
    private static String coin_old = "null";
    private static int count = 0;

    public static void main(String[] args) throws IOException, InterruptedException {

        new ProcessBuilder("cmd", "/c", "mode con cols=50 lines=35&color f0&title 收益最大化工具").inheritIO().start();

        System.out.println("程序初始化中....................");
        //关闭log
        LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
        java.util.logging.Logger.getLogger("org.apache.http.client").setLevel(Level.OFF);

        // HtmlUnit 模拟浏览器
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        webClient.getOptions().setJavaScriptEnabled(true);              // 启用JS解释器，默认为true
        webClient.getOptions().setCssEnabled(false);                    // 禁用css支持
        webClient.getOptions().setThrowExceptionOnScriptError(false);   // js运行错误时，是否抛出异常
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setTimeout(10 * 1000);                   // 设置连接超时时间

        System.out.print("请输入刷新时间(单位分钟)：");
        long flushtime = (long) (new Scanner(System.in).nextFloat() * 1000 * 60);


        while (true) {
            count++;
            System.out.println("正在第" + count + "次爬取数据...............");
            HtmlPage page = webClient.getPage("https://www.beepool.com/");
            webClient.waitForBackgroundJavaScript(3 * 1000);    // 等待js后台执行3秒
            String pageAsXml = page.asXml();
            System.out.println("开始解析.......................");
            System.out.println("=============================================");

            //jsoup 解析
            Document document = Jsoup.parse(pageAsXml);
            Elements formElement = document.getElementsByClass("b-tr-coin");
            for (Element element : formElement) {
                String coin_title = element.getElementsByClass("coin_title").text();
                String coin_valuestr = element.getElementsByClass("detail font_14").text();
                double coin_value = Float.parseFloat(coin_valuestr.substring(0, coin_valuestr.length() / 2).substring(4));
                System.out.println("币种:" + coin_title);
                double income = coin_value * getSpeed(coin_title);
                System.out.println("实时收益:" + income + "元/天");

                //debug
              /*  if (coin_title.equals("CFX") && count == 2) {
                    income = 50;
                }
                if (coin_title.equals("AE") && count == 4) {
                    income = 31;
                }*/
                if (maxincome < income) {
                    maxincome = income;
                    coin = coin_title;
                }
            }
                System.out.println("=============================================");
                String kill = "taskkill /f /im nbminer.exe";
                String start = "cmd /c start start_" + coin.toLowerCase() + ".bat";
                if (!coin_old.equals(coin)) {                                      //判断最大收益币种是否发生变化
                    try {
                        Runtime.getRuntime().exec(kill);
                        Runtime.getRuntime().exec(kill);
                        Runtime.getRuntime().exec("taskkill /f /im cmd.exe");
                        Thread.sleep(1000);
                        Runtime.getRuntime().exec(start);
                        System.out.println("正在切换到最高收益币种:" + coin);
                        System.out.println("预计收益：" + maxincome + "元/天");
                        System.out.println("收益变化:" + (maxincome - maxincome_old));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("当前币种" + coin_old + "仍为最高收益币种");
                    System.out.println("预计收益：" + maxincome + "元/天");
                    System.out.println("收益变化:" + (maxincome - maxincome_old));
                }

                coin_old = coin;
                maxincome_old = maxincome;
                maxincome = 0;          //初始化最大收益

                Thread.sleep(flushtime);          // 爬取时间间隔
            }
        }

        private static double getSpeed (String title)  {

            JSONObject config = null;
            try {
                config = getConfig();
            } catch (IOException e) {
                System.out.println("配置文件未找到");
            }
            //统一单位
            if(title.equals("ETH")||title.equals("ETC")||title.equals("SERO")||title.equals("MOAC")){
                assert config != null;
                return config.getDouble(title)/1024;
            }else {
                assert config != null;
                return config.getDouble(title);
            }
/*            switch (title) {
                case "ETH":
                    return 42.5 / 1024;
                case "ETC":
                    return 42.5 / 1024;
                case "CFX":
                    return 60;
                case "AE":
                    return 10;
                case "SERO":
                    return 27.5 / 1024;
                default:
                    return 0;
            }*/
        }
        private static JSONObject getConfig() throws IOException {

            String path = new MiningSwitcher().getPath()+"/config.json";
            InputStreamReader isr = new InputStreamReader(new FileInputStream(path));
            BufferedReader br = new BufferedReader(isr);
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line);
            }
            br.close();
            isr.close();

            return JSONObject.parseObject(stringBuilder.toString());

        }

    private String getPath() //获取jar包所在目录
    {
        String path = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
        if(System.getProperty("os.name").contains("dows"))
        {
            path = path.substring(1,path.length());
        }
        if(path.contains("jar"))
        {
            path = path.substring(0,path.lastIndexOf("."));
            return path.substring(0,path.lastIndexOf("/"));
        }
        return path.replace("target/classes/", "");
    }

    }
