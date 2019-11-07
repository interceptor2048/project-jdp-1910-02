package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.controller.exception.NotFoundException;
import com.kodilla.ecommercee.domain.dto.GroupDto;
import com.kodilla.ecommercee.mapper.GroupMapper;
import com.kodilla.ecommercee.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/ecommercee/group")
public class GroupController {
    @Autowired
    GroupService service;
    @Autowired
    GroupMapper mapper;

    @GetMapping(path = "/allProductGroups")
    public List<GroupDto> getAllProductGroups() {
        return mapper.mapToGroupDtoList(service.getAllGroups());
    }

    @GetMapping(path = "/getGroup")
    public GroupDto getGroup(@RequestParam Long groupId) throws NotFoundException {
        return mapper.mapToGroupDto(service.getGroup(groupId).orElseThrow(NotFoundException::new));
    }

    @PostMapping(path = "/addGroup", consumes = "application/json")
    public void addGroup(@RequestBody GroupDto groupDto) {
        service.saveGroup(mapper.mapToGroup(groupDto));
    }

    @PutMapping(path = "/groupUpdate", consumes = "application/json")
    public GroupDto groupUpdate(@RequestBody GroupDto groupDto) {
        return mapper.mapToGroupDto(service.saveGroup(mapper.mapToGroup(groupDto)));
    }
}
