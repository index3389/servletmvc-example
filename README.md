# servletmvc-example
servletmvc-api的使用例子

使用方式一（约定优于配置）<br />
  <servlet><br />
  	<servlet-name>dispatcherServlet</servlet-name><br />
  	<servlet-class>com.hqit.servletmvc.servlet.DispatcherServlet</servlet-class><br />
  	<init-param><br />
  		<param-name>base-package</param-name><br />
  		<param-value>com.hqit</param-value><br />
  	</init-param><br />
  	<load-on-startup>1</load-on-startup><br />
  </servlet><br />
  <br />
  <servlet-mapping><br />
  	<servlet-name>dispatcherServlet</servlet-name><br />
  	<url-pattern>*.do</url-pattern><br />
  </servlet-mapping><br />
  <br />
  public class UserController<br />
  {<br />
  	public String indexAction()throws Exception<br />
    {<br />
	  return "/user/index.jsp";<br />
    }<br />
  }<br />
  访问路径为controller的前面部分，和action的前面部分<br />
  http://127.0.0.1:8080/{project}/user/index.do<br />
<br />
使用方式二（注解）<br />
  <servlet><br />
  	<servlet-name>dispatcherServlet</servlet-name><br />
  	<servlet-class>com.hqit.servletmvc.servlet.DispatcherServlet</servlet-class><br />
  	<init-param><br />
  		<param-name>base-package</param-name><br />
  		<param-value>com.hqit</param-value><br />
  	</init-param><br />
  	<init-param><br />
  		<param-name>loadingStrategyClass</param-name><br />
  		<param-value>com.hqit.servletmvc.api.impl.AnnotationMethodHandlerAdapter</param-value><br />
  	</init-param><br />
  	<load-on-startup>1</load-on-startup><br />
  </servlet><br />
  <br />
  <servlet-mapping><br />
  	<servlet-name>dispatcherServlet</servlet-name><br />
  	<url-pattern>*.do</url-pattern><br />
  </servlet-mapping><br />
  <br />
然后，在com.hqit包（或者子包）<br />
	@Path("/user/default")<br />
	public String index()throws Exception<br />
	{<br />
		return "/user/index.jsp";<br />
	}<br />
	http://127.0.0.1:8080/{project}/user/default.do<br />
  <br />
  
  