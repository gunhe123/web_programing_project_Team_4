<%@ page contentType="text/html; charset=utf-8" import="java.sql.*" %> 

<% 

Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_game", "id001" , "pwd001");
Statement stmt = conn.createStatement();
ResultSet rset = null;
 
 
 
String query = "SELECT * FROM users"; 

rset = stmt.executeQuery(query);
 

out.println("<TABLE BORDER=1"); 

out.println("<TR><TD>성명</TD><TD>전화번호</TD></TR>"); 


while(rset.next()) { 

        String name = rset.getString("id"); 

        String tel = rset.getString("email"); 


        out.println("<TR><TD>"+name+"</TD><TD>"+tel+"</TD></TR>"); 

        } 

out.println("</TABLE>"); 
rset.close();
stmt.close();
conn.close();
 

%> 



