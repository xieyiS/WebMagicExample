package test;

import lombok.Data;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.model.annotation.ExtractBy;

@Data
public class Hupu {
    @ExtractBy("/html/body/div[4]/div[1]/div[1]/h1/text()")
    private String Title;

    @ExtractBy("/html/body/div[4]/div[1]/div[2]/div/div[2]/p/text()")
    private String Content;

    @Override
    public String toString() {
        return "Hupu{" +
               "Title='" + Title + '\'' +
               ", Content='" + Content + '\'' +
               '}';
    }

    public static void main(String[] args) {
        OOSpider ooSpider = OOSpider.create(Site.me().setSleepTime(0).setCharset("UTF-8"), Hupu.class);
        //String url = "http://news.baidu.com/ns?tn=news&cl=2&rn=20&ct=1&fr=bks0000&ie=utf-8&word=httpclient";
        String url = "https://voice.hupu.com/nba/1";
        //single download
        Hupu hupu = ooSpider.<Hupu>get(url);
        System.out.println(hupu);

        ooSpider.close();
    }
}
