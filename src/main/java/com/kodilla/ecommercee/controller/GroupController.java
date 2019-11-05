package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.dto.GroupDto;
import com.kodilla.ecommercee.mapper.GroupMapper;
import com.kodilla.ecommercee.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/ecommercee")
public class GroupController {
    @Autowired
    GroupService service;
    @Autowired
    GroupMapper mapper;

    @RequestMapping(method = RequestMethod.GET, value = "allProductGroups")
    public List<GroupDto> getAllProductGroups() {
        return mapper.mapToGroupDtoList(service.getAllGroups());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getGroup")
    public GroupDto getGroup(@RequestParam Long groupId) throws NotFoundException {
        return mapper.mapToGroupDto(service.getGroup(groupId).orElseThrow(NotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.POST, value = "addGroup", consumes = "application/json")
    public void addGroup(@RequestBody GroupDto groupDto) {
        service.saveGroup(mapper.mapToGroup(groupDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "groupUpdate", consumes = "application/json")
    public GroupDto groupUpdate(@RequestBody GroupDto groupDto) {
        return mapper.mapToGroupDto(service.saveGroup(mapper.mapToGroup(groupDto)));
    }
}
