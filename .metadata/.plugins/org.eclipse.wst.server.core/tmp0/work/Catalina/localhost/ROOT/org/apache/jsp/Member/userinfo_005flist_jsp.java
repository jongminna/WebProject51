/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.71
 * Generated at: 2022-01-18 05:35:30 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.Member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class userinfo_005flist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("java.sql");
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");

	String myDriver="oracle.jdbc.driver.OracleDriver";
	String myURL ="jdbc:oracle:thin:@localhost:1521:xe";
	String myID = "jslhrd51";
	String myPass = "1234";

      out.write("\r\n");
      out.write("\r\n");

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	try{
		Class.forName(myDriver);
		conn = DriverManager.getConnection(myURL, myID, myPass);
		String sql="select * from tbl_member ";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
	}catch(Exception e){
		e.printStackTrace();
	}


      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>회원목록 보여주기</title>\r\n");
      out.write("\r\n");
      out.write("<STYLE TYPE=\"text/css\">\r\n");
      out.write("<!--\r\n");
      out.write("body { font-family: 돋움, Verdana; font-size: 9pt}\r\n");
      out.write("td   { font-family: 돋움, Verdana; font-size: 9pt; text-decoration: none; color: #000000} \r\n");
      out.write("--->\r\n");
      out.write("</STYLE>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<table width=\"550\" border=\"1\" cellspacing=\"0\" cellpadding=\"2\" bordercolorlight=\"#173E7C\" bordercolordark=\"white\">\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td width=50 align=center>번호</td>\r\n");
      out.write("    <td width=50 align=center>ID</td>\r\n");
      out.write("    <td width=80 align=center>이름</td>\r\n");
      out.write("    <td width=100 align=center>전화번호</td>\r\n");
      out.write("    <td width=100 align=center>등록일자</td>\r\n");
      out.write("    <td width=100 align=center>최근접속일</td>\r\n");
      out.write("  </tr>\r\n");

	while(rs.next()){

      out.write("  \r\n");
      out.write("   <tr>\r\n");
      out.write("      <td align=center>5</td>\r\n");
      out.write("      <td align=center><a href=\"userinfo_modify.jsp?userid=");
      out.print( rs.getString("userid") );
      out.write('"');
      out.write('>');
      out.print( rs.getString("userid") );
      out.write("</a></td>\r\n");
      out.write("      <td align=center>");
      out.print( rs.getString("name") );
      out.write("</td>\r\n");
      out.write("      <td align=center>");
      out.print( rs.getString("tel") );
      out.write("</td>\r\n");
      out.write("      <td align=center>");
      out.print( rs.getString("first_time") );
      out.write("</td>\r\n");
      out.write("      <td align=center></td>\r\n");
      out.write("   </tr>\r\n");

	}

      out.write("\r\n");
      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("<table width=550>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td>\r\n");
      out.write("      <select name=\"search_gubun\">\r\n");
      out.write("        <option >이름 </option>\r\n");
      out.write("        <option >주소 </option>\r\n");
      out.write("        \r\n");
      out.write("    </td>\r\n");
      out.write("    <td>  찾는이름:\r\n");
      out.write("          <input type=\"text\" name=\"searc\" size=10> &nbsp;\r\n");
      out.write("          [조회]\r\n");
      out.write("     </td>\r\n");
      out.write("   </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td>\r\n");
      out.write("    </td>\r\n");
      out.write("    <td></td>\r\n");
      out.write("   </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td>로그인 페이지 이동\r\n");
      out.write("    </td>\r\n");
      out.write("    <td><a href=\"userinfo_insert.jsp\">회원가입페이지 이동</a></td>\r\n");
      out.write("   </tr>\r\n");
      out.write("</table>    \r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
