package home.Servlet;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dishdetect.Dish;

/**
 * Servlet implementation class DishDetctServlet
 */
//这是访问的servlet路径
@WebServlet("/DishDetctServlet")
public class DishDetctServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DishDetctServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		 //get反馈的信息，存储上传上来的图片
        //获取反馈信息		,修改函数，改为传参,传进去刚刚接收到的图片地址
		response.setContentType("application/x-www-form-urlencoded");
		String result=Dish.dish();
		response.setContentType("text/html;charset=utf-8");          
        // 设置响应头允许ajax跨域访问  
        response.setHeader("Access-Control-Allow-Origin", "*");  
        // 星号表示所有的异域请求都可以接受  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  

        //获取微信小程序get的参数值并打印
        String message = request.getParameter("message");
        //System.out.println("message="+message);

       // System.out.print(Dish.dish());
        //返回值给微信小程序
        Writer out = response.getWriter(); 
        out.write("接收到的信息是"+message+"返回的信息是"+result);
        //out.write(result);
        out.flush();   
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
