/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.71
 * Generated at: 2022-01-25 05:30:48 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.BoardReply;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class board_005fwrite_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
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

      out.write('\r');
      out.write('\n');

	int parent=Integer.parseInt(request.getParameter("parent"));
	int realparent=Integer.parseInt(request.getParameter("realparent"));
	int depth=Integer.parseInt(request.getParameter("depth"));
	int indent=Integer.parseInt(request.getParameter("indent"));

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("   <head><title>게시판 작성</title>\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"/stylesheet.css\">\r\n");
      out.write("<script>\r\n");
      out.write("	function send(){\r\n");
      out.write("		alert(\"자료를 등록합니다.\");\r\n");
      out.write("		boardreply.action=\"board_write_pro.jsp\";\r\n");
      out.write("		boardreply.submit();\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write(" <body topmargin=\"0\" leftmargin=\"0\">\r\n");
      out.write(" <table border=\"0\" width=\"800\">\r\n");
      out.write(" <tr>\r\n");
      out.write("   <td width=\"20%\" height=\"500\" bgcolor=\"#ecf1ef\" valign=\"top\">\r\n");
      out.write("\r\n");
      out.write("   <!-- 다음에 추가할 부분 -->\r\n");
      out.write("\r\n");
      out.write("   </td>\r\n");
      out.write("\r\n");
      out.write("   <td width=\"80%\" valign=\"top\">&nbsp;<br>\r\n");
      out.write("     <img src=\"./img/bullet-01.gif\"><font size=\"3\" face=\"돋움\" color=\"blue\"> <b>반갑습니다</b></font>\r\n");
      out.write("     <font size=\"2\"> - 글쓰기</font><p>\r\n");
      out.write("     <img src=\"./img/bullet-03.gif\"><font size=\"2\" face=\"돋움\" color=\"orange\"> 잠깐</font> &nbsp;\r\n");
      out.write("     <img src=\"./img/bullet-02.gif\"><font size=\"2\" face=\"돋움\">는 필수 입력 사항입니다.</font><p>\r\n");
      out.write("     <form name=\"boardreply\" method=\"post\">\r\n");
      out.write("		<input type=\"hidden\" name=\"parent\" value=\"");
      out.print(parent);
      out.write("\">\r\n");
      out.write("		<input type=\"hidden\" name=\"realparent\" value=\"");
      out.print(realparent);
      out.write("\">\r\n");
      out.write("		<input type=\"hidden\" name=\"depth\" value=\"");
      out.print(depth);
      out.write("\">\r\n");
      out.write("		<input type=\"hidden\" name=\"indent\" value=\"");
      out.print(indent);
      out.write("\">\r\n");
      out.write("		\r\n");
      out.write("	  <table border=\"0\">\r\n");
      out.write("       <tr>\r\n");
      out.write("         <td width=\"5%\" align=\"right\"><img src=\"./img/bullet-02.gif\"></td>\r\n");
      out.write("         <td width=\"15%\"><font size=\"2\" face=\"돋움\">글쓴이</font></td>\r\n");
      out.write("         <td width=\"80%\">\r\n");
      out.write("         <input type=\"text\" size=\"20\" name=\"name\"></td>\r\n");
      out.write("       </tr>\r\n");
      out.write("       <tr>\r\n");
      out.write("         <td align=\"right\">&nbsp;</td>\r\n");
      out.write("         <td ><font size=\"2 face=\"돋움\"\">메일주소</font></td>\r\n");
      out.write("         <td>\r\n");
      out.write("          <input type=\"text\" size=\"20\" name=\"email\"></td>\r\n");
      out.write("       </tr>\r\n");
      out.write("	   <tr>\r\n");
      out.write("         <td align=\"right\"><img src=\"./img/bullet-02.gif\"></td>\r\n");
      out.write("         <td><font size=\"2\" face=\"돋움\">제목</font></td>\r\n");
      out.write("         <td><input type=\"text\" size=\"60\" name=\"subject\" ></td>\r\n");
      out.write("       </tr>\r\n");
      out.write("       <tr>\r\n");
      out.write("         <td align=\"right\"><img src=\"./img/bullet-02.gif\"></td>\r\n");
      out.write("         <td><font size=\"2\" face=\"돋움\">내용</font></td>\r\n");
      out.write("         <td><textarea wrap=\"physical\" rows=\"10\" name=\"contents\" cols=\"60\"></textarea></td>\r\n");
      out.write("       </tr>\r\n");
      out.write("	   <tr>\r\n");
      out.write("         <td align=\"right\"><img src=\"./img/bullet-02.gif\"></td>\r\n");
      out.write("         <td><font size=\"2\" face=\"돋움\">비밀번호</font></td>\r\n");
      out.write("          <td><input type=\"password\" size=\"10\" name=\"pass\" ><font size=\"2\" face=\"돋움\">*.수정과 삭제시 꼭 입력하셔야 합니다.</font></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr></tr>\r\n");
      out.write("		<tr>\r\n");
      out.write("          <td align=\"right\">&nbsp;</td>\r\n");
      out.write("          <td><font size=\"2\">&nbsp;</font></td>\r\n");
      out.write("          <td>\r\n");
      out.write("             <a href=\"javascript:send()\"><img src=\"./img/save.gif\" border=0></a>&nbsp;&nbsp;&nbsp;\r\n");
      out.write("             <a href=\"javascript:history.back()\"><img src=\"./img/cancle.gif\" border=0></a>\r\n");
      out.write("          </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("      </table>\r\n");
      out.write("      </form>\r\n");
      out.write("    </td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  </table>\r\n");
      out.write("  </body>\r\n");
      out.write("  </html>\r\n");
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