package com.example.test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.example.util.MyBatisUtil;

public class SessionTest {

	@Test
	public void test() {
		SqlSession session = MyBatisUtil.getInstance().getSession();
		assertThat(session, is(notNullValue()));
	}

}
