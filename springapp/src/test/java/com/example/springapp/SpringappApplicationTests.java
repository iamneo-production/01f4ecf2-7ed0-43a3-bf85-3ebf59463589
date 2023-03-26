package com.example.springapp;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class) 
@SpringBootTest(classes = SpringappApplication.class)
@AutoConfigureMockMvc
class SpringappApplicationTests {

	@Autowired
	private  MockMvc mockMvc ;

	@Test
	void test_case1() throws Exception{	

		String st = "{\"cycleId\": 1000,\"cycleName\": \"Demo\", \"price\": \"56455\",\"size\": \"1079\",\"type\":\"normal\"}";
		 mockMvc.perform(MockMvcRequestBuilders.post("/")
		 				.contentType(MediaType.APPLICATION_JSON)
		 				.content(st)
		 				.accept(MediaType.APPLICATION_JSON))
						.andExpect(MockMvcResultMatchers.status().isOk())
						.andExpect(jsonPath("$").value(true))
						.andReturn();
	}


	@Test
	void test_case2() throws Exception{	

		String st = "{\"cycleId\": 1000,\"cycleName\": \"Demo1\", \"price\": \"6455\",\"size\": \"79\",\"type\":\"Demo\"}";
		  mockMvc.perform(MockMvcRequestBuilders.put("/1000")
		 				.contentType(MediaType.APPLICATION_JSON)
		 				.content(st)
		 				.accept(MediaType.APPLICATION_JSON))
						.andExpect(MockMvcResultMatchers.status().isOk())
						.andExpect(jsonPath("$.size").value(79))
						.andReturn();
	}

	@Test
	void test_case3() throws Exception{	

		 mockMvc.perform(get("/1000")
		 				.accept(MediaType.APPLICATION_JSON))
						.andDo(print())
						.andExpect(status().isOk())
						.andExpect(jsonPath("$.cycleName").value("Demo1"))
						.andReturn();
	}

	@Test
	void test_case4() throws Exception{	

		 mockMvc.perform(get("/")
		 				.accept(MediaType.APPLICATION_JSON))
						.andDo(print())
						.andExpect(status().isOk())
						.andExpect(jsonPath("$").isArray())
						.andReturn();
	}

	@Test
	void test_case5() throws Exception{	

		 mockMvc.perform(MockMvcRequestBuilders.delete("/1001")
		 				.accept(MediaType.APPLICATION_JSON))
						.andDo(print())
						.andExpect(status().isOk())
						.andExpect(jsonPath("$").exists())
						.andReturn();
	}

	@Test
	void test_case6() throws Exception{	


		String st = "{\"cycleId\": 1002,\"cycleName\": \"Demo2\", \"price\": \"5455\",\"size\": \"109\",\"type\":\"gear\"}";
		 mockMvc.perform(MockMvcRequestBuilders.post("/")
		 				.contentType(MediaType.APPLICATION_JSON)
		 				.content(st)
		 				.accept(MediaType.APPLICATION_JSON))
						.andExpect(MockMvcResultMatchers.status().isOk())
						.andExpect(jsonPath("$").value(true))
						.andReturn();
	}


	@Test
	void test_case8() throws Exception{	

		String st = "{\"cycleId\": 1002,\"cycleName\": \"Demo4\", \"price\": \"6495\",\"size\": \"10\",\"type\":\"normal\"}";
		  mockMvc.perform(MockMvcRequestBuilders.put("/1002")
		 				.contentType(MediaType.APPLICATION_JSON)
		 				.content(st)
		 				.accept(MediaType.APPLICATION_JSON))
						.andExpect(MockMvcResultMatchers.status().isOk())
						.andExpect(jsonPath("$.size").value(10))
						.andReturn();
	}

	@Test
	void test_case7() throws Exception{	

		 mockMvc.perform(get("/1002")
		 				.accept(MediaType.APPLICATION_JSON))
						.andDo(print())
						.andExpect(status().isOk())
						.andExpect(jsonPath("$.cycleName").value("Demo4"))
						.andReturn();
	}

	@Test
	void test_case9() throws Exception{	

		 mockMvc.perform(get("/")
		 				.accept(MediaType.APPLICATION_JSON))
						.andDo(print())
						.andExpect(status().isOk())
						.andExpect(jsonPath("$").isArray())
						.andReturn();
	}

	@Test
	void test_case10() throws Exception{	

		 mockMvc.perform(MockMvcRequestBuilders.delete("/1002")
		 				.accept(MediaType.APPLICATION_JSON))
						.andDo(print())
						.andExpect(status().isOk())
						.andExpect(jsonPath("$").exists())
						.andReturn();
	}

}
