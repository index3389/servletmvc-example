# servletmvc-example
servletmvc-api的使用例子

###	
		使用方式一（约定优于配置）
		  <servlet>
		  	<servlet-name>dispatcherServlet</servlet-name>
		  	<servlet-class>com.hqit.servletmvc.servlet.DispatcherServlet</servlet-class>
		  	<init-param>
		  		<param-name>base-package</param-name>
		  		<param-value>com.hqit</param-value>
		  	</init-param>
		  	<load-on-startup>1</load-on-startup>
		  </servlet>
		  
		  <servlet-mapping>
		  	<servlet-name>dispatcherServlet</servlet-name>
		  	<url-pattern>*.do</url-pattern>
		  </servlet-mapping>
		  
		  public class UserController
		  {
		  	public String indexAction()throws Exception
		    {
			  return "/user/index.jsp";
		    }
		  }
		  访问路径为controller的前面部分，和action的前面部分
		  http://127.0.0.1:8080/{project}/user/index.do
		
		使用方式二（注解）
		  <servlet>
		  	<servlet-name>dispatcherServlet</servlet-name>
		  	<servlet-class>com.hqit.servletmvc.servlet.DispatcherServlet</servlet-class>
		  	<init-param>
		  		<param-name>base-package</param-name>
		  		<param-value>com.hqit</param-value>
		  	</init-param>
		  	<init-param>
		  		<param-name>loadingStrategyClass</param-name>
		  		<param-value>com.hqit.servletmvc.api.impl.AnnotationMethodHandlerAdapter</param-value>
		  	</init-param>
		  	<load-on-startup>1</load-on-startup>
		  </servlet>
		  
		  <servlet-mapping>
		  	<servlet-name>dispatcherServlet</servlet-name>
		  	<url-pattern>*.do</url-pattern>
		  </servlet-mapping>
		  
		然后，在com.hqit包（或者子包）
			@Path("/user/default")
			public String index()throws Exception
			{
				return "/user/index.jsp";
			}
			http://127.0.0.1:8080/{project}/user/default.do
###
  
  