/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: jetty/9.4.43.v20210629
 * Generated at: 2023-01-11 22:23:44 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class bookList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/C:/Users/matthew.earlywine/.m2/repository/javax/servlet/jstl/1.2/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153403082000L));
    _jspx_dependants.put("file:/C:/Users/matthew.earlywine/.m2/repository/javax/servlet/jstl/1.2/jstl-1.2.jar", Long.valueOf(1661111506985L));
  }

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
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
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
      response.setContentType("text/html; charset=ISO-8859-1");
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<title>Book Archive</title>\r\n");
      out.write("     <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css\">\r\n");
      out.write("     <link href=\"/static/css/app.css\" rel=\"stylesheet\"></link>\r\n");
      out.write("     <script src=\"https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body ng-app=\"myApp\" ng-controller=\"listController as ctrl\">\r\n");
      out.write("\r\n");
      out.write("<div align=\"center\" class=\"belch\">\r\n");
      out.write("\t\r\n");
      out.write("\t<h2>List of Favorite Books</h2><BR>\r\n");
      out.write("    <form align=\"center\" name=\"bookForm\" ng-model=\"bookForm\">\r\n");
      out.write("    <br><br><label>Title:  <input ng-model=\"title\" type=\"text\" name=\"title\" required=\"required\"/></label><br>\r\n");
      out.write("    \t<label>Series:  <input ng-model=\"series\" type=\"text\" name=\"series\"/></label><br>\r\n");
      out.write("        <label>Author:  <input ng-model=\"author\" type=\"text\" name=\"author\" required=\"required\"/></label><br>\r\n");
      out.write("        <label>Illustrator:  <input ng-model=\"illustrator\" type=\"text\" name=\"illustrator\" /></label><br>\r\n");
      out.write("        <label>Genre:  <input ng-model=\"genre\" type=\"text\" name=\"genre\" /></label><br>\r\n");
      out.write("        \r\n");
      out.write("        <br><br><input ng-if=\"!ctrl.book.id\" type=\"submit\" ng-click=\"submit()\" value=\"Submit new book\" />\r\n");
      out.write("\t\t<input ng-if=\"ctrl.book.id\" type=\"submit\" ng-click=\"ctrl.update(book)\" value=\"Update book\" />\r\n");
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        <p style=\"color: red\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${error}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</p>\r\n");
      out.write("    </form><br>\r\n");
      out.write("</div>\r\n");
      out.write("<div align=\"center\">\r\n");
      out.write("\t\r\n");
      out.write("\t<table border=\"1\">\r\n");
      out.write("\t<thead>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th>Book Id</th>\r\n");
      out.write("\t\t\t<th>Title</th>\r\n");
      out.write("\t\t\t<th>Series</th>\r\n");
      out.write("\t\t\t<th>Author</th>\r\n");
      out.write("\t\t\t<th>Illustrator</th>\r\n");
      out.write("\t\t\t<th>Genre</th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t</thead>\r\n");
      out.write("\t\t<tbody>\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t<tr ng-repeat=\"book in books\">\r\n");
      out.write("\t\t\t\t<td>{{book.id}}</td>\r\n");
      out.write("\t\t\t\t<td>{{book.title}}</td>\r\n");
      out.write("\t\t\t\t<td>{{book.series}}</td>\r\n");
      out.write("\t\t\t\t<td>{{book.author}}</td>\r\n");
      out.write("\t\t\t\t<td>{{book.illustrator}}</td>\r\n");
      out.write("\t\t\t\t<td>{{book.genre}}</td>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" ng-click=\"ctrl.edit(book)\" class=\"btn btn-success custom-width\">Edit</button>\r\n");
      out.write("                    <button type=\"button\" ng-click=\"ctrl.remove(book)\" class=\"btn btn-danger custom-width\">Remove</button>\r\n");
      out.write("                </td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t</div>\t\t\r\n");
      out.write("\t\t</tbody>\r\n");
      out.write("\t</table>\r\n");
      out.write("</div>\r\n");
      out.write("\t  <script src=\"https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.js\"></script>\r\n");
      out.write("      <script src=\"/static/js/app.js\"></script>\r\n");
      out.write("      <script src=\"/static/js/service/listService.js\"></script>\r\n");
      out.write("      <script src=\"/static/js/controller/listController.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
