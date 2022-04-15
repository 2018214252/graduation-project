package com.example.graduationproject.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.graduationproject.entity.basis.Organization;
import com.example.graduationproject.mapper.OrganizationMapper;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class OrganizationService {
    @Autowired
    private OrganizationMapper organizationMapper;

    public void insertOrganization(Organization organization) {
        organizationMapper.insert(organization);
    }

    public void deleteOrganization(Long id) {
        organizationMapper.deleteById(id);
    }

    public void updateOrganization(Organization organization) {
        organizationMapper.updateById(organization);
    }

    public List<Organization> selectOrganization(QueryWrapper<Organization> wrapper) {
        return organizationMapper.selectList(wrapper);
    }
}
