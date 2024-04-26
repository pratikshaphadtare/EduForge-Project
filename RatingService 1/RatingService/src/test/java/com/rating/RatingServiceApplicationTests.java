package com.rating;
 
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
 
import com.rating.controller.RatingController;
import com.rating.model.Rating;
import com.rating.service.RatingService;
 
import static org.mockito.Mockito.when;
 
import java.util.ArrayList;
import java.util.List;
 
@WebMvcTest(RatingController.class)
public class RatingServiceApplicationTests {
 
    @Autowired
    private MockMvc mockMvc;
 
    @MockBean
    private RatingService ratingService;
 
    @Test
    public void testCreateRating() throws Exception {
        // Create a JSON string manually without ObjectMapper
        String requestBody = "{\"rating\": 4.5, \"message\": \"Great course!\"}";
 
        mockMvc.perform(MockMvcRequestBuilders.post("/ratings")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }
 
    @Test
    public void testGetRatings() throws Exception {
        List<Rating> ratings = new ArrayList<>(); // Sample list of ratings
        // Mock the service to return the sample list of ratings
        when(ratingService.getRatings()).thenReturn(ratings);
 
        mockMvc.perform(MockMvcRequestBuilders.get("/ratings")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
 