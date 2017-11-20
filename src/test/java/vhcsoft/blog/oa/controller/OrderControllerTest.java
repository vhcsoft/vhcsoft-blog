package vhcsoft.blog.oa.controller;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import vhcsoft.blog.oa.entities.Order;
import vhcsoft.blog.oa.entities.OrderItem;
import vhcsoft.blog.oa.repositories.OrderRepository;


@RunWith(SpringRunner.class)
@WebMvcTest(controllers = { OrderController.class }, secure = false)
@TestPropertySource("/application-test.properties")
public class OrderControllerTest {

	@Autowired
	private MockMvc mvc;
	@MockBean
	private OrderRepository orderRepoMock;
	
	private Long orderId = 12L;
	private String orderDetail ="test order detail";
	private String orderOwner = "vhcsoft_blog";
	private Long itemId =2L;
	private Double itemPrice = 3.7;
	private String productName = "test product";
	private Integer itemAmount = 12;
	
	@Before
	public void setUp() {
		List<Order> orders = new ArrayList<>();
		Order testOrder = new Order();
		testOrder.setId(orderId);
		testOrder.setOrderDetail(orderDetail);
		testOrder.setOwner(orderOwner);
		OrderItem item = new OrderItem();
		item.setId(itemId);
		item.setPrice(itemPrice);
		item.setProductName(productName);
		item.setAmount(itemAmount);
		testOrder.getItems().add(item );
		orders.add(testOrder);
		given(this.orderRepoMock.findAll()).willReturn(orders );
	}
	
	/**
	 * we expect the following json 
	 * <code>
	 * [{
  "id": 12,
  "orderDetail": "test order detail",
  "items": [{
    "id": 2,
    "productName": "test product",
    "price": 3.7
  }]
}]
	 * </code>
	 * @throws Exception
	 */
	@Test
	public void testGetOrders() throws Exception {
		mvc.perform(get("/api/orders").accept(MediaType.APPLICATION_JSON_UTF8))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$[0].id").value(orderId))
		.andExpect(jsonPath("$[0].orderDetail").value(orderDetail))
		.andExpect(jsonPath("$[0].items[0].id").value(itemId))
		.andExpect(jsonPath("$[0].orderOwner").doesNotExist())
		
		;
	}
}
