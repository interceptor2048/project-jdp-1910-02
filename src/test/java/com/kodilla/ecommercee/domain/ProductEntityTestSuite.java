package com.kodilla.ecommercee.domain;
import com.kodilla.ecommercee.repository.GroupRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import com.kodilla.ecommercee.service.GroupService;
import com.kodilla.ecommercee.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductEntityTestSuite {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private GroupService groupService;
    @Autowired
    private GroupRepository groupRepository;

    @Test
    public void testProductEntity() {
        //Given
        Group rtv = new Group("rtv","Produkty RTV");
        Product monitor = new Product (2323L,"name",3.22,"desc",null,null);
        rtv.getProducts().add(monitor);
        monitor.setProductGroup(rtv);
        //When
        groupService.saveGroup(rtv);
        productService.saveProduct(monitor);
        //Then
    }
}
