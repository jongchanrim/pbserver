package kr.pb.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.pb.action.Action;
import kr.pb.action.ActionForward;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns="/pb",initParams={@WebInitParam
		(name="urlpattern",value="/kr/pb/conf/urlPatterns.properties")})
//�ش��ϴ� Servlet�������� urlpattern�� �� ��밡��. �� ���̸� �о� Properites��� �޼ҵ��
//����. init �޼ҵ� �ȿ��� �����Ѵ�. �� ���� ���ָ� ��.
// (/board?cmd=list ?�ڿ� ���� �Ŵ� �����ͷ� �ν��Ѵ�. 


public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Map<String,Action> map=new HashMap<String,Action>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainController() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
		super.init(config);
		String urlpattern=config.getInitParameter("urlpattern");//�ʿ��� �޼ҵ带 �о�´�.
		InputStream is=getClass().getResourceAsStream(urlpattern);
		//
		Properties prop=new Properties();//�����߾�! ���� �����;ߵȴ�!
		
		//config�� �о�ðž�
		
		try{
			prop.load(is);
			
		}catch(IOException e){
			e.printStackTrace();
		}
		Iterator it=prop.keySet().iterator();
		
		while(it.hasNext()){
			//�����͵��� ���ʴ�� �о cmd�� �ҷ��鿩�� ������.
			String cmd=(String)it.next();
			
			String action=prop.getProperty(cmd);//������ �ش�
			System.out.println(cmd+":"+action);//String���� �о��� ��
			//������ ��ų ���� ������ �о���� ������ ����.
			Action actionObject=null;
			
			try {
				Class actionClass= Class.forName(action);
				//�� ���̴� �׳� Ŭ�����̴�. �ٵ� ������
				//execute�� Ŭ���� Ÿ���� �޼ҵ尡 �ƴ϶� 
				//ȣ���Ϸ��� ��ü�̸�.�޼ҵ��̸����� ȣ���� �ؾ��Ѵ�.
				//�׷����� Ŭ������ ��üȭ ���Ѿ� �Ѵ�.
			    actionObject=(Action) actionClass.newInstance();
				
				
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			map.put(cmd,actionObject);//�ʿ� properties���� ����.
		}
		
		System.out.println("init");
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doGet");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	
		//doget�޼ҵ忡�� request.getParameter�� �Ἥ cmd=???���� �ڿ� ���� ???�� �޾ƿ´�.
		String cmd=request.getParameter("cmd");//???�� action�� �ҷ��´�. get���� ������
		//map�� key������ �־��⿡ key������ �޾ƿ��� �ȴ�.
		
	
		
		Action action=map.get(cmd);
		ActionForward forward=new ActionForward();
		
		action.execute(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		System.out.println("doPost");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("destroy");
	}

	
	
	

	
	

}
