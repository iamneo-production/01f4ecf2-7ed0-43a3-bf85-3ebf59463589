package com.example.springapp;

import org.springframework.http.MediaType;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@RunWith(SpringJUnit4ClassRunner.class) 
@SpringBootTest(classes = SpringappApplication.class)
@AutoConfigureMockMvc
class SpringappApplicationTests {

	@Autowired
	private  MockMvc mockMvc ;

	@Test
    public void test_case1() throws Exception {
	
		String st = "{\"ratingId\": 1000,\"userId\": 1001, \"productId\": 1002, \"ratingDate\": \"22Mar\", \"score\": 50}";
	 	mockMvc.perform(MockMvcRequestBuilders.post("/")
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.content(st)
	 			.accept(MediaType.APPLICATION_JSON))
	        	.andExpect(status().isOk())
				.andExpect(jsonPath("$").value(true))
	        	.andReturn();
	    
    }


	@Test
	void test_case2() throws Exception{	

		 mockMvc.perform(MockMvcRequestBuilders.get("/userId")
		 				.accept(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk())
						.andExpect(jsonPath("$").isArray())
						.andReturn();
	}

	@Test
	void test_case3() throws Exception{	

		 mockMvc.perform(MockMvcRequestBuilders.get("/0/2")
		 				.accept(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk())
						.andDo(print())
						.andExpect(jsonPath("$.content").exists())
						.andReturn().getResponse().getContentAsString();
	}

	@Test
	void test_case4() throws Exception{	

		 mockMvc.perform(MockMvcRequestBuilders.get("/1/4/score")
		 				.accept(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk())
						.andExpect(jsonPath("$.pageable.sort.sorted").value(true))
						.andReturn();
	}

	@Test
	void test_case5() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders
                .get("/rating?field=score&sortDirection=ASC")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
				.andExpect(jsonPath("$").isArray())
				.andReturn();              
	}

	@Test
    public void test_case6() throws Exception {
	
		String st = "{\"ratingId\": 1001,\"userId\": 1002, \"productId\": 1003, \"ratingDate\": \"23Mar\", \"score\": 70}";
	 	mockMvc.perform(MockMvcRequestBuilders.post("/")
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.content(st)
	 			.accept(MediaType.APPLICATION_JSON))
	        	.andExpect(status().isOk())
				.andExpect(jsonPath("$").value(true))
	        	.andReturn();
	    
    }


	@Test
	void test_case7() throws Exception{	

		 mockMvc.perform(MockMvcRequestBuilders.get("/productId")
		 				.accept(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk())
						.andExpect(jsonPath("$").isArray())
						.andReturn();
	}

	@Test
	void test_case8() throws Exception{	

		 mockMvc.perform(MockMvcRequestBuilders.get("/0/3")
		 				.accept(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk())
						.andDo(print())
						.andExpect(jsonPath("$.content").exists())
						.andReturn().getResponse().getContentAsString();
	}

	@Test
	void test_case9() throws Exception{	

		 mockMvc.perform(MockMvcRequestBuilders.get("/2/4/score")
		 				.accept(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk())
						.andExpect(jsonPath("$.pageable.sort.sorted").value(true))
						.andReturn();
	}

	@Test
	void test_case10() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders
                .get("/rating?field=score&sortDirection=DESC")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
				.andExpect(jsonPath("$").isArray())
				.andReturn();              
	}


}
