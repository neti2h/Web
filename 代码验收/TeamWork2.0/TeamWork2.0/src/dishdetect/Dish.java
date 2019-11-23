package dishdetect;

import java.net.URLEncoder;

public class Dish {
    public static String dish() {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/image-classify/v2/dish";
        String result="";
        try {
            // 本地文件路径
            String filePath = "C:\\Users\\ASUS\\Pictures\\Camera Roll\\300.jpg";
            //读取图片为byte型数组
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            //对存入byte型数组的图片进行base64的加密。
            String imgStr = Base64Util.encode(imgData);
            //再进行URL的编码。
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");
            String param = "image=" + imgParam + "&top_num=" + 5;
            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = "24.12b11758786f98e16045324226f8dcc2.2592000.1576489792.282335-17785614";
            //请求百度的服务器，上传图片信息，获取识别结果。
            result = HttpUtil.post(url, accessToken, param);
            System.out.println(result);
          //  return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
    	Dish.dish();
    }
}
