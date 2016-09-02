package com.example.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyBatisUtil {
	static Logger logger = LoggerFactory.getLogger(MyBatisUtil.class);
	//singleton 처리
	private MyBatisUtil() {
		init();
	}

	private static MyBatisUtil instance = new MyBatisUtil();

	public static MyBatisUtil getInstance() {
		return instance;
	}
	
	private SqlSessionFactory factory;
	
	private void init(){
		String res = "mybatis-config.xml";
		try(InputStream input = Resources.getResourceAsStream(res)){
			factory = new SqlSessionFactoryBuilder().build(input);
		}catch(IOException e){
			logger.error("Sql연결 초기화 실패", e);
		}
	}
	
	public SqlSession getSession(){
		logger.trace("SqlSession연결");
		return factory.openSession();
	}

}
