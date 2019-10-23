package com.kodilla.ecommercee;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.web.bind.annotation.*;

import java.security.acl.Group;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/eecommercee")
public class GroupController {

    @RequestMapping(method = RequestMethod.GET, value = "allProductGroups")
    public List<ProductDto> getAllProductGroups(){
        return new ArrayList<ProductDto>() ;
    }

    @RequestMapping(method = RequestMethod.GET, value = "getGroup", consumes = "application/json")
    public GroupDto getGroup(@RequestParam Long groupId){
        return new GroupDto();
    }

    @RequestMapping(method = RequestMethod.POST, value = "addGroup", consumes = "application/json")
    public void addGroup(@RequestBody GroupDto groupDto){
    }

    @RequestMapping(method = RequestMethod.PUT, value = "groupUpdate", consumes = "application/json")
    public GroupDto groupUpdate(@RequestBody GroupDto groupDto){
        return new GroupDto();
    }



}
