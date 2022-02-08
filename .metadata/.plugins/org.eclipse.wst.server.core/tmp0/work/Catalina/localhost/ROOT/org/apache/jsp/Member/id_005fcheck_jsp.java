/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.71
 * Generated at: 2022-01-18 05:25:44 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.Member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class id_005fcheck_jsp extends org.apache.jasper.runtime.HttpJspBase
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
	}catch(Exception e){}
		
	String userid="";
	int row=0;
	if(request.getParameter("userid") != null){
		userid=request.getParameter("userid");
		String sql="select count(*) from tbl_member where userid=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userid);
		rs = pstmt.executeQuery();
		if(rs.next()){
			row = rs.getInt(1);
		}
	}
	

      out.write("\r\n");
      out.write("\r\n");
      out.write("<HTML>\r\n");
      out.write("<HEAD>\r\n");
      out.write("<TITLE>사용자의 아이디를 체크합니다.</TITLE>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=euc-kr\">\r\n");
      out.write("<STYLE TYPE=\"text/css\">\r\n");
      out.write("<!--\r\n");
      out.write("body { font-family: 돋움, Verdana; font-size: 9pt}\r\n");
      out.write("td   { font-family: 돋움, Verdana; font-size: 9pt; text-decoration: none; color: #000000} \r\n");
      out.write("--->\r\n");
      out.write("</STYLE>\r\n");
      out.write("<script>\r\n");
      out.write("	function send(){\r\n");
      out.write("		if(idcheck.userid.value==\"\"){\r\n");
      out.write("			alert(\"ID Input\");\r\n");
      out.write("			idcheck.userid.focus();\r\n");
      out.write("			return;\r\n");
      out.write("		}\r\n");
      out.write("		idcheck.submit();\r\n");
      out.write("	}\r\n");
      out.write("</script>\r\n");
      out.write("</HEAD>\r\n");
      out.write("<BODY bgcolor=\"#FFFFFF\">\r\n");
      out.write("<TABLE CELLPADDING=0 CELLSPACING=0 BORDER=0 WIDTH=330>\r\n");
      out.write("  <TR BGCOLOR=#7AAAD5>\r\n");
      out.write("    <td align=left><img src=\"./img/u_b02.gif\"></td>\r\n");
      out.write("    <td align=center><FONT COLOR=\"#FFFFFF\"><b>아이디 중복 체크</FONT></td>\r\n");
      out.write("    <td align=right><img src=\"./img/u_b03.gif\"></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("</table>\r\n");
      out.write("<TABLE CELLPADDING=0 CELLSPACING=0 BORDER=0 WIDTH=330>\r\n");
      out.write("<TR BGCOLOR=#948DCF>\r\n");
      out.write("  <TD>\r\n");
      out.write("    <TABLE CELLPADDING=4 CELLSPACING=1 BORDER=0 WIDTH=330>\r\n");
      out.write("  	  <TR BGCOLOR=\"#FFFFFF\">\r\n");
      out.write("        <TD ALIGN=\"center\">\r\n");
      out.write("  ");

  	if(!userid.equals("")){
  		if(row==0){
  
      out.write("       \r\n");
      out.write("          <br><FONT FACE=\"굴림\"><B>사용 가능합니다.</B></FONT><br>\r\n");
      out.write("         <BR><FONT COLOR=\"#483cae\"><b>");
      out.print(userid);
      out.write("</b></FONT>는 아직 사용되지 않은 아이디입니다.\r\n");
      out.write("         <BR><FONT COLOR=\"#483cae\"><b>");
      out.print(userid);
      out.write("</b></FONT>로 등록하셔도 됩니다.\r\n");
      out.write(" ");

  		}else{
 
      out.write("        \r\n");
      out.write("         <br><font face=\"굴림\"><b>죄송합니다</b></font><br>\r\n");
      out.write("    	<BR><FONT COLOR=\"#483cae\"><b>");
      out.print(userid);
      out.write("</b></FONT>는 이미 사용 중인 아이디입니다<br>\r\n");
      out.write("    	\r\n");
      out.write("   ");

  		}
  	}
   
      out.write(" 	\r\n");
      out.write("        <form name=\"idcheck\" method=\"post\" action=\"id_check.jsp\">\r\n");
      out.write("        	아이디 입력 :<INPUT NAME=userid type=text size=16 maxlength=16>\r\n");
      out.write("      	   <a href=\"#\" onClick=\"send()\"><img src=\"./img/u_bt08.gif\" border=0 vspace=0></a>\r\n");
      out.write("		</form>\r\n");
      out.write("        </TD>\r\n");
      out.write("      </TR>\r\n");
      out.write("    </TABLE>\r\n");
      out.write(" </TD>\r\n");
      out.write("</TR>\r\n");
      out.write("</TABLE>\r\n");
      out.write("\r\n");
      out.write("<TABLE CELLPADDING=0 CELLSPACING=0 BORDER=0 WIDTH=330>\r\n");
      out.write("  <TR BGCOLOR=#7AAAD5>\r\n");
      out.write("    <td align=left><img src=\"./img/u_b04.gif\"></td>\r\n");
      out.write("    <td align=right><img src=\"./img/u_b05.gif\"></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td colspan=3 align=center>\r\n");
      out.write("      <img src=\"./img/u_bt13.gif\" border=0 vspace=5>\r\n");
      out.write("    </td>\r\n");
      out.write("  </tr>\r\n");
      out.write("</table>\r\n");
      out.write("</BODY>\r\n");
      out.write("</HTML>");
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
