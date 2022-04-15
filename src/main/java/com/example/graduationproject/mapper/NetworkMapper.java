package com.example.graduationproject.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.graduationproject.entity.basis.Network;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface NetworkMapper extends BaseMapper<Network> {
}
