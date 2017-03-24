package com.Jan;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

@WebServlet(
		urlPatterns={"/search"},
		name="searchs")
public class searchServlet extends HttpServlet{
	
	static List<String> datas=new ArrayList<String>();
	static{
		datas.add("ajaxx");
		datas.add("ajaxcs");
		datas.add("ajax post");
		datas.add("jax");
		datas.add("jaxxx");
		datas.add("baax");
		datas.add("bbaaxx");
		datas.add("aass");
		datas.add("eeeex");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("123");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//首先获得客户端发送来的数据keyword
		String keyword=request.getParameter("keyword");
		System.out.println(keyword);
		//获得关键字之后进行处理，得到关联数据 
		List<String> listData=new ArrayList<String>();
		listData=getData(keyword);
		System.out.println(listData);
		//返回json格式
	//	JSONArray.fromObject(listData);
		System.out.println(JSONArray.fromObject(listData));
		response.getWriter().write(JSONArray.fromObject(listData).toString());
	}
	public List<String> getData(String keyword){
		List<String> list=new ArrayList<String>();
		for(String data:datas){
			if(data.contains(keyword)){
				list.add(data);
			}
		}
		return list;
	}   
}
